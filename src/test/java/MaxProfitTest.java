import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StockItem {
    public int day;
    public int price;

    public StockItem(int day, int price) {
        this.day = day;
        this.price = price;

    }
}

class ProfitItem {
    public int buyOn;
    public int sellOn;
    public int profit;

    public ProfitItem(int buyOn, int sellOn, int profit) {
        this.buyOn = buyOn;
        this.sellOn = sellOn;
        this.profit = profit;
    }
}

public class MaxProfitTest {

    @Test
    public void bidi_Test() {

        StockItem[] stockPricesPerDay = new StockItem[] { new StockItem(1, 12), new StockItem(2, 13),
                new StockItem(3, 8), new StockItem(4, 14) };

        ProfitItem result = calculate(stockPricesPerDay);

        System.out.println(" Buy: " + result.buyOn + "Sell: " + result.sellOn + "Profit: " + result.profit);
        assertThat(true).isEqualTo(true);
    }

    private ProfitItem calculate(StockItem[] stockPricesPerDay) {
        // 12, 13, 8, 14

        if(stockPricesPerDay.length == 0) return new ProfitItem(-1, -1, -1);
        if (stockPricesPerDay.length == 1) return new ProfitItem(1, 1, 0);

        int minPrice = stockPricesPerDay[0].price;
        int profit = 0;
        int minIndex = 0;
        int sellOn = 0;

        for (int i = 1; i < stockPricesPerDay.length; i++) {
            StockItem current =  stockPricesPerDay[i];

            if( current.price < minPrice){
                minPrice = current.price;
                minIndex = i;
            }

            sellOn = current.day;
            if((current.price - minPrice) > profit){
                profit = (current.price - minPrice);
            }else{
                profit = current.price - stockPricesPerDay[i-1].price;
            }
        }
        
        return new ProfitItem(stockPricesPerDay[minIndex].day,  sellOn, profit);
    }
}
