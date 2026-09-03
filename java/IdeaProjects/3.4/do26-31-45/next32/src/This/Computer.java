package This;
import java.awt.print.Printable;

public class Computer {
    private printer printer;

    public Computer(printer printer) {
        this.printer = printer;
    }

    public void print(String s){
//        thistext printtable=new thistext() {
//            @Override
//            public void print(String s) {
//                printer.print(s);
//            }
//        };
//        thistext  printtable=a-> printer.print(a);
        thistext printtable=printer::print;
        printtable.print(s);

    }
}
