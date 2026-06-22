import java.util.ArrayList;

public class ObserverPatternTest {

    interface Observer {
        void update(double price);
    }

    interface Stock {
        void registerObserver(Observer o);
        void deregisterObserver(Observer o);
        void notifyObservers();
    }

    static class StockMarket implements Stock {

        private ArrayList<Observer> observers = new ArrayList<>();
        private double stockPrice;

        public void registerObserver(Observer o) {
            observers.add(o);
        }

        public void deregisterObserver(Observer o) {
            observers.remove(o);
        }

        public void notifyObservers() {
            for (Observer o : observers) {
                o.update(stockPrice);
            }
        }

        public void setStockPrice(double stockPrice) {
            this.stockPrice = stockPrice;
            notifyObservers();
        }
    }

    static class MobileApp implements Observer {

        public void update(double price) {
            System.out.println("Mobile App: Stock price updated to Rs." + price);
        }
    }

    static class WebApp implements Observer {

        public void update(double price) {
            System.out.println("Web App: Stock price updated to Rs." + price);
        }
    }

    public static void main(String[] args) {

        StockMarket stockMarket = new StockMarket();

        Observer mobile = new MobileApp();
        Observer web = new WebApp();

        stockMarket.registerObserver(mobile);
        stockMarket.registerObserver(web);

        System.out.println("Stock Price Changed to 1000");
        stockMarket.setStockPrice(1000);

        System.out.println();

        System.out.println("Stock Price Changed to 1200");
        stockMarket.setStockPrice(1200);
    }
}