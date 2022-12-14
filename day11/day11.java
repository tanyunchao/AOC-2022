import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class day11 {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("/Users/yunchao/Library/CloudStorage/OneDrive-NationalUniversityofSingapore/Documents/AdventOfCode/AOC-2022/day11/input.txt");
        Scanner sc = new Scanner(file);
        Monkey[] monkeys = new Monkey[8]; //need to change manually
        int counter = 0;

        while (sc.hasNextLine()){
            // monkey instructions 6 line
            sc.nextLine(); // monkey number

            //adding in starting items into arraylist
            String[] itemsInput = sc.nextLine().trim().split(" ");
            ArrayList<Long> startingItems = new ArrayList<>();
            for (int i = 0; i < itemsInput.length; i++) {
                if(itemsInput[i].length() > 3){
                    //do nth
                } else if(itemsInput[i].length() == 3){
                    startingItems.add(Long.parseLong(itemsInput[i].substring(0, 2)));
                } else if(i == itemsInput.length - 1){
                    startingItems.add(Long.parseLong(itemsInput[i]));
                }
            }

            //operations, to get sign and digit
            int sign, digit;
            String[] operationsInput = sc.nextLine().trim().split(" ");
            int opLength = operationsInput.length;
            if(operationsInput[opLength - 2].equals("+")){
                sign = 0;
            } else if(operationsInput[opLength - 2].equals("-")){
                sign = 1;
            } else if(operationsInput[opLength - 2].equals("*")){
                sign = 2;
            } else if(operationsInput[opLength - 2].equals("/")){
                sign = 3;
            } else {
                sign = -1;
            }
            if(operationsInput[opLength - 1].equals("old")){
                digit = 0;
            } else{
                digit = Integer.parseInt(operationsInput[opLength - 1]);
            }

            String[] testInput = sc.nextLine().trim().split(" ");
            int divDigit = Integer.parseInt(testInput[testInput.length - 1]);

            String[] monkeyOneInput = sc.nextLine().trim().split(" ");
            int trueMonkey = Integer.parseInt(monkeyOneInput[monkeyOneInput.length - 1]);

            String[] monkeyTwoInput = sc.nextLine().trim().split(" ");
            int falseMonkey = Integer.parseInt(monkeyTwoInput[monkeyTwoInput.length - 1]);

            //initialise monkeys
            monkeys[counter] = new Monkey(startingItems, sign, digit, divDigit, trueMonkey, falseMonkey);
            //visualise monkey input after parsing
            // for (int i = 0; i < 2; i++) {
            //     System.out.println(monkeys[counter].formattedStringArr()[i]);
            // }

            counter++;

            if(sc.hasNextLine()){
                sc.nextLine(); // eat up blank lines after each monkey
            }
        }

        Long superModulo = 1L;
        for (int j = 0; j < monkeys.length; j++) {
            superModulo *= monkeys[j].getDivisor();
        }
        Monkey.setSuperMod(superModulo);
        // System.out.println(superModulo);

        //call round fn 
        int numberOfRounds = 10000; // change manually
        for (int j = 0; j < numberOfRounds; j++) {
            round(monkeys);
        }

        for (int i = 0; i < monkeys.length; i++) {
            System.out.println(monkeys[i].inspect);
        }

        sc.close();
    }

    public static void round(Monkey[] monkeys){
        //execute number of 
        for (int i = 0; i < monkeys.length; i++) {
            ArrayList<Integer> receivingMonkeys = monkeys[i].turn();
            for (int j = 0; j < receivingMonkeys.size(); j++) {
                int receiptient = receivingMonkeys.get(j);
                monkeys[receiptient].get(monkeys[i].throwItem());
            }
        }
    }
}
