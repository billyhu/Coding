package directgraph;

import java.util.LinkedList;
import java.util.List;

public class DirectGraph {

    public static final int MAX_VALUE = Integer.MAX_VALUE;

    private List<Node> nodeList;

    public DirectGraph() {
        nodeList = new LinkedList<Node>();
    }

    /**
     * add node
     */
    public int add(String name) {
        int index = -1;
        if (name != null) {
            Node node = new Node(name);
            nodeList.add(node);
            index = nodeList.indexOf(node);
        }
        return index;
    }

    /**
     * get node
     */
    public Node getNode(String name) {
        Node result = null;
        if (name != null) {
            for (Node node : nodeList) {
                if (node.getName() != null && node.getName().equals(name)) {
                    result = node;
                    break;
                }
            }
        }
        return result;
    }

    /**
     * add edge
     */
    public void add(Edge e) {
        if (e != null) {
            Node node = getNode(e.getSource());
            if (node != null) {
                node.addEdge(e);
            }
        }
    }

    /**
     * get edge
     */
    public Edge get(String src, String dest) {
        Edge result = null;
        Node s = getNode(src);
        Node d = getNode(dest);
        if (s != null && d != null) {
            result = s.getEdge(d.getName());
        }
        return result;
    }

    /**
     * get all edges
     */

    public List<Edge> getAllEdges() {
        List<Node> allNodes = nodeList;
        List<Edge> allEdges = new LinkedList<Edge>();
        for (Node node : nodeList) {
            for (Edge edge : node.getEdgeList()) {
                allEdges.add(edge);
            }
        }
        return allEdges;
    }

    /**
     * get node list
     */
    public List<Node> getNodeList() {
        return nodeList;
    }

    /**
     * compute shortest ways in a direct graph (Floyd)
     */

    public Integer getShortestDistance(DirectGraph dg, String source, String destination) {
        List<Node> nodes = dg.getNodeList();
        int size = nodes.size();
        Integer[][] distances = new Integer[size][size];
        for (Node nodei : nodes) {
            for (Node nodej : nodes) {
                Edge edge = dg.get(nodei.getName(), nodej.getName());

                int i = nodes.indexOf(nodei);
                int j = nodes.indexOf(nodej);
                if (edge != null) {
                    distances[i][j] = edge.getWeight();
                } else {
                    distances[i][j] = MAX_VALUE;
                }
            }
        }
        for (Node start : nodes) {
            for (Node midWay : nodes) {
                for (Node end : nodes) {
                    int m = nodes.indexOf(start);
                    int k = nodes.indexOf(midWay);
                    int n = nodes.indexOf(end);
                    if (distances[m][k] != MAX_VALUE && distances[k][n] != MAX_VALUE && distances[m][n] > (distances[m][k] + distances[k][n])) {
                        distances[m][n] = distances[m][k] + distances[k][n];
                    }
                }
            }
        }
        Node sourceNode = dg.getNode(source);
        Node destNode = dg.getNode(destination);
        Integer shortestDistance = MAX_VALUE;
        if (sourceNode != null && destNode != null) {
            shortestDistance = distances[nodes.indexOf(sourceNode)][nodes.indexOf(destNode)];
        }
        return shortestDistance;
    }
}
