package Test;

import java.io.IOException;
import java.util.List;
import java.util.Map;



public class TestLivraison {

    public static void main(String[] args) throws IOException {
        Map<String, String> villeDe = Test.FichierLoader.chargerMembres("data/membres.txt");
        List<LivraisonHeuristique.Vente> ventes = Test.FichierLoader.chargerVentes("data/ventes.txt");
        Map<String, Map<String, Integer>> distances = Test.FichierLoader.chargerDistances("data/distances.txt");

        List<String> chemin = LivraisonHeuristique.heuristiqueSimple(ventes, distances, villeDe, "Vélizy");

        System.out.println("Itinéraire calculé : " + chemin);

         /* //Test pour savoir si les fichiers sont bien lues//
        System.out.println("Ventes lues :");
        for (var v : ventes) {
            System.out.println("- " + v.vendeur + " -> " + v.acheteur);
        }

        System.out.println("\nVille de chaque membre :");
        for (var e : villeDe.entrySet()) {
            System.out.println("- " + e.getKey() + " : " + e.getValue());
        }

        System.out.println("\nDistances disponibles :");
        for (var e1 : distances.entrySet()) {
            for (var e2 : e1.getValue().entrySet()) {
                System.out.println("- " + e1.getKey() + " -> " + e2.getKey() + " : " + e2.getValue());
            }
        }

          */



    }
}
