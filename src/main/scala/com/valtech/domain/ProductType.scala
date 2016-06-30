package com.valtech.domain

/**
  * ProductType to represent different products
  */
sealed trait ProductType {
  def name: String
}

case object Apple extends ProductType {
  val name = "Apple"
}

case object Orange extends ProductType {
  val name = "Orange"
}