import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Fitxategia {

    public Fitxategia() {

    }
    public void irakurriEditoreak(String pFitxeroa) throws FileNotFoundException, IOException {
        try (Scanner entrada = new Scanner(new FileReader(pFitxeroa))) {
            while (entrada.hasNext()) {
                String linea = entrada.nextLine();
                String[] datuak = linea.split("\\s+#\\s+");
                String id = datuak[0].trim();      // Ej: Q36423409
                String izena = datuak[1].trim();

                Editorea e = new Editorea(id, izena);
                EditoreaBiltegi.getNireEditoreaBiltegi().gehituEditorea(id, e);
            }
        }
    }


    // 2. ARGITALPENAK
    public void irakurriArgitalpenak(String pFitxeroa) throws FileNotFoundException, IOException {
        try (Scanner entrada = new Scanner(new FileReader(pFitxeroa))) {
            while (entrada.hasNext()) {
                String linea = entrada.nextLine();
                String[] datuak = linea.split("\\s+#\\s+");
                String id = datuak[0].trim();          // Ej: Q33205611
                String izenburua = datuak[1].trim();

                Argitalpena a = new Argitalpena(id, izenburua);
                ArgitalpenaBiltegi.getNireArgitalpenaBiltegi().gehituArgitalpena(id, a);
            }
        }
    }

    // 3. RELACIÓN ARGITALPENA ↔ EDITOREA
    public void irakurriArgitalpenaEditoreak(String pFitxeroa) throws FileNotFoundException, IOException {
        try (Scanner entrada = new Scanner(new FileReader(pFitxeroa))) {
            String linea;
            while (entrada.hasNext()) {
                linea = entrada.nextLine();
                String[] datuak = linea.split("\\s+#\\s+");
                String idArgitalpena = datuak[0].trim();
                String idEditorea = datuak[1].trim();

                Argitalpena a = ArgitalpenaBiltegi.getNireArgitalpenaBiltegi().bilatuArgitalpena(idArgitalpena);
                Editorea e = EditoreaBiltegi.getNireEditoreaBiltegi().bilatuEditorea(idEditorea);

                if (a != null && e != null) {
                    a.gehituEgilea(e);
                    e.gehituArgitalpena(a);
                }
            }
        }
    }
    public void irakurriArgitalpenaAgintapeak(String pFitxeroa) throws FileNotFoundException, IOException {
        try (Scanner entrada = new Scanner(new FileReader(pFitxeroa))) {
            String linea;
            while (entrada.hasNext()) {
                linea = entrada.nextLine();
                String[] datuak = linea.split("\\s+#\\s+");
                String idArgitalpena = datuak[0].trim();
                String idArgitalpena2 = datuak[1].trim();

                Argitalpena a = ArgitalpenaBiltegi.getNireArgitalpenaBiltegi().bilatuArgitalpena(idArgitalpena);
                Argitalpena ag = ArgitalpenaBiltegi.getNireArgitalpenaBiltegi().bilatuArgitalpena(idArgitalpena2);

                if (a != null && ag != null) {
                    a.gehituArgitalpena(ag);
                    ag.gehituArgitalpena(a);
                }
            }
        }
    }
    public void gordeEditoreak(String fitxeroa) throws IOException {
        try (PrintWriter pw = new PrintWriter(new FileWriter(fitxeroa))) {
            for (Editorea e : EditoreaBiltegi.getNireEditoreaBiltegi().getEditoreak()) {
                pw.println(e.getId() + " # " + e.getIzena());
            }
        }
    }

    public void gordeArgitalpenak(String fitxeroa) throws IOException {
        try (PrintWriter pw = new PrintWriter(new FileWriter(fitxeroa))) {
            for (Argitalpena a : ArgitalpenaBiltegi.getNireArgitalpenaBiltegi().getArgitalpenak()) {
                pw.println(a.getIdA() + " # " + a.getIzenburua());
            }
        }
    }
    
}
