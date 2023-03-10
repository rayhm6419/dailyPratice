package slidingWindow;

import java.util.HashMap;
import java.util.Map;

/*
*we use a HashMap freq to keep track of the frequency of each character in the current substring. We initialize left to 0 and maxLen to 0, and then we loop through each character in s with the right pointer.

For each character, we update freq and then we move the left pointer to the right as long as the number of distinct characters in the current substring is greater than k. We update maxLen at each step with the length of the current substring.

Finally, we return maxLen, which is the length of the longest substring with at most k distinct characters.
*
* Time: O(n)
* The inner while loop that moves the i pointer is also executed at most n times in total over all iterations of the outer loop, because the i pointer can only move to the right and cannot move back to the left. The time complexity of the operations inside the inner loop is constant, because they involve simple operations on a hash map with at most k entries.
*
* */
public class lc340 {
    class Solution {
        public int lengthOfLongestSubstringKDistinct(String s, int k) {
            char[] tmp = s.toCharArray();
            Map<Character, Integer> map = new HashMap<>();
            int longest = Integer.MIN_VALUE;
            int i = 0;
            int j = 0;

            while (j < tmp.length){ //j is a exploring pointer
                //as long as the map size is lestt than k, record into map
                map.put(tmp[j], map.getOrDefault(tmp[j], 0) + 1);
                j++;

                while (map.size() > k){
                    int count = map.get(tmp[i]); //如果大于k，那我们就要从map里移除，并且更新i的位置
                    if (count == 1){
                        map.remove(tmp[i]); //如果等于1，直接移除
                    } else{
                        map.put(tmp[i], count - 1); //如果有多个，那就挨个移除
                    }
                    i++; //移除后更新i的位置
                }
                longest = Math.max(longest, j - i);
            }
            return longest;
        }
    }
}
