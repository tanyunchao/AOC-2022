import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class day9 {
    public static ArrayList <Point> listOfPoints = new ArrayList<>(); //unique list of points tail visited
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("input.txt");
        Scanner sc = new Scanner(file);

        // part one
        // Point heads = new Point(0, 0);
        // Point tails = new Point(0, 0);
        Point[] rope = new Point[10];
        for (int i = 0; i < rope.length; i++) {
            rope[i] = new Point(0, 0);
        }

        //add starting point to unique list
        listOfPoints.add(new Point(0, 0));


        while (sc.hasNextLine()){
            String[] inputs = sc.nextLine().split(" ");
            int moves = Integer.parseInt(inputs[1]);
            String direction = inputs[0];



            for (int i = 0; i < moves; i++) {
                switch(direction){
                    case "R":
                        rope[0].x++;
                        break;

                    case "L":
                        rope[0].x--;
                        break;

                    case "U":
                        rope[0].y++;
                        break;

                    case "D":
                        rope[0].y--;
                        break;
                }

                for (int j = 0; j < rope.length - 1; j++) {
                    if(j + 1 == 9){
                        reaction(rope[j], rope[j + 1], true);                        
                    } else {
                        reaction(rope[j], rope[j + 1], false);
                    }
                    
                }

            }
        }

        System.out.println(listOfPoints.size());

        // int[][] arr = new int[7][7];
        // //visualise plot
        // for (int i = 0; i < 11; i++) {
        //     Point p = listOfPoints.get(i);
        //     arr[p.x][p.y] = 1;
        // }

        // for (int i = 0; i < 7; i++) {
        //     System.out.println(Arrays.toString(arr[i]));
        // }

        sc.close();
    }

    public static void reaction(Point first, Point second, boolean last){
        if(Math.abs(first.x - second.x) > 1 || Math.abs(first.y - second.y) > 1){
            //same x, means need to change y
            if(first.x == second.x){
                if(first.y - second.y > 0){
                    second.y++;
                } else{
                    second.y--;
                }
            } else if(first.y == second.y){ // same y, mneans change x
                if(first.x - second.x > 0){
                    second.x++;
                } else{
                    second.x--;
                }
            } else{ //not same row or same col means need to move diagonally to get closer
                //calculate which diagonal to take

                //change to if(first.x > second.x && first.y > second.y) => top right, followed by else if statements to check

                if(first.x > second.x && first.y > second.y){ // top right
                    second.x++;
                    second.y++;
                } else if(first.x > second.x && first.y < second.y){ // bottom right
                    second.x++;
                    second.y--;
                } else if(first.x < second.x && first.y > second.y){ //top left
                    second.x--;
                    second.y++;
                } else { // botom left
                    second.x--;
                    second.y--;
                }

            }

            //only store points for last node
            if(last){
                calc(second);
            }
        }

    }


    public static void calc(Point p){
        boolean unique = true;
        for (int i = 0; i < listOfPoints.size(); i++) {
            if(p.equals(listOfPoints.get(i))){
                unique = false;
            }
        }

        if(unique){
           // System.out.println(p.toString());
            listOfPoints.add(new Point(p.x, p.y));
        }
    }
}
