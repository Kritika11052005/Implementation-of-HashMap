import java.util.*;
public class LeetCode {
    static class HashMap<K,V>{
        private class Node{
            K key;
            V value;
            public Node(K key ,V value){
                this.key=key;
                this.value=value;
            }
        }
        private int n;// n-nodes
        private int N;//N-buckets
        private LinkedList<Node>buckets[];
        public HashMap(){
            this.N=4;//N=buckets.length
            this.buckets=new LinkedList[4];
            for(int i=0;i<4;i++){
                this.buckets[i]=new LinkedList<>();
            }
        }
        private int hasFunction(K key){
            int bi=key.hashCode();
            return Math.abs(bi)%N;

        }
        private int SearchLL(K key,int bi){
            LinkedList<Node>ll=buckets[bi];
            for(int i=0;i<ll.size();i++){
                if(ll.get(i).key==key){
                    return i;//di
                }
            }
            return -1;

        }
        private void rehash(){
            LinkedList<Node> oldbucket[]=buckets;
            buckets=new LinkedList[N*2];
            for(int i =0;i<N*2;i++){
                buckets[i]=new LinkedList<>();
        }
        for(int i=0;i<oldbuckets.length;i++){
            LinkedList<Node>ll=oldbuckets[i];
            for(int j=0;j<ll.size();j++){
                Node node=ll.get(j);
                put(node.key,node.value);
            }
        }
        
        }
        public void put(K key ,V value ){
            int bi=hasFunction(key);
            int di=SearchLL(key, bi);//di=-1
            if(di==-1){//key doesn't exist
                buckets[bi].add(new Node(key,value));
                n++;
            }
            else{
                Node data=buckets[bi].get(di);
                data.value=value;
                double lamda=(double)n/N;
                if(lamda>2.0){
                    rehash();
                }
            }
        }
        public V get(K key){
            int bi=hasFunction(key);
            int di=SearchLL(key, bi); //di=-1  
            if(di==-1){//key doesn't exists
                return null;
                
            }
            else{// key exists
                Node node=buckets[bi].get(di);
                return node.value;
            }}
            public boolean containsKey(K key){
                int bi=hasFunction(key);
                int di=SearchLL(key, bi);
                if(di==-1){
                    return false;
                }
                else{
                    return true;
                }
            }
            public int remove(K key){
                int bi=hasFunction(key);
                int di=SearchLL(key, bi);
                if(di==-1){
                    return null;
                }
                else{
                    Node node=buckets[bi].remove(di);
                    n--;
                    return node.value;
                }

            }
            public boolean isEmpty(){
                return n==0;
            }
            public ArrayList<K> keySet(){
                ArrayList<K> keys=new ArrayList<K>();
                for(int i=0;i<buckets.length;i++){//bi
                    LinkedList<Node> ll=buckets[i];
                    for(int j=0;j<ll.size();j++){//di
                        Node node=ll.get(j);
                        keys.add(node.key);
                    }
            }
            return keys;
        }
        public static void main(String[] args) {
            HashMap<String,Integer>map=new HashMap<>();
            map.put("Kritika",99);
            map.put("Ananya",98);
            map.put("Ritu",100);
            map.put("Kavindu",100);
            ArrayList<String> keys = map.keySet();
            for(int i=0; i<keys.size(); i++) {
                System.out.println(keys.get(i)+" "+map.get(keys.get(i)));
                }
        }

    }}

    

