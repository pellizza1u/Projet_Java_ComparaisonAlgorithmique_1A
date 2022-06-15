import java.io.IOException;

public class MainGraphAuto {
    public static void main(String[] args) throws IOException {
        GrapheListe graph = new GrapheListe(10,"1","10");
        System.out.println(graph.toGraphViz());
    }
}