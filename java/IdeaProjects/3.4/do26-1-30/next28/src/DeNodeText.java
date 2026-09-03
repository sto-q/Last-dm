public class DeNodeText {
    public static void main(String[] args) {
        Denode<Integer> number1=new Denode<>(1,null,null);
        Denode<Integer> number2=new Denode<>(2,null,null);
        number1.setNext(number2);
        number2.setPrev(number1);
        Denode<Integer> number3=new Denode<>(3,null,null);
        number2.setNext(number3);
        number3.setPrev(number2);
        Denode<Integer> number4=new Denode<>(4,null,null);
        number3.setNext(number4);
        number4.setPrev(number3);
        Denode<Integer> number5=new Denode<>(5,null,null);
        number4.setNext(number5);
        number5.setPrev(number4);

        Denode<Integer> number6=number1;
        Denode<Integer> number7=number5;
        while (number6 != null) {
            System.out.println(number6.getData());
            number6=number6.getNext();
        }
        while (number7 != null) {
            System.out.println(number7.getData());
            number7=number7.getPrev();
        }
    }
}
