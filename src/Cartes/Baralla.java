package Cartes;
import java.util.Random;
public class Baralla {
    private class Node {
        private Node next;
        private Carta inf;

        public Node (Carta c){
            this.inf = c;
            this.next = null;
        }
    }

    private Node primer;
    private int intQuantesCartes;

    public Baralla(){
        // Genera una baralla auxiliar y la barrella amb la nostra variable dinamica node
        this.barrella(this.generaBaralla());
    }

    private Carta [] generaBaralla (){
        Carta [] auxMtxCartes = new Carta[48];
        for (int i = 1; i <= 4; i++){
            for (int j = 1; j <= 12; j++)
                auxMtxCartes[(j + (i - 1) * 12) - 1] = new Carta(j,i);
            /* Petita formula per calcular el num del vector
             * IDX = (columna + (fila - 1) * max columnes) - 1
             * I així de pas crees correctament la carta amb
             * el numeric i el pal*/
        }

        return auxMtxCartes;
    }

    private void barrella(Carta [] auxMtxCartes)
    {
        Random rnd = new Random();
        int intRndNum = rnd.nextInt(48);

        // Creem un nou node per l'atribut primer amb la primera carta aleatòria
        this.primer = new Node(auxMtxCartes[intRndNum]);
        // Creem un node auxiliar per treballar amb ell
        Node aux = this.primer;
        auxMtxCartes[intRndNum] = null;
        this.intQuantesCartes = 1;

        while (this.intQuantesCartes < 48){
            intRndNum = rnd.nextInt(48);
            //System.out.println("Processing...");

            if (auxMtxCartes[intRndNum] != null)
            {
                aux.next = new Node(auxMtxCartes[intRndNum]);
                aux = aux.next;
                auxMtxCartes[intRndNum] = null;
                this.intQuantesCartes++;
            }
        }
    }

    public int getIntQuantesCartes() {
        return intQuantesCartes;
    }

    public Carta treureCarta(){
        if (this.primer == null || this.primer.inf == null)
            return null;

        // Treiem la carta
        Carta carta = this.primer.inf;
        this.primer = this.primer.next;
        this.intQuantesCartes--;
        return carta;
    }

    public Carta[] treureCartes(int intQuantes){
        Carta [] cartes = new Carta[intQuantes];

        for (int i = intQuantes - 1; i >= 0; i--)
            cartes[i] = this.treureCarta();

        return cartes;
    }

    //Implementació recursiva per treure cartes (no s'utilitza)
    private Carta[] asignarCartes(Carta [] cartes, int idx){
        if (idx >= cartes.length)
            return cartes;

        cartes[idx] = this.primer.inf;
        this.primer = this.primer.next;
        this.intQuantesCartes--;
        return this.asignarCartes(cartes, idx + 1);
    }

    public void visualitza(){
        Node aux = this.primer;
        while (aux.next != null) {
            System.out.print(aux.inf.getIntNumeracio() + " de ");

            switch (aux.inf.getIntPal()){
                case 1:
                    System.out.println("COPES");
                    break;
                case 2:
                    System.out.println("ESPASES");
                    break;
                case 3:
                    System.out.println("OROS");
                    break;
                case 4:
                    System.out.println("BASTONS");
                    break;
            }

            aux = aux.next;
        }
    }
}
