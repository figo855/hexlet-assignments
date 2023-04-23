package exercise;

// BEGIN
import java.util.HashMap;
import java.util.Map;


class App {

public static Map getWordCount(String sentence) {

        String[] words = sentence.split("\\s+");
        Map<String, Integer> wordsToCount = new HashMap<>();

        for (String word : words) {
        if (!wordsToCount.containsKey(word)) {
        wordsToCount.put(word, 0);
        }
        wordsToCount.put(word, wordsToCount.get(word) + 1);

        }
        return wordsToCount;

        }

public static String toString1(Map wordsToCount) {

        Map<String, Integer> newWordsToCount = new HashMap(wordsToCount);
        String stringToWordsCount=null;

        for (Map.Entry<String, Integer> wordToCount : newWordsToCount.entrySet()) {


        if (wordToCount.getKey().isEmpty()) {
        stringToWordsCount = "{}";

        } else {
        StringBuilder stringWords = new StringBuilder();
        String a = "{";
        String b = ": ";
        String c = "\n}";


        for (Map.Entry<String, Integer> wordToCountNew : newWordsToCount.entrySet()) {
        String stringWordKey = wordToCountNew.getKey().toString();
        String stringWordValue = wordToCountNew.getValue().toString();
        stringWords.append("\n  " + stringWordKey + b+ stringWordValue
        );
        }
        stringToWordsCount = new String(a + stringWords + c);



        }
        }
        return stringToWordsCount;
        }
        }
//END
