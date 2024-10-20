package com.example.etl
package Extraction

import org.apache.spark.sql.{DataFrame, SparkSession}


object Extract {
  def extractCustomerData(spark: SparkSession): DataFrame = {
    val filePath = "C:/Users/ABHISHEK KUMAR/Downloadscustomer_data.csv"
    val customerDF = spark.read
      .option("header", "true")
      .option("inferSchema", "true")
      .csv(filePath)

    customerDF
  }
}
