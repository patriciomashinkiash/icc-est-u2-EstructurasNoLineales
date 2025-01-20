package main.materia.Controllers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

import main.materia.Models.NodeGraph;

public class Graph {
    private List<NodeGraph> nodes;
    
    public Graph(){
        this.nodes = new ArrayList<>();
    }

    public NodeGraph addNode(int value) {
        NodeGraph nodeGraph = new NodeGraph(value);
        nodes.add(nodeGraph);
        return nodeGraph;
    }

    public void addEdge(NodeGraph src, NodeGraph dest) {
        src.addNeighbor(dest);
        dest.addNeighbor(src);
    }

    public void addEdgeUnit(NodeGraph src, NodeGraph dest) {
        src.addNeighbor(dest);
    }

    public void printGraph() {
        for (NodeGraph nodeGraph : nodes) {
            System.out.print("Vertice " + nodeGraph.getValue() + ": ");
            for (NodeGraph neighbor : nodeGraph.getNeighbors()) {
                System.out.print(neighbor.getValue() + " -> ");
            }
            System.out.println() ;
        }
    }

    public void getDFS(NodeGraph start) {
        Set<NodeGraph> visitados = new HashSet<>();
        System.out.println("DFS desde el node " + start.getValue() + ":");
        getDFSUtil(start, visitados);
        System.out.println();
    }

    private void getDFSUtil(NodeGraph start, Set<NodeGraph> visitados) {
        if (visitados.contains(start)) {
            return;
            
        }

        System.out.print(start.getValue() + " ");
        visitados.add(start);

        for (NodeGraph neighbor : start.getNeighbors()) {
            getDFSUtil(neighbor, visitados);
        }
    }

    public boolean getDFS(NodeGraph start, NodeGraph destino) {
        
    }

    private boolean getDFSUtil(NodeGraph node, NodeGraph destino, Set<NodeGraph> visitados) {

    }


    public void getBFS(NodeGraph start) {
        Set<NodeGraph> visitados = new HashSet<>();
        Queue<NodeGraph> cola = new LinkedList<>();

        System.out.println("BFS desde el nodo " + start.getValue() + ":");
        cola.add(start);
        visitados.add(start);

        while (!cola.isEmpty()) {
            NodeGraph actual = cola.poll();
            System.out.print(actual.getValue() + " ");

            for (NodeGraph neighbor : actual.getNeighbors()) {
                if (!visitados.contains(neighbor)) {
                    visitados.add(neighbor);
                    cola.add(neighbor);
                }
            }
        }
    }
}
