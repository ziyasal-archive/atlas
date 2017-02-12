import org.junit.Test;

import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThat;

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
