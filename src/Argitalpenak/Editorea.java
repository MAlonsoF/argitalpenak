package Argitalpenak;
import java.util.ArrayList;
import java.util.HashMap;

public class Editorea {
    private String id;
    private String izena;
    private HashMap<String, Argitalpena> argitalpenak;

    public Editorea(String pId, String pIzena){
        this.id = pId;
        this.izena = pIzena;
        this.argitalpenak = new HashMap<String, Argitalpena>();
    }

    public String getIzena() {
        return izena;
    }

    public String getId() {
        return id;
    }

    public void gehituArgitalpena(Argitalpena a) {
        if (!argitalpenak.containsKey(a.getIdA())) {
            argitalpenak.put(a.getIdA(), a);
        }
    }
    public ArrayList<String> getArgitalpenak() {
        ArrayList<String> lista = new ArrayList<String>();
        for (Argitalpena a : argitalpenak.values()) {
            String id = a.getIdA();
            String idS = id.toString();
            lista.add(idS);
        }
        return lista;
    }
    public Iterable<Argitalpena> getArgitalpenakObjektuak() {
        return argitalpenak.values();
    }
}
