import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        GrapheListe graphe = new GrapheListe("graphes/Exemple.txt");
        System.out.println(graphe.toGraphViz());
    }
}
