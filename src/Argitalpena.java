public class Argitalpena {
	private int idA;
	private String izenburua;
	private ArrayList<Editorea> egileak;
	
	public Argitalpena(int pIdA, String pIzenburua) {
		this.idA = pIdA;
		this.izenburua = pIzenburua;
		this.egileak = new ArrayList<Editorea>();
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
}
