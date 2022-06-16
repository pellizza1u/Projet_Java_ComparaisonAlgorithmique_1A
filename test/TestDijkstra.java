import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertSame;

public class TestDijkstra {

    @Test
    public void test_Dijkstra() throws IOException {
        //init
        GrapheListe graphe = new GrapheListe("graphes/Graphe5.txt");
        Dijkstra algo= new Dijkstra();
        //utilisation
        Valeur valeur = algo.resoudre(graphe,"1");
        //verification
        assertEquals(0,valeur.getValeur("1"));
        assertEquals(6,valeur.getValeur("2"));
        assertEquals(12,valeur.getValeur("3"));

        assertNull(valeur.getParent("1"));
        assertEquals("1", valeur.getParent("2"));
        assertEquals("1", valeur.getParent("3"));
    }

    @Test
    public void test_Dijkstra_boucle() throws IOException {
        //init
        GrapheListe graphe = new GrapheListe("graphes/boucle.txt");
        Dijkstra algo= new Dijkstra();
        //utilisation
        Valeur valeur = algo.resoudre(graphe,"A");
        //verification
        assertEquals(0,valeur.getValeur("A"));
        assertEquals(9,valeur.getValeur("B"));
        assertEquals(7,valeur.getValeur("C"));
        assertEquals(3,valeur.getValeur("D"));
        assertEquals(27,valeur.getValeur("E"));
        assertEquals(24,valeur.getValeur("F"));
        assertEquals(19,valeur.getValeur("G"));

        assertNull(valeur.getParent("A"));
        assertEquals("C", valeur.getParent("B"));
        assertEquals("D", valeur.getParent("C"));
        assertEquals("A", valeur.getParent("D"));
        assertEquals("F", valeur.getParent("E"));
        assertEquals("G", valeur.getParent("F"));
        assertEquals("B", valeur.getParent("G"));
    }
}
