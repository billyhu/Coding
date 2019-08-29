import java.util.LinkedList;
import java.util.List;

public class Node {
    private String name;
    private List<Edge> edgeList;

    public String getName() {
        return name;
    }

    public List<Edge> getEdgeList() {
        return edgeList;
    }

    public Node(String name) {
        this.name = name;
        this.edgeList = new LinkedList<Edge>();
    }

    public String toString() {
        String info = String.format("name : %s , list length : %s",
                name, edgeList.size());
        return info;
    }

    public void addEdge(Edge e) {
        if(getEdge(e.getDest()) == null) {
            edgeList.add(e);
        } else {
            System.out.println("edge exist : " + e);
        }
    }

    public Edge getEdge(String dest) {
        Edge result = null;
        if(dest != null) {
            for(Edge edge : edgeList) {
                if(edge.getDest() != null &&
                        dest.equals(edge.getDest())) {
                    result = edge;
                    break;
                }
            }
        }
        return result;
    }





}
