package com.dsa.ds;

public class Graph {

	private int[][] adjMatrix;
	private int v;
	private int e;

	public Graph(int n) {
		this.v = n;
		adjMatrix = new int[v][v];
		this.e = 0;
	}

	public void insertEdge(int i, int j) {
		adjMatrix[i][j] = 1;
		adjMatrix[j][i] = 1;
		e++; // Edges Count
	}

	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append(v + " vertices, " + e + " edges " + "\n");
		s.append("  0 1 2 3" + "\n");
		for (int i = 0; i < v; i++) {
			s.append(i + " ");
			for (int j = 0; j < v; j++) {
				s.append(adjMatrix[i][j] + " ");
			}
			s.append("\n");
		}
		return s.toString();
	}

	public static void main(String args[]) {
		Graph graph = new Graph(4);
		graph.insertEdge(0, 1);
		graph.insertEdge(1, 2);
		graph.insertEdge(2, 3);
		graph.insertEdge(3, 0);
		System.out.println(graph.toString());
	}

}
