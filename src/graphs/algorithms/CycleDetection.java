/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphs.algorithms;

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
        
//        for(int n = 0; n < graph.getSize(); n++){
//            if(!marked[n]) dfs(graph, null);
//        }

        Iterator<Node> it = graph.getNodes().iterator();
        
        while(it.hasNext()){
            Node n = it.next();
//            if(!marked[n.getIndex()]) dfs(graph, null);
            System.out.println(n.getIndex());
        }
        
        return null;
    }
    
    
    private void dfs(Graph graph, Node node){
        
    }
    
}
