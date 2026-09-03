import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public class Util<T>extends AbstractCollection<T> implements Iterable<T>{
    private Object[] element;
    private int size;

    public Util() {
        this(16);
    }
    public Util(int number) {
        element=new Object[number];
    }
//    public Iterator<T> iterator(){
//        return new CollectionIterator();
//    }
    public int size(){
        return size;
    }
//    class CollectionIterator implements Iterator<T>{
//        private int cursor;
//
//        @Override
//        public boolean hasNext() {
//            return cursor < size;
//        }
//        public T next(){
//
//            return (T)element[cursor++];
//        }
//    }
    public Iterator<T> iterator(){
        return new Iterator<T>() {
        private int cursor;

        @Override
        public boolean hasNext() {
            return cursor < size;
        }
        public T next(){

            return (T)element[cursor++];
        }
        };
    }//匿名类部类

    public boolean add(T o) {
        if(o==null) return false;
        if(size==element.length){
            int length=element.length+element.length>>1  ;
            element= Arrays.copyOf(element,length);
        }
        element[size++]=o;
        return true;
    }
    public void delete(Object o) {
        if(o==null)return;
        int index=-1;
        for(int i=0;i<size;i++){
            if(o.equals(element[i])){
                index=i;
                break;
            }
        }
        System.arraycopy(element,index+1,element,index,size-index);
        size--;
    }
    public Object get(int i){
        if(i<0 || i>=size) {
            throw new IndexOutOfBoundsException("no");
        }else {
            return element[i];
        }
    }
}
