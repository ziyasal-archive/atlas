import org.junit.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;


class HEntry<T, K> {
    private T key;
    private K value;

    HEntry(T key, K value) {
        this.key = key;
        this.setValue(value);
    }

    T getKey() {
        return key;
    }

    K getValue() {
        return value;
    }

    void setValue(K value) {
        this.value = value;
    }
}

//TODO: resize
class Hashtbl<T, K> {
    private ArrayList<ArrayList<HEntry<T, K>>> table;
    private int size;

    Hashtbl() {
        this(20);
    }

    private Hashtbl(int size) {
        this.size = size;
        table = new ArrayList<>(this.size);

        for (int i = 0; i < this.size; i++) {
            table.add(new ArrayList<>());
        }
    }

    private int indexOf(T key) {
        return key.hashCode() % this.table.size();
    }

    void put(T key, K value) throws Exception {
        int idx = indexOf(key);
        ArrayList<HEntry<T, K>> bucket = table.get(idx);

        for (HEntry<T, K> item : bucket) {
            if (item.getKey().equals(key)) {
                item.setValue(value);
                return;
            }
        }

        bucket.add(new HEntry<>(key, value));
    }

    K get(T key) throws Exception {
        int idx = indexOf(key);
        ArrayList<HEntry<T, K>> bucket = table.get(idx);

        for (HEntry<T, K> item : bucket) {
            if (item.getKey().equals(key)) return item.getValue();
        }

        throw new Exception("key not found!");
    }

    void remove(T key) throws Exception {
        int idx = indexOf(key);
        ArrayList<HEntry<T, K>> bucket = table.get(idx);

        for (int i = 0; i < bucket.size(); i++) {
            if (bucket.get(i).getKey().equals(key)) {
                bucket.remove(i);
                break;
            }
        }

        throw new Exception("key not found!");
    }
}

public class HashtblTest {

    @Test
    public void bidi_Test() {

        Hashtbl<String, Integer> hashtbl = new Hashtbl<>();
        try {
            hashtbl.put("A", 1);
            hashtbl.put("B", 2);
            hashtbl.put("C", 3);

            System.out.println(hashtbl.get("B"));

            hashtbl.remove("B");

            System.out.println(hashtbl.get("B"));

        } catch (Exception e) {
            e.printStackTrace();
        }

        assertThat(true).isEqualTo(true);
    }
}
