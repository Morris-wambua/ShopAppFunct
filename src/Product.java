
public class Product {
    private String name;
    private int stockLevel;
    private double price;

    //create a constructor method fot the product class
    public Product(String name, int stockLevel, double price) {
        this.name=name;
        this.stockLevel = stockLevel;
        this.price = price;
    }

    //create buyStock method
    public double buyStock(int newStock){
        stockLevel+=newStock;
        return newStock;
    }

    //create sell method
    public boolean sell(int itemSold){

        if((stockLevel-itemSold)<0) {
            return false;
        }
        else {
            int newStockLevel=stockLevel-itemSold;
            stockLevel=newStockLevel;
            return true;
        }
    }

    //create setters
    public void setPrice(double price) {
        this.price = price;
    }

    //getters
    public String getName() {
        return name;
    }

    public int getStockLevel() {
        return stockLevel;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Product[" +
                "name='" + name + '\'' +
                ", stockLevel=" + stockLevel +
                ", price=" + price +
                ']';
    }
}