/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphs;

/**
 *
 * @author Tobias
 */
public interface Node
{
    public String getName();
    public int getIndex();
    public Iterable<Edge> getFromEdges();
}
