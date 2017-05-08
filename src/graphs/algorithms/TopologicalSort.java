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
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Stack;

/**
 *
 * @author Bancho
 */
public class TopologicalSort {
    
    public static List<Node> sort(Graph graph){
        Set<Node> visited = new HashSet<>();
        Stack<Node> stack = new Stack<>();
        Iterator<Node> it = graph.getNodes().iterator();
        
        // loop through all nodes
        while(it.hasNext()){
            Node n = it.next();
            if(!visited.contains(n)){
                recurse(n, visited, stack);
            }
        }
        
        List<Node> sorted = new ArrayList<>();
        while(!stack.empty()){
            sorted.add(stack.pop());
        }
        
        return sorted;
    }
    
    public static void recurse(Node current, Set<Node> visited, Stack<Node> stack){
        if(stack.contains(current)){
            return;
        }
        visited.add(current);
        for (Edge e : current.getFromEdges()) {
            Node child = e.getEndNode();
            if(!visited.contains(child)){
                recurse(child, visited, stack);
            }
        }
        stack.push(current);
    }
    
}
