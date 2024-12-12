package entities;

import java.util.ArrayList;
import java.util.List;

public class Prospects {
    public static ArrayList<Prospect> prospects = new ArrayList<>();

    public static void ajouterProspect(Prospect prospect) {
        prospects.add(prospect);
    }

    public static List<Prospect> getProspects() {
        return prospects;
    }
}

