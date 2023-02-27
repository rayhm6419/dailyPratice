import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/*

Find all pairs of elements in a given array that sum to the given target number. Return all the pairs of indices.

Example:
        A = {1, 3, 2, 4}, target = 5, return [[0, 3], [1, 2]]

        A = {1, 2, 2, 4}, target = 6, return [[1, 3], [2, 3]]

main idea: traverse every element, and look up if the other half is in the array, if in the array, put it index as result

step 1: outer forloop to check each element
step 2: maintain a HashMap, Key: the value of the number, value: the List of the crosponding value that sum equal to target
        if no contain in map: put the elemnt into an array
        if contain: get it keys, return it crossponding array, and add the num into the array
step 3: return the list of list of Integer with index
* */
public class twoSumAllPairs {
    public List<List<Integer>> twoSumAllParisOfIndex(int[] array, int target) {
        //coner case
        if (array == null || array.length == 0) {
            return null;
        }
        //fianl result
        List<List<Integer>> res = new ArrayList<>();
        //maintain a HashMap
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        //check and record every element
        for (int i = 0; i < array.length; i++) {
            List<Integer> list = map.get(target - array[i]); // look up if other half is exist in map
            if (list != null) {
                for (int x : list) {
                    res.add(Arrays.asList(i, x));
                }
            }
            //if not contain, need to put the value to the map
            if (!map.containsKey(array[i])) {
                map.put(array[i], new ArrayList<Integer>());
            }
            map.get(array[i]).add(i);
        }
        return res;
    }
}

//time: O(n^2)
//space: O(n)