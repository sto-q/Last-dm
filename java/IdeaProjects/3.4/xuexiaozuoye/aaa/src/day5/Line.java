package day5;

 class Line {
     private point start,end;
     public Line(int x1,int y1,int x2, int y2) {
         start = new point(x1,y1);
         end = new point(x2,y2);
     }
     public Line(point start, point end) {
         start=new point(start.getX(),start.getY());
         end=new point(end.getX(),end.getY());
     }
     public int getStartX(){
         return start.getX();
     }
     public int getStartY(){
         return start.getY();
     }
     public int getEndX(){
         return end.getX();
     }
     public int getEndY(){
         return end.getY();
     }
     public void move(int dx,int dy) {
         start.move(dx,dy);
         end.move(dx,dy);
     }
     public double length(){
         return start.length(end);
     }
     public String toString(){
         String str=start.toString();
         str+="-"+end.toString();
         return str;
     }
     public void print(){
         System.out.println(toString());
     }
 }
