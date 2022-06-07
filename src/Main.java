public class Main {
    public static void main(String[] args) {
        Noeud n1 = new Noeud("A");
        Noeud n2 = new Noeud("B");
        Noeud n3 = new Noeud("C");
        Noeud n4 = new Noeud("D");
        Noeud n5 = new Noeud("E");
        GrapheListe graphe = new GrapheListe();
        graphe.ajouterArc("A","B",12);
        graphe.ajouterArc("A","D",87);
        graphe.ajouterArc("B","E",11);
        graphe.ajouterArc("C","A",19);
        graphe.ajouterArc("D","C",10);
        graphe.ajouterArc("D","B",23);
        graphe.ajouterArc("E","D",43);
        System.out.println(graphe);
    }
}
