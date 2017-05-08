/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphs.algorithms;

import graphs.Edge;
import graphs.Graph;
import graphs.Node;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

/**
 *
 * @author Bancho
 */
public class CycleDetection { 
    
    //source for init code: https://github.com/mission-peace/interview/blob/master/src/com/interview/graph/CycleInDirectedGraph.java
    
    Map<Node, Node> edgeTo;
    Stack<Node> cycle;
    
    public Iterable<Node> findCycle(Graph graph) {

        Set<Node> whiteSet = new HashSet<>();

        Set<Node> graySet = new HashSet<>();

        Set<Node> blackSet = new HashSet<>();
        
        edgeTo = new HashMap<>();

        Iterator<Node> it = graph.getNodes().iterator();
        
        while(it.hasNext()){
            Node n = it.next();
            whiteSet.add(n);
        }

        while (whiteSet.size() > 0) {

            Node current = whiteSet.iterator().next();

            if (dfs(current, whiteSet, graySet, blackSet)) {
                
                // we found a cycle
                cycle = new Stack<>();
                cycle.push(current);
                
//                System.out.println(edgeTo.size());
//                System.out.println(current.getName());
                
                Node next = edgeTo.get(current);
                while(next != null){
                    cycle.push(next);
//                    System.out.println(next.getName());
                    next = edgeTo.get(next);
                }
                
                cycle.push(current);

                return cycle;

            }
            
            edgeTo.clear();

        }

        return null;

    }

    private boolean dfs(Node current, Set<Node> whiteSet,
            Set<Node> graySet, Set<Node> blackSet) {

        //move current to gray set from white set and then explore it.
        moveVertex(current, whiteSet, graySet);
        

        for (Edge e : current.getFromEdges()) {
            
            Node neighbor = e.getEndNode();
            
            //if in black set means already explored so continue.
            if (blackSet.contains(neighbor)) {

                continue;

            }

            //if in gray set then cycle found.
            if (graySet.contains(neighbor)) {
                
                return true;

            }

            if (dfs(neighbor, whiteSet, graySet, blackSet)) {

                edgeTo.put(current, neighbor);
                
                return true;

            }

        }

        //move vertex from gray set to black set when done exploring.
        moveVertex(current, graySet, blackSet);

        return false;

    }

    private void moveVertex(Node vertex, Set<Node> sourceSet,
            Set<Node> destinationSet) {

        sourceSet.remove(vertex);

        destinationSet.add(vertex);

    }

}
