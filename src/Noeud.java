import java.lang.String;
import java.util.ArrayList;
import java.util.List;

public class Noeud{
    private String nom;
    private List<Arc> adj;

    public Noeud(String n){
        this.nom = n;
        this.adj= new ArrayList<Arc>();
    }

    public boolean equals(Object o){
        return(this.equals(o));
    }

    public void ajouterArc(String destination, double cout){
        this.adj.add(new Arc(destination,cout));
    }
    public String getNom(){
        return nom;
    }
    public List<Arc> getAdj() {
        return adj;
    }

    @Override
    public String toString() {
        String res="";
        for(int i=0;i<adj.size();i++){
            res+=adj.get(i).getDest()+"("+adj.get(i).getCout()+") ";
        }
        return res;
    }
}
