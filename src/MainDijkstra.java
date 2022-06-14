import java.io.IOException;

public class MainDijkstra {
    public static void main(String[] args) throws IOException {
        GrapheListe graphe = new GrapheListe("graphes/Graphe905.txt");
        Dijkstra algo= new Dijkstra();
        long start1 = System.currentTimeMillis();
        String res = algo.resoudre(graphe,"1").toString();
        System.out.println(res);
        long end1 = System.currentTimeMillis();
        long time = end1 - start1;
        System.out.println(time);
    }
}
