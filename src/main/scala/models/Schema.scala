package com.example.etl
package models

import java.sql.Date

case class Customer(
                     customerName: String,
                     customerId: String,
                     openDate: Date,
                     lastConsultedDate: Option[Date],
                     vaccinationId: Option[String],
                     drName: Option[String],
                     state: Option[String],
                     country: String,
                     postCode: Option[Int],
                     dob: Date,
                     isActive: Char,
                     age: Option[Int] = None,
                     daysSinceLastConsult: Option[Int] = None
                   )


val customerSchema = StructType(Array(
  StructField("record_type", StringType, nullable = false),  // H or D
  StructField("customer_name", StringType, nullable = true),
  StructField("customer_id", StringType, nullable = true),
  StructField("open_date", DateType, nullable = true),
  StructField("last_consulted_date", DateType, nullable = true),
  StructField("vaccination_id", StringType, nullable = true),
  StructField("dr_name", StringType, nullable = true),
  StructField("state", StringType, nullable = true),
  StructField("country", StringType, nullable = true),
  StructField("dob", DateType, nullable = true),
  StructField("is_active", StringType, nullable = true)
))