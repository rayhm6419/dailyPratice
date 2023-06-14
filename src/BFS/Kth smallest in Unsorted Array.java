/**
 * Find the K smallest numbers in an unsorted integer array A. The returned numbers should be in ascending order.
 */

 /*MaxHeap */

 public int[] kSmallest (int[] array, int k){
    //coner case
    if (array == null || array.length == 0 || k == 0){
        return new int[0];
    }
    //create a maxHeap PQ
    ProrityQueue<Integer> maxHeap = new Priority<>(k, new Comparator<>(){
        @Override
        public int comapre(Integer o1, Integer o2){
            if (o1.equals(o2)){
                return 0;
            }
            return o1 > o2 ? -1 : 1;
        }
    });
    //push all the number into Priority Queue and compare, larger number always on top
    for (int i = 0; i < array.length; i++){
        if (i < k){ 
            maxHeap.offer(array[i]);
        }
        //compare, and decide if need to pull the larger number
        else if (maxHeap.peek() > array[i]){
            maxHeap.poll();
            maxHeap.offer(array[i]); //push the smaller one into PQ
        }

        int[] res = new int[k];
        for (int i = k - 1; i >= k; i--){
            res[i] = maxHeap.poll();
        }
        return res;
    }
 }

 /*MinHeap */
 public int[] kSmallest (int[] array, int k){
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    for (int i = 0; i < array.length; i++){
        minHeap.offer(array[i]);
    }
    int[] res = new int[k];
    for (int i = 0; i < k; i++){
        res[i] = maxHeap.poll();
    }
    return res;
 }