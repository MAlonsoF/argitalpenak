import java.util.ArrayList;

public class Argitalpena {
	private int idA;
	private String izenburua;
	private ArrayList<Editorea> egileak;
	private ArrayList<Argitalpena> erlazionatuak;
	
	public Argitalpena(int pIdA, String pIzenburua) {
		this.idA = pIdA;
		this.izenburua = pIzenburua;
		this.egileak = new ArrayList<Editorea>();
		this.erlazionatuak = new ArrayList<Argitalpena>();
	}
	 public int getIdA() { 
        return idA;
	 }

	 public String getIzenburua() { 
        return izenburua;
	 }

	 public void gehituEgilea(Editorea e) {
	        if (!this.egileak.contains(e)) {
	            this.egileak.add(e);
	        }
	 }
	 public ArrayList<Editorea> getEgileak() {
        return egileak;
	 }

	 public void gehituArgitalpena(Argitalpena a) {
		    if (!this.erlazionatuak.contains(a)) {
		        this.erlazionatuak.add(a);
		    }
		} 

     public ArrayList<Argitalpena> getErlazionatuak() {
        return erlazionatuak;
	}
}
