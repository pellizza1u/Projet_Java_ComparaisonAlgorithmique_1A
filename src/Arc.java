/**
 * Classe crée qui permet de representer un arc partant d'un noeud
 */

public class Arc {
    /**
     * Initialisation d'attributs privés
     * pour décrire un arc
     * un noeud de destination et un cout
     */
    private String dest;
    private double cout;

    /**
     * Construtcteur qui cree un arc à partir d'une destination et d'un cout
     * @param destination
     * @param c
     */
    public Arc(String destination, double c){
        this.dest=destination;
        if(c>0){
            this.cout=c;
        } else{this.cout=0;
            }
    }
    /**
     * methode de guetter sur le cout
     * @return double
     */
    public double getCout() {
        return cout;
    }

    /**
     * methode de guetter sur la destination
     * @return String
     */
    public String getDest() {
        return dest;
    }

}
