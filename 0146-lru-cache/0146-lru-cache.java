class Node{
    Node next=null,prev=null;
    int key,val;
}

class LRUCache {
    int size,cap;
    HashMap<Integer,Node> map = new HashMap<>();
    Node tail,head;

    public LRUCache(int capacity) {
        size=0;
        cap=capacity;
        head=null;
        tail=null;
    }
    
    public int get(int key) {
        if(!map.containsKey(key))
         return -1;

        Node node = map.get(key);

       
        if(size==1 || node==head) return node.val;

        if(node!=tail)
            {
               moveTheNodeToFirstPosition(node);
            }
            else{
                moveTheTailToFirstPosition(node);

            }
        return node.val;
    }
    
    public void put(int key, int value) {
        
        if(map.containsKey(key))
        {
            Node node = map.get(key);
            node.val=value;

            //put it on first posn----
            //in case of only one node, we can just return
            if(node.prev==null && node.next==null || node==head) return;

            //if more than one node ---
            //if fetched node is not tail
            if(node!=tail)
            {
                moveTheNodeToFirstPosition(node);
            }
            else{
                  moveTheTailToFirstPosition(node);
            }
            //fetched node is tail
            //----
        }
        else{
            Node newNode = new Node();
            newNode.key=key;
            newNode.val=value;
            insert(newNode);
            }
    }
    void moveTheNodeToFirstPosition(Node node)
    {
        //first free the node
        node.prev.next=node.next;
        node.next.prev=node.prev;

        //now bring it to the first position
        head.prev = node;
        //node ka next = node at second position
        head.prev.next=head;

        head=node;
        head.prev=null;

    }

    void moveTheTailToFirstPosition(Node node){

        tail=tail.prev;

        head.prev = node;
        head.prev.next=head;
        head=node;
        head.prev=null;

        tail.next=null;
    }
    void remove()
    {
       if(size==1)
       {
        head=null;
        tail=null;
       }
       else{
        tail=tail.prev;
        tail.next=null;
       }
    }
    void insert(Node newNode)
    {
        if(size>=cap)
        {
            map.remove(tail.key);
            remove();
            size--;
        }

        if(head==null) 
        {
            head=newNode;
            tail=newNode;
        }
        else{
            head.prev=newNode;
            newNode.next=head;
            head=newNode;
        }
        map.put(newNode.key,newNode);
        size++;

    }

}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */