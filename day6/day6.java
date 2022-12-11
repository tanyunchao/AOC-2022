package day6;

import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class day6 {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("/Users/yunchao/Library/CloudStorage/OneDrive-NationalUniversityofSingapore/Documents/AdventOfCode/day6/input.txt");
        Scanner sc = new Scanner(file);

        String input = sc.nextLine();
        int i = 14;
        while(true){
            String sub = input.substring(i - 14, i);
            boolean noDup = true;
            for (int j = 0; j < 13; j++) {
                for (int j2 = j + 1; j2 < 14; j2++) {
                    if(sub.charAt(j) == sub.charAt(j2)){
                        noDup = false;
                    }
                }
            }

            if(noDup){
                break;
            }
            i++;
        }
        System.out.println(i);

        sc.close();
    }
}