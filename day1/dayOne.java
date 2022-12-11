import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

class dayOne{
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("/Users/yunchao/Library/CloudStorage/OneDrive-NationalUniversityofSingapore/Documents/AdventOfCode/day1/input.txt");
        Scanner sc = new Scanner(file);

        int first = 0, second = 0, third = 0;
        int current = 0;
        while (sc.hasNextLine()) {
            // part one
            // String input = sc.nextLine();
            // if(input.equals("")){
            //     max = Math.max(max, current);
            //     current = 0;
            // } else {
            //     current += Integer.parseInt(input);
            // }

            // part two
            
            String input = sc.nextLine();
            if(input.equals("")){
                if(current > first){
                    int temp = first;
                    first = current;
                    if (temp > second){
                        int hold = second;
                        second = temp;
                        if (hold > third){
                            third = hold;
                        }
                    }
                } else if(current > second){
                    int temp = second;
                    second = current;
                    if (temp > third){
                        third = temp;
                    }
                } else if (current > third){
                    third = current;
                }
                current = 0;
                
    
            } else {
                current += Integer.parseInt(input);
            }


        }
        System.out.println(first + second + third);


    }

}