package challenges.Random;

import java.util.*;

public class WordFrequency {

    public HashMap<String, Integer> countNumberOfWords(String sentence) {

        HashMap<String, Integer> wordCountMap = new HashMap<>();

        String[] words = sentence.split(" ");
        List<String> wordList = new ArrayList<>(Arrays.asList(words));
        List<String> cleanWords = cleanWords(wordList);

        for (String word: cleanWords) {
            if(wordCountMap.containsKey(word)){
                wordCountMap.put(word, wordCountMap.get(word) + 1);
            } else {
                wordCountMap.put(word, 1);
            }
        }

        return sortEntriesByValue(wordCountMap);
    }

    private <K, V extends Comparable<? super V>> HashMap<K,V> sortEntriesByValue(Map<K,V> wordCountMap) {
        List<Map.Entry<K,V>> sortedEntries = new ArrayList<>(wordCountMap.entrySet());
        sortedEntries.sort(Comparator.comparing(Map.Entry::getValue));

        Collections.reverse(sortedEntries);

        HashMap<K,V> sortedEntryMap = new HashMap<>();

        for(Map.Entry<K,V> entry : sortedEntries) {
            sortedEntryMap.put(entry.getKey(), entry.getValue());
        }

        return sortedEntryMap;
    }

    private List<String> cleanWords(List<String> words) {
        for (int i = 0; i < words.size(); i++) {
            words.set(i, words.get(i)
                    .replaceAll("[123456789!@#$%^&*()_+|\\-=~`{}\\[\\]:;\"<>,.?/]","")
                    .toLowerCase());
        }

        words.removeAll(Collections.singletonList(""));

        return words;
    }

}
