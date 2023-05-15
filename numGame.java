//package numberguess;
import java.util.Random; 
import java.util.Scanner;
import java.util.ArrayList;
public class numGame {
    int range;
    int num = 0;
    int numGuesses = 1;
    int randInt;
    int randnumranges;
    ArrayList<Integer> guesed = new ArrayList<Integer>();

    numGame(int randnumranges){
        this.randnumranges = range;
        Random r = new Random();
        Scanner sc = new Scanner(System.in);
        randInt = r.nextInt(randnumranges);
        while (!(num == randInt)) {
            if (sc.hasNextInt()) {
                guesed.add(num);
                num = sc.nextInt();
                if (!(num <= randnumranges && num >= 1)) {
                    System.out.println("You input a number that is out of the guess range, please input a number between 1 and " + randnumranges);
                } else if (guesed.contains(num)){
                    System.out.println("You have already guesed this number, please guess again");
                } else if(num > randInt){
                    System.out.println("The number is less than " + num + ", please reguess!");
                    numGuesses += 1;
                }else if(num < randInt){
                    System.out.println("the number is more than " + num + ", please reguess!");
                    numGuesses += 1;
                }
            } else {
                System.out.println("You did not input a number, please input one between 1 and " + randnumranges);
                sc.next();
            }
        }
        numGuesses += 1;
        System.out.println("Congrats you won in " + numGuesses + " guesses!!!");
    }

    public void numGuesses() {
    }
}
