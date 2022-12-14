import java.util.ArrayList;

public class Monkey {
    private static Long superModulo;

    private ArrayList<Long> items;
    private int sign, divideDigit, trueMonkey, falseMonkey;
    private long digit;
    private boolean changingDigit = false;
    public int inspect = 0;

    //sign numbers, + - * /
    public Monkey(ArrayList<Long> startingItems, int sign, int digit, int divDigit, int trueMonkey, int falseMonkey){
        if(sign == -1){
            System.out.println("sign wrong, given -1");
        }
        
        items = startingItems;
        this.sign = sign;
        this.digit = digit;
        if(digit == 0){ //zero means operation digit is itself
            changingDigit = true; 
        }
        this.divideDigit = divDigit;
        this.trueMonkey = trueMonkey;
        this.falseMonkey = falseMonkey;

        // System.out.println(startingItems.toString());
        // System.out.println(sign);
        // System.out.println(digit);
        // System.out.println(trueMonkey);
    }

    //movements in a single turn
    // returns monkey index to throw to
    public ArrayList<Integer> turn() {
        inspect += this.items.size();
        //array list of monkeys to throw items to
        ArrayList<Integer> recipient = new ArrayList<>();

        //loop thru item, process items throw one by one
        for (int i = 0; i < items.size(); i++) {
            //if divisor changes
            if(changingDigit){
                digit = items.get(i);
            }

            //operation
            switch(sign){
                case 0:
                    items.set(i, items.get(i) + digit);
                    break;
                case 1:
                    items.set(i, items.get(i) - digit);
                    break;
                case 2:
                    items.set(i, items.get(i) * digit);
                    break;
                case 3:
                    items.set(i, items.get(i) / digit);
                    break;
            }

            //counts inspection count
            // inspect++;

            //part 2 no longer divide by 3
            //items.set(i, items.get(i)/3); //integer division, boredom

            //math part 
            items.set(i, items.get(i) % superModulo);

            //test
            if(items.get(i) % divideDigit == 0){
                recipient.add(trueMonkey);
            } else{
                recipient.add(falseMonkey);
            }

        }

        return recipient;
    }

    //adding items from other monkeys to back of list   
    public void get(Long incomingItem){
        items.add(incomingItem);
    }

    public Long throwItem(){
        return items.remove(0); 
    }

    public String[] formattedStringArr(){
        String[] formatted = new String[2];
        formatted[0] = "items = " +  items.toString();
        formatted[1] = "operation = " + sign + ", digit = " + digit + ", divisor = " + divideDigit + ", trueMonke + falseMonke = " + (trueMonkey + falseMonkey);
        return formatted;
    }

    public static void setSuperMod(Long x){
        superModulo = x;
    }
    
    public int getDivisor(){
        return divideDigit;
    }
}
