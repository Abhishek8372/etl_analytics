ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.15"

lazy val root = (project in file("."))
  .settings(
    name := "DE",
    idePackagePrefix := Some("com.example.etl")
  )

libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-core" % "3.4.3",
  "org.apache.spark" %% "spark-sql" % "3.4.3",
  "org.apache.spark" %% "spark-streaming" % "3.4.3",
  "org.apache.spark" %% "spark-streaming-kafka-0-10" % "3.4.3", // For Kafka integration
  "org.apache.kafka" % "kafka-clients" % "3.1.0",// kafka client for real-time streaming
  "org.twitter4j" % "twitter4j-core" % "4.0.7",// For Twitter streaming
  //"org.apache.spark" %% "spark-streaming-twitter" % "3.4.3"

  "mysql" % "mysql-connector-java" % "8.0.33",
)


Test / javaOptions ++= Seq(
  "--add-exports java.base/sun.nio.ch=ALL-UNNAMED"
)
