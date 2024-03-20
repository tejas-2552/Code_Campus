package com.dsa.ds;

import java.util.LinkedList;
import java.util.Queue;

public class GraphWithLL {

	private LinkedList<Integer>[] adj;
	private int V;
	private int E;

	public GraphWithLL(int nodes) {
		this.V = nodes;
		this.E = 0;
		adj = new LinkedList[nodes];
		for (int i = 0; i < nodes; i++) {
			adj[i] = new LinkedList<>();
		}
	}

	public void addEdge(int u, int v) {
		this.adj[u].add(v);
		this.adj[v].add(u);
		E++;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(V + " vertices, " + E + " edges" + "\n");
		for (int i = 0; i < V; i++) {
			sb.append(i + " : ");
			for (int j = 0; j < adj[i].size(); j++) {
				sb.append(adj[i].get(j) + "  ");
			}
			sb.append("\n");
		}
		return sb.toString();
	}

	public void breadthFirstSearch(int val) {
		boolean[] visited = new boolean[V];
		Queue<Integer> q = new LinkedList<>();
		visited[val] = true;
		q.offer(val);
		while (!q.isEmpty()) {
			int u = q.poll();
			System.out.print(u + " ");
			for (int v : adj[u]) {
				if (!visited[v]) {
					visited[v] = true;
					q.offer(v);
				}
			}
		}
	}

	public static void main(String args[]) {
		GraphWithLL gll = new GraphWithLL(5);
		gll.addEdge(0, 1);
		gll.addEdge(1, 2);
		gll.addEdge(2, 3);
		gll.addEdge(3, 0);
		gll.addEdge(2, 4);
		System.out.println(gll.toString());
		gll.breadthFirstSearch(0);
		
	}
}
