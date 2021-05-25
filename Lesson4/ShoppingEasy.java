import java.util.ArrayList;
import java.util.List;

public class ShoppingEasy {


    public static void main(String[] args) {
        Buyer buyer = new Buyer(100);
        buyer.add(new Product("молоко", 60));
        buyer.add(new Product("шоколадка", 30));
        // buyer.add(new Product("шоколадка", 30));
        try {
            System.out.println(buyer.payForGoods());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class Buyer {

    private double money;
    private List<Product> basket = new ArrayList<>();
    private double sum;

    public Buyer(double money) {
        this.money = money;
        sum = 0;
    }

    public String payForGoods() throws Exception {
        if (sum > money)
            throw new Exception("not enough money");
        money -= sum;
        return basketToSrtring();
    }

    public void add(Product p) {
        sum += p.getPrice();
        basket.add(p);
    }

    public String basketToSrtring() {
        String str = "";
        for (Product p : basket) {
            str += p + "\n";
        }
        str += "Сумма " + sum + "р.\n";
        return str;
    }
}

class Product {
    private String name;
    private double price;

    public double getPrice() {
        return price;
    }

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return name + " " + price + "р.";
    }
}