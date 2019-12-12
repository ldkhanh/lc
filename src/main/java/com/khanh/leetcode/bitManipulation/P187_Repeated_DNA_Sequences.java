package com.khanh.leetcode.bitManipulation;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

/***
 * @url https://leetcode.com/problems/repeated-dna-sequences/
 * All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG".
 * When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.
 *
 * Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.
 *
 * Example:
 *
 * Input: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
 *
 * Output: ["AAAAACCCCC", "CCCCCAAAAA"]
 */
public class P187_Repeated_DNA_Sequences {
    // Bit Manipulation
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new ArrayList<>();
        if (s == null || s.length() < 11) return res;
        int[] dna = new int[26];
        dna['A'-'A'] = 0;   // bit value 00
        dna['C'-'A'] = 1;   // bit value 01
        dna['G'-'A'] = 2;   // bit value 10
        dna['T'-'A'] = 3;   // bit value 11
        int hash = 0;       // hash with 20 bit represent 10 letter
        // First 10 letter of DNA string
        // each time shift left 2 bit
        // each 2 bit can store value of 4 DNA value from 0 -> 3
        for (int i = 0; i < 10; i++) {
            hash = (hash << 2) | dna[s.charAt(i) - 'A'];
        }
        BitSet seen = new BitSet(20);
        BitSet add = new BitSet(20);
        seen.set(hash);
        int mask = 0xFFFFF;    // 20 bit standard : 11111111111111111111
        // Iterate remain of string s
        for (int i = 1; i < s.length() - 9; i++) {
            hash =((hash << 2) | dna[s.charAt(i+9)-'A']) & mask;     //add new letter and keep 20bit
            if (!add.get(hash)) {
                if (seen.get(hash)) {
                    add.set(hash);
                    res.add(s.substring(i, i + 10));
                } else {
                    seen.set(hash);
                }
            }
        }
        return res;
    }
}
