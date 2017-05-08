/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphs.simpleimpl;

import graphs.Graph;
import graphs.Node;

/**
 *
 * @author Tobias
 */
public class GraphImpl implements Graph
{
    private final Iterable<Node> nodes;
    private final int size;

    public GraphImpl(Iterable<Node> nodes)
    {
        this.nodes = nodes;
        int size = 0;
        while(nodes.iterator().hasNext()){
            nodes.iterator().next();
            size++;
        }
        this.size = size;
    }
    
    @Override
    public int getSize(){
        return size;
    }
    
    
    @Override
    public Iterable<Node> getNodes()
    {
        return nodes;
    }

    @Override
    public Node findNode(String name)
    {
        for(Node n : nodes)
        {
            if(name.equals(n.getName()))
            {
                return n;
            }
        }
        return null;
    }
    
    
}
