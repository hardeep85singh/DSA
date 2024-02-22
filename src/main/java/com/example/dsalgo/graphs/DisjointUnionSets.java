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

    public int find(int x){
        if(parent[x] == x){
            return x;
        }
        return find(parent[x]);
    }

    public void union(int x, int y){
        int xRoot = find(x);
        int yRoot = find(y);

        if(xRoot == yRoot){
            return;
        }

        if(rank[xRoot] < rank[yRoot]){
            parent[xRoot] = yRoot;
        } else if (rank[yRoot] < rank[xRoot]){
            parent[yRoot] = xRoot;
        } else {
            parent[yRoot] = xRoot;
            rank[xRoot] = rank[xRoot] + 1;
        }
    }
}
