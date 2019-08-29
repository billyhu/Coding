public class Edge {
    private String src;
    private String dest;
    private Integer weight;

    public Edge(String src, String dest, Integer weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }

    public String getSource() {
        return this.src;
    }

    public String getDest() {
        return this.dest;
    }

    public Integer getWeight() {
        return this.weight;
    }

    @Override
    public String toString() {
        String info = String.format("source : %s , destination : %s , weight : %s", src, dest, weight);
        return info;
    }
}
