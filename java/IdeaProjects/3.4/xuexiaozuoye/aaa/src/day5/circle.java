package day5;

public class circle {
    private point center;
    int radius;
    public circle(int x,int y, int radius) {
        center=new point(x,y);
        this.radius=radius;
    }
    public circle(point p, int radius) {
        center=new point(p.getX(),p.getY());
        this.radius=radius;
    }
    public int getX(){
        return center.getX();
    }
    public int getY(){
        return center.getY();
    }
    public int getRadius(){
        return radius;
    }
    public void move(int dffx,int dffy){
        center.move(dffx,dffy);
    }
    public double area(){
        return Math.PI*radius*radius;
    }
    public double perim(){
        return 2*Math.PI*radius;
    }

    @Override
    public String toString() {
        String satr=radius + " ,";
        satr+=center.toString();
        return satr;
    }
    public void print(){
        System.out.println(center.toString());
    }

}
