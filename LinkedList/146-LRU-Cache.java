class LRUCache {
    class Node{
        int key;
        int value;
        Node next;
        Node prev;

        Node(int key,int value){
            this.key=key;
            this.value=value;
        }
    }

    Node head;
    Node tail;
    HashMap<Integer,Node> map;
    int cap;
    public LRUCache(int capacity) {
        cap=capacity;
        head = new Node(-1,-1);
        tail=new Node(-1,-1);
        head.next=tail;
        tail.prev=head;
        map=new HashMap<>();
    }

    private void removeNode(Node nn){
        Node nm1=nn.prev;
        Node np1=nn.next;
        nm1.next=np1;
        np1.prev=nm1;
    }

    private void addNodeBeforeTail(Node nn){
        Node nm1 = tail.prev;
        nn.prev=nm1;
        nn.next=tail;
        nm1.next=nn;
        tail.prev=nn;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            Node rem = map.get(key);
            //remove
            removeNode(rem);
            //add at front
            addNodeBeforeTail(rem);
            return rem.value;
        }       
        return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node rem = map.get(key);
            //remove
            removeNode(rem);
            //add front
            addNodeBeforeTail(rem);
            rem.value=value;
        }
        else{
            if(map.size()==cap){
                Node rem = head.next;
                //remove from hashmap
                map.remove(rem.key);
                //remove from dll
                removeNode(rem);
            }
            Node nn = new Node(key,value);
            addNodeBeforeTail(nn);
            map.put(key,nn);
            }
        }
}


/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */