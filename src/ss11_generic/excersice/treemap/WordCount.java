package ss11_generic.excersice.treemap;

import java.util.TreeMap;

public class WordCount {
    public static void main(String[] args) {
        String text = "Hello world hello java world hello";
        text = text.toLowerCase();
        String[] words = text.split(" ");

        TreeMap<String, Integer> map = new TreeMap<>();

        for (String word : words) {
            if (map.containsKey(word)) {
                map.put(word, map.get(word) + 1);
            } else {
                map.put(word, 1);
            }
        }

        for (String key : map.keySet()) {
            System.out.println(key + " : " + map.get(key));
        }
    }
}
