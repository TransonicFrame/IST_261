package wordfrequencycounterstubwithhints;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

// https://beginnersbook.com/2014/07/how-to-sort-a-treemap-by-value-in-java/
// https://stackoverflow.com/questions/109383/sort-a-mapkey-value-by-values
// https://stackoverflow.com/questions/36312464/what-does-regex-pattern-pl-mean-in-java
// https://docs.oracle.com/javase/8/docs/api/java/util/regex/Pattern.html
// https://stackoverflow.com/questions/7384791/splitting-strings-through-regular-expressions-by-punctuation-and-whitespace-etc
// https://stackoverflow.com/questions/28999757/how-do-i-read-next-line-with-bufferedreader-in-java
public class WordFrequencyCounterStubWithHints {

    public static <K, V extends Comparable<V>> Map<K, V> sortByValues(final Map<K, V> map) {
        Comparator<K> valueComparator = (K k1, K k2) -> {
            int compare = map.get(k1).compareTo(map.get(k2));
            if (compare == 0) {
                return 1;
            } else {
                return -compare;
            }
        };
        Map<K, V> sortedByValues = new TreeMap<>(valueComparator);
        sortedByValues.putAll(map);
        return sortedByValues;
    }

    public static void main(String[] args) {
        Map<String, Integer> stringCount = new TreeMap<>();
        String fileName = "GettysburgAddress.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line = "";
            while ((line = br.readLine()) != null) {

                String[] words = line.split("[\\p{Punct}\\s]+");
                for (String word : words) {
                    word = word.toLowerCase();
                    Integer j = stringCount.get(word);
                    stringCount.put(word, (j == null) ? 1 : j + 1);
                }
            }
        } catch (IOException ex) {
            System.err.println("Problem reading file: " + ex.getMessage());
        }

        Map sortedMap = sortByValues(stringCount);
        Set entrySet = sortedMap.entrySet();
        Iterator iterator = entrySet.iterator();

        while (iterator.hasNext()) {
            Map.Entry map = (Map.Entry) iterator.next();
            System.out.println(map.getKey() + "=" + map.getValue());
        }
    }
}
