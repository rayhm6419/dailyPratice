package Array;

import java.util.*;

/*
Find all pairs of elements in a given array that sum to the pair the given target number. Return all the distinct pairs of values.

main idea: find all paris of sum to target, and the result of pairs must be distinct

Example: A = {2, 1, 3, 2, 4, 3, 4, 2}, target = 6, return [[2, 4], [3, 3]]

first condition:
x + y = z -> make sure x and y only use once, order does not matter
2 + 4 is the same as 4 + 2.
so we need to record if we have used during the traversal

other condition:
x + x = z
3 + 3 = 6 -> so we have to control only use two 3, if the array have three 3, we just use two of it.

* */
public class twoSumAllPairsDistinct {
    public static List<List<Integer>> allPairs(int[] array, int target) {
        //the final result
        List<List<Integer>> result = new ArrayList<>();
        //maintain a HashMap<Key: values, Value: the number of appear time>
        Map<Integer,Integer> map = new HashMap<>();
        //traverse every element
        for (int num : array){
            //the number of appear times
            Integer count = map.get(num);
            //the condition for 3 + 3 = 6
            if (num * 2 == target && count != null && count == 1){
                result.add(Arrays.asList(num,num));
                //condition: if other half is already exit in map and the current have not been used -> good match
            }else if (map.containsKey(target - num) && count == null){
                result.add(Arrays.asList(target - num,num));
            }
            //current nums and the other half is not in the map, add it into map
            if (count == null){
                map.put(num ,1);
            } else{
                //or itself, + 1 as count
                map.put(num, count + 1);
            }
        }
        return result;
        // Write your solution here
    }

    //time: O(n)
    //space： O(n)

    public static void main(String[] args) {
        int[] array = new int[]{2, 1, 3, 2, 4, 3, 4, 2};
        allPairs(array, 6);
    }
}
