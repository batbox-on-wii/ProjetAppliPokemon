package Test;

import java.io.*;
import java.util.*;

public class FichierLoaderAncien {

    public static Map<String, String> chargerMembres(String fichier) throws IOException {
        Map<String, String> villeDe = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fichier))) {
            String ligne;
            while ((ligne = reader.readLine()) != null) {
                String[] parts = ligne.split(";");
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
        try (BufferedReader reader = new BufferedReader(new FileReader(fichier))) {
            String ligne;
            while ((ligne = reader.readLine()) != null) {
                String[] parts = ligne.split(";");
                if (parts.length == 3) {
                    String ville1 = parts[0].trim();
                    String ville2 = parts[1].trim();
                    int d = Integer.parseInt(parts[2].trim());

                    distances.putIfAbsent(ville1, new HashMap<>());
                    distances.putIfAbsent(ville2, new HashMap<>());
                    distances.get(ville1).put(ville2, d);
                    distances.get(ville2).put(ville1, d);
                }
            }
        }
        return distances;
    }
}
