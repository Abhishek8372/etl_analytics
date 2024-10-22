package com.example.etl
package etl

import com.typesafe.config.ConfigFactory
import org.scalatest.funsuite.AnyFunSuite

class FileFormatValidationTest extends AnyFunSuite {

  private val config=ConfigFactory.load

  private val filePath=config.getString("file.path")
  private val fileName=filePath.split("/").last

  test("Valid file format with correct naming and date format") {
    val validFormat = "^customers_data_\\d{8}\\.csv$".r

    assert(validFormat.matches(fileName))
  }

}
