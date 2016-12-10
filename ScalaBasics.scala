package com.sundogsoftware.spark

object LearnScala {
  
  def SquareIt(x:Int) : Int = {
      x*x
     }
  
  def transformInt(x:Int, f:Int=>Int):Int = {                      //perfoms the function on x
      f(x) 
    }
  
  def main(args: Array[String]){
  
      val hello: String = "hello world"                         //Val is a constant value
      println(hello)
      
      var num: Int = 20                            //Var allows the value to changed, hence mutable variable
      println(num)
      
      for(i <- 1 to 10)                            //for loop
        println(i)
      
      println("Square of 3 is " +SquareIt(3))           //calling the function
      
      println(transformInt(4, x => x*x*x));             //pasing the value of x along with the function it has to perform
      
      println(transformInt(5, x=> {val y = x*3; y*y}))
      
      val sentence = ("nova", "jar", "boeing - 747");       //creating an array of string pretty much
      println(sentence);
      println(sentence._1)                                    //access them using name._1  //index starts at 1 and not 0
      println(sentence._2)
      println(sentence._3)
       
      val keyVal = "key"->"value"      //>
      println(keyVal._2)
      
      val listExample = List("hello","world", "nova", "test");
      println(listExample(2))
      println(listExample.head)
      println(listExample.tail)
      
      for (value <- listExample)
        println(value)
        
      val numberList = List(1,2,3,4,5)
      val sum = numberList.reduce((x:Int, y:Int) =>x+y)
      println(sum)
      
      val iHateFives = numberList.filter((x:Int) => x!=5)
      println(iHateFives)
      
      val iHateThrees = numberList.filter(_ !=3)      //filter values not equal to 3
      println(iHateThrees)
      
      val moreNumbers = List(9,7,8)
      val lotsOfNumbers = numberList ++ moreNumbers    //join two lists
      println(lotsOfNumbers)
      
      val reversed = lotsOfNumbers.reverse            //reverse the list
      println(reversed)
      
      val duplicateNumberList = numberList ++ numberList
      println(duplicateNumberList)
      
      val distinctValues = duplicateNumberList.distinct      //determine the distinct values
      println(distinctValues)
      
      println(lotsOfNumbers.sorted)
      
      println(numberList.max)          //display the max value 
      
      var map1 = Map(1 -> "John", 2 -> "Lame", 3-> "Rodeo" )
      map1 = map1 ++ Map(4 ->"tim")
      println(map1(4))
  }
  
}
