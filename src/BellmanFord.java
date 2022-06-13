public class BellmanFord {
    Graphe g;
    String depart;

    public Valeur resoudre(GrapheListe g, String depart){
        Valeur v=  new Valeur();
        for(String i : g.listeNoeuds()){
            v.setValeur(i,Double.MAX_VALUE);
            v.setParent(i,null);
        }
        v.setValeur(depart,0);
        boolean stop=false;
        while(!stop) {
            stop=true;
            for (int k = 0; k < g.listeNoeuds().size(); k++) {
                for (int l = 0; l < g.suivants(g.listeNoeuds().get(k)).size(); l++) {
                    if (v.getValeur(g.suivants(g.listeNoeuds().get(k)).get(l).getDest()) > v.getValeur(g.listeNoeuds().get(k)) + g.suivants(g.listeNoeuds().get(k)).get(l).getCout()) {
                        v.setValeur(g.suivants(g.listeNoeuds().get(k)).get(l).getDest(), v.getValeur(g.listeNoeuds().get(k)) + g.suivants(g.listeNoeuds().get(k)).get(l).getCout());
                        v.setParent(g.suivants(g.listeNoeuds().get(k)).get(l).getDest(), g.listeNoeuds().get(k));
                        stop=false;
                    }
                }
            }
        }
        return v;
    }
}
