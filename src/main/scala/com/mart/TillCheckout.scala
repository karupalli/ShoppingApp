package com.mart

import com.mart.service.PricingService._

/**
  * Till Checkout service
  */
object TillCheckout {

  def main(args: Array[String]) = {

    val items = convertToItems(args)
    val price = calculatePriceWithOffers(items)
    println(s"Price of the items is:$price")
  }
}


