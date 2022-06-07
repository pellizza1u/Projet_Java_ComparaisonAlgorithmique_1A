
import java.lang.String;

public class Noeud extends String{
    private String nom;
    private List<Arc> adj;

    public Noeud(String n){
        this.nom = n;
        this.adj= new List<Arc>();
    }

    public boolean equals(Object o){
        return(this.equals(o));
    }
}
