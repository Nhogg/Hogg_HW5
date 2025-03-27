/******************************************************************
 *
 *   Nathan Hogg / Section 002
 *
 *   This java file contains the problem solutions of isSubSet, findKthLargest,
 *   and sort2Arrays methods. You should utilize the Java Collection Framework for
 *   these methods.
 *
 ********************************************************************/

import java.util.*;

class ProblemSolutions {

    /**
     * Method: isSubset()
     *
     * Given two arrays of integers, A and B, return whether
     * array B is a subset if array A. Example:
     *      Input: [1,50,55,80,90], [55,90]
     *      Output: true
     *      Input: [1,50,55,80,90], [55,90, 99]
     *      Output: false
     *
     * The solution time complexity must NOT be worse than O(n).
     * For the solution, use a Hash Table.
     *
     * To solve this problem, we take advantage of the Hashtable method
     * containskey(). Using an enhanced for loop, we can iterate over
     * each element in list2[] and check if it does not exist in the table.
     * If one element doesn't exist, list2[] is not a subset of list1[] and
     * we exit the function.
     *
     * @param list1 - Input array A
     * @param list2 - input array B
     * @return      - returns boolean value B is a subset of A.
     */

    public boolean isSubset(int list1[], int list2[]) {
        Hashtable<Integer, Integer> table1 = new Hashtable<>();

        for (int i = 0; i < list1.length; i++) {
            table1.put(list1[i], i);
        }

        for (int j : list2) {
            if (!table1.containsKey(j)) {
                return false;
            }
        }

        return true;
    }

    /**
     * Method: findKthLargest
     *
     * Given an Array A and integer K, return the k-th maximum element in the array.
     * Example:
     *      Input: [1,7,3,10,34,5,8], 4
     *      Output: 7
     *
     * To solve this problem, we use a priority queue. First, we check to ensure
     * that all inputs are valid.
     * Next, we can instantiate a new heap, and use an enhanced for loop
     * to add the elements of the array using offer().
     * On each insertion, we check if the size is greater than k.
     * If it is, we remove the smallest element using poll. This
     * ensures that when we peek after adding all elements,
     * the element at the bottom of the heap will be the kth largest element.
     *
     * @param array - Array of integers
     * @param k     - the kth maximum element
     * @return      - the value in the array which is the kth maximum value
     */

    public int findKthLargest(int[] array, int k) {
        if (array == null || array.length == 0 || k <= 0 || k > array.length) {
            return -1;
        }

        PriorityQueue<Integer> heap = new PriorityQueue<>();

        for (int num: array) {
            heap.offer(num);
            if (heap.size() > k) {
                heap.poll();
            }
        }

        return heap.peek();
    }


    /**
     * Method: sort2Arrays
     *
     * Given two arrays A and B with n and m integers respectively, return
     * a single array of all the elements in A and B in sorted order. Example:
     *      Input: [4,1,5], [3,2]
     *      Output: 1 2 3 4 5
     *
     * To solve this problem, we can take advantage of the ordering properties
     * of a min heap. When we add an element to a min heap, elements are
     * automatically sorted. As such, we can add all the elements
     * from both arrays to the heap and then create a new array, poll
     * each element, and add it to a new array. The resultant array
     * will be completely sorted.
     *
     * @param array1    - Input array 1
     * @param array2    - Input array 2
     * @return          - Sorted array with all elements in A and B.
     */

    public int[] sort2Arrays(int[] array1, int[] array2) {
        if (array1 == null || array1.length == 0 || array2 == null || array2.length == 0) {
            return array1;
        }

        PriorityQueue<Integer> heap = new PriorityQueue<>();

        for (int i : array1) {
            heap.add(i);
        }

        for (int i : array2) {
            heap.add(i);
        }

        int[] sorted = new int[array1.length + array2.length];

        for (int i = 0; i < sorted.length; i++) {
            sorted[i] = heap.poll();
        }

        return sorted;
    }

}