import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestGraphe {

    @Test
    public void test_Graphe(){
        //preparation des données
        GrapheListe graphe = new GrapheListe();
        graphe.ajouterArc("A","B",12);
        graphe.ajouterArc("A","D",87);
        graphe.ajouterArc("B","E",11);
        graphe.ajouterArc("C","A",19);
        graphe.ajouterArc("D","C",10);
        graphe.ajouterArc("D","B",23);
        graphe.ajouterArc("E","D",43);

        //verification
        assertEquals(5,graphe.getEnsNoeuds().size());
        assertEquals(5,graphe.listeNoeuds().size());

        int nbArc=0;
        for(int i=0;i<graphe.getEnsNoeuds().size();i++){
            nbArc+=graphe.getEnsNoeuds().get(i).getAdj().size();
        }
        assertEquals(7,nbArc);
    }
}
