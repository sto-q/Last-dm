package day13.AA;

public class text {
    int []arrays;
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        try{
            System.out.println(calc.div(25,6));
            System.out.println(calc.div(25,0));
        } catch (CalculatorException e) {
            System.out.println(e.getMessage());
        }
    }
}
    class CalculatorException extends Exception {
        private String msg;
        public CalculatorException(String msg) {
            this.msg = msg;
        }

        public String getMessage() {
            return msg;
        }
    }
    class Calculator {
        public int div(int x,int y)throws day13.AA.CalculatorException {
            if(y==0)throw new day13.AA.CalculatorException("被0除了!");
            return x/y;
        }
    }

