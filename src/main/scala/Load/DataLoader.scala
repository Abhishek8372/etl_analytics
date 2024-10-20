package com.example.etl
package Load

import org.apache.spark.sql.{DataFrame, Row}
import org.apache.spark.streaming._


object DataLoader {

  def load(df:DataFrame):Unit= df match {
    case Row("country"=="INDIA")=>loadToIndia(df)
  }


  def loadToIndia(df: DataFrame): Unit = {
    df.write
      .format("jdbc")
      .option("url", "jdbc:postgresql://localhost:5432/analytics")
      .option("dbtable", "customer_table")
      .option("user", "")
      .option("password", "your_password")
      .mode("append")
      .save()
  }


}