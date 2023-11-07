import java.util.ArrayList;

public class Bibliotek {
    private ArrayList<Bog> bogListe = new ArrayList<>();
    private ArrayList<Laener> laenerListe = new ArrayList<>();

    public Bibliotek() {
    }

    public Bibliotek(ArrayList<Bog> bogListe, ArrayList<Laener> laenerListe) {
        this.bogListe = bogListe;
        this.laenerListe = laenerListe;
    }

    public ArrayList<Bog> getBogListe() {
        return bogListe;
    }

    public void setBogListe(ArrayList<Bog> bogListe) {
        this.bogListe = bogListe;
    }

    public ArrayList<Laener> getLaenerListe() {
        return laenerListe;
    }

    public void setLaenerListe(ArrayList<Laener> laenerListe) {
        this.laenerListe = laenerListe;
    }

    public void tilfoejBog(Bog b) {
        bogListe.add(b);
    }

    public void tilfoejBog(int bogId, String t, String f) {
        Bog b = new Bog(bogId, t, f);
        bogListe.add(b);
    }


    public void tilfoejLaener(Laener l) {
        laenerListe.add(l);
    }

    public void tilfoejLaener(int lId, String fnavn, String enavn) {
        Laener l = new Laener(lId, fnavn, enavn);
        laenerListe.add(l);
    }

    public void udlaenBog(int bogId, int lId, String dato) {
        for (int i = 0; i < bogListe.size(); i++) {
            if (bogListe.get(i).getBogId() == bogId) {
                bogListe.get(i).udlaenBog(lId, dato);
                for (int j = 0; j < laenerListe.size(); j++) {
                    if (laenerListe.get(j).getlNr() == lId)
                        laenerListe.get(j).laenBog(bogId);
                }
            }
        }
    }

    public boolean erBogUdlant(int bogId) {
        for (int i = 0; i < bogListe.size(); i++) {
            if (bogListe.get(i).getBogId() == bogId) {
            if (bogListe.get(i).isUdlant())
                return true;
            } else return false;
        }
        return false;
    }

    public void afleverBog(int bogId) {
        for (int i = 0; i < bogListe.size(); i++) {
            if (bogListe.get(i).getBogId() == bogId) {
                int n = bogListe.get(i).getLaener();
                bogListe.get(i).afleverBog();
                for (int j = 0; j < laenerListe.size(); j++) {
                    if (laenerListe.get(j).getlNr() == n)
                        laenerListe.get(j).afleverBog(bogId);
                }
            }
        }
    }

    public ArrayList<Bog> udlanteBoeger() {
        ArrayList<Bog> udlantliste = new ArrayList<>();
        for (int i = 0; i < bogListe.size(); i++) {
            if (bogListe.get(i).isUdlant()){
                udlantliste.add(bogListe.get(i));
            }
        }
        return udlantliste;
    }

    public Bog getBog(int bogId) {
        for (int i = 0; i < bogListe.size(); i++) {
            if (bogListe.get(i).getBogId() == bogId) {
                return bogListe.get(i);
            }
        }
        return null;
    }

    public Laener getLaener(int lId) {
        for (int i = 0; i < laenerListe.size(); i++) {
            if (laenerListe.get(i).getlNr() == lId) {
                return laenerListe.get(i);
            }
        }
        return null;
    }

    public Laener bogUdlantTil(int bogId) {
        for (int i = 0; i < bogListe.size(); i++) {
            if (bogListe.get(i).getBogId() == bogId) {
                int n = bogListe.get(i).getLaener();
                for (int j = 0; j < laenerListe.size(); j++) {
                    if (laenerListe.get(i).getlNr() == n) {
                        return laenerListe.get(i);
                    }
                }
            }
        }
        return null;
    }


    @Override
    public String toString() {
        return "Bibliotek{" +
                "bogListe=" + bogListe +
                ", laenerListe=" + laenerListe +
                '}';
    }
}


