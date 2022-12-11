import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;


public class day2 {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("input.txt");
        Scanner sc = new Scanner(file);

        int score = 0;

        // while (sc.hasNextLine()){
        //     char you = sc.next().charAt(0);
        //     char me = sc.next().charAt(0);
        //     int currentRound = 0;
        //     switch(me){
        //         case 'X':
        //             score += 1;
        //             switch(you){
        //                 case 'A':
        //                     score += 3;
        //                     break;
        //                 case 'B':
        //                     break;
        //                 case 'C':
        //                     score +=6;
        //                     break;
        //             }
        //             break;
        //         case 'Y':
        //             score += 2;
        //             switch(you){
        //                 case 'A':
        //                     score += 6;
        //                     break;
        //                 case 'B':
        //                     score += 3;
        //                     break;
        //                 case 'C':
        //                     break;
        //             }
        //             break;
        //         case 'Z':
        //             score += 3;
        //             switch(you){
        //                 case 'A':
        //                     break;
        //                 case 'B':
        //                     score += 6;
        //                     break;
        //                 case 'C':
        //                     score += 3;
        //                     break;
        //             }
        //             break;
        //     }
        // }

        // part two
        while (sc.hasNextLine()){
            char you = sc.next().charAt(0);
            char me = sc.next().charAt(0);
            int currentRound = 0;
            switch(me){
                case 'X':
                    switch(you){
                        case 'A':
                            score += 3;
                            break;
                        case 'B':
                            score += 1;
                            break;
                        case 'C':
                            score +=2;
                            break;
                    }
                    break;

                case 'Y':
                    score += 3;
                    switch(you){
                        case 'A':
                            score += 1;
                            break;
                        case 'B':
                            score += 2;
                            break;
                        case 'C':
                            score +=3;
                            break;
                    }
                    break;
                
                case 'Z':
                    score += 6;
                    switch(you){
                        case 'A':
                            score += 2;
                            break;
                        case 'B':
                            score += 3;
                            break;
                        case 'C':
                            score +=1;
                            break;
                    }
                    break;
                

            }


        }
        System.out.println(score);
        
    }
}
