import java.util.HashMap;


public class ArgitalpenaBiltegi {
	private static ArgitalpenaBiltegi nireArgitalpenaBiltegi = null;
	private HashMap <String, Argitalpena> map; 
	
	private ArgitalpenaBiltegi() {
		this.map = new HashMap <String,Argitalpena>();
	}
	public static ArgitalpenaBiltegi getNireArgitalpenaBiltegi() {
		if (nireArgitalpenaBiltegi == null) nireArgitalpenaBiltegi = new ArgitalpenaBiltegi();
	    return nireArgitalpenaBiltegi;
	}
	public int argitalpenKopurua() {
		return this.map.size();
	}
	
	public void erreseteatu() {
		this.map.clear();
	}
	public void gehituArgitalpena(String izen, Argitalpena a) {
	    if (!map.containsKey(izen)) {
	        map.put(izen, a);
	    }
	}

	public Argitalpena bilatuArgitalpena(String izen) {
	    return map.get(izen);
	}
	
}
