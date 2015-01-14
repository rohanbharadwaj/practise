import java.util.HashMap;
import java.util.Map;

public class LRUCacheOptimal {
    int cap;
    int curNum;
    HashMap<Integer,DoubleNode> map;
    DoubleNode head;
	DoubleNode end;

    public LRUCacheOptimal(int capacity) {
         cap = capacity;
         curNum = 0;
         map = new HashMap<Integer,DoubleNode>();
         head = new DoubleNode(0);
         end = head;
    }

    public int get(int key) {
        if(map.get(key) == null){return -1;}
        else{
            // set lst
        	DoubleNode temp = map.get(key);
            if(head.next != temp){
                if(end == temp){end = temp.pre;}
                temp.pre.next = temp.next;
                if(temp.next != null)
                    temp.next.pre = temp.pre;

                head.next.pre = temp;
                temp.next = head.next;
                head.next = temp;
                temp.pre = head;
            }
            // return value
            return temp.value;
        }
    }

    public void set(int key, int value) {
        if(map.get(key)== null){
            // insert
            if(curNum < cap){
                curNum++;
            }else{
                // remove from map
                for (Map.Entry<Integer, DoubleNode> entry : map.entrySet()) {
                    if (entry.getValue() == end) {
                        map.remove(entry.getKey());
                        break;
                    }
                }

                end.pre.next = null;
                end = end.pre;
            }
            DoubleNode newNode = new DoubleNode(value);
            // set map
            map.put(key,newNode);
            // set lst
            newNode.next = head.next;
            newNode.pre = head;
            if(head == end){
                end = newNode;
            }
            else{
                head.next.pre = newNode;
            }
            head.next = newNode;
        }else{
            // change
            // set map
        	DoubleNode temp = map.get(key);
            temp.value = value;
            // set lst
            if(head.next != temp){
                if(end == temp){end = temp.pre;}
                temp.pre.next = temp.next;
                if(temp.next != null)
                    temp.next.pre = temp.pre;

                head.next.pre = temp;
                temp.next = head.next;
                head.next = temp;
                temp.pre = head;
            }
        }
    }
}

class DoubleNode{
    int value;
    DoubleNode pre;
    DoubleNode next;
    DoubleNode(int x){value = x;}
}