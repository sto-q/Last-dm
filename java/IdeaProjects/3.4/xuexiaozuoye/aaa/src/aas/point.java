package aas;

public class point {
    private int x,y;
    point(){
        x=0;
        y=0;
    }
    point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    public void move(int dx, int dy) {
        x += dx;
        y += dy;
    }
    public double length(point p){
        int dx=x-p.x;
        int dy=y-p.y;
        return Math.sqrt(dx*dx+dy*dy);
    }

    public String toString(){
        String s="("+x+","+y+")";
        return s;
    }
    public void print(){
        System.out.println(toString());
    }
}
