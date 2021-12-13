package Cartes;

import Arbres.*;

import java.util.Random;

public class Main {
    public static void main(String[] args) throws ArbreException {
	    Baralla baralla = new Baralla();
        AcbEnll arbre = new AcbEnll();
        Random rnd = new Random();
        Carta carta;

        while (baralla.getIntQuantesCartes() > 0)
            arbre.inserir(baralla.treureCarta());

        arbre.iniRecorregut(false);
        while (!arbre.finalRecorregut())
            System.out.println(arbre.segRecorregut());

        AcbEnll arbreSec = (AcbEnll) arbre.clone();

        System.out.println("*****************************************");

        arbreSec.iniRecorregut(true);
        while (!arbreSec.finalRecorregut())
            System.out.println(arbreSec.segRecorregut());

        int pal,num;
        for (int i = 0; i < 2; i++) {
            num = rnd.nextInt(12) + 1;
            pal = rnd.nextInt(4) + 1;

            carta = new Carta(num, pal);

            arbreSec.esborrar(carta);
        }

        arbreSec.iniRecorregut(true);
        while (!arbreSec.finalRecorregut())
            System.out.println(arbreSec.segRecorregut());
    }
}
