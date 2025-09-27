import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class Fitxategia {

    public Fitxategia() {

    }
    public void irakurriEditoreak(String pFitxeroa) throws FileNotFoundException, IOException {
        try (Scanner entrada = new Scanner(new FileReader(pFitxeroa))) {
            String linea;
            while (entrada.hasNext()) {
                linea = entrada.nextLine();
                String[] datuak = linea.split("\\s+#\\s+");
                String id = datuak[0].trim();
                String izena = datuak[1].trim();

                Editorea e = new Editorea(id.hashCode(), izena); // o usar String id directamente
                EditoreaBiltegi.getNireEditoreaBiltegi().gehituEditorea(id, e);
            }
        }
    }

    public void lineaEditoreak(String pEditoreak) throws FileNotFoundException, IOException {
        try (Scanner entrada = new Scanner(new FileReader(pFitxeroa))) {

            while ((entrada.hasNext())&& (linea[i].equals())) {
                linea = entrada.nextLine();
                if ()
                String[] datuak = linea.split("\\s+#\\s+");
                String id = datuak[0].trim();
                String izena = datuak[1].trim();

                Editorea e = new Editorea(id.hashCode(), izena); // o usar String id directamente
                EditoreaBiltegi.getNireEditoreaBiltegi().gehituEditorea(id, e);
        }
    }

    // 2. ARGITALPENAK
    public void irakurriArgitalpenak(String pFitxeroa) throws FileNotFoundException, IOException {
        try (Scanner entrada = new Scanner(new FileReader(pFitxeroa))) {
            String linea;
            while (entrada.hasNext()) {
                linea = entrada.nextLine();
                String[] datuak = linea.split("\\s+#\\s+");
                String id = datuak[0].trim();
                String izenburua = datuak[1].trim();

                Argitalpena a = new Argitalpena(id.hashCode(), izenburua);
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
                String idAgintapea = datuak[1].trim();

                Argitalpena a = ArgitalpenaBiltegi.getNireArgitalpenaBiltegi().bilatuArgitalpena(idArgitalpena);
                Agintapea ag = AgintapeBiltegi.getNireAgintapeBiltegi().bilatuAgintapea(idAgintapea);

                if (a != null && ag != null) {
                    a.gehituAgintapea(ag);
                    ag.gehituArgitalpena(a);
                }
            }
        }
    }
}
