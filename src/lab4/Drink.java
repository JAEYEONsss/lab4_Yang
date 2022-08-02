package lab4;

import java.lang.*;

public class Drink {
    private String drink;
    private int price;
    private int stock;


    public Drink(String drink, int price, int stock) {
        this.drink = drink;
        this.price = price;
        this.stock = stock;
    }

    public void minus() {
        this.stock -= 1;
    }

    public int isPrice() {
        return this.price;
    }//소비자가 돈을 충분히 갖고 있는지

    public String getDrink() {
        return this.drink;
    }

    public int getStock() {
        return this.stock;
    }

    public int getPrice() {
        return this.price;
    }
}
