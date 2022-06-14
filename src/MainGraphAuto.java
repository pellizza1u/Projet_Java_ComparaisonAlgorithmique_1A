import java.io.IOException;

public class MainGraphAuto {
    public static void main(String[] args) throws IOException {
        GrapheListe graph = new GrapheListe("graphes/Graphe11.txt");
        graph.etendre(6);
        System.out.println(graph);
    }
}