package d.collection.practice;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class MapSample {
    public static void main(String[] args) {
        MapSample map = new MapSample();
        map.checkMap();
    }
    public void checkMap(){
        HashMap<String, String> map =new HashMap<String, String>();
        map.put("A", "hello");
        map.put("B", "hi");
        map.put("c", "bye");
        map.put("d", "adios");
        Set<String> keySets = map.keySet();
        keySets.forEach((String v) -> {
            System.out.println("v is " + v);
        });

        map.entrySet().forEach((Map.Entry<String, String> entry) -> {
            String key = entry.getKey();
            String value = entry.getValue();
        });

        Properties props = System.getProperties();
        for (Map.Entry<Object, Object> objectObjectEntry : props.entrySet()) {
            System.out.println(objectObjectEntry.getKey() + " = " + objectObjectEntry.getValue());
        }
    }
}
