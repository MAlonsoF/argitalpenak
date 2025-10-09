package Testak;


import Argitalpenak.Argitalpena;
import Argitalpenak.Editorea;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.NoSuchElementException;

class ArgitalpenaTest {

    private Argitalpena argitalpena;
    private Editorea editorea1;
    private Editorea editorea2;
    private Argitalpena erlazionatua1;
    private Argitalpena erlazionatua2;

    @BeforeEach
    void setUp() {
        argitalpena = new Argitalpena("A1", "Probako Argitalpena");
        editorea1 = new Editorea("E1", "Editore Bat");
        editorea2 = new Editorea("E2", "Editore Bi");
        erlazionatua1 = new Argitalpena("A2", "Erlazionatutako Argitalpena 1");
        erlazionatua2 = new Argitalpena("" ,"" );
    }

    @Test
    void testGetIdA() {
        assertEquals("A1", argitalpena.getIdA());
    }

    @Test
    void testGetIzenburua() {
        assertEquals("Probako Argitalpena", argitalpena.getIzenburua());
    }

    @Test
    void testGehituEgilea() {
        argitalpena.gehituEgilea(editorea1);
        ArrayList<String> egileZerrenda = argitalpena.egileak();

        assertEquals(1, egileZerrenda.size());
        assertTrue(egileZerrenda.contains("E1"));
    }

    @Test
    void testEzDituEgileBikoiztuakGehitzen() {
        argitalpena.gehituEgilea(editorea1);
        argitalpena.gehituEgilea(editorea1); // bikoiztua
        ArrayList<String> egileZerrenda = argitalpena.egileak();

        assertEquals(1, egileZerrenda.size(), "Ez luke egile bikoiztua gehitu behar");
    }

    @Test
    void testKenduEgilea() {
        argitalpena.gehituEgilea(editorea1);
        argitalpena.kenduEgilea("E1");
        ArrayList<String> egileZerrenda = argitalpena.egileak();

        assertFalse(egileZerrenda.contains("E1"));
        assertEquals(0, egileZerrenda.size());
    }

    @Test
    void testGehituArgitalpena() {
        argitalpena.gehituArgitalpena(erlazionatua1);
        ArrayList<String> aipamenZerrenda = argitalpena.aipamenak();

        assertEquals(1, aipamenZerrenda.size());
        assertTrue(aipamenZerrenda.contains("A2"));

        argitalpena.gehituArgitalpena(erlazionatua2);
        assertThrows(NullPointerException.class, () -> {
            argitalpena.gehituArgitalpena(erlazionatua2);
        });
    }

    @Test
    void testEzDituArgitalpenBikoiztuakGehitzen() {
        argitalpena.gehituArgitalpena(erlazionatua1);
        argitalpena.gehituArgitalpena(erlazionatua1); // bikoiztua
        ArrayList<String> aipamenZerrenda = argitalpena.aipamenak();

        assertEquals(1, aipamenZerrenda.size(), "Ez luke argitalpen bikoiztua gehitu behar");
    }

    @Test
    void testAipamenZerrendaHutsik() {
        ArrayList<String> aipamenZerrenda = argitalpena.aipamenak();
        assertTrue(aipamenZerrenda.isEmpty());
    }

    @Test
    void testEgileZerrendaHutsik() {
        ArrayList<String> egileZerrenda = argitalpena.egileak();
        assertTrue(egileZerrenda.isEmpty());
    }

    void testEgileZerrenda() {
        ArrayList<String> egileZerrenda = argitalpena.egileak();
        argitalpena.gehituEgilea(editorea1);
        assertEquals(1, egileZerrenda.size());
    }
}
