package Test;

import java.io.*;
import java.util.*;

public class FichierLoader {

    public static Map<String, String> chargerMembres(String fichier) throws IOException {
        Map<String, String> villeDe = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fichier))) {
            String ligne;
            while ((ligne = reader.readLine()) != null) {
                String[] parts = ligne.split(" ");
                if (parts.length == 2) {
                    villeDe.put(parts[0].trim(), parts[1].trim());
                }
            }
        }
        return villeDe;
    }

    public static List<LivraisonHeuristique.Vente> chargerVentes(String fichier) throws IOException {
        List<LivraisonHeuristique.Vente> ventes = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fichier))) {
            String ligne;
            while ((ligne = reader.readLine()) != null) {
                String[] parts = ligne.split("->");
                if (parts.length == 2) {
                    ventes.add(new LivraisonHeuristique.Vente(parts[0].trim(), parts[1].trim()));
                }
            }
        }
        return ventes;
    }

    public static Map<String, Map<String, Integer>> chargerDistances(String fichier) throws IOException {
        Map<String, Map<String, Integer>> distances = new HashMap<>();
        List<String> villes = new ArrayList<>();
        List<int[]> lignesDistances = new ArrayList<>();

        // Lecture du fichier
        try (BufferedReader reader = new BufferedReader(new FileReader(fichier))) {
            String ligne;
            while ((ligne = reader.readLine()) != null) {
                String[] parts = ligne.trim().split("\\s+");
                if (parts.length < 2) continue; // ignorer lignes incorrectes

                String ville = parts[0].trim();
                villes.add(ville);

                int[] valeurs = new int[parts.length - 1];
                for (int i = 1; i < parts.length; i++) {
                    valeurs[i - 1] = Integer.parseInt(parts[i].trim());
                }
                lignesDistances.add(valeurs);
            }
        }

        // Construction de la carte distances
        for (int i = 0; i < villes.size(); i++) {
            String ville1 = villes.get(i);
            distances.putIfAbsent(ville1, new HashMap<>());
            for (int j = 0; j < villes.size(); j++) {
                String ville2 = villes.get(j);
                int d = lignesDistances.get(i)[j];
                distances.get(ville1).put(ville2, d);
            }
        }

        return distances;
    }

}
