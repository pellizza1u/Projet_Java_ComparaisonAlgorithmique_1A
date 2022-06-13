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
        for(int k=1; k<g.listeNoeuds().size()-1;k++) {
            for (int l = 0; l < g.getEnsNoeuds().get(k).getListArc().size(); l++){
                if(v.getValeur(g.getEnsNoeuds().get(k).getListArc().get(l).getDest())> (v.getValeur(g.suivants(depart).get(l).getDest()) + g.getEnsNoeuds().get(k).getListArc().get(l).getCout())){
                    v.setValeur(g.getEnsNoeuds().get(k).getListArc().get(l).getDest(),(v.getValeur(g.suivants(depart).get(l).getDest()) + g.getEnsNoeuds().get(k).getListArc().get(l).getCout()));
                    v.setParent(g.getEnsNoeuds().get(k).getListArc().get(l).getDest(),);
                }
            }
        }
    }
}
