package day10;

 class Transport {
     int speed;
     String name;
     public Transport() {}
     public Transport( String name, int speed) {
         this.speed = speed;
         this.name = name;
     }
     public void run(){
         System.out.println("交通工具在运行");
     }

}
