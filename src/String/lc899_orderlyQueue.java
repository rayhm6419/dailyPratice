package String;

import java.util.Arrays;
/**
 key: if k > 1, use sort, so we find the lexicographically smallest string
 if k == 1, look up one by one, rotate from start to end

 time: O(nlogn) when k > 1
 O(n) * O(l) when k == 1, and if need to compare the whole string

 */
public class lc899_orderlyQueue {
    public static String orderlyQueue(String s, int k) {
        //coner case
        if (s == null || s.length() == 0){
            return null;
        }
        if (k > 1){
            char[] tmp = s.toCharArray();
            Arrays.sort(tmp);
            return new String(tmp);
        } else{
            String last = s;
            for (int i = 0; i < s.length(); i++){
                //subString (startIdx inclusive, endIdx exclusive)
                //subString if only input startIdx, java default input the last index)
                String cur = s.substring(i) + s.substring(0,i);
                if (last.compareTo(cur) > 0){
                    last = cur;
                }
            }
            return last;
        }
    }

    public static void main(String[] args) {
        System.out.println(orderlyQueue("cba", 1) );
    }
}
