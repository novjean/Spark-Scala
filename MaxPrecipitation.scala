package com.sundogsoftware.spark

import org.apache.spark._
import org.apache.spark.SparkContext._
import org.apache.log4j._
import scala.math.max

object MaxPrecipitation {
  
  def parseLine(line: String) =
  {
    val fields = line.split(",")
    val date = fields(1)
    val measureType = fields(2)
    val precipValue = fields(3)
    
    (date, measureType, precipValue)
  }
  
  def main(args: Array[String])
  {
    Logger.getLogger("org").setLevel(Level.ERROR)
    
    val sc = new SparkContext("local[*]", "MaxPrecipitation")
    
    val lines = sc.textFile("../1800.csv")
    
    val parsedLines = lines.map(parseLine)
    
    val precipLines = parsedLines.filter(x=>x._2 == "PRCP")
    
    val remPrcpLines = precipLines.map(x => (x._1,x._3.toFloat))
    
    val maxPrecipByDate = remPrcpLines.reduceByKey((x,y) => max(x,y))
    
    val results = maxPrecipByDate.collect()
    
    for(result <- results.sorted)
    {
      val date = result._1
      val temp = result._2
      
      println(s"$date max precipitation: $temp")
    }
        
    
  }
  
}