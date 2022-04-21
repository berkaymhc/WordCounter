import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class WordCounter {

    String finishedProduct;
    String[] inputArray;
    Map<String, Integer> hash = new HashMap<String, Integer>();


    /*
     * Constructor of WordCounter
     * Program takes in string and counts the number of times each word shows up
     * Starts out by putting the inputString into an array
     */
    public WordCounter(String inputString) {

        inputArray = inputString.replaceAll("[^a-zA-Z ]", "").toLowerCase().split(" ");
        hashSort();

        // DBHelper dbObject = new DBHelper();
        // String name = "berkay";
        // dbObject.simpleMessage(name);

    }


    /*
     * Method compiles strings to hashes, alphabetize hash to array
     * puts everything together
     */
    public void hashSort() {

        int length = inputArray.length;

        for (int i = 0; i < length; i++) {
            if (!hash.containsKey(inputArray[i])) {
                hash.put(inputArray[i], 1);
            } else {
                hash.put(inputArray[i], hash.get(inputArray[i]) + 1);
            }
        }


    }

    public void alphabetical() {
        String[] finArray = new String[hash.size()];
        int index = 0;
        for (Map.Entry<String, Integer> mapEntry : hash.entrySet()) {
            finArray[index] = mapEntry.getKey() + ": " + mapEntry.getValue().toString();
            index++;
        }
        String last = "<html>";

        Arrays.sort(finArray);

        for (int i = 0; i < finArray.length; i++) {
            last = last + finArray[i] + "<br>";
        }

        finishedProduct = last + "</html>";
    }

    public void numerical() {
        String[] finArray = new String[hash.size()];
        int index = 0;
        for (Map.Entry<String, Integer> mapEntry : hash.entrySet()) {
            finArray[index] = mapEntry.getValue().toString() + ": " + mapEntry.getKey();
            index++;
            // System.out.println(mapEntry.getKey());
            // System.out.println(mapEntry.getValue().toString());
        }
        String last = "<html>";
        Arrays.sort(finArray);


        for (int i = 0; i < finArray.length; i++) {
            last = last + finArray[i] + "<br>";

            for (int ct = 0; ct < finArray[i].length(); ct++) {
                if (' ' == finArray[i].charAt(ct)) {
                    int count = Integer.parseInt(finArray[i].substring(0, ct - 1));
                    String word = finArray[i].substring(ct + 1);

                    DBHelper dbObject = new DBHelper();
                    dbObject.simpleMessage(word, count);
                }
            }


        }


        finishedProduct = last + "</html>";
    }


}
