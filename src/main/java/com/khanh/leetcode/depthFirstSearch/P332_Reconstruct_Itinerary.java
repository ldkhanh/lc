package com.khanh.leetcode.depthFirstSearch;

import java.util.*;

/**
 * @url https://leetcode.com/problems/reconstruct-itinerary/
 *
 * Given a list of airline tickets represented by pairs of departure and arrival airports [from, to], reconstruct the itinerary in order. All of the tickets belong to a man who departs from JFK. Thus, the itinerary must begin with JFK.
 *
 * Note:
 *
 * If there are multiple valid itineraries, you should return the itinerary that has the smallest lexical order when read as a single string. For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].
 * All airports are represented by three capital letters (IATA code).
 * You may assume all tickets form at least one valid itinerary.
 * Example 1:
 *
 * Input: [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
 * Output: ["JFK", "MUC", "LHR", "SFO", "SJC"]
 * Example 2:
 *
 * Input: [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
 * Output: ["JFK","ATL","JFK","SFO","ATL","SFO"]
 * Explanation: Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"].
 *              But it is larger in lexical order.
 *
 */

public class P332_Reconstruct_Itinerary {
    LinkedList<String> result = new LinkedList<>();
    Map<String, PriorityQueue<String>> map = new HashMap<>();
    public List<String> findItinerary(String[][] tickets) {
        if (tickets == null || tickets.length == 0) return result;
        for (String[] iter : tickets) {
            if (!map.containsKey(iter[0]))
                map.put(iter[0], new PriorityQueue<>());
            map.get(iter[0]).offer(iter[1]);
        }
        visit("JFK");
        return result;
    }

    private void visit(String des) {
        while (map.containsKey(des) && !map.get(des).isEmpty())
            visit(map.get(des).poll());
        result.addFirst(des);
    }
}
