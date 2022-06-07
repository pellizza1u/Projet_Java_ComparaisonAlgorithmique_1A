import java.util.ArrayList;
import java.util.List;

public class GrapheListe implements Graphe {
    private List<String> ensNom;
    private List<Noeud> ensNoeuds;

    public GrapheListe(){
        ensNom=new ArrayList();
        ensNoeuds=new ArrayList<>();
    }

    public void ajouterArc(String depart, String destination, double cout) {
        boolean existDep = false;
        boolean existArv = false;
        Noeud noeudDep = null;
        for (int i = 0; i < ensNom.size(); i++) {
            if (ensNom.get(i).equals(depart)) {
                existDep = true;
            }
            if (ensNom.get(i).equals(destination)) {
                existArv = true;
            }
        }
        if (existDep && existArv) {
            for (int j = 0; j < ensNoeuds.size(); j++) {
                if (ensNoeuds.get(j).getNom().equals(depart)) {
                    noeudDep = ensNoeuds.get(j);
                    break;
                }
            }
            noeudDep.ajouterArc(destination, cout);
        }
    }

    @Override
    public List<String> listeNoeuds() {
        return ensNom;
    }

    @Override
    public List<Arc> suivants(String n) {
        Noeud noeud = null;
        for (int i = 0; i < ensNoeuds.size(); i++) {
            if (ensNoeuds.get(i).getNom().equals(n)) {
                noeud = ensNoeuds.get(i);
            }
        }
        if (noeud!=null){
            return noeud.getAdj();
        } else{
            return null;
        }
    }

    @Override
    public String toString() {
        String res ="";
        for(int i=0;i<ensNoeuds.size();i++){
            res+= ensNoeuds.get(i).getNom()+" --> ";
            res+=ensNoeuds.get(i).toString()+"\n";
        }
        return res;
    }
}