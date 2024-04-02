package com.iremnurpirincci.shoppinglistapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

open class Item(val name: String, val price: Double)

class Food(name: String, price: Double, val weight: Double) : Item(name, price)

class Cloth(name: String, price: Double, val type: String) : Item(name, price)

class ShoppingList {

    private val items = mutableListOf<Item>()

    fun addItem() {
        print("Enter the item type you want to add (1 for Food, 2 for Cloth) :")


        when (readlnOrNull()?.toIntOrNull()) {
            1 -> {
                print("Enter the item name you want to add :")
                val itemName = readln()

                var itemPrice:Double? = null
                print("Enter the item price you want to add :")
                while (itemPrice == null){
                    //burdan aldım
                    val priceCheck = readlnOrNull()?.toDoubleOrNull()
                    if (priceCheck == null){
                        print("Please enter valid price! :")
                    }
                    else{
                        itemPrice = priceCheck
                    }
                }

                var itemWeight: Double? =null
                print("Enter the food weight :")
                while (itemWeight == null) {
                    val weightCheck = readlnOrNull()?.toDoubleOrNull()
                    if (weightCheck == null) {
                        print("Please enter valid weight! :")
                    } else {
                        itemWeight = weightCheck
                    }
                }

                items.add(Food(itemName, itemPrice, itemWeight))
                println("$itemName is added successfully!")
                println("--------------------------------")


            }
            2 -> {
                print("Enter the item name you want to add :")
                val itemName = readln()

                var priceCheck:Double? = null
                print("Enter the item price you want to add :")
                while (priceCheck == null){
                    val itemPrice = readlnOrNull()?.toDoubleOrNull()
                    if (itemPrice == null){
                        print("Please enter valid weight! :")
                    }
                    else{
                        priceCheck = itemPrice
                    }
                }

                print("Enter the cloth type :")
                val itemType = readln()
                items.add(Cloth(itemName, priceCheck, itemType))
                println("$itemName is added successfully!")
                println("--------------------------------")
            }
            else -> {
                print("Invalid number. ")
                addItem()
            }


        }
    }

    fun displayItems() {
        if (items.isEmpty()) {
            print("Your shopping list is empty!")
            return
        }

        println("Your shopping list :")
        for (i in items.indices) {
            val item = items[i]
            print("${i + 1}. ${item.name} ${item.price}$")
            if (item is Food) {
                println(" ${item.weight}kg")
            } else if (item is Cloth) {
                println(" ${item.type}")
            }
        }
    }

    fun deleteItem() {
        if (items.isEmpty()) {
            print("Your shopping list is empty!")
            return
        }

        print("Enter the item number you want to delete :")
        val itemNumber = readlnOrNull()?.toIntOrNull() ?: -1

        if (itemNumber in 1..items.size) {
            val deletedItem = items.removeAt(itemNumber - 1)
            println("${deletedItem.name} is deleted successfully!")
            println("--------------------------------")
        } else {
            print("Invalid item number!")
        }
    }
}

fun main() {
    val shoppingList = ShoppingList()

    while (true) {
        println("Make your choice : (1-2-3-4)")
        println("1) Add Item")
        println("2) Display Item")
        println("3) Delete Item")
        println("4) Exit")

        print("Your choice is :")
        val choice = readlnOrNull()?.toIntOrNull() ?: -1

        when (choice) {
            1 -> shoppingList.addItem()
            2 -> shoppingList.displayItems()
            3 -> shoppingList.deleteItem()
            4 -> break
            else -> print("Invalid number !")
        }
    }

    print("Exiting...")
}
