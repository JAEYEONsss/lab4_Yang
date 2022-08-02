package lab4;
import java.lang.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] id = new int[3];
        int[] price = new int[3];
        int stock, cash, insertId;
        int check = 0;
        int check_drink = 0;
        int end = 1;
        String[] pwd = new String[3];
        String[] drink = new String[3];
        String insertPwd, insertDrink;

        Account[] accounts = new Account[3];
        Drink[] drinks = new Drink[3];
        Scanner input = new Scanner(System.in);

        while (check != 3) {
            System.out.print("사용자 계정: ");
            id[check] = input.nextInt();
            System.out.print("사용자 계정 비밀번호: ");
            pwd[check] = input.next();

            if (id[check] < 1 || id[check] >= 10000) {
                System.out.println("retype your id");
                continue;
            }
            if (pwd[check].length() > 10 || pwd[check].length() <= 0) {
                System.out.println("retype your password");
                continue;
            }

            check++;
        }//id, password 입력

        check = 0;
        System.out.print("초기 예치금: ");
        cash = input.nextInt();

        for (int i = 0; i < 3; i++) {
            accounts[i] = new Account(id[i], cash, pwd[i]);
        }

        while (check != 3) {
            System.out.print("음료 이름: ");
            drink[check] = input.next();
            System.out.print("음료 가격: ");
            price[check] = input.nextInt();

            if (price[check] < 0 || price[check] > 10000) {
                System.out.println("음료 가격은 0원 초과, 10000원 이하입니다.");
                continue;
            }

            check++;
        }//음료 정보 입력

        check = 0;
        System.out.print("초기 재고: ");
        stock = input.nextInt();

        for (int i = 0; i < 3; i++) {
            drinks[i] = new Drink(drink[i], price[i], stock);
        }

        while (true) {
            System.out.println("Input the number of a menu that you want to run");
            System.out.println("1 : buy a drink");
            System.out.println("2 : deposit money");
            System.out.println("3 : see the current state");
            System.out.println("4 : program exit");

            check = input.nextInt();

            if (check == 1) {
                System.out.println("---MENU---");
                for (int i = 0; i < 3; i++) {
                    System.out.print(drinks[i].getDrink() + " - ");
                    System.out.println(drinks[i].getPrice() + " won");
                }
                System.out.println("----------");
                System.out.println("who are you? Input your account ID.");
                insertId = input.nextInt();
                System.out.println("Input the password");
                insertPwd = input.next();

                for (int i = 0; i < 3; i++) {
                    end = 0;
                    if(accounts[i].getId() == insertId) {
                        check = i;
                        end =1;
                        break;
                    }
                }

                if(end == 0){
                    System.out.println("you enter the wrong id");
                    continue;
                }

                if(accounts[check].getPwd().equals(insertPwd) == false){
                    System.out.println("you enter the wrong pwd");
                    continue;
                }

                System.out.printf("Hello %d. please specify the name of a drink that you want to buy.\n", accounts[check].getId());
                insertDrink = input.next();

                for (int i = 0; i < 3; i++) {
                    end = 0;
                    if(drinks[i].getDrink().equals(insertDrink)){
                        end =1;
                        check_drink = i;
                        break;
                    }
                }

                if (end == 0) {
                    System.out.printf("we dont have %s.\n", insertDrink);
                    continue;
                }

                accounts[check].buy(drinks[check_drink]);
            } else if (check == 2) {
                System.out.println("please type the amount that you want to deposit");
                cash = input.nextInt();

                System.out.println("who are you? Input your account ID.");
                insertId = input.nextInt();
                System.out.println("Input the password");
                insertPwd = input.next();

                for (int i = 0; i < 3; i++) {
                    end = 0;
                    if(accounts[i].getId() == insertId) {
                        check = i;
                        end =1;
                        break;
                    }
                }

                if(end == 0){
                    System.out.println("you enter the wrong id");
                    continue;
                }

                if(accounts[check].getPwd().equals(insertPwd) == false){
                    System.out.println("you enter the wrong pwd");
                    continue;
                }

                System.out.printf("Hello %d. please specify the name of a drink that you want to buy.\n", accounts[check].getId());
                accounts[check].getGuap(cash);

            } else if (check == 3) {
                System.out.println("----Current System State----");
                System.out.println("[users]");

                for (int i = 0; i < 3; i++) {
                    System.out.printf("%d : ",accounts[i].getId());
                    System.out.printf("%d won\n", accounts[i].getCash());
                }

                System.out.println();

                for (int i = 0; i < 3; i++) {
                    System.out.println("[drinks]");
                    System.out.printf("%s : ",drinks[i].getDrink());
                    System.out.printf("%d stock(s)\n", drinks[i].getStock());
                }
                System.out.println("----------------------------");
            } else if (check == 4) {
                System.out.println("Have a nice day~!");
                break;
            }else{
                System.out.println("select number from 1 to 4");
                continue;
            }
        }

    }
}
