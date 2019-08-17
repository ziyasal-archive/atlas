
object Program {
  
  case class StockItem(day: Int, price:Int)
  case class ProfitItem (profit:Int, buyOn: Int, sellOn: Int)
  
  def main(args: Array[String]) : Unit ={
    
    var stockPricesPerDay = Array[StockItem]( StockItem(1, 12), StockItem(2, 13), StockItem(3, 8), StockItem(4, 14) )
    
    val result: ProfitItem =  profitCalc(stockPricesPerDay)
    
    println(s" Buy: ${result.buyOn}, Sell: ${result.sellOn}, Profit: ${result.profit}")
  }
  
  // O(N)
  def profitCalc(pricesPerDay: Array[StockItem]) : ProfitItem = {
    
    if( pricesPerDay.length == 0 ) {
      ProfitItem(0, 0, 0)
    }
    else {
      
      var minIndex: Int = 0
      var MaxIndex: Int = 0
      
      var min: Int = pricesPerDay(0).price
      
      var profitArray: Array[ProfitItem] = Array.fill(pricesPerDay.length) { ProfitItem(0, 0, 0) }
      
      for( i <- 1 until pricesPerDay.length ) {
        
        if( pricesPerDay(i).price < min ) {
          min = pricesPerDay(i).price
          minIndex = pricesPerDay(i).day
        }
        
        profitArray(i) = ProfitItem(math.max(profitArray(i - 1).profit, pricesPerDay(i).price - min), minIndex, pricesPerDay(i).day)
      }
      
      profitArray.foreach(p => println(s"( Buy on day: ${p.buyOn} - Sell on day: ${p.sellOn} =  profit: ${p.profit})"))
  
      profitArray(pricesPerDay.length - 1)
    }
  }
}

import Program._
main(Array[String]())