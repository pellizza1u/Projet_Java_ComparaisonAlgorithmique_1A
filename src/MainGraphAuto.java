import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainGraphAuto {

    public static void main(String[] args) throws IOException {
        var lst = new ArrayList<Integer>(List.of(10,20,50,100,500,1000,2000,5000,10000));
        for (var i : lst){
            long moyBelManFord = 0;
            long moyDijkstra = 0;

            GrapheListe graphe = new GrapheListe(i,"0",String.valueOf(i-1));

            for (int j = 0; j < 10; j++) {
                BellmanFord algo= new BellmanFord();
                Dijkstra dijkstra = new Dijkstra();
                long start1 = 0L;
                start1 = System.nanoTime();
                    algo.resoudre(graphe,"1");
                long end1 = System.nanoTime();
                long time = end1 - start1;
                moyBelManFord+=time;

                long start2 = 0L;
                start2 = System.nanoTime();
                dijkstra.resoudre(graphe,"1");
                long end2 = System.nanoTime();
                long time1 = end2 - start2;
                moyDijkstra+=time1;
            }
                System.out.println("Taille"+"|\t"+"BellmanFord"+"|\t"+"Dijkstra");
                System.out.println(i+"|\t"+moyBelManFord/10+"ns"+"|\t"+moyDijkstra/10+"ns");
                System.out.println();
    }
}
}