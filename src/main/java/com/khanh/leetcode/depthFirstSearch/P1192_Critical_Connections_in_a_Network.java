package com.khanh.leetcode.depthFirstSearch;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/***
 * https://leetcode.com/problems/critical-connections-in-a-network/
 * Hard
 * There are n servers numbered from 0 to n-1 connected by undirected server-to-server connections forming a network where connections[i] = [a, b] represents a connection between servers a and b. Any server can reach any other server directly or indirectly through the network.
 *
 * A critical connection is a connection that, if removed, will make some server unable to reach some other server.
 *
 * Return all critical connections in the network in any order.
 *
 *
 * Example 1:
 *                     2
 *                   /  |
 *                 /    |
 *              1       |
 *              |  \    |
 *   critical   |    \  |
 *              |       0
 *              3
 *
 * Input: n = 4, connections = [[0,1],[1,2],[2,0],[1,3]]
 * Output: [[1,3]]
 * Explanation: [[3,1]] is also accepted.
 *
 * https://leetcode.com/problems/critical-connections-in-a-network/discuss/382638/DFS-detailed-explanation-O(orEor)-solution
 */
public class P1192_Critical_Connections_in_a_Network {

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        /*List<Integer>[] graph = new ArrayList[];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (List<Integer> oneConnection: connections) {
            graph[oneConnection.get(0)].add(oneConnection.get(1));
            graph[oneConnection.get(1)].add(oneConnection.get(0));
        }
        HashSet<List<Integer>> connectionSet = new HashSet<>(connections);
        */
        return null;
    }

}
