package day8;

import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class day8 {
    public static int visible = 0;
    public static int highScore = 0;

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("input.txt");
        Scanner sc = new Scanner(file);

        //main file is 99 x 99
        int size = 99; // for test case
        int[][] plot = new int[size][size];

        int x = 0;
        // reading in plot of land 
        while (sc.hasNextLine()){
            String inputLine = sc.nextLine();
            for(int i = 0; i < inputLine.length(); i++){
                plot[x][i] = Integer.parseInt(inputLine.substring(i, i + 1));
            }
            x++;
        }

        // to visualise plot
        // for (int i = 0; i < size; i++) {
        //     System.out.println(Arrays.toString(plot[i]));
        // }

        //partOne(plot);
        
        //int[][] scenicAggregate = new int[size][size];
        for(int row = 0; row < size; row++){
            for(int col = 0; col < size; col++){
                
                //check top
                int topScore = 0;

                if(row - 1 >= 0){
                    for (int i = row - 1; i > -1; i--) {
                        if(plot[i][col] < plot[row][col]){
                            topScore++;
                        }
                        if(plot[i][col] >= plot[row][col]){
                            topScore++;
                            break;
                        }
                    }
                }

                //check bot 
                int botScore = 0;

                if(row + 1 <= size - 1){
                    for (int i = row + 1; i < size; i++) {
                        if(plot[i][col] < plot[row][col]){
                            botScore++;
                        }
                        if(plot[i][col] >= plot[row][col]){
                            botScore++;
                            break;
                        }
                    }
                }

                //check left
                int leftScore = 0;

                if(col - 1 >= 0){
                    for (int i = col - 1; i > -1; i--) {
                        if(plot[row][i] < plot[row][col]){
                            leftScore++;
                        }
                        if(plot[row][i] >= plot[row][col]){
                            leftScore++;
                            break;
                        }
                    }
                }

                //check right
                int rightScore = 0;

                if(col + 1 <= size - 1){
                    for (int i = col + 1; i < size; i++) {
                        if(plot[row][i] < plot[row][col]){
                            rightScore++;
                        }
                        if(plot[row][i] >= plot[row][col]){
                            rightScore++;
                            break;
                        }
                    }
                }


                //compare and keep highest
                highScore = Math.max(highScore, topScore*botScore*leftScore*rightScore);
            }
        }

        System.out.println("highscore: " + highScore);
    
        sc.close();
    }

    public static void partOne(int[][] plot) {
        // to visualise plot
        // for (int i = 0; i < size; i++) {
        //     System.out.println(Arrays.toString(plot[i]));
        // }
        
        int size = plot[0].length;

        // to be visible from any direction, plot[i][j] must be taller than all others in that direction
        for(int row = 1; row < size - 1; row++){
            for(int col = 1; col < size - 1; col++){
                boolean canSee = false;
                
                //check from top
                boolean topflag = true;
                for (int i = 0; i < row ; i++) {
                    if(plot[i][col] >= plot[row][col]){
                        topflag = false;
                    }
                }
                if(topflag){
                    canSee = true;
                }

                //check from bottom
                boolean botflag = true;
                for (int i = size - 1; i > row; i--) {
                    if(plot[i][col] >= plot[row][col]){
                        botflag = false;
                    }
                }
                if(botflag){
                    canSee = true;
                }


                //check from left
                boolean leftflag = true;
                for (int i = 0; i < col; i++) {
                    if(plot[row][i] >= plot[row][col]){
                        leftflag = false;
                    }
                }
                if(leftflag){
                    canSee = true;
                }

                //check from right 
                boolean rightflag = true;
                for (int i = size - 1; i > col; i--) {
                    if(plot[row][i] >= plot[row][col]){
                        rightflag = false;
                    }
                }
                if(rightflag){
                    canSee = true;
                }

                //boolean condition if true, visible ++
                if(canSee){
                    //System.out.println("row :" + row + ", col: " + col );
                    visible++;
                }

            }
        }

        visible += size * 2 + (size - 2) * 2;
        System.out.println("visible = " + visible);        
    }
}
