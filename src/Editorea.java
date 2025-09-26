import java.util.ArrayList;

public class Editorea {
    private int id;
    private String izena;
    private ArrayList<Argitalpena> argitalpenak;

    public Editorea(int pId, String pIzena){
        this.id = pId;
        this.izena = pIzena;
        this.argitalpenak = new ArrayList<Argitalpena>();
    }
    public String getIzena() {
        return izena;
    }
    public int getId() {
        return id;
    }
    public void gehituArgitalpena(Argitalpena a) {
        if (!argitalpenak.contains(a)) {
            argitalpenak.add(a);
        }
    }
    public ArrayList<Argitalpena> getArgitalpenak() {
        return argitalpenak;
    }


}
