import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GrapheListe implements Graphe {
    private List<String> ensNom;
    private List<Noeud> ensNoeuds;

    public GrapheListe(){
        ensNom=new ArrayList();
        ensNoeuds=new ArrayList<>();
    }

    public GrapheListe(String nomdufichier) throws IOException {
        ensNom=new ArrayList();
        ensNoeuds=new ArrayList<>();
        // ouvrir fichier
        FileReader fichier = new FileReader(nomdufichier);
        BufferedReader bfRead = new BufferedReader(fichier);

        // lecture des cases
        String ligne = bfRead.readLine();

        while (ligne != null) {
            String[] ligneSplit = ligne.split("\t");
            this.ajouterArc(ligneSplit[0],ligneSplit[1], Double.parseDouble(ligneSplit[2]));
            ligne = bfRead.readLine();
        }
        // ferme fichier
        bfRead.close();
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
        if(!existDep) {
            ensNom.add(depart);
            ensNoeuds.add(new Noeud(depart));
        }
        if(!existArv) {
            ensNom.add(destination);
            ensNoeuds.add(new Noeud(destination));
        }
            for (int j = 0; j < ensNoeuds.size(); j++) {
                if (ensNoeuds.get(j).getNom().equals(depart)) {
                    noeudDep = ensNoeuds.get(j);
                    break;
                }
            }
            noeudDep.ajouterArc(destination, cout);
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

    public String toGraphViz(){
        String res="digraph G {\n";
        for(int i=0;i<ensNoeuds.size();i++){
            for(int j=0;j<ensNoeuds.get(i).getAdj().size();j++) {
                res += ensNoeuds.get(i).getNom() + " -> ";
                res += ensNoeuds.get(i).getAdj().get(j).getDest();
                res+= " [label = "+ensNoeuds.get(i).getAdj().get(j).getCout()+"]\n";
            }
        }
        return res+="}";
    }

    public List<Noeud> getEnsNoeuds() {return ensNoeuds;}

}
