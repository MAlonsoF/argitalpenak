package Argitalpenak;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.NoSuchElementException;


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

	public void gehituArgitalpena(String izen, Argitalpena a) throws IzenaEzberdinaException {
	    if (!map.containsKey(izen)) {
            if (!(izen.equals(a.getIdA()))){
                throw new IzenaEzberdinaException("Sartutako id-a ez da Argitalpenarena");
            }
	        else map.put(izen, a);
	    }
	}

	public Argitalpena bilatuArgitalpena(String izen) {
        return map.get(izen);
	}

	public void ezabatuArgitalpena(String id) {
        if(!map.containsKey(id)) {
            throw new NoSuchElementException("Ez dago id hori daukan argitalpenik");
        }
        else map.remove(id);
    }

	public ArrayList<String> argitalpenakOrdenatuta() {
	    ArrayList<String> lista = new ArrayList<>();
	    for (Argitalpena a : map.values()) {
	        lista.add(a.getIzenburua());
	    }

	    // Algoritmo de ordenación propio (ej: burbuja)
	    for (int i = 0; i < lista.size()-1; i++) {
	        for (int j = 0; j < lista.size()-i-1; j++) {
	            if (lista.get(j).compareToIgnoreCase(lista.get(j+1)) > 0) {
	                // intercambiar
	                String tmp = lista.get(j);
	                lista.set(j, lista.get(j+1));
	                lista.set(j+1, tmp);
	            }
	        }
	    }

	    return lista;
	}
	public Iterable<Argitalpena> getArgitalpenak() {
        return map.values();
	}
}
