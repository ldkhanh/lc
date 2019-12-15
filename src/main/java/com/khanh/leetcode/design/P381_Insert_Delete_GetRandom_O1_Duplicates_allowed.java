package com.khanh.leetcode.design;

import java.util.*;

/**
 * @url https://leetcode.com/problems/insert-delete-getrandom-o1-duplicates-allowed/
 * <p>
 * Design a data structure that supports all following operations in average O(1) time.
 * <p>
 * Note: Duplicate elements are allowed.
 * insert(val): Inserts an item val to the collection.
 * remove(val): Removes an item val from the collection if present.
 * getRandom: Returns a random element from current collection of elements. The probability of each element being returned is linearly related to the number of same value the collection contains.
 * Example:
 * <p>
 * // Init an empty collection.
 * RandomizedCollection collection = new RandomizedCollection();
 * <p>
 * // Inserts 1 to the collection. Returns true as the collection did not contain 1.
 * collection.insert(1);
 * <p>
 * // Inserts another 1 to the collection. Returns false as the collection contained 1. Collection now contains [1,1].
 * collection.insert(1);
 * <p>
 * // Inserts 2 to the collection, returns true. Collection now contains [1,1,2].
 * collection.insert(2);
 * <p>
 * // getRandom should return 1 with the probability 2/3, and returns 2 with the probability 1/3.
 * collection.getRandom();
 * <p>
 * // Removes 1 from the collection, returns true. Collection now contains [1,2].
 * collection.remove(1);
 * <p>
 * // getRandom should return 1 and 2 both equally likely.
 * collection.getRandom();
 */
public class P381_Insert_Delete_GetRandom_O1_Duplicates_allowed {
    /**
     * Initialize your data structure here.
     */
    HashMap<Integer, LinkedHashSet<Integer>> map;
    ArrayList<Integer> data;
    Random random;

    public P381_Insert_Delete_GetRandom_O1_Duplicates_allowed() {
        map = new HashMap<>();
        data = new ArrayList<>();
        random = new Random();
        random.setSeed(123456789);
    }

    /**
     * Inserts a value to the collection. Returns true if the collection did not already contain the specified element.
     */
    public boolean insert(int val) {
        boolean contain = map.containsKey(val);
        if (!contain)
            map.put(val, new LinkedHashSet<>());
        map.get(val).add(data.size());          // put <value, index in data list>
        data.add(val);
        return !contain;
    }

    /**
     * Removes a value from the collection. Returns true if the collection contained the specified element.
     */
    public boolean remove(int val) {
        if (!map.containsKey(val)) return false;
        int index = map.get(val).iterator().next();
        map.get(val).remove(index);
        if (index < data.size() - 1) {      // swap with the end value in data
            int lastVal = data.get(data.size() - 1);
            map.get(lastVal).remove(data.size() - 1);
            map.get(lastVal).add(index);
            data.set(index, lastVal);
        }
        if (map.get(val).isEmpty()) map.remove(val);
        data.remove(data.size() - 1);

        return true;
    }

    /**
     * Get a random element from the collection.
     */
    public int getRandom() {
        return data.get(random.nextInt(data.size()));
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */