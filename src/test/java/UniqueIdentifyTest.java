import org.junit.Test;

import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThat;


 class Mamap {

    int[] keys;
    Object[] values;

    int size = 20;
    int N = 0;

    public Mamap(int size) {
        this.size = size;
        keys = new int[this.size];
        values = new Object[this.size];
    }

    public void put(Object key, Object value) {
        //resize
        int hashCode = key.hashCode();
        keys[N] = hashCode;
        values[N] = value;
        N++;
    }

    public Object get(Object key) throws Exception {
        int hashCode = key.hashCode();
        int index = FindIndex(hashCode);

        if (index == -1) throw new Exception("Key not found");
        return values[index];
    }

    private int FindIndex(int hashCode) {
        for (int i = 0; i < N; i++) {
            if (keys[i] == hashCode) return i;
        }

        return -1;
    }
}

public class UniqueIdentifyTest {

    /*
    Uniquely identify the repeating strings from the array
     */
    @Test
    public void uniqueIdentify_Test() {
        String[] strings = new String[]{
                "horse",
                "pc",
                "car",
                "picture",
                "pc",
                "car"
        };

        String[] result = getRepeated(strings);

        assertThat(result).isEqualTo(new String[]{"pc", "car"});
    }

    @Test
    public void map_Test() throws Exception {
        Mamap map = new Mamap(100);

        map.put("A", "1");
        map.put("B", "2");
        map.put("C", "3");
        map.put("D", "4");

        String result = (String)map.get("C");
    }

    private String[] getRepeated(String[] strings) {

        HashMap<String, Integer> hashMap = new HashMap<>();

        for (String key : strings) {
            int value = 1;
            if (hashMap.containsKey(key)) {
                value = hashMap.get(key) + 1;
            }

            hashMap.put(key, value);
        }

        return hashMap
                .entrySet()
                .stream()
                .filter(map -> map.getValue() > 1)
                .map(map -> map.getKey())
                .toArray(String[]::new);
    }

}
