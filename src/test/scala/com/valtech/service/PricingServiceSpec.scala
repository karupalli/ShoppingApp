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

  calculatePriceWithOffers
    None should return 0                                          $shouldReturnZeroForNoItems
    One apple price must be .60                                   $shouldReturn60PenceForApple
    One Orange price must be 0.25                                 $shouldReturn25PenceForOrangeWithOffers
    One Apple and Orange price must be 0.85                       $shouldReturn85PenceForAppleOrangeWithOffers
    One Apple and Invalid String should return 0.60               $shouldReturn60PenceForAppleInvalidWithOffers
    Two Apples should return 0.60 (after discounts applied)       $shouldReturn60PenceForTwoApplesWithOffers
    Three oranges should return 0.50 (after discounts)            $shouldReturn50PenceForThreeOrangesWithOffers
    Four Oranges should return 0.75(discounts applied on three)   $shouldReturn75PenceForFourOrangesWithOffers
    Three apples should return 1.20 (discount applied on two)     $shouldReturn120PenceForThreeApplesWithOffers
    """

  def shouldReturnApple = priceDefinedItem("Apple").get.name  must be equalTo "Apple"
  def shouldReturnOrange = priceDefinedItem("Orange").get.name  must be equalTo "Orange"
  def shouldReturnNoneItem = priceDefinedItem("Invalid") equals  None

  def shouldReturnZeroForNoItems= calculatePrice(Array()) must be equalTo 0.0
  def shouldReturn60PenceForApple = calculatePrice(convertToItems(Array("Apple")))  must be equalTo 0.60
  def shouldReturn25PenceForOrange = calculatePrice(convertToItems(Array("Orange")))  must be equalTo 0.25
  def shouldReturn85PenceForAppleOrange = calculatePrice(convertToItems(Array("Apple","Orange")))  must be equalTo 0.85
  def shouldReturn60PenceForAppleInvalid = calculatePrice(convertToItems(Array("Apple","Invalid"))) must be equalTo 0.60

  def shouldReturnZeroForNoItemsWithOffers= calculatePriceWithOffers(Array()) must be equalTo 0.0
  def shouldReturn60PenceForAppleWithOffers = calculatePriceWithOffers(convertToItems(Array("Apple")))  must be equalTo 0.60
  def shouldReturn25PenceForOrangeWithOffers = calculatePriceWithOffers(convertToItems(Array("Orange")))  must be equalTo 0.25
  def shouldReturn85PenceForAppleOrangeWithOffers = calculatePriceWithOffers(convertToItems(Array("Apple","Orange")))  must be equalTo 0.85
  def shouldReturn60PenceForAppleInvalidWithOffers = calculatePriceWithOffers(convertToItems(Array("Apple","Invalid"))) must be equalTo 0.60
  def shouldReturn60PenceForTwoApplesWithOffers = calculatePriceWithOffers(convertToItems(Array("Apple","Apple"))) must be equalTo 0.60
  def shouldReturn50PenceForThreeOrangesWithOffers = calculatePriceWithOffers(convertToItems(Array("Orange","Orange","Orange"))) must be equalTo 0.50
  def shouldReturn75PenceForFourOrangesWithOffers = calculatePriceWithOffers(convertToItems(Array("Orange","Orange","Orange","Orange"))) must be equalTo 0.75
  def shouldReturn120PenceForThreeApplesWithOffers = calculatePriceWithOffers(convertToItems(Array("Apple","Apple","Apple"))) must be equalTo 1.20

}
