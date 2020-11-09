package challenges.Random;

import java.util.ArrayList;
import java.util.List;

public class WordSearch {

    public List<String> findWords(String wordString) {
        List<String> words = new ArrayList<>();
        char[] wordChar = new char[wordString.length()];

        for(int i = 0; i < wordChar.length - 1; i++) {
            wordChar[i] = wordString.charAt(i);
        }

        findWords(wordChar, words);

        return words;
    }

    private void findWords(char[] charArr, List<String> wordString) {

        int startIndex = 0;
        int endIndex = 0;

        while(endIndex <= charArr.length) {

            if(Dictionary.searchWord(charArr, startIndex, endIndex)) {//dictionary system returns true if word is found
                StringBuilder newWord = new StringBuilder();
                for(int i = startIndex; i <= endIndex; i++){
                    newWord.append(charArr[i]);
                }
                wordString.add(newWord.toString());
                startIndex = endIndex;
            }

            endIndex++;
        }
    }
}
