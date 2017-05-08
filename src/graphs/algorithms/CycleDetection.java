/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphs.algorithms;

import graphs.Edge;
import graphs.Graph;
import graphs.Node;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 *
 * @author Bancho
 */
public class CycleDetection {
    
    private boolean[] marked;
    private Node[] edgeTo;
    private boolean[] onStack;
    private Stack<Node> cycle;
    
    public List<Node> detectCycles(Graph graph){
        marked = new boolean[graph.getSize()];
        edgeTo = new Node[graph.getSize()];
        onStack = new boolean[graph.getSize()];
        

        Iterator<Node> it = graph.getNodes().iterator();
        
        while(it.hasNext()){
            Node n = it.next();
            if(!marked[n.getIndex()]) dfs(graph, n);
        }
        
        return null;
    }
    
    
    private void dfs(Graph graph, Node node){
//        System.out.println(node.getIndex());
        onStack[node.getIndex()] = true;
        marked[node.getIndex()] = true;
        for (Edge e : node.getFromEdges()) {
            Node neighbour = e.getEndNode();
            if(this.hasCycle()){
                 return;
            }
            else if(!marked[neighbour.getIndex()]){
                edgeTo[neighbour.getIndex()] = node;
                dfs(graph, neighbour);
            }
            else if(onStack[neighbour.getIndex()]){
                cycle = new Stack<Node>();
                for (Node x = node; x.getIndex() != neighbour.getIndex(); x = edgeTo[x.getIndex()]) {
                    cycle.push(x);
                }
                cycle.push(neighbour);
                cycle.push(node);
            }
        }
        onStack[node.getIndex()] = false;
    }
    
    public boolean hasCycle(){
        return cycle != null;
    }
    
    public Iterable<Node> cycle(){
        return cycle;
    }
    
}
