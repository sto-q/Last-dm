package Map;
public class MyMap <K,V>{
    private int size;
    private MyEntry <K,V>[] elements;
    public MyMap(){
        this(16);
    }
    public MyMap(int elements) {
        this.elements = new MyEntry[elements];
    }
    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return size == 0;
    }
    private float loadFator=0.75f;
    public V put(K key,V value){
        int currentSize=size+1;
        if(currentSize>=elements.length*loadFator){
            MyEntry <K,V>[] entries=new MyEntry[currentSize<<1];
            for(MyEntry <K,V> entry:elements){
                if(entry==null)continue;
                int hash=entry.getKey().hashCode();//->返回key的哈希值-hashcode是返回对象的哈希值
                int index=hash&(entries.length-1);//从0开始所以length-1
                entries[index]=entry;
            }
            elements=entries;//element更换地址
        }//这个是超过数组现有的位置
        int hash = key.hashCode();
        int index = hash &(elements.length-1);
        MyEntry <K,V> addEntry=new MyEntry<>(key,value,null);
        if(elements[index]==null){
        elements[index]=addEntry;//如果是空的就放进去
        }else {
            MyEntry <K,V> extistEntry=elements[index];//获得位置的值因为MyEntry是链表形式所有如果位置被占用在位置后在连一个就成了数组链表形式
            while (extistEntry.getNext()!=null){
                extistEntry=extistEntry.getNext();
            }
            extistEntry.setNext(addEntry);
        }
        size++;
//        elements[index] = new MyEntry<>(key,value,null);
//        return elements[index].getValue();
        return elements[index].getValue();
    }
    public V get(K key){
        for(MyEntry <K,V> entry:elements){
            if(entry==null)continue;
            K k=entry.getKey();
            if(k.equals(key))return entry.getValue();
            MyEntry <K,V> temp=entry;
            while(temp.getNext()!=null){
                if(temp.getNext().getKey().equals(key))return temp.getNext().getValue();
                temp=temp.getNext();
            }//while前是在数组中查找while里是链表中查找
        }
        return null;
    }
}
