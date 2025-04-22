package JavaCoolections;

public class HashmapImplementation {
    static class  MyHashMap<K, V>{
        public static final int DEFAULT_CAPACITY=4;
        public static final float DEFAULT_LOAD_FACTOR=0.75f;
        private class Node{
            K key;
            V value;
            Node(K key, V value){
                this.key=key;
                this.value=value;
            }
        }
    //    public int size(){

    //    }
    //    public void put(K key, V value){

    //    }
    //    public V get(K key){

    //    }
    //    public V remove(K key){
        
    //    }
    }
    public static void main(String[] args) {
        MyHashMap<Integer, String> mp1=new MyHashMap<>();
    }
}
