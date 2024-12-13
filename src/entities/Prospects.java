package entities;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Prospects {
    public static ArrayList<Prospect> prospects = new ArrayList<>();

    public static void ajouterProspect(Prospect prospect) {
        prospects.add(prospect);
    }

    public static List<Prospect> getProspects() {
        return prospects;
    }

    public static List<Prospect> triRaisonSociale() {
        return prospects.stream()
                .sorted(Comparator.comparing(Prospect::getRaisonSociale, String.CASE_INSENSITIVE_ORDER))
                .collect(Collectors.toList());
    }
}

