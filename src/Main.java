import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Bog b1 = new Bog(1, "ABC", "Halfdan Rasmussen");
        Bog b2 = new Bog(2, "Ved Vejen", "Herman Bang");
        Bog b3 = new Bog(3, "Sweatlana", "Martin Ebon");

        /*Laener l3 = new Laener(1,"Søren","Hansen");
        b1.udlaenBog(1,"07-11-2023");
        l3.laenBog(1);
        l3.laenBog(2);
        b2.udlaenBog(1,"06-11-2023");
        System.out.println(b1);
        System.out.println(l3);
        b2.afleverBog();
        l3.afleverBog(2);
        System.out.println(b1);
        System.out.println(l3);*/

            Bibliotek bib=new Bibliotek();
            bib.tilfoejBog(b1);
            bib.tilfoejBog(b2);
            bib.tilfoejBog(b3);
            bib.tilfoejBog(4, "Trine", "Herman Bang");
            Bog b4=new Bog(5,"Bare det kører rundt","Finn Søborg");
            bib.tilfoejBog(b4);

            Laener l1=new Laener(1,"Peter","Hansen");
            Laener l2=new Laener(2,"Pernille","Hansen");
            bib.tilfoejLaener(l1);
            bib.tilfoejLaener(l2);
            bib.tilfoejLaener(3,"Christian","Hansen");

            bib.udlaenBog(1,1,"051123");
            bib.udlaenBog(2,1,"051123");
            bib.udlaenBog(3,2,"051123");

            /*
            System.out.println(l1);
            System.out.println(l2);
            System.out.println(b1);
            System.out.println(b2);
            System.out.println(b3);*/

            System.out.println("Alle udlånte bøger:");
            udskrivUdlanteBoeger(bib);
            System.out.println("Alle Bøger:");
            udskrivAlleBoeger(bib);
            udskrivAlleBogerAfForfatter(bib,"Herman Bang");
            System.out.println("Alle lånere:");
            udskrivAlleLaenere(bib);

            System.out.println();
            Bog b=bib.getBog(1);
            System.out.println(b);

            Laener l=bib.getLaener(1);
            System.out.println(l);

            bib.afleverBog(1);

            b=bib.getBog(1);
            System.out.println(b);
            l=bib.getLaener(1);
            System.out.println(l);

            bib.udlaenBog(1,3,"051123");
            System.out.println(bib.getBog(1));

        }

        public static void udskrivUdlanteBoeger(Bibliotek bib){
            ArrayList<Bog> liste=bib.udlanteBoeger();
            for (Bog b:liste) {
                System.out.println(b);
                if(b.isUdlant()){
                    Laener l=bib.getLaener(b.getLaener());
                    System.out.println(("Bogen udlånt til "+l));
                }
            }
        }
        public static void udskrivAlleBoeger(Bibliotek bib){
            ArrayList<Bog> liste=bib.getBogListe();
            for (Bog b:liste) {
                Laener l=bib.getLaener(b.getLaener());
                System.out.println((b+" Bogen udlånt til "+l));
            }
        }

        public static void udskrivAlleBogerAfForfatter(Bibliotek bib, String f){
            ArrayList<Bog> liste=bib.getBogListe();
            System.out.println("Alle bøger af: "+f);
            for (Bog b:liste) {
                if(b.getForfatter()==f){
                    System.out.println((b));
                }
            }
        }

        public static void udskrivAlleLaenere(Bibliotek bib){
            ArrayList<Laener> liste=bib.getLaenerListe();
            for (Laener l:liste){
                System.out.println(l);
            }
        }
    }
