package Test;

import java.util.*;

public class LivraisonHeuristique {

    public static class Vente {
        public final String vendeur;
        public final String acheteur;

        public Vente(String vendeur, String acheteur) {
            this.vendeur = vendeur;
            this.acheteur = acheteur;
        }
    }

    public static List<String> heuristiqueSimple(List<Vente> ventes, Map<String, Map<String, Integer>> distances, Map<String, String> villeDe, String depart) {
        Set<String> villesAVisiter = new HashSet<>();
        for (Vente vente : ventes) {
            villesAVisiter.add(villeDe.get(vente.vendeur));
            villesAVisiter.add(villeDe.get(vente.acheteur));
        }

        List<String> chemin = new ArrayList<>();
        String villeActuelle = depart;
        chemin.add(villeActuelle);

        while (!villesAVisiter.isEmpty()) {
            String prochaineVille = null;
            int distanceMin = Integer.MAX_VALUE;

            for (String ville : villesAVisiter) {
                int distance = distances.getOrDefault(villeActuelle, new HashMap<>()).getOrDefault(ville, Integer.MAX_VALUE);
                if (distance < distanceMin) {
                    distanceMin = distance;
                    prochaineVille = ville;
                }
            }

            if (prochaineVille != null) {
                chemin.add(prochaineVille);
                villesAVisiter.remove(prochaineVille);
                villeActuelle = prochaineVille;
            } else {
                break; // Erreur : plus de ville atteignable
            }
        }

        return chemin;
    }
}
