import java.util.ArrayList;
import java.util.List;

/**
 * Classe crée qui permet d'implémenter l'algorithme de Dijkstra
 */
public class Dijkstra {
    /**
     * Constructeur vide
     */
    public Dijkstra() {
    }

    /**
     * methode qui permet de résoudre le meilleur chemin par Dijkstra
     * @param g
     * @param depart
     * @return Valeur
     */
    public Valeur resoudre(GrapheListe g, String depart) {
        Valeur v = new Valeur();
        //NodeList <- {} // utilisation d’une liste de noeuds a traiter
        List<String> NodeList = new ArrayList<>();
        //Pour chaque sommet node de g faire
        for (Noeud node : ((GrapheListe) g).getEnsNoeuds()) {
            //node.distance <- Infini
            v.setValeur(node.getNom(), Double.MAX_VALUE);
            //node.parent <- Indefini
            v.setParent(node.getNom(), null);
            // ajout du sommet v a la liste NodeList
            NodeList.add(node.getNom());
        }
        //depart.distance <- 0
        v.setValeur(depart, 0);
        //Tant que NodeList est un ensemble non vide faire
        while(NodeList.size()>0) {
            //ActualNode <- un sommet de NodeList telle que ActualNode.distance est minimale
            String ActualNode = minimum(NodeList, v);
            // enlever le sommet ActualNode de la liste NodeList
            NodeList.remove(ActualNode);
            //Pour chaque sommet node de NodeList tel que l’arc (ActualNode,node) existe faire
            for (Arc arc : g.suivants(ActualNode)) {
                if(NodeList.contains(arc.getDest())){
                    double val= v.getValeur(ActualNode)+arc.getCout();
                    if(val<v.getValeur(arc.getDest())){
                        v.setValeur(arc.getDest(),val);
                        v.setParent(arc.getDest(),ActualNode);
                    }
                }
            }
        }
        return v;
    }

    /**
     * methode qui permet de trouver la distance minimale du graphe vers un sommet
     * @param liste
     * @param v
     * @return String
     */
    public String minimum(List<String> liste, Valeur v){
        String mini= liste.get(0);
        for(int i=1;i< liste.size();i++){
            if(v.getValeur(liste.get(i))<v.getValeur(mini)){
                mini= liste.get(i);
            }
        }
        return mini;
    }
}

