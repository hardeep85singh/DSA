package com.example.dsalgo.graphs;

/**
 * @author Hardeep Singh
 */
public class DisjointUnionSets {
    int[] rank;
    int[] parent;
    int n;

    public DisjointUnionSets(int n){
        rank = new int[n];
        parent = new int[n];
        this.n = n;
        for (int i = 0; i < n; i++){
            parent[i] = i;
        }
    }

    public int findParent(int x){
        if(parent[x] == x){
            return x;
        }
        return parent[x] = findParent(parent[x]);
    }

    public void union(int u, int v){
        int uRoot = findParent(u);
        int vRoot = findParent(v);

        if(uRoot == vRoot){
            return;
        }

        if(rank[uRoot] < rank[vRoot]){
            parent[uRoot] = vRoot;
        } else if (rank[vRoot] < rank[uRoot]){
            parent[vRoot] = uRoot;
        } else {
            parent[vRoot] = uRoot;
            rank[uRoot] = rank[uRoot] + 1;
        }
    }
}
