package com.valtech

import com.valtech.service.PricingService._

/**
  * Created by kiran on 30/06/2016.
  */
object TillCheckout{

  def main(args:Array[String])={

    val items = convertToItems(args)
    val price = calculatePrice(items)
    println(s"Price of the items is:$price")
  }
}
