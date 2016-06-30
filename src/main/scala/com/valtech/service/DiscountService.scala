package com.valtech.service

import com.valtech.domain.Item

/**
  * Defines the various discounts that can be applied on Products
  */
object DiscountService {

  /**
    * Calculates the total price considering two items as one item. Returns
    * total price of the items after discount applied
    */
  def buyOneGetOne(items:Array[Item]):Double ={
    if(items.isEmpty) 0
    (items.size / 2) * items.head.price + (items.size % 2)* items.head.price
  }

  /**
    * Calculates price of two for three items. Returns total price of the items after
    * the discount applied
    */
  def buyThreeForTwo(items:Array[Item]):Double={
    if(items.isEmpty) 0
    ((items.size / 3) * 2) * items.head.price + (items.size % 3)* items.head.price
  }
}
