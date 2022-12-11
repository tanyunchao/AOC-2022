import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class day10 {
    public static int cycleCount = 0;
    public static int xCount = 1;
    public static ArrayList<Integer> xHist = new ArrayList<>();
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("input.txt");
        Scanner sc = new Scanner(file);

        //initialise cycle 0
        update();

        while (sc.hasNextLine()){
            String[] inputs = sc.nextLine().split(" ");
            if(inputs.length == 1){
                noop();
            } else{
                addx(Integer.parseInt(inputs[1]));
            }
        }

        // part one
        // int totalSignal = 0;
        // for (int i = 20; i < 221; i += 40) {
        //     System.out.println(xHist.get(i));
        //     totalSignal += xHist.get(i) * i;
        // }
        // System.out.println(totalSignal);

        char[][] crt = new char[6][40];
        for (int i = 0; i < crt.length; i++) {
            for (int j = 0; j < crt[0].length; j++) {
                int currentCycle = i * 40 + j + 1;
                if(Math.abs(xHist.get(currentCycle) - j) <= 1){
                    crt[i][j] = '#';
                } else {
                    crt[i][j] = '.';
                }
            }
        }

        for (int i = 0; i < crt.length; i++) {
            System.out.println(Arrays.toString(crt[i]));
        }

        
        sc.close();
    }

    public static void noop(){
        cycleCount++;
        update();
    }

    public static void addx(int num){
        cycleCount++;
        update();
        cycleCount++;
        update();
        xCount += num;
    }

    public static void update(){
        xHist.add(xCount);
    }
}
