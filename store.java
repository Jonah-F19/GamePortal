import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;

public class store implements Game {
    static items[] watchs = new items[3];
    static items[] vehicles = new items[4];
    static items[] groceries = new items[6];
    static ArrayList<Integer> owned = new ArrayList<Integer>();
    static Scanner sc = new Scanner(System.in);
    static player p;
    static boolean gameOver;
    // public static void main(String[] args) throws Exception{
    // play();
    // }

    public void play() {
        watchs[0] = new Watch("Rose gold rolex", 65000.0, 100.0, true);
        watchs[1] = new Watch("Hublot", 10000.0, 95.0, true);
        watchs[2] = new Watch("Walmart watch", 15.0, 60.0, false);

        vehicles[0] = new Vehicle("Honda Accord", 30000.0, 75.0, true);
        vehicles[1] = new Vehicle("Hennessy venom f5", 3500000.0, 100.0, true);
        vehicles[2] = new Vehicle("inflatable boat", 1500.0, 65.0, false);
        vehicles[3] = new Vehicle("yacht", 2500000.0, 90.0, false);

        groceries[0] = new Groceries("2 dozen Eggs", 16.0, 80.0, true);
        groceries[1] = new Groceries("2 gallons of milk", 12.0, 80.0, true);
        groceries[2] = new Groceries("6 apples", 4.0, 97.0, true);
        groceries[3] = new Groceries("1 dozen Eggs", 8.0, 80.0, false);
        groceries[4] = new Groceries("gallon of milk", 6.0, 80.0, false);
        groceries[5] = new Groceries("apple", 2.0, 97.0, false);

        gameIntro();
        System.out.println("Great Choice, you have " + p.money + " dollars!!");
        System.out.println("Hello, welcome to the super store!");
        System.out.println("Today we have 10 items in stock ranging from cars, to watches, all the way to groceries.");
        store();
        if (p.money < 2) {
            System.out.println(
                    "Your game has ended due to you not having enough money to buy the cheapest item, a dozen eggs.");
        }
        System.out.println("Thank you for playing. You bought a total of " + owned.size() + "items.");
        System.out.println("Including ");
        for (int i : owned) {
            items has = getItemAtIndex(i);
            System.out.println(has.name);
        }
    }

    public String getScore(){
        return "2";
    }

    public void writeHighScore(File file) {
        return;
    }
    public String getGameName() {
        return "store";
    }

    public static void gameIntro() {
        System.out.println("Choose which celebrity would you like to be: ");
        System.out.println("1. Daniel Jones");
        System.out.println("2. Sterling Shepard");
        System.out.println("3. Lionel Messi");
        System.out.println("4. Landon Colins");
        int ans = 0;
        while (ans > 4 || ans < 1) {
            if (sc.hasNextInt()) {
                ans = sc.nextInt();
                if (ans > 4 || ans < 1) {
                    System.out.println("You input a incorrect number, please input a number 1-4");
                }
            } else {
                System.out.println("You did not enter a number, please enter a number from 1-4");
                sc.next();
            }
        }
        p = new player(ans);

    }

    public static void store() {
        while (gameOver != true || p.money < 2) {
            System.out.println("Would you like to 1. buy or 2. sell items today?");
            int option = 0;
            int over = 0;
            while (option > 2 || option < 1) {
                if (sc.hasNextInt()) {
                    option = sc.nextInt();
                    if (option > 2 || option < 1) {
                        System.out.println("You input a incorrect number, please input 1 or 2");
                    }
                } else {
                    System.out.println("You did not enter a number, please input 1 or 2");
                    sc.next();
                }
            }
            if (option == 1) {
                buy();
            } else if (option == 2) {
                sell();
            }
            System.out.println("Thank you so much!!! You now own: ");
            for (int i : owned) {
                items has = getItemAtIndex(i);
                System.out.println("A(n) " + has.name);
            }
            if (owned.size() == 0) {
                System.out.println("Nothing");
            }
            System.out.println("Would you like to continue playing or do you want end here?");
            System.out.println("Enter 1 to continue and 2 to end");
            while (over > 2 || over < 1) {
                if (sc.hasNextInt()) {
                    over = sc.nextInt();
                    if (over > 2 || over < 1) {
                        System.out.println("You input a incorrect number, please input 1 or 2");
                    }
                } else {
                    System.out.println("You did not enter a number, please input 1 or 2");
                    sc.next();
                }
            }
            if (over == 2) {
                gameOver = true;
            }
        }
    }

    public static void buy() {
        System.out.println("Hello, today we have");
        for (int i = 0; i < 3; i++) {
            System.out.println(i + 1 + ". " + watchs[i].name + ". The price is " + watchs[i].price);
            watchs[i].indexvalue = i + 1;
        }
        for (int i = 0; i < 4; i++) {
            System.out.println(i + 4 + ". " + vehicles[i].name + ". The price is " + vehicles[i].price);
            vehicles[i].indexvalue = i + 4;
        }
        for (int i = 0; i < 6; i++) {
            System.out.println(i + 8 + ". " + groceries[i].name + ". The price is " + groceries[i].price);
            groceries[i].indexvalue = i + 8;
        }
        System.out.println(
                "which would you like to buy. If you have changed your mind and would like to sell please enter 14");
        int item = 0;
        while (item > 14 || item < 1) {
            if (sc.hasNextInt()) {
                item = sc.nextInt();
                if (item > 11 || item < 1) {
                    System.out.println("You input a incorrect number, please input a number between 1 and 14");
                }
            } else {
                System.out.println("You did not enter a number, please input a  number between 1 and 14");
                sc.next();
            }
            if (item == 14) {
                sell();
            } else {
                items choice = getItemAtIndex(item);
                if (choice.price > p.money) {
                    System.out.println("sorry you do not have enough money to buy this item");
                } else {
                    p.money = p.money - choice.price;
                    owned.add(item);
                }
                System.out.println("Thank you for buying a(n) " + choice.name);
                choice.description();
                System.out.println("You now have " + p.money + " left.");
            }
        }
    }

    public static items getItemAtIndex(int index) {
        for (int i = 0; i < 3; i++) {
            if (watchs[i].indexvalue == index) {
                return watchs[i];
            }
        }
        for (int i = 0; i < 4; i++) {
            if (vehicles[i].indexvalue == index) {
                return vehicles[i];
            }
        }
        for (int i = 0; i < 6; i++) {
            if (groceries[i].indexvalue == index) {
                return groceries[i];
            }
        }
        return null;
    }

    public static void sell() {
        if (owned.size() == 0) {
            System.out.println(
                    "You cannot sell any items due to you not owning any items. Please head over to the buy function");
        } else {
            System.out.println("Hello what item would you like to sell");
            int j = 0;
            for (int i : owned) {
                j++;
                items has = getItemAtIndex(i);
                System.out.println(j + ") A(n) " + has.name + " which you can sell for "
                        + has.resaleValue / 100 * has.price + ". AKA " + has.resaleValue + "% of its value.");
            }
            System.out.println(
                    "which would you like to sell. If you have changed your mind and would like to sell please enter 5311");
            int item = 0;
            while (item < owned.size() || item > 1) {
                if (sc.hasNextInt()) {
                    item = sc.nextInt();
                    if (item > 11 || item < 1) {
                        System.out.println(
                                "You input a incorrect number, please input a number between 1 and " + owned.size());
                    }
                } else {
                    System.out.println(
                            "You did not enter a number, please input a  number between 1 and " + owned.size());
                    sc.next();
                }
                if (item == 5311) {
                    buy();
                } else {
                    items choice = getItemAtIndex(owned.get(item - 1));
                    if (owned.size() == 0) {
                        System.out.println("sorry you do not own any items, please go to the buy function");
                    } else {
                        p.money = p.money + choice.resaleValue / 100 * choice.price;
                        owned.remove(item - 1);
                    }
                    System.out.println("Thank you for selling a(n) " + choice.name);
                    choice.description();
                    System.out.println("You now have " + p.money + " left.");
                }
            }
        }
    }
}