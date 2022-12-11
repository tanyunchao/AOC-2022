import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;


public class day4 {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("input.txt");
        Scanner sc = new Scanner(file);

        int count = 0;
        while (sc.hasNextLine()){
            String original = sc.nextLine();
            String[] arr = original.split("[-,]");

            int a = Integer.parseInt(arr[0]);
            int b = Integer.parseInt(arr[1]);
            int x = Integer.parseInt(arr[2]);
            int y = Integer.parseInt(arr[3]);

            // first guy is (a, b), second guy is (x, y)
            // below is first case where second guy contains first guy
            if(y - b >= 0 && x - a <= 0){
                count++;
            } else if(b - y >= 0 && a - x <= 0){
                count++;
            } else if((y >= a && b >= x)){ //part 2 addition
                count++;
            }
        }
        System.out.println(count);
        
    }
}
