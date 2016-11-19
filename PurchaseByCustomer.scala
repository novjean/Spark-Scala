package com.sundogsoftware.spark

import org.apache.spark._
import org.apache.spark.SparkContext._
import org.apache.log4j._

object PurchaseByCustomer {
  
  def parseLine(line: String) = 
  {
    val fields = line.split(",")
    val id = fields(0).toInt
    val amount = fields(2).toFloat;
    
    (id,amount)
  }
  
 def main(args: Array[String]) 
  {
    Logger.getLogger("org").setLevel(Level.ERROR)
    
    val sc = new SparkContext("local[*]","PurchaseByCustomer")
    
    val input  = sc.textFile("../customer-orders.csv")
    
    val lines = input.map(parseLine)
    
    val totalByCustomer = lines.reduceByKey((x,y) => x+y)
    
    val arrangeRes = totalByCustomer.map(x=>(x._2,x._1))
    
    val results = arrangeRes.collect()
    
    //results.foreach(println)
    
    for(result<-results.sorted)
    {
      val cid = result._2
      val amount = result._1
      val formattedAmount = f"$amount%.2f"
      
      println(s"$cid : $formattedAmount")
    }
  }
}