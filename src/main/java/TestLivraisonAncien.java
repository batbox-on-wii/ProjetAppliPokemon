package Test;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class TestLivraisonAncien {

    public static void main(String[] args) throws IOException {
        Map<String, String> villeDe = Test.FichierLoaderAncien.chargerMembres("data/membres.txt");
        List<LivraisonHeuristique.Vente> ventes = Test.FichierLoaderAncien.chargerVentes("data/ventes.txt");
        Map<String, Map<String, Integer>> distances = Test.FichierLoaderAncien.chargerDistances("data/distances.txt");

        List<String> chemin = LivraisonHeuristique.heuristiqueSimple(ventes, distances, villeDe, "Vélizy");

        System.out.println("Itinéraire calculé : " + chemin);
    }
}
