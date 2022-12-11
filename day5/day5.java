package day5;

import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class day5 {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("/Users/yunchao/Library/CloudStorage/OneDrive-NationalUniversityofSingapore/Documents/AdventOfCode/day5/input.txt");
        Scanner sc = new Scanner(file);

        char[][] arr = new char[9][8];
        for(int i = 0; i < 8; i ++){
            String s = sc.nextLine();
            int counter = 0;
            for(int j = 1; j < 34; j += 4){
                arr[counter][i] = s.charAt(j);
                counter++;
            }
        }

        // for(int k = 0; k < 8; k++){
        //     System.out.println(Arrays.toString(arr[k]));
        // }

        List[] listOfArr = new List[9];
        for (int i = 0; i < 9; i++) {
            listOfArr[i] = new ArrayList<>();
        }

        // re order rows and store into new array
        for(int i = 0; i < 9; i++){
            for(int j = 7; j >= 0; j--){
                if(arr[i][j] != ' '){
                    listOfArr[i].add(arr[i][j]);
                }
            }
        }

        for (int i = 0; i < listOfArr.length; i++) {
            System.out.println(listOfArr[i].toString());
        }

        // get rid of next 2 lines
        sc.nextLine();
        sc.nextLine();

        System.out.println("after");

        // move 4 from 5 to 9
        while (sc.hasNextLine()){
            sc.next();
            int a = sc.nextInt();
            sc.next();
            int b = sc.nextInt() - 1;
            sc.next();
            int c = sc.nextInt() - 1;

            // part one
            // for (int i = 0; i < a; i++) {
            //     listOfArr[c].add(listOfArr[b].remove(listOfArr[b].size() - 1));
            // }

            //part 2
            int x = listOfArr[b].size() - a;
            int y = listOfArr[b].size();
            while(y != x){
                listOfArr[c].add(listOfArr[b].remove(x));
                y = listOfArr[b].size();
            }
        }

        for (int i = 0; i < listOfArr.length; i++) {
            System.out.println(listOfArr[i].toString());
        }


        sc.close();
    }
}