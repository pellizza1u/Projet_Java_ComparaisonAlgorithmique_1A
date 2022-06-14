import java.io.IOException;
import java.util.List;

public class MainBellmanFord {

    public static void main(String[] args) throws IOException {
        GrapheListe graphe = new GrapheListe("graphes/Graphe505.txt");
        BellmanFord algo= new BellmanFord();
        long start1 = System.currentTimeMillis();
        System.out.println(algo.resoudre(graphe,"1"));
        long end1 = System.currentTimeMillis();
        long time = end1 - start1;
        System.out.println(time);
    }
}
