package wordfrequencycounterfinishinclass;

import java.util.TreeMap;

public class WordFrequencyCounterFinishInClass {

    public static void main(String[] args) {
        TreeMap<String, Integer> sortedWordCount = new TreeMap<>();

        String[] words = {"dog", "cat", "cat", "bird", "elk", 
            "bee", "dog", "cow", "bird", "cat", "elk", "dog", "bee", "elk", "cow"};
        
        for (String word : words) {
            Integer j = sortedWordCount.get(word);
            sortedWordCount.put(word, (j == null) ? 1 : j + 1);
        }
        
        System.out.println(sortedWordCount);
    }
}


