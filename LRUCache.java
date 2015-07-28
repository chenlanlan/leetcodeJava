class Node {
    Node pre;
    Node next;
    int k;
    int val;
    Node(int k, int val) {
        this.k = k;
        this.val = val;
    }
}

public class LRUCache {
    private int cacheSize;
    private HashMap<Integer, Node> map;
    private Node first;
    private Node last;
    
    public LRUCache(int capacity) {
        first = new Node(-1, -1);
        last = new Node(1, 1);
        first.next = last;
        last.pre = first;
        cacheSize = capacity;
        map = new HashMap<Integer, Node>(capacity);
    }
    
    public int get(int key) {
        if (map.containsKey(key)) {
            Node p = map.get(key);
            putToHead(p);
            return p.val;
        } else {
            return -1;
        }
    }
    
    public void set(int key, int value) {
        if (map.containsKey(key)) {
            Node p = map.get(key);
            p.val = value;
            putToHead(p);
        } else if (map.size() < cacheSize) {
            Node p = new Node(key, value);
            putToHead(p);
            map.put(key, p);
        } else {
            Node p = new Node(key, value);
            putToHead(p);
            map.put(key, p);
            int tmpk = removeEnd();
            map.remove(tmpk);
        }
    }
    
    private int removeEnd() {
        Node p = last.pre;
        last.pre.pre.next = last;
        last.pre = p.pre;
        p.pre = null;
        p.next = null;
        return p.k;
    }
    
    private void putToHead(Node p) {
        if (p.next != null && p.pre != null) {
            p.pre.next = p.next;
            p.next.pre = p.pre;
        }
        p.pre = first;
        p.next = first.next;
        first.next.pre = p;
        first.next = p;
    }
    
}