package Testak;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

class ArgitalpenaBiltegiTest {

    private ArgitalpenaBiltegi biltegia;
    private Argitalpena arg1;
    private Argitalpena arg2;

    @BeforeEach
    void setUp() {
        biltegia = ArgitalpenaBiltegi.getNireArgitalpenaBiltegi();
        biltegia.erreseteatu();
        arg1 = new Argitalpena("A1", "Argitalpena Bat");
        arg2 = new Argitalpena("A2", "Beste Argitalpena");
    }

    @Test
    void testSingletonEredua() {
        ArgitalpenaBiltegi b1 = ArgitalpenaBiltegi.getNireArgitalpenaBiltegi();
        ArgitalpenaBiltegi b2 = ArgitalpenaBiltegi.getNireArgitalpenaBiltegi();
        assertSame(b1, b2, "Singleton eredua ez du bi instantzia ezberdin sortu behar");
    }

    @Test
    void testGehituArgitalpena() {
        biltegia.gehituArgitalpena("A1", arg1);
        biltegia.gehituArgitalpena("A2", arg2);

        assertEquals(2, biltegia.argitalpenKopurua());
    }

    @Test
    void testEzDituBikoiztuakGehitzen() {
        biltegia.gehituArgitalpena("A1", arg1);
        biltegia.gehituArgitalpena("A1", arg1); // Bikoiztua
        assertEquals(1, biltegia.argitalpenKopurua(), "Ez luke argitalpen bikoiztua gehitu behar");
    }

    @Test
    void testBilatuArgitalpena() {
        biltegia.gehituArgitalpena("A1", arg1);
        Argitalpena aurkitua = biltegia.bilatuArgitalpena("A1");

        assertNotNull(aurkitua);
        assertEquals("Argitalpena Bat", aurkitua.getIzenburua());
    }

    @Test
    void testBilatuArgitalpenaEzDagoenean() {
        Argitalpena aurkitua = biltegia.bilatuArgitalpena("E99");
        assertNull(aurkitua);
    }

    @Test
    void testEzabatuArgitalpena() {
        biltegia.gehituArgitalpena("A1", arg1);
        assertEquals(1, biltegia.argitalpenKopurua());

        biltegia.ezabatuArgitalpena("A1");
        assertEquals(0, biltegia.argitalpenKopurua());
        assertNull(biltegia.bilatuArgitalpena("A1"));
    }

    @Test
    void testArgitalpenakOrdenatuta() {
        biltegia.gehituArgitalpena("A1", arg1); // Argitalpena Bat
        biltegia.gehituArgitalpena("A2", arg2); // Beste Argitalpena

        ArrayList<String> lista = biltegia.argitalpenakOrdenatuta();

        assertEquals(2, lista.size());
        assertEquals("Argitalpena Bat", lista.get(0));
        assertEquals("Beste Argitalpena", lista.get(1));
    }

    @Test
    void testGetArgitalpenak() {
        biltegia.gehituArgitalpena("A1", arg1);
        biltegia.gehituArgitalpena("A2", arg2);

        int kopurua = 0;
        for (Argitalpena a : biltegia.getArgitalpenak()) {
            assertNotNull(a);
            kopurua++;
        }
        assertEquals(2, kopurua);
    }

    @Test
    void testErreseteatu() {
        biltegia.gehituArgitalpena("A1", arg1);
        biltegia.gehituArgitalpena("A2", arg2);

        biltegia.erreseteatu();
        assertEquals(0, biltegia.argitalpenKopurua());
    }
}