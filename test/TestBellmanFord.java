import org.junit.jupiter.api.Test;


import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertSame;

public class TestBellmanFord {

    @Test
    public void test_BellmanFord() throws IOException {
        //init
        GrapheListe graphe = new GrapheListe("graphes/Graphe5.txt");
        BellmanFord algo= new BellmanFord();
        //utilisation
        Valeur valeur = algo.resoudre(graphe,"1");
        //verification
        assertEquals(0,valeur.getValeur("1"));
        assertEquals(6,valeur.getValeur("2"));
        assertEquals(12,valeur.getValeur("3"));

        assertNull(valeur.getParent("1"));
        assertSame("1", valeur.getParent("2"));
        assertSame("1", valeur.getParent("3"));
    }
}
