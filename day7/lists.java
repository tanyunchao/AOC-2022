import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class lists {
    public static int number = 0;
    public static ArrayList<Integer> directories = new ArrayList<>();

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("/Users/yunchao/Library/CloudStorage/OneDrive-NationalUniversityofSingapore/Documents/AdventOfCode/day7/input.txt");
        Scanner sc = new Scanner(file);

        int size = calcDir(sc);
        System.out.println(number);
        int amtFree = 70000000 - size;
        int amtToFree = 30000000 - amtFree;

        System.out.println("amt to free: " + amtToFree);

        int index = -1;
        int min = 1000000000;
        for (int i = 0; i < directories.size(); i++) {
            if(directories.get(i) >= amtToFree){
                int x = directories.get(i) - amtToFree;
                if(x < min){
                    index = i;
                    min = x;
                }
            }
        }

        System.out.println("answer = " + directories.get(index));

        sc.close();
    }

    public static int calcDir(Scanner sc) {

        ArrayList<Integer> currentDir = new ArrayList<>();
        while(sc.hasNextLine()){
            String[] x = sc.nextLine().split(" ");
            // System.out.println(Arrays.toString(x));
            if(x[0].equals("$")){
                if(x[1].equals("cd")){
                    if(x[2].equals("..")){
                        // cd..
                        // System.out.println("returning");
                        int dirTotal = sum(currentDir);
                        if(dirTotal <= 100000){
                            number += dirTotal;
                        }
                        directories.add(dirTotal);
                        return dirTotal;
                    } else{
                        for(int i = 0; i < currentDir.size(); i++){
                            if(currentDir.get(i) == -1){
                                currentDir.set(i, calcDir(sc));
                            }
                        }
                    }
                }
            } else {
                if(x[0].equals("dir")){
                    currentDir.add(-1);
                } else{ // if not dir then is size of file
                    currentDir.add(Integer.parseInt(x[0]));
                }
            }

            if(!sc.hasNextLine()){
                int dirTotal = sum(currentDir);
                if(dirTotal <= 100000){
                    number += dirTotal;
                }
                return dirTotal;
            }

        }

        int dirTotal = sum(currentDir);
        if(dirTotal <= 100000){
            number += dirTotal;
        }
        directories.add(dirTotal);
        return dirTotal;
    }

    public static int sum(ArrayList<Integer> arr) {
        int total = 0;
        for (int i = 0; i < arr.size(); i++) {
            total += arr.get(i);
        }
        return total;
    }

}