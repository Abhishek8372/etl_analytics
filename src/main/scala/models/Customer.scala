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
