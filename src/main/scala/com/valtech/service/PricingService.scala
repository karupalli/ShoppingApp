package com.valtech.service

import com.valtech.domain.Item

/**
  * Created by kiran on 30/06/2016.
  */
object PricingService {

  /**
    * Calculates total price of all the items supplied
    */
  def calculatePrice(items:Array[Item]) = {
    items.map(_.price).sum
  }

  /**
    * Convert String (name of the item) to items if they are valid
    */
  def convertToItems(args:Array[String])={
    args.flatMap(priceDefinedItem)
  }

  /**
    * Returns the Item with price defined on it. Ideally price will be read from a DB/XML/Some input. Here we defined
    * as constant for now.
    */
  def priceDefinedItem(name:String):Option[Item] ={
    name match {
      case "Apple" => Some(Item(name, 0.60))
      case "Orange" => Some(Item(name, 0.25))
      case _ => None
    }
  }
}
