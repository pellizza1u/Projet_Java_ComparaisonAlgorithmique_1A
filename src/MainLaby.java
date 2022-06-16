import java.io.IOException;

public class MainLaby {
    public static void main(String[] args) throws IOException {
        Labyrinthe laby = new Labyrinthe("labySimple/laby1.txt");
        GrapheListe graphe = laby.genererGraphe();
        Dijkstra algo= new Dijkstra();
        Valeur val = algo.resoudre(graphe,"1.1");
        System.out.println(val.calculerChemin("8.1"));
        System.out.println(graphe.toGraphViz());
    }
}
