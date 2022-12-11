import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class day3 {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("input.txt");
        Scanner sc = new Scanner(file);
                
        int priorities = 0;
        int count = 0;
        while (sc.hasNextLine()){
            // String full = sc.nextLine();
            // String front = full.substring(0, full.length()/2);
            // String back = full.substring(full.length()/2);

            // part one
            // for(int i = 0; i < front.length(); i++){
            //     if(front.indexOf(back.charAt(i)) != -1){
            //         if(back.charAt(i) <= 90){
            //             priorities += back.charAt(i) - 65 + 27;
            //             break;
            //         } else {
            //             priorities += back.charAt(i) - 96;
            //             break;
            //         }
            //     }
            // }
            // count ++;
            
            String[] arr = new String[3];
            for(int i = 0; i < 3; i++){
                arr[i] = sc.nextLine();
            }
            for(int j = 0; j < arr[0].length(); j++){
                if(arr[1].indexOf(arr[0].charAt(j)) != -1 && arr[2].indexOf(arr[0].charAt(j)) != -1){
                    if(arr[0].charAt(j) <= 90){
                        priorities += arr[0].charAt(j) - 65 + 27;
                        break;
                    } else {
                        priorities += arr[0].charAt(j) - 96;
                        break;
                    }
                }
            }
    

        }
        
        System.out.println(count);
        System.out.println(priorities);
        
    }
}
