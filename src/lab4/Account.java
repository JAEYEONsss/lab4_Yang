package lab4;

import java.lang.*;

public class Account {
    private int id, check;
    private int cash = 0;
    private String pwd;

    public Account(int id, int cash, String pwd) {
        this.id = id;
        this.cash = cash;
        this.pwd = pwd;
    }

    public void buy(Drink drink) {
        if (drink.getPrice() > this.cash) {
            System.out.println("you don't have enough money");
            return;
        } else if (drink.getStock() <= 0) {
            System.out.println("Sorry, We don't have any stock");
            return;
        }

        this.cash -= drink.getPrice();
        System.out.print("you bought " + drink.getDrink() + ". ");
        System.out.println("now, you have " + this.cash + " won.");
        drink.minus();
        System.out.printf("%s is now %d left more\n", drink.getDrink(), drink.getStock());

        return;
    }

    public int getId() {
        return this.id;
    }

    public String getPwd() {
        return this.pwd;
    }

    public int getCash() {
        return this.cash;
    }

    public void getGuap(int cash) {
        if (cash <= 0){
            System.out.println("put the money more than zero");
            return;
        }
        if (this.cash + cash > 100000){
            System.out.println("Keep the money, you have too much");
            return;
        }
        System.out.printf("user %d deposited money. %d", this.id, this.cash);
        this.cash += cash;
        System.out.printf(" -> %d\n", this.cash);

        return;
    }//돈 추가
}
