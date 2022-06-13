import java.io.IOException;

public class MainDijkstra {
    public static void main(String[] args) throws IOException {
        GrapheListe graphe = new GrapheListe("graphes/Graphe1.txt");
        Dijkstra algo= new Dijkstra();
        String res = algo.resoudre(graphe,"1").toString();
        System.out.println(res);
    }
}
