import java.io.IOException;

public class MainLaby {
    public static void main(String[] args) throws IOException {
        Labyrinthe laby = new Labyrinthe("labySimple/laby0.txt");
        GrapheListe graphe = laby.genererGraphe();
        Dijkstra algo= new Dijkstra();
        String res = algo.resoudre(graphe,"1.1").toString();
        System.out.println(res);
    }
}
