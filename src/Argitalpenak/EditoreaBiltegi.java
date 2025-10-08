package Argitalpenak;
import java.util.ArrayList;
import java.util.HashMap;

public class EditoreaBiltegi {
    private static EditoreaBiltegi nireEditoreaBiltegi = null;
    private HashMap<String, Editorea> map;

    private EditoreaBiltegi() {
        this.map = new HashMap<>();
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

    // Añadir por ID (preferible)
    public void gehituEditorea(Editorea e) {
        if (e != null) {
            map.put(e.getId(), e);
        }
    }

    // Sobrecarga por compatibilidad
    public void gehituEditorea(String id, Editorea e) {
        if (id != null && e != null) {
            map.put(id, e);
        }
    }

    // Buscar por ID
    public Editorea bilatuEditorea(String id) {
        return this.map.get(id);
    }

    public Iterable<Editorea> getEditoreak() {
        return this.map.values();
    }

    // devuelve los ids (útil para depurar)
    public ArrayList<String> getEditoreIds() {
        return new ArrayList<>(map.keySet());
    }

    // Ordenación propia (burbuja)
    public ArrayList<String> egileakOrdenatuta(){
        ArrayList<String> lista = new ArrayList<>();
        for (Editorea e : map.values()){
            lista.add(e.getIzena());
        }
        for (int i = 0; i < lista.size()-1; i++){
            for (int j = 0; j < lista.size()-i-1; j++){
                if (lista.get(j).compareToIgnoreCase(lista.get(j+1)) > 0){
                    String tmp = lista.get(j);
                    lista.set(j, lista.get(j+1));
                    lista.set(j+1, tmp);
                }
            }
        }
        return lista;
    }

    // Eliminar editor por id y limpiar sus referencias en publicaciones
    public void ezabatuEditorea(String id) {
        Editorea e = map.remove(id);
        if (e != null) {
            for (Argitalpena a : e.getArgitalpenakObjektuak()) {
                a.kenduEgilea(id);   // Argitalpena.kenduEgilea debe eliminar la clave id
            }
        }
    }
}
