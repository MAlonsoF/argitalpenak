import java.util.ArrayList;
import java.util.HashMap;

public class EditoreaBiltegi {
    private static EditoreaBiltegi nireEditoreaBiltegi = null;
    private HashMap <String, Editorea> map;

    private EditoreaBiltegi() {
        this.map = new HashMap <String,Editorea>();
    }
    public static EditoreaBiltegi getNireEditoreaBiltegi() {
        if (nireEditoreaBiltegi == null) nireEditoreaBiltegi = new EditoreaBiltegi();
        return nireEditoreaBiltegi;
    }
    public int editoreKopurua() {
        return this.map.size();
    }

    public void erreseteatu() {
        this.map.clear();
    }
    public void gehituEditorea(String izena, Editorea e) {
        if (!map.containsKey(izena)) {
            map.put(izena, e);
        }
    }
    public Editorea bilatuEditorea(String izena) {
        return this.map.get(izena);
    }
    public Iterable<Editorea> getEditoreak() {
        return this.map.values();
    }

    public ArrayList<String> egileakOrdenatuta(){
        ArrayList<String> lista = new ArrayList<String>();
        for (Editorea e : map.values()){
        	lista.add(e.getIzena());   
        }
        lista.sort(String::compareToIgnoreCase);
        return lista;

    }
    public void ezabatuEditorea(String id) {
        Editorea e = map.remove(id);
        if (e != null) {
            // Eliminar al editor de todas sus publicaciones
            for (Argitalpena a : e.getArgitalpenakObjektuak()) {
                a.kenduEgilea(id);
            }
        }
    }

}
