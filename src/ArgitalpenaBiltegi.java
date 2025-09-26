public class ArgitalpenaBiltegi {

    private static ArgitalpenaBiltegi nireArgitalpenaBiltegi = null;
    private HashMap <Integer, Argitalpena> map;

    private ArgitalpenaBiltegi() {
        this.map = new HashMap <Integer,Argitalpena>();
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

}
