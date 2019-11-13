package com.khanh.leetcode.hashTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @url https://leetcode.com/problems/group-anagrams/
 * Given an array of strings, group anagrams together.
 *
 * Example:
 *
 * Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * Output:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 * Note:
 *
 * All inputs will be in lowercase.
 * The order of your output does not matter.
 */


public class P49_Group_Anagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Key, List<String>> mp = new HashMap<Key, List<String>>();
        for (String s : strs) {
            Key key = new Key(s);
            List<String> l = mp.get(key);
            if (l == null) {
                l = new ArrayList<>();
                mp.put(key,l);
            }
            l.add(s);
        }
        return new ArrayList(mp.values());
    }
}

class Key {
    int[] index;
    int hc;
    public Key(String str) {
        index = new int[26];
        hc = 0;
        for (char c : str.toCharArray()) {
            index[c - 'a']++;
        }
        for (int in : index) {
            hc = hc * 31 + in;
        }
    }
    @Override
    public int hashCode() {
        return hc;
    }
    @Override
    public boolean equals(Object obj) {
        return hc == ((Key)obj).hc;
    }
}
