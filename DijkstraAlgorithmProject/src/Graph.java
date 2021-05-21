
import java.util.List;

public class Graph {
    private final List<Node> nodes;
    private final List<Arc> arcs;

    public Graph(List<Node> nodes, List<Arc> arcs) {
        this.nodes = nodes;
        this.arcs = arcs;
    }

    public List<Node> getNodes() {
        return nodes;
    }

    public List<Arc> getArcs() {
        return arcs;
    }



}