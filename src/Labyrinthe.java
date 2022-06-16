import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * classe labyrinthe. represente un labyrinthe avec
 * <ul> des murs </ul>
 * <ul> un personnage (x,y) </ul>
 */
public class Labyrinthe {

    /**
     * Constantes char
     */
    public static final char MUR = 'X';
    public static final char PJ = 'P';
    public static final char VIDE = '.';

    /**
     * constantes actions possibles
     */
    public static final String HAUT = "Haut";
    public static final String BAS = "Bas";
    public static final String GAUCHE = "Gauche";
    public static final String DROITE = "Droite";


    /**
     * les murs du labyrinthe
     */
    public boolean[][] murs;

    /**
     * retourne la case suivante selon une actions
     *
     * @param x      case depart
     * @param y      case depart
     * @param action action effectuee
     * @return case suivante
     */
    static int[] getSuivant(int x, int y, String action) {
        switch (action) {
            case HAUT:
                // on monte une ligne
                y--;
                break;
            case BAS:
                // on descend une ligne
                y++;
                break;
            case DROITE:
                // on augmente colonne
                x++;
                break;
            case GAUCHE:
                // on augmente colonne
                x--;
                break;
            default:
                throw new Error("action inconnue");
        }
        int[] res = {x, y};
        return res;
    }

    /**
     * charge le labyrinthe
     *
     * @param nom nom du fichier de labyrinthe
     * @return labyrinthe cree
     * @throws IOException probleme a la lecture / ouverture
     */
    public Labyrinthe(String nom) throws IOException {
        // ouvrir fichier
        FileReader fichier = new FileReader(nom);
        BufferedReader bfRead = new BufferedReader(fichier);

        int nbLignes, nbColonnes;
        // lecture nblignes
        nbLignes = Integer.parseInt(bfRead.readLine());
        // lecture nbcolonnes
        nbColonnes = Integer.parseInt(bfRead.readLine());

        // creation labyrinthe vide
        this.murs = new boolean[nbColonnes][nbLignes];

        // lecture des cases
        String ligne = bfRead.readLine();

        // stocke les indices courants
        int numeroLigne = 0;

        // parcours le fichier
        while (ligne != null) {

            // parcours de la ligne
            for (int colonne = 0; colonne < ligne.length(); colonne++) {
                char c = ligne.charAt(colonne);
                switch (c) {
                    case MUR:
                        this.murs[colonne][numeroLigne] = true;
                        break;
                    case VIDE:
                        this.murs[colonne][numeroLigne] = false;
                        break;

                    default:
                        throw new Error("caractere inconnu " + c);
                }
            }

            // lecture
            ligne = bfRead.readLine();
            numeroLigne++;
        }

        // ferme fichier
        bfRead.close();
    }


    /**
     * deplace le personnage en fonction de l'action.
     * gere la collision avec les murs
     *
     * @param action une des actions possibles
     */
    public int[] deplacerPerso(int i, int j,String action) {
        // case courante
        int[] courante = {i,j};

        // calcule case suivante
        int[] suivante = getSuivant(courante[0], courante[1], action);

        // si c'est pas un mur, on effectue le deplacement
        if (!this.murs[suivante[0]][suivante[1]]) {
            // on met a jour personnage
            return suivante;
        }
        return courante;
    }

    public GrapheListe genererGraphe (){
        GrapheListe res = new GrapheListe();
        //on parcourt le tableau
        for (int i=0;i<this.murs.length;i++) {
            for (int j = 0; j < this.murs[i].length; j++) {
                //si on ne se trouve pas sur un mur
                if (!this.murs[i][j]) {
                    String actualNode = i + "." + j;
                    boolean exist1 = false;
                    boolean exist2 = false;
                    boolean exist3 = false;
                    boolean exist4 = false;
                    int index = 0;
                    for (int k = 0; k < res.listeNoeuds().size(); k++) {
                        if (actualNode.equals(res.listeNoeuds().get(k))) {
                            index = k;
                            break;
                        }
                    }
                    //si la liste de noeud n'est pas vide
                    if (res.listeNoeuds().size() > 0) {
                        //on parcourt la liste d'arc du noeud à l'index
                        for (int l = 0; l < res.suivants(res.listeNoeuds().get(index)).size(); l++) {
                            //on regard pour chaque case de côté si il y a déjà un arc qui les relis
                            double dest = Double.parseDouble(res.suivants(res.listeNoeuds().get(index)).get(l).getDest());
                            if (Double.parseDouble(actualNode) - 1 == dest) {
                                exist1 = true;
                            }
                            if (Double.parseDouble(actualNode) - 0.1 == dest) {
                                exist2 = true;
                            }
                            if (Double.parseDouble(actualNode) + 1 == dest) {
                                exist3 = true;
                            }
                            if (Double.parseDouble(actualNode) + 0.1 == dest) {
                                exist4 = true;
                            }
                        }
                    }
                    //on ajoute l'arc
                    if (i - 1 >= 0 && !this.murs[i - 1][j] && !exist1)
                        res.ajouterArc(actualNode, (i - 1) + "." + j, 1);
                    if (j - 1 >= 0 && !this.murs[i][j - 1] && !exist2)
                        res.ajouterArc(actualNode, i + "." + (j - 1), 1);
                    if (i + 1 < this.murs.length && !this.murs[i + 1][j] && !exist3)
                        res.ajouterArc(actualNode, (i + 1) + "." + j, 1);
                    if (j + 1 < this.murs[i].length && !this.murs[i][j + 1] && !exist4)
                        res.ajouterArc(actualNode, i + "." + (j + 1), 1);
                }
            }
        }
        return res;
    }

    /**
     * jamais fini
     *
     * @return fin du jeu
     */
    public boolean etreFini() {
        return false;
    }

    // ##################################
    // GETTER
    // ##################################

    /**
     * return taille selon Y
     *
     * @return
     */
    public int getLengthY() {
        return murs[0].length;
    }

    /**
     * return taille selon X
     *
     * @return
     */
    public int getLength() {
        return murs.length;
    }

    /**
     * return mur en (i,j)
     * @param x
     * @param y
     * @return
     */
    public boolean getMur(int x, int y) {
        // utilise le tableau de boolean
        return this.murs[x][y];
    }
}
