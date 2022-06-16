import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Classe crée pour représenter les données d'un graphe
 * implémente l'interface Graphe
 */
public class GrapheListe implements Graphe {
    /**
     * Initialisation d'attributs
     * une liste de String qui stock les noms des objets noeuds
     * une liste de noeud qui stock les arcs
     */
    private final List<String> ensNom;
    private final List<Noeud> ensNoeuds;

    /**
     * Constructeur vide
     */
    public GrapheListe(){
        ensNom=new ArrayList<>();
        ensNoeuds=new ArrayList<>();
    }

    /**
     * Constructeur qui crée un graphe à partir d'un nom de fichier
     * @param nomdufichier
     * @throws IOException
     */
    public GrapheListe(String nomdufichier) throws IOException {
        ensNom=new ArrayList<>();
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

    /**
     * Constructeur qui permet de générer un graphe automatiquement
     * à partir d'une taille, noeud de départ, noeud d'arrivée
     * @param taille
     * @param depart
     * @param arrivee
     */
    public GrapheListe(int taille, String depart, String arrivee){
        Random r = new Random();
        this.ensNom=new ArrayList<>();
        this.ensNoeuds=new ArrayList<>();
        initRandomChemin(taille, depart, arrivee);
        for (int i=0;i<taille;i++){
            for (int j=0;j<r.nextInt(3)+1;j++) {
                int arr = r.nextInt(taille) + 1;
                while (arr == i + 1) {
                    arr = r.nextInt(taille) + 1;
                }
                boolean exist=false;
                int index=0;
                for (int l=0;l< listeNoeuds().size();l++){
                    if (listeNoeuds().get(l).equals(String.valueOf(i+1))) {
                        index = l;
                        break;
                    }
                }
                for (int k=0;k<suivants(listeNoeuds().get(index)).size();k++){
                    if (suivants(listeNoeuds().get(index)).get(k).getDest().equals(String.valueOf(arr))){
                        exist=true;
                    }
                }
                if (!String.valueOf(i + 1).equals(depart) && !String.valueOf(arr).equals(arrivee)) {
                    if (!exist)
                    ajouterArc(String.valueOf(i + 1), String.valueOf(arr), Math.round(100 * r.nextDouble(1) * r.nextDouble(1)));
                }
            }
        }
    }

    /**
     * méthode qui permet de créer un chemin aléatoire dans un graphe
     * @param taille
     * @param depart
     * @param arrivee
     */
    private void initRandomChemin(int taille, String depart, String arrivee){
        Random r = new Random();
        int tailleChemin;
        try{
            tailleChemin=r.nextInt(taille/r.nextInt(1,taille),taille);
        }catch (IllegalArgumentException e){
            tailleChemin=2;
        }
        String dep=depart;
        String arr;
        List<String> nodeUsed = new ArrayList<>();
        nodeUsed.add(dep);
        for (int i=0;i<tailleChemin-1;i++) {
            boolean used=false;
            arr = String.valueOf(r.nextInt(1, taille));
            for (String s : nodeUsed){
                if (arr.equals(s))
                    used=true;
            }
            while (dep.equals(arr) || arr.equals(arrivee) || used){
                used=false;
                arr = String.valueOf(r.nextInt(1, taille));
                for (String s : nodeUsed){
                    if (arr.equals(s))
                        used=true;
                }
            }
            ajouterArc(dep, arr,r.nextInt(1,100));
            nodeUsed.add(arr);
            dep=arr;
        }
        ajouterArc(dep, arrivee,r.nextInt(1,100));
    }

    /**
     * méthode qui permet d’ajouter des nœuds et des arcs
     * à un objet de type GrapheListe
     * @param depart
     * @param destination
     * @param cout
     */
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
    /**
     * méthode qui retourne la liste de noeuds
     */
    public List<String> listeNoeuds() {
        return ensNom;
    }

    @Override
    /**
     * méthode qui retourne la liste des arcs partant du noeud passé en paramètre.
     * @return List<Arc>
     */
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

    /**
     * méthode d'affichage du graphe
     * @return String
     */
    @Override
    public String toString() {
        String res ="";
        for(int i=0;i<ensNoeuds.size();i++){
            res+= ensNoeuds.get(i).getNom()+" --> ";
            res+=ensNoeuds.get(i).toString()+"\n";
        }
        return res;
    }

    /**
     * méthode qui représente le graphe
     * en respectant le format GraphViz
     * @return String
     */
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

    /**
     * méthode de guetter sur la liste de noeuds
     * @return List<Noeud>
     */
    public List<Noeud> getEnsNoeuds() {return ensNoeuds;}

}
