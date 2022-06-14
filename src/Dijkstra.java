import java.util.ArrayList;
import java.util.List;

public class Dijkstra {

    public Dijkstra() {
    }

    public Valeur resoudre(GrapheListe g, String depart) {
        Valeur v = new Valeur();
        //NodeList <- {} // utilisation d’une liste de noeuds a traiter
        List<String> NodeList = new ArrayList<>();
        //Pour chaque sommet node de g faire
        for (String node : g.listeNoeuds()) {
            //node.distance <- Infini
            v.setValeur(node, Double.MAX_VALUE);
            //node.parent <- Indefini
            v.setParent(node, null);
            // ajout du sommet v a la liste NodeList
            NodeList.add(node);
        }
        //depart.distance <- 0
        v.setValeur(depart, 0);
        //Tant que NodeList est un ensemble non vide faire
        while (!NodeList.isEmpty()) {
            //ActualNode <- un sommet de NodeList telle que ActualNode.distance est minimale
            String ActualNode = NodeList.get(0);
            int index = 0;
            for (int i = 0; i < NodeList.size(); i++) {
                if (v.getValeur(NodeList.get(i)) < v.getValeur(ActualNode)) {
                    ActualNode = NodeList.get(i);
                    index = i;
                }
            }
            // enlever le sommet ActualNode de la liste NodeList
            NodeList.remove(NodeList.get(index));
            //Pour chaque sommet node de NodeList tel que l’arc (ActualNode,node) existe faire
            for (String s : NodeList) {
                for (int k = 0; k < g.suivants(ActualNode).size(); k++) {
                    boolean exist = false;
                    if (s.equals(g.suivants(ActualNode).get(k).getDest()))
                        exist = true;

                    if (exist) {
                        double sum = v.getValeur(ActualNode) + g.suivants(ActualNode).get(k).getCout();
                        if (sum < v.getValeur(s)) {
                            v.setValeur(s, sum);
                            v.setParent(s, ActualNode);
                        }
                    }
                }
            }
        }
        return v;
    }
}

