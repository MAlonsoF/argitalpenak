package Argitalpenak;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

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
        System.out.println("=== BILATU EDITORE BAT ===");
        Editorea e1 = EditoreaBiltegi.getNireEditoreaBiltegi().bilatuEditorea("Q42331385");
        if (e1 != null) {
            System.out.println("Aurkitu da editorea: " + e1.getIzena());
        } else {
            System.out.println("Ez da aurkitu editorea.");
        }
        System.out.println();

        // === GEHITU EDITORE BERRIA ===
        System.out.println("=== GEHITU EDITORE BERRIA ===");
        Editorea e2 = new Editorea("E9999", "Martinez, Ainhoa (I)");
        EditoreaBiltegi.getNireEditoreaBiltegi().gehituEditorea(e2);
        System.out.println("Editore berria gehituta: " + e2.getIzena());
        System.out.println("Editore kopurua orain: " + EditoreaBiltegi.getNireEditoreaBiltegi().editoreKopurua());
        System.out.println();

        // === BILATU ARGITALPEN BAT ===
        System.out.println("=== BILATU ARGITALPEN BAT ===");
        Argitalpena a1 = ArgitalpenaBiltegi.getNireArgitalpenaBiltegi().bilatuArgitalpena("Q33205611");
        if (a1 != null) {
            System.out.println("Aurkitu da argitalpena: " + a1.getIzenburua());
        } else {
            System.out.println("Ez da aurkitu argitalpena.");
        }
        System.out.println();

        // === GEHITU ARGITALPEN BERRIA ===
        System.out.println("=== GEHITU ARGITALPEN BERRIA ===");
        Argitalpena a2 = new Argitalpena("Q00001", "Revista Ingenieritza Digitala");
        ArgitalpenaBiltegi.getNireArgitalpenaBiltegi().gehituArgitalpena(a2.getIdA(), a2);
        System.out.println("Argitalpen berria gehituta: " + a2.getIzenburua());
        System.out.println("Argitalpen kopurua orain: " + ArgitalpenaBiltegi.getNireArgitalpenaBiltegi().argitalpenKopurua());
        System.out.println();

        // === GEHITU EGILE BAT ARGITALPENARI ===
        System.out.println("=== GEHITU EGILE BAT ARGITALPENARI ===");
        a2.gehituEgilea(e2);
        e2.gehituArgitalpena(a2);
        System.out.println("Egilea gehituta argitalpenari:");
        for (String idEgile : a2.egileak()) {
            System.out.println(" - " + idEgile);
        }
        System.out.println();

     // === EZABATU EDITORE BAT ===
        System.out.println("=== EZABATU EDITORE BAT ===");
        String idEzabatu1 = "Q40101394";
        EditoreaBiltegi.getNireEditoreaBiltegi().ezabatuEditorea(idEzabatu1);
        System.out.println("Editorea '" + idEzabatu1 + "' ezabatzen saiatu da.");
        System.out.println("Editore kopurua orain: " + EditoreaBiltegi.getNireEditoreaBiltegi().editoreKopurua());
        System.out.println();
        
     // === EZABATU ARGITALPEN BAT ===
        System.out.println("=== EZABATU ARGITALPEN BAT ===");
        String idEzabatu = "Q48901983"; // Argitalpenaren ID
        ArgitalpenaBiltegi.getNireArgitalpenaBiltegi().ezabatuArgitalpena(idEzabatu);

        System.out.println("Argitalpena '" + idEzabatu + "' ezabatzen saiatu da.");
        System.out.println("Argitalpen kopurua orain: " + ArgitalpenaBiltegi.getNireArgitalpenaBiltegi().argitalpenKopurua());
        System.out.println();
        
     // === GEHITU EGILE BAT ARGITALPENARI (ID bidez) ===
        System.out.println("=== GEHITU EGILE BAT ARGITALPENARI (ID bidez) ===");
        String idEditorea = "Q47372720";           
        String idArgitalpena = "Q33205611";    

        Editorea e3 = EditoreaBiltegi.getNireEditoreaBiltegi().bilatuEditorea(idEditorea);
        Argitalpena a3 = ArgitalpenaBiltegi.getNireArgitalpenaBiltegi().bilatuArgitalpena(idArgitalpena);

        if (e3 != null && a3 != null) {
            a3.gehituEgilea(e3);     // gehitu editorea argitalpenari
            e3.gehituArgitalpena(a3); // gehitu argitalpena editoreari
            System.out.println("Egilea '" + e3.getIzena() + "' gehituta '" + a3.getIzenburua() + "' argitalpenari.");
        } else {
            System.out.println("Errorea: ezin izan da egilea edo argitalpena aurkitu.");
        }
        System.out.println();
     // === ARGITALPEN BATEN EGILEAK ===
        System.out.println("=== ARGITALPEN BATEN EGILEAK ===");
        String idArgitalpena1 = "Q33205611"; // ejemplo de ID de publicación existente
        Argitalpena arg = ArgitalpenaBiltegi.getNireArgitalpenaBiltegi().bilatuArgitalpena(idArgitalpena);

        if (arg != null) {
            System.out.println("Argitalpena: " + arg.getIzenburua());
            System.out.println("Egileak:");
            for (String idEgile : arg.egileak()) {
                Editorea e = EditoreaBiltegi.getNireEditoreaBiltegi().bilatuEditorea(idEgile);
                System.out.println(" - " + (e != null ? e.getIzena() : idEgile));
            }
        } else {
            System.out.println("Ez da aurkitu argitalpena: " + idArgitalpena);
        }
     // === AIPAMENAK ARGITALPEN BATERAKO ===
        System.out.println("=== AIPAMENAK ARGITALPEN BATERAKO ===");
        String idBilatua = "Q21136163"; // argitalpenaren ID-a, kontsultatu nahi dena
        Argitalpena arg2 = ArgitalpenaBiltegi.getNireArgitalpenaBiltegi().bilatuArgitalpena(idBilatua);

        if (arg != null) {
            System.out.println("Argitalpena: " + arg.getIzenburua());
            System.out.println("Aipatzen dituen argitalpenak:");
            for (String idAipatua : arg.aipamenak()) {
                System.out.println(" - " + idAipatua);
            }
        } else {
            System.out.println("Ez da aurkitu argitalpena: " + idBilatua);
        }
     // === EGILE BATEN ARGITALPENAK ===
        System.out.println("=== EGILE BATEN ARGITALPENAK ===");
        String idEditoreaBilatua = "Q89962239"; // Egilearen ID
        Editorea eBilatua = EditoreaBiltegi.getNireEditoreaBiltegi().bilatuEditorea(idEditoreaBilatua);

        if (eBilatua != null) {
            System.out.println("Egilea: " + eBilatua.getIzena());
            System.out.println("Argitalpenak:");
            for (String idArg : eBilatua.getArgitalpenak()) {
                Argitalpena a = ArgitalpenaBiltegi.getNireArgitalpenaBiltegi().bilatuArgitalpena(idArg);
                System.out.println(" - " + (a != null ? a.getIzenburua() : idArg));
            }
        } else {
            System.out.println("Ez da aurkitu egilea: " + idEditoreaBilatua);
        }
        System.out.println();

     // === AIPAMEN BAT GEHITU ARGITALPEN BATI ===
        System.out.println("=== AIPAMEN BAT GEHITU ARGITALPEN BATI ===");

        // Identifikadoreak
        String idArgitalpen1 = "Q35192782";  // el que cita
        String idArgitalpen2 = "Q36078047";  // el citado

        ArgitalpenaBiltegi biltegi = ArgitalpenaBiltegi.getNireArgitalpenaBiltegi();
        Argitalpena arg1 = biltegi.bilatuArgitalpena(idArgitalpen1);
        Argitalpena arg3 = biltegi.bilatuArgitalpena(idArgitalpen2);

        if (arg1 != null && arg3 != null) {
            arg1.gehituArgitalpena(arg3);
            System.out.println("Argitalpena '" + arg1.getIzenburua() + 
                               "' orain aipatzen du '" + arg3.getIzenburua() + "'");
        } else {
            System.out.println("Errorea: ezin izan da aurkitu argitalpenetako bat.");
        }

        System.out.println();
   // === RGITALPENEN ZERRENDA ORDENATUTA ===
        System.out.println("=== ARGITALPENEN ZERRENDA ORDENATUTA ===");
        System.out.println("(Total: " + ArgitalpenaBiltegi.getNireArgitalpenaBiltegi().argitalpenKopurua() + " argitalpen)");

        ArrayList<String> ordenatuta = ArgitalpenaBiltegi.getNireArgitalpenaBiltegi().argitalpenakOrdenatuta();
        for (String izen : ordenatuta) {
            System.out.println(izen);
        }
        

        System.out.println();

        // === GORDE EGOERA FITXATEGIAN ===
        fitx.gordeEditoreak("Datos_DEA/authors-name-all.txt");
        fitx.gordeArgitalpenak("Datos_DEA/publications-titles-all.txt");
        System.out.println();
        System.out.println("✅ Egoera gordeta fitxategietan.");
    }
}
