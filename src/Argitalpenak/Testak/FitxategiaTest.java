package Testak;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import java.io.*;
import java.nio.file.*;
import java.util.*;

class FitxategiaTest {

    private Fitxategia fitxategia;
    private Path editoreFitxeroa;
    private Path argitalpenFitxeroa;
    private Path erlazioFitxeroa;
    private Path agintapeFitxeroa;
    private Path gordetakoEditoreak;
    private Path gordetakoArgitalpenak;

    @BeforeEach
    void setUp() throws IOException {
        fitxategia = new Fitxategia();
        EditoreaBiltegi.getNireEditoreaBiltegi().erreseteatu();
        ArgitalpenaBiltegi.getNireArgitalpenaBiltegi().erreseteatu();

        // Sortu fitxategi behin-behinekoak
        editoreFitxeroa = Files.createTempFile("editoreak", ".txt");
        argitalpenFitxeroa = Files.createTempFile("argitalpenak", ".txt");
        erlazioFitxeroa = Files.createTempFile("argitalpena_editorea", ".txt");
        agintapeFitxeroa = Files.createTempFile("argitalpena_agintapeak", ".txt");
        gordetakoEditoreak = Files.createTempFile("gorde_editoreak", ".txt");
        gordetakoArgitalpenak = Files.createTempFile("gorde_argitalpenak", ".txt");
    }

    @AfterEach
    void tearDown() throws IOException {
        Files.deleteIfExists(editoreFitxeroa);
        Files.deleteIfExists(argitalpenFitxeroa);
        Files.deleteIfExists(erlazioFitxeroa);
        Files.deleteIfExists(agintapeFitxeroa);
        Files.deleteIfExists(gordetakoEditoreak);
        Files.deleteIfExists(gordetakoArgitalpenak);
    }

    @Test
    void testIrakurriEditoreak() throws Exception {
        Files.writeString(editoreFitxeroa, "E1 # Jon\nE2 # Ane\n");
        fitxategia.irakurriEditoreak(editoreFitxeroa.toString());

        EditoreaBiltegi biltegia = EditoreaBiltegi.getNireEditoreaBiltegi();
        assertEquals(2, biltegia.editoreKopurua());
        assertNotNull(biltegia.bilatuEditorea("E1"));
        assertEquals("Jon", biltegia.bilatuEditorea("E1").getIzena());
    }

    @Test
    void testIrakurriArgitalpenak() throws Exception {
        Files.writeString(argitalpenFitxeroa, "A1 # Liburu Bat\nA2 # Bigarren Liburua\n");
        fitxategia.irakurriArgitalpenak(argitalpenFitxeroa.toString());

        ArgitalpenaBiltegi biltegia = ArgitalpenaBiltegi.getNireArgitalpenaBiltegi();
        assertEquals(2, biltegia.argitalpenKopurua());
        assertEquals("Liburu Bat", biltegia.bilatuArgitalpena("A1").getIzenburua());
    }

    @Test
    void testIrakurriArgitalpenaEditoreak() throws Exception {
        // Prestatu datuak
        Editorea e = new Editorea("E1", "Jon");
        Argitalpena a = new Argitalpena("A1", "Liburu Bat");
        EditoreaBiltegi.getNireEditoreaBiltegi().gehituEditorea("E1", e);
        ArgitalpenaBiltegi.getNireArgitalpenaBiltegi().gehituArgitalpena("A1", a);

        Files.writeString(erlazioFitxeroa, "A1 # E1\n");

        fitxategia.irakurriArgitalpenaEditoreak(erlazioFitxeroa.toString());

        assertTrue(a.egileak().contains("E1"));
        assertTrue(e.getArgitalpenak().contains("A1"));
    }

    @Test
    void testIrakurriArgitalpenaAgintapeak() throws Exception {
        Argitalpena a1 = new Argitalpena("A1", "Lehen Liburua");
        Argitalpena a2 = new Argitalpena("A2", "Bigarren Liburua");
        ArgitalpenaBiltegi.getNireArgitalpenaBiltegi().gehituArgitalpena("A1", a1);
        ArgitalpenaBiltegi.getNireArgitalpenaBiltegi().gehituArgitalpena("A2", a2);

        Files.writeString(agintapeFitxeroa, "A1 # A2\n");

        fitxategia.irakurriArgitalpenaAgintapeak(agintapeFitxeroa.toString());

        assertTrue(a1.aipamenak().contains("A2"));
        assertTrue(a2.aipamenak().contains("A1"));
    }

    @Test
    void testGordeEditoreak() throws Exception {
        Editorea e1 = new Editorea("E1", "Jon");
        Editorea e2 = new Editorea("E2", "Ane");
        EditoreaBiltegi.getNireEditoreaBiltegi().gehituEditorea("E1", e1);
        EditoreaBiltegi.getNireEditoreaBiltegi().gehituEditorea("E2", e2);

        fitxategia.gordeEditoreak(gordetakoEditoreak.toString());

        String edukia = Files.readString(gordetakoEditoreak);
        assertTrue(edukia.contains("E1 # Jon"));
        assertTrue(edukia.contains("E2 # Ane"));
    }

    @Test
    void testGordeArgitalpenak() throws Exception {
        Argitalpena a1 = new Argitalpena("A1", "Liburu Bat");
        Argitalpena a2 = new Argitalpena("A2", "Bigarren Liburua");
        ArgitalpenaBiltegi.getNireArgitalpenaBiltegi().gehituArgitalpena("A1", a1);
        ArgitalpenaBiltegi.getNireArgitalpenaBiltegi().gehituArgitalpena("A2", a2);

        fitxategia.gordeArgitalpenak(gordetakoArgitalpenak.toString());

        String edukia = Files.readString(gordetakoArgitalpenak);
        assertTrue(edukia.contains("A1 # Liburu Bat"));
        assertTrue(edukia.contains("A2 # Bigarren Liburua"));
    }
}