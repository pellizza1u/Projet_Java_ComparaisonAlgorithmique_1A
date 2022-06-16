import java.lang.String;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe crée pour représenter les noeuds d'un graphe
 */
public class Noeud{
    /**
     * Initialisation d'attributs privés
     * Un nom de noeud pour l'identifier
     * une liste d'arc contenant la liste des arcs
     * reliant ce noeud à ses noeuds adjacents
     */
    private String nom;
    private List<Arc> adj;

    /**
     * Constructeur de Noeud à partir d'un nom de noeud
     * @param n
     */
    public Noeud(String n){
        this.nom = n;
        this.adj= new ArrayList<Arc>();
    }

    /**
     * méthode  qui sp spécifie que deux noeuds sont égaux
     * si et seulement si leurs noms sont  égaux
     * @param o
     * @return boolean
     */
    public boolean equals(Object o){
        return(this.equals(o));
    }

    /**
     * méthode qui permet d'ajouter un arc
     * allant vers le nœud destination
     * avec un coût de cout à la liste adj.
     * @param destination
     * @param cout
     */
    public void ajouterArc(String destination, double cout){
        this.adj.add(new Arc(destination,cout));
    }

    /**
     * méthode de guetter sur le nom du noeud
     * @return String
     */
    public String getNom(){
        return nom;
    }

    /**
     * méthode de guetter sur la liste d'arcs adjacents
     * @return List<Arc>
     */
    public List<Arc> getAdj() {
        return adj;
    }

    /**
     * méthode d'affichage d'un noeud
     * @return String
     */
    @Override
    public String toString() {
        String res="";
        for(int i=0;i<adj.size();i++){
            res+=adj.get(i).getDest()+"("+adj.get(i).getCout()+") ";
        }
        return res;
    }
}
