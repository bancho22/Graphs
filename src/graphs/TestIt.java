/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphs;

import graphs.algorithms.BreadthFirst;
import graphs.algorithms.CycleDetection;
import graphs.algorithms.TopologicalSort;
import graphs.simpleimpl.GraphBuilderImpl;

/**
 *
 * @author Tobias
 */
public class TestIt
{
    public static void main(String[] args)
    {
        GraphBuilder gb = new GraphBuilderImpl();

        BuildNode a = gb.createNode("A");
        BuildNode b = gb.createNode("B");
        BuildNode c = gb.createNode("C");
        BuildNode d = gb.createNode("D");
        BuildNode e = gb.createNode("E");
        BuildNode f = gb.createNode("F");
        BuildNode g = gb.createNode("G");
        BuildNode h = gb.createNode("H");

//        gb.createEdge(a, b);
//        gb.createEdge(b, a);
//        gb.createEdge(a, d);
//        gb.createEdge(d, a);
//        gb.createEdge(b, c);
//        gb.createEdge(c, d);
//        gb.createEdge(c, c);
//        gb.createEdge(c, e);
//        gb.createEdge(e, d);
        
        gb.createEdge(a, c);
        gb.createEdge(b, c);
        gb.createEdge(b, d);
        gb.createEdge(c, e);
        gb.createEdge(e, h);
        gb.createEdge(e, f);
        gb.createEdge(d, f);
        gb.createEdge(f, g);
        
        
        Graph graph = gb.build();
        
        
        // Breadth First
//        Iterable<Node> res = BreadthFirst.runBreadthFirst(graph.findNode("A"));
//
//        for(Node n : res)
//        {
//            System.out.println(n.getName());
//        }
        
        
        // Cycle Detection
//        Iterable<Node> cycle = new CycleDetection().findCycle(graph);
//        if(cycle != null){
//            System.out.println("Cycle start");
//            for(Node n : cycle)
//            {
//                System.out.println(n.getName());
//            }
//            System.out.println("Cycle end");
//        }
//        else{
//            System.out.println("No cycles found");
//        }
        
        
        // Topological Sort
        Iterable<Node> topSorted = TopologicalSort.sort(graph);
        for (Node n : topSorted) {
            System.out.println(n.getName());
        }
    }
}
