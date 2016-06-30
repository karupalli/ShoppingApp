package com.valtech.domain

/**
  * Created by kiran on 30/06/2016.
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