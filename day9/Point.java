public class Point {
    public int x;
    public int y;

    public Point(int a, int b){
        this.x = a;
        this.y = b;
    }

    public String toString(){
        return ("[" + x + ", " + y + "]");
    }

    public boolean equals(Point other){
        if(other.x == this.x && other.y == this.y){
            return true;
        } else{
            return false;
        }
    }

    
}
