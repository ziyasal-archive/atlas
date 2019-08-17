import org.junit.Test;

import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThat;

class Node {
    public int value;
    public int key;

    public Node prev;
    public Node next;
}

class LRUCache {

    private Node head;
    private Node tail;

    HashMap<Integer, Node> map;
    private int capasity;

    public LRUCache(int capcasity) {
        map = new HashMap<Integer, Node>();
        this.capasity = capcasity;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;
            remove(node);
            setHead(node);
        } else {
            Node newNode = new Node();
            newNode.value = value;
            newNode.key = key;
            newNode.next = null;
            newNode.prev = null;

            if (map.size() > capasity) {
                map.remove(tail.key);

                remove(tail);
                setHead(newNode);
            } else {
                setHead(newNode);
            }

            map.put(key, newNode);
        }
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            remove(node);
            setHead(node);

            return node.value;
        } else {
            return -1;
        }
    }

    private void setHead(Node node) {
        node.next = head;
        node.prev = null;

        if(head != null){
            head.prev = node;
        }

        head = node;

        if(tail == null){
            tail = head;
        }
    }

    private void remove(Node node) {

        if(node.prev !=null ){
            node.prev.next = node.next;
        }else{
            head = node.next;
        }

        if(node.next !=null ){
            node.next.prev = node.prev;
        }else{
            tail = node.prev;
        }
    }
}

public class LRUCacheTest {

    @Test
    public void bidi_Test() {

        LRUCache lrucache = new LRUCache(20);
		lrucache.put(10, 15);
		lrucache.put(1, 1);
		lrucache.put(15, 10);
		lrucache.put(10, 16);
		lrucache.put(12, 15);
		lrucache.put(18, 10);
		lrucache.put(13, 16);

        assertThat(lrucache.get(1)).isEqualTo(1);
        assertThat(lrucache.get(10)).isEqualTo(16);
        assertThat(lrucache.get(15)).isEqualTo(10);
    }
}
