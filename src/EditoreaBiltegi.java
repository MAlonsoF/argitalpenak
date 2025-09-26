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
}
