package Hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class allAnagrams {
    public List<List<String>> anagrams (String[] input){
        //coner case
        if (input == null || input.length == 0){
            return null;
        }
        HashMap<String, List<String>> map = new HashMap<>();
        List<List<String>> res = new ArrayList<>();
        //look up every word
        for (String s : input){
            char[] word = s.toCharArray();
            Arrays.sort(word);
            String wordSorted = new String(word);

            //check if sorted word as a list index have every exist in the map,
            //if not, create the list index, and add the current word. otherwise, add the current word
            if (!map.containsKey(wordSorted)){
                map.put(wordSorted, new ArrayList<>());
                map.get(wordSorted).add(s);
            } else{
                map.get(wordSorted).add(s);
            }
        }
        //get all the map value -> word, add into outter list
        res.addAll(map.values());
        return res;
    }
}
