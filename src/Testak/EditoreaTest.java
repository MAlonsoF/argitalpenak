package Testak;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

class EditoreaTest {

    private Editorea editorea;
    private Argitalpena argitalpena1;
    private Argitalpena argitalpena2;

    @BeforeEach
    void setUp() {
        editorea = new Editorea("E1", "Editore Bat");
        argitalpena1 = new Argitalpena("A1", "Argitalpena 1");
        argitalpena2 = new Argitalpena("A2", "Argitalpena 2");
    }

    @Test
    void testGetId() {
        assertEquals("E1", editorea.getId());
    }

    @Test
    void testGetIzena() {
        assertEquals("Editore Bat", editorea.getIzena());
    }

    @Test
    void testGehituArgitalpena() {
        editorea.gehituArgitalpena(argitalpena1);
        ArrayList<String> zerrenda = editorea.getArgitalpenak();

        assertEquals(1, zerrenda.size());
        assertTrue(zerrenda.contains("A1"));
    }

    @Test
    void testEzDituArgitalpenBikoiztuakGehitzen() {
        editorea.gehituArgitalpena(argitalpena1);
        editorea.gehituArgitalpena(argitalpena1); // bikoiztua
        ArrayList<String> zerrenda = editorea.getArgitalpenak();

        assertEquals(1, zerrenda.size(), "Ez luke argitalpen bikoiztua gehitu behar");
    }

    @Test
    void testArgitalpenZerrendaHutsik() {
        ArrayList<String> zerrenda = editorea.getArgitalpenak();
        assertTrue(zerrenda.isEmpty());
    }

    @Test
    void testGetArgitalpenakObjektuak() {
        editorea.gehituArgitalpena(argitalpena1);
        editorea.gehituArgitalpena(argitalpena2);

        int kopurua = 0;
        for (Argitalpena a : editorea.getArgitalpenakObjektuak()) {
            assertNotNull(a);
            kopurua++;
        }
        assertEquals(2, kopurua);
    }

    @Test
    void testElkarrekikoHarremana() {
        // Editorea eta Argitalpena elkarrekin ondo funtzionatzen dutela egiaztatzeko
        editorea.gehituArgitalpena(argitalpena1);
        argitalpena1.gehituEgilea(editorea);

        assertTrue(editorea.getArgitalpenak().contains("A1"));
        assertTrue(argitalpena1.egileak().contains("E1"));
    }
}
