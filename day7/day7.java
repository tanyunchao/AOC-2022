import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class day7 {
    public static int number = 0;

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("input2.txt");
        Scanner sc = new Scanner(file);

        
        sc.close();
    }

    public static int calcDir(Scanner sc) {
        // String inputCmd = sc.nextLine();
        // System.out.println(inputCmd);
        int subDir = 0;
        int currentCount = 0;
        // String [] inputCmdArr = inputCmd.split(" ");
        // if(inputCmdArr[1].equals("cd") && !inputCmdArr[2].equals("..")){
        //     if(inputCmdArr[0].equals("$")){
        //         sc.nextLine(); //skip cd a
        //         inputCmdArr = sc.nextLine().split(" ");
        //     }
        // }
        System.out.println("fn called");
        String[] inputCmdArr = sc.nextLine().split(" ");
        //System.out.println("fn first line" + Arrays.toString(inputCmdArr));

        if(inputCmdArr[1].equals("cd")){
            // if(inputCmdArr[2].equals("..")){
            //     if(currentCount <= 100000){
            //         number += currentCount;
            //     }
            //     System.out.println("accident returns");
            //     sc.nextLine();
            //     sc.nextLine();

            //     return currentCount;
            // } else { //if its a normal cd next command confirm ls
                sc.nextLine(); //ls
                inputCmdArr = sc.nextLine().split(" ");
            //}
        }
        if(inputCmdArr[1].equals("ls")){
            inputCmdArr = sc.nextLine().split(" ");
        }
        

        //will overread a line
        while(sc.hasNextLine() && !inputCmdArr[0].equals("$")){
            if(inputCmdArr[0].equals("dir")){
                subDir++;
            } else{
                currentCount += Integer.parseInt(inputCmdArr[0]);
            }

            System.out.println(Arrays.toString(inputCmdArr));

            inputCmdArr = sc.nextLine().split(" ");
        }
        

        //System.out.println("out " + Arrays.toString(inputCmdArr));

        if(subDir > 0){
            for(int i = 0; i < subDir; i++){
                // int subValues = calcDir(sc);
                // if(subValues <= 100000){
                //     number += subValues;
                // }
                // currentCount += subValues;

                System.out.println();
                System.out.println("run " + i);
                currentCount += calcDir(sc);
                // System.out.println("for loop in calcDir");
            }
        }
        
        // System.out.println("no. of sub directories: " + subDir);
        System.out.println("current count: " + currentCount);
        //System.out.println("global var number: "  + number);
        
        //System.out.println("returns at: " + Arrays.toString(inputCmdArr));

        if(currentCount <= 100000){
            number += currentCount;
        }

        return currentCount;
    }
}


// 95437 is the ans
