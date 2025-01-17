package main.materia.Controllers;

import java.util.ArrayList;
import java.util.List;
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

    public void printGraph() {
        for (NodeGraph nodeGraph : nodes) {
            System.out.print("Vertice " + nodeGraph.getValue() + ": ");
            for (NodeGraph neighbor : nodeGraph.getNeighbors()) {
                System.out.print(neighbor.getValue() + " - ");
            }
            System.out.println() ;
        }
    }

    public void getDFS(NodeGraph startNode) {

    }

    private void getDFSUtil(NodeGraph node, boolean[] visited) {

    }

    public void getBFS(NodeGraph startNode) {

    }
}
