import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class tree {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("/Users/yunchao/Library/CloudStorage/OneDrive-NationalUniversityofSingapore/Documents/AdventOfCode/day7/input2.txt");
        Scanner sc = new Scanner(file);
        ArrayList<String> stack = new ArrayList<String>();

        


        while (sc.hasNextLine()){
            String[] input = sc.nextLine().split(" ");
            if(input[0].equals("$")){
                if(input[1].equals("cd")){
                    cd(input[2], stack);
                } else {
                    //nth much to do for ls
                }
            } else{
                //directory nonsense 
                // if see dir, new directory
            }
        }

        System.out.println(stack.toString());
        sc.close();
    }


    public static void cd(String x, ArrayList<String> y) {
        if(x.equals("..")){
            //pop directory off stack 
            y.remove(y.size() - 1);
        } else{
            y.add(x);
        }
    }
}

