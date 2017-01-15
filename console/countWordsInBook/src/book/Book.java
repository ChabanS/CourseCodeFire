package book;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Sergey
 */
public class Book {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        String fileName = "146561.txt";
        String filePath = System.getProperty("user.dir");
        String fileSeparator = System.getProperty("file.separator");
        File file = new File(filePath + fileSeparator + fileName);

        BufferedReader fin = new BufferedReader(new FileReader(file));
        String line;
        int countAllWords = 0;
        Set<String> set = new HashSet();
        Map<String, Integer> word = new HashMap<>();

        while ((line = fin.readLine()) != null) {
            int countWord = 1;
            String[] s = deleteAnySymbol(line);
            countAllWords = countAllWords + s.length;

            for (int i = 0; i < s.length; i++) {
                set.add(s[i]);

                if (s[i].length() > 3) {
                    word.put(s[i], countWord++);
                }
            }
        }
        System.out.println("ALL count words in " + filePath + fileSeparator + fileName + ": " + countAllWords);
        System.out.println("Count distinct words: " + set.size());
//        printMap(word);
//        TreeMap<String, Integer> sorted = new TreeMap(new ValueComparator(word));
//        sorted.putAll(word);
        printMap(sortByComparator(word));

    }

    public static String[] deleteAnySymbol(String line) {
        String string = line.replaceAll("[^A-Za-zА-Яа-я0-9]", " ");
        String[] s = string.split(" ");
        return s;
    }

    public static void printMap(Map<String, Integer> word) {
        for (Map.Entry entry : word.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }

    public static void printMapSort(Map<String, Integer> treeMap) {
        for (Map.Entry e : treeMap.entrySet()) {
            System.out.println(e.getKey() + " " + e.getValue());
        }
    }

    public static Map<String, Integer> sortByComparator(Map<String, Integer> unsortMap) {

        List<Map.Entry<String, Integer>> list = new LinkedList<Map.Entry<String, Integer>>(unsortMap.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1,
                    Map.Entry<String, Integer> o2) {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });
        Map<String, Integer> sortedMap = new LinkedHashMap<String, Integer>();
        for (Iterator<Map.Entry<String, Integer>> it = list.iterator(); it.hasNext();) {
            Map.Entry<String, Integer> entry = it.next();
            sortedMap.put(entry.getKey(), entry.getValue());
        }
        return sortedMap;
    }

}
