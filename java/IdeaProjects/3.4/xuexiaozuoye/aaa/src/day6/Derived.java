package day6;

 class Derived extends base{
     int derived_var1;
     double derived_var2;

     public void setDerived_var(int derived_var1, double derived_var2) {
         this.derived_var1 = derived_var1;
         this.derived_var2 = derived_var2;
     }
     void PrintDerivedVar() {
         System.out.print("derived_var1 = " + derived_var1+",");
         System.out.println("derived_var2 = " + derived_var2);
     }
     void Print(){
         System.out.print("base_var1 = " + base_var1+",");
         System.out.println("base_var2 = " + base_var2);
         System.out.print("derived_var1 = " + derived_var1+",");
         System.out.println("derived_var2 = " + derived_var2);
     }
 }
