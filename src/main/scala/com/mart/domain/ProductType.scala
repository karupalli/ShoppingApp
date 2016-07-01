package com.mart.domain

/**
  * ProductType to represent different products
  */
sealed trait ProductType {
  def name: String
  def price: Double
}

case object Apple extends ProductType {
  val name = "Apple"
  val price = 0.60
}

case object Orange extends ProductType {
  val name = "Orange"
  val price = 0.25
}