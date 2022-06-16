import java.util.List;

/**
 * Interface Graphe
 */
public interface Graphe {
    public List<String> listeNoeuds();

    public List<Arc> suivants(String n);
}
