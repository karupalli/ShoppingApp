package com.valtech.service

import com.valtech.domain.Item
import org.specs2.Specification
import com.valtech.service.PricingService._

/**
  * Created by kiran on 30/06/2016.
  */
class PricingServiceSpec extends Specification{
  override def is = s2"""

  priceDefinedItem
     Invlid String should return None             $shouldReturnNoneItem
     Apple should return Apple Item               $shouldReturnApple
     Orange should return Orange Item             $shouldReturnOrange

  calculatePrice
    None should return 0                         $shouldReturnZeroForNoItems
    Apple price is 0.60                          $shouldReturn60PenceForApple
    Orange price is 0.25                         $shouldReturn25PenceForOrange
    Apple,Orange price is 0.85                   $shouldReturn85PenceForAppleOrange
    Apple,Invalid price is 0.60                  $shouldReturn60PenceForAppleInvalid
    """

  def shouldReturnApple = priceDefinedItem("Apple").get.name  must be equalTo "Apple"
  def shouldReturnOrange = priceDefinedItem("Orange").get.name  must be equalTo "Orange"
  def shouldReturnNoneItem = priceDefinedItem("Invalid") equals  None

  def shouldReturnZeroForNoItems= calculatePrice(Array()) must be equalTo 0.0
  def shouldReturn60PenceForApple = calculatePrice(convertToItems(Array("Apple")))  must be equalTo 0.60
  def shouldReturn25PenceForOrange = calculatePrice(convertToItems(Array("Orange")))  must be equalTo 0.25
  def shouldReturn85PenceForAppleOrange = calculatePrice(convertToItems(Array("Apple","Orange")))  must be equalTo 0.85
  def shouldReturn60PenceForAppleInvalid = calculatePrice(convertToItems(Array("Apple","Invalid"))) must be equalTo 0.60

}
