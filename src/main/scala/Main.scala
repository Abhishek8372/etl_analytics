package com.example.etl

import com.example.etl.Extraction.Extract
import com.example.etl.Ingestion.TwitterStream
import com.example.etl.Load.DataLoader
import com.example.etl.Transformation.DataTransformer
import org.apache.spark.sql.SparkSession

object Main {
  def main(args: Array[String]): Unit = {

    val spark = SparkSession.builder()
      .appName("ETL Application")
      .master("local")  // Change for cluster mode
      .config("spark.local.dir", "C:/Users/ABHISHEK KUMAR/spark_loc_dir")
      .config("spark.driver.extraClassPath", "/path/to/postgresql-42.6.0.jar")
      .getOrCreate()

    val data=Seq(("Abhishek",23),("Ravi",65))

    val df=spark.createDataFrame(data).toDF("Name","Age")
    df.show()
    println(s"Hello World")


    // Extract data
    val extract =Extract.extractCustomerData(spark)

    // Transform data
    val transformedStream = DataTransformer.transform(extract)

    // Load data to table
    DataLoader.load(transformedStream)


  }
}