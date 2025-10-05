import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException, IOException {

        // === FITXATEGIAK IRAKURTZEN ===
        Fitxategia fitx = new Fitxategia();
        fitx.irakurriEditoreak("Datos_DEA/authors-name-all.txt");
        fitx.irakurriArgitalpenak("Datos_DEA/publications-titles-all.txt");
        fitx.irakurriArgitalpenaEditoreak("Datos_DEA/publications-authors-all-final.txt");
        fitx.irakurriArgitalpenaAgintapeak("Datos_DEA/publications-citedPubs-all.txt");

        System.out.println("=== DATUAK KARGATUTA ===");
        System.out.println("Editore kopurua: " + EditoreaBiltegi.getNireEditoreaBiltegi().editoreKopurua());
        System.out.println("Argitalpen kopurua: " + ArgitalpenaBiltegi.getNireArgitalpenaBiltegi().argitalpenKopurua());
        System.out.println();

        // === BILATU EDITORE BAT ===
        Editorea e1 = EditoreaBiltegi.getNireEditoreaBiltegi().bilatuEditorea("Zhang, Wei (III)");
        if (e1 != null) {
            System.out.println("Aurkitu da editorea: " + e1.getIzena());
        } else {
            System.out.println("Ez da aurkitu editorea.");
        }
        System.out.println();

        // === GEHITU EDITORE BERRIA ===
        Editorea e2 = new Editorea("E9999", "Martinez, Ainhoa (I)");
        EditoreaBiltegi.getNireEditoreaBiltegi().gehituEditorea(e2);
        System.out.println("Editore berria gehituta: " + e2.getIzena());
        System.out.println("Editore kopurua orain: " + EditoreaBiltegi.getNireEditoreaBiltegi().editoreKopurua());
        System.out.println();

        // === BILATU ARGITALPEN BAT ===
        Argitalpena a1 = ArgitalpenaBiltegi.getNireArgitalpenaBiltegi().bilatuArgitalpena("JAir");
        if (a1 != null) {
            System.out.println("Aurkitu da argitalpena: " + a1.getIzenburua());
        } else {
            System.out.println("Ez da aurkitu argitalpena.");
        }
        System.out.println();

        // === GEHITU ARGITALPEN BERRIA ===
        Argitalpena a2 = new Argitalpena("00001", "Revista Ingenieritza Digitala");
        ArgitalpenaBiltegi.getNireArgitalpenaBiltegi().gehituArgitalpena(a2.getIdA(), a2);
        System.out.println("Argitalpen berria gehituta: " + a2.getIzenburua());
        System.out.println("Argitalpen kopurua orain: " + ArgitalpenaBiltegi.getNireArgitalpenaBiltegi().argitalpenKopurua());
        System.out.println();

        // === GEHITU EGILE BAT ARGITALPENARI ===
        a2.gehituEgilea(e2);
        e2.gehituArgitalpena(a2);
        System.out.println("Egilea gehituta argitalpenari:");
        for (String idEgile : a2.egileak()) {
            System.out.println(" - " + idEgile);
        }
        System.out.println();

        // === EZABATU EDITORE BAT ===
        EditoreaBiltegi.getNireEditoreaBiltegi().ezabatuEditorea("Q547084");
        System.out.println("Editorea 'Q547084' (Kevin Thiele) ezabatzen saiatu da.");
        System.out.println("Editore kopurua orain: " + EditoreaBiltegi.getNireEditoreaBiltegi().editoreKopurua());
        System.out.println();

        // === ORDENATU ETA BISTARATU ARGITALPENAK ===
        System.out.println("=== ARGITALPENAK ORDENATUTA ===");
        for (String izen : ArgitalpenaBiltegi.getNireArgitalpenaBiltegi().argitalpenakOrdenatuta()) {
            System.out.println(izen);
        }

        // === GORDE EGOERA FITXATEGIAN ===
        fitx.gordeEditoreak("Datos_DEA/authors-name-all.txt");
        fitx.gordeArgitalpenak("Datos_DEA/publications-titles-all.txt");
        System.out.println();
        System.out.println("✅ Egoera gordeta fitxategietan.");
    }
}
