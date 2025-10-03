import java.util.ArrayList;
import java.util.HashMap;

public class Editorea {
    private int id;
    private String izena;
    private HashMap<Integer, Argitalpena> argitalpenak;

    public Editorea(int pId, String pIzena){
        this.id = pId;
        this.izena = pIzena;
        this.argitalpenak = new HashMap<Integer, Argitalpena>();
    }

    public String getIzena() {
        return izena;
    }

    public int getId() {
        return id;
    }

    public void gehituArgitalpena(Argitalpena a) {
        if (!argitalpenak.containsKey(a)) {
            argitalpenak.put(a.getIdA(), a);
        }
    }
    public ArrayList<String> getArgitalpenak() {
        ArrayList<String> lista = new ArrayList<String>();
        for (Argitalpena a : argitalpenak.values()) {
            Integer id = a.getIdA();
            String idS = id.toString();
            lista.add(idS);
        }
        return lista;
    }




}
