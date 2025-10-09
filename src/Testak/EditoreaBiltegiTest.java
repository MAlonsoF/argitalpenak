package Testak;

import Argitalpenak.Argitalpena;
import Argitalpenak.Editorea;
import Argitalpenak.EditoreaBiltegi;
import Argitalpenak.IzenaEzberdinaException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.NoSuchElementException;

class EditoreaBiltegiTest {

    private EditoreaBiltegi biltegia;
    private Editorea editorea1;
    private Editorea editorea2;
    private Argitalpena arg1;
    private Argitalpena arg2;

    @BeforeEach
    void setUp() {
        biltegia = EditoreaBiltegi.getNireEditoreaBiltegi();
        biltegia.erreseteatu(); // Biltegia garbitu aurretik
        editorea1 = new Editorea("E1", "Aitor");
        editorea2 = new Editorea("E2", "Beńat");
        arg1 = new Argitalpena("A1", "Artikulu 1");
        arg2 = new Argitalpena("A2", "Artikulu 2");
    }

    @Test
    void testSingletonEredua() {
        EditoreaBiltegi b1 = EditoreaBiltegi.getNireEditoreaBiltegi();
        EditoreaBiltegi b2 = EditoreaBiltegi.getNireEditoreaBiltegi();
        assertSame(b1, b2, "Singleton eredua ez du bi instantzia ezberdin sortu behar");
    }

    @Test
    void testGehituEditoreaEtaKopurua() {
        biltegia.gehituEditorea(editorea1);
        biltegia.gehituEditorea(editorea2);

        assertEquals(2, biltegia.editoreKopurua());
    }

    @Test
    void testGehituEditoreaNullEzDuenOnartzen() {
        biltegia.gehituEditorea((Editorea) null);
        assertEquals(0, biltegia.editoreKopurua());
    }

    @Test
    void testGehituEditoreaIdarekin() {
        biltegia.gehituEditorea("E1", editorea1);
        assertEquals(1, biltegia.editoreKopurua());
        assertNotNull(biltegia.bilatuEditorea("E1"));
    }

    @Test
    void testBilatuEditorea() {
        biltegia.gehituEditorea(editorea1);
        Editorea aurkitua = biltegia.bilatuEditorea("E1");
        biltegia.bilatuEditorea("E4");
        biltegia.bilatuEditorea("");

        assertEquals("Aitor", aurkitua.getIzena());
        assertThrows(NoSuchElementException.class, () -> {
            biltegia.bilatuEditorea("E4");
        });
        assertThrows(NoSuchElementException.class, () -> {
            biltegia.bilatuEditorea("");
        });
    }

    @Test
    void testBilatuEditoreaEzDagoenean() {
        Editorea aurkitua = biltegia.bilatuEditorea("E99");
        assertNull(aurkitua);
    }

    @Test
    void testErreseteatu() {
        biltegia.gehituEditorea(editorea1);
        biltegia.erreseteatu();
        assertEquals(0, biltegia.editoreKopurua());
    }

    @Test
    void testGetEditoreak() {
        biltegia.gehituEditorea(editorea1);
        biltegia.gehituEditorea(editorea2);

        int kopurua = 0;
        for (Editorea e : biltegia.getEditoreak()) {
            assertNotNull(e);
            kopurua++;
        }
        assertEquals(2, kopurua);
    }

    @Test
    void testGetEditoreIds() {
        biltegia.gehituEditorea(editorea1);
        biltegia.gehituEditorea(editorea2);

        ArrayList<String> ids = biltegia.getEditoreIds();
        assertTrue(ids.contains("E1"));
        assertTrue(ids.contains("E2"));
    }

    @Test
    void testEgileakOrdenatuta() {
        biltegia.gehituEditorea(editorea2); // Beńat
        biltegia.gehituEditorea(editorea1); // Aitor

        ArrayList<String> ordenatua = biltegia.egileakOrdenatuta();

        assertEquals(2, ordenatua.size());
        assertEquals("Aitor", ordenatua.get(0), "Aitor lehenengo izan behar da alfabetikoki");
        assertEquals("Beńat", ordenatua.get(1));
    }

    @Test
    void testEzabatuEditorea() {
        // Loturak sortu
        editorea1.gehituArgitalpena(arg1);
        arg1.gehituEgilea(editorea1);

        biltegia.gehituEditorea(editorea1);
        assertEquals(1, biltegia.editoreKopurua());

        // Ezabatu eta egiaztatu
        biltegia.ezabatuEditorea("E1");
        assertNull(biltegia.bilatuEditorea("E1"), "Editorea ezabatua izan behar da");

        // Gainera, Argitalpenetik ere kendu behar da
        assertFalse(arg1.egileak().contains("E1"), "Argitalpenetik ere kendu behar du editorea");
    }

    @Test
    void testEzabatuEditoreaEzDagoenean() {
        biltegia.gehituEditorea(editorea1);
        biltegia.ezabatuEditorea("E99"); // Ez dago
        assertEquals(1, biltegia.editoreKopurua());
        assertNull(biltegia.bilatuEditorea("A1"));
        biltegia.ezabatuEditorea("A1");
        assertThrows(NoSuchElementException.class, () -> {
            biltegia.ezabatuEditorea("A1");
        });
        biltegia.ezabatuEditorea("");
        assertThrows(NoSuchElementException.class, () -> {
            biltegia.ezabatuEditorea("");
        });
    }
}
