import java.util.ArrayList;
import java.util.HashMap;

public class Argitalpena {
	private int idA;
	private String izenburua;
	//private ArrayList<Editorea> egileak; Deberia ser hashmap
	private HashMap<Integer, Editorea> egileak;
	//private ArrayList<Argitalpena> erlazionatuak;  Deberia de ser hashmap
	private HashMap<Integer, Argitalpena> erlazionatuak;

	public Argitalpena(int pIdA, String pIzenburua) {
		this.idA = pIdA;
		this.izenburua = pIzenburua;
		this.egileak = new HashMap<Integer, Editorea>();
		this.erlazionatuak = new HashMap<Integer, Argitalpena>();
	}
	 public int getIdA() { 
        return idA;
	 }

	 public String getIzenburua() { 
		return izenburua;
	 }

	 public void gehituEgilea(Editorea e) {
	        if (!this.egileak.containsKey(e)) {
	            this.egileak.put(e.getId(), e);
	        }
	 }
	 public ArrayList<String> egileak() {
		 ArrayList<String> lista = new ArrayList<String>();
		 for (Editorea a : egileak.values()) {
			 Integer id = a.getId();
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
			 Integer id = a.idA;
			 String idS = id.toString();
			 lista.add(idS);
		 }
		 return lista;
	}


}
