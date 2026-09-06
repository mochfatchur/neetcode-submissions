class Solution {
    // plans:
    // we will use directed graph, by defining the:
    // - indegree as sum of node that trust the node
    // - outgree as sum of node that the node trust
    // town judge is 
    // - a node with indegree = TotalNode-1
    // - a node with outdegree = 0

    // implementation
    public int findJudge(int n, int[][] trust) {
        // biar gampang define 1 - n (idx 0 ngga kepakai)
        int[] indegree = new int[n+1];
        int[] outdegree = new int[n+1];

        // build indegree and outdegree graph
        for (int[] t : trust) {
            // node t
            indegree[t[1]]++;
            outdegree[t[0]]++;
        }

        for (int i = 1; i <= n; i++) {
            if (indegree[i] == (n-1) && outdegree[i] == 0) {
                return i;
            }
        } 
        return -1;
    }
}