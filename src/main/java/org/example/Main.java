package org.example;

import edu.princeton.cs.algs4.In;

public class Main {


    public static void main(String[] args) {
        // 1. Lê o arquivo
        In in = new In("dados/entrada_eulerizada.txt");

        EdgeWeightedDigraph weightedDigraph = new EdgeWeightedDigraph(in);

        System.out.println("Vertices: " + weightedDigraph.V());
        System.out.println("Arestas: " + weightedDigraph.E() + "\n");

        boolean isBalanced = true;
        for (int v = 0; v < weightedDigraph.V(); v++) {
            System.out.println("Vertice " + v + " Grau de entrada: " + weightedDigraph.indegree(v));
            System.out.println("Vertice " + v + " Grau de saída: " + weightedDigraph.outdegree(v));
            System.out.println();

            if (weightedDigraph.indegree(v) != weightedDigraph.outdegree(v)) {
                isBalanced = false;
            }

        }

        if (isBalanced) {
            System.out.println("Grafo é balanceado.");
        } else {
            System.out.println("Grafo não é balanceado.");
        }

        Digraph digraph = new Digraph(weightedDigraph.V());
        for (DirectedEdge e : weightedDigraph.edges()) {
            digraph.addEdge(e.from(), e.to());
        }

        //metodo Hierholzer
        DirectedEulerianCycle eulerianCycle = new DirectedEulerianCycle(digraph);
        double pesoTotal = 0;

        if (eulerianCycle.hasEulerianCycle()) {
            System.out.println("\nCiclo Euleriano encontrado:");

            Integer anterior = null;
            for (int atual : eulerianCycle.cycle()) {
                System.out.print(atual + " ");

                if (anterior != null) {
                    for (DirectedEdge e : weightedDigraph.adj(anterior)) {
                        if (e.to() == atual) {
                            pesoTotal += e.weight();
                            break;
                        }
                    }
                }
                anterior = atual;
            }
            System.out.println("\nPeso total do ciclo Euleriano: " + pesoTotal);
        } else {
            System.out.println("Grafo não possui ciclo Euleriano.");
        }
    }
}
