package com.mart.service

import com.mart.domain.{Orange, Apple, Item}
import DiscountService._

/**
  * Defines Pricing calculations
  */
object PricingService {

  /**
    * Calculates total price of all the items supplied
    */
  def calculatePrice(items: Array[Item]) = {
    items.map(_.price).sum
  }


  /**
    * Calculate the price with discounts
    *  ○ buy one, get one free on Apples
    *  ○ 3 for the price of 2 on Oranges
    */
  def calculatePriceWithOffers(items: Array[Item]) = {

    val groupedItems = items.groupBy(_.name)

    groupedItems.map(item => {
      item._1 match {
        case Apple.name => buyOneGetOne(item._2)
        case Orange.name => buyThreeForTwo(item._2)
        case _ => 0
      }
    }).sum
  }

  /**
    * Convert String (name of the item) to items if they are valid
    */
  def convertToItems(args: Array[String]) = {
    args.flatMap(priceDefinedItem)
  }

  /**
    * Returns the Item with price defined on it. Ideally price will be read from a DB/XML/Some input. Here we defined
    * as constant for now.
    */
  def priceDefinedItem(name: String): Option[Item] = {
    name match {
      case Apple.name => Some(Item(name, Apple.price))
      case Orange.name => Some(Item(name, Orange.price))
      case _ => None
    }
  }
}
