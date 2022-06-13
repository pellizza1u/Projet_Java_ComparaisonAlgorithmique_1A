import java.io.IOException;
import java.util.List;

public class MainBellmanFord {

    public static void main(String[] args) throws IOException {
        GrapheListe graphe = new GrapheListe("graphes/Graphe1.txt");
        BellmanFord algo= new BellmanFord();
        System.out.println(algo.resoudre(graphe,"1"));
    }
}
