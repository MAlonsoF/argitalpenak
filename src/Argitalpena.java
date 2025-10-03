import java.util.ArrayList;
import java.util.HashMap;

public class Argitalpena {
	private String idA;
	private String izenburua;
	//private ArrayList<Editorea> egileak; Deberia ser hashmap
	private HashMap<String, Editorea> egileak;
	//private ArrayList<Argitalpena> erlazionatuak;  Deberia de ser hashmap
	private HashMap<String, Argitalpena> erlazionatuak;

	public Argitalpena(String pIdA, String pIzenburua) {
		this.idA = pIdA;
		this.izenburua = pIzenburua;
		this.egileak = new HashMap<String, Editorea>();
		this.erlazionatuak = new HashMap<String, Argitalpena>();
	}
	 public String getIdA() { 
        return idA;
	 }

	 public String getIzenburua() { 
		return izenburua;
	 }

	 public void gehituEgilea(Editorea e) {
	        if (!this.egileak.containsKey(e.getId())) {
	            this.egileak.put(e.getId(), e);
	        }
	 }
	 public ArrayList<String> egileak() {
		 ArrayList<String> lista = new ArrayList<String>();
		 for (Editorea a : egileak.values()) {
			 String id = a.getId();
			 String idS = id.toString();
			 lista.add(idS);
		 }
		 return lista;
	 }

	 public void gehituArgitalpena(Argitalpena a) {
		    if (!this.erlazionatuak.containsKey(a.idA)) {
		        this.erlazionatuak.put(a.idA, a);
		    }
		} 

     public ArrayList<String> aipamenak() {
		 ArrayList<String> lista = new ArrayList<String>();
		 for (Argitalpena a : erlazionatuak.values()) {
			 String id = a.idA;
			 String idS = id.toString();
			 lista.add(idS);
		 }
		 return lista;
	}


}
