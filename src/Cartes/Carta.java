package Cartes;

public class Carta {
    private int intNumeracio;
    private int intPal;

    public Carta(int num, int pal) throws IllegalArgumentException {
        try{
            if (num < 1 || num > 12)
                throw new IllegalArgumentException("El numero de la carta no es correcte.");

            if (pal < 1 || pal > 4)
                throw new IllegalArgumentException("El pal de la carta no es correcte.");

            this.intNumeracio = num;

            this.intPal = pal;
        }catch (IllegalArgumentException e){
            throw e;
        }
    }

    public int getIntNumeracio() {
        return intNumeracio;
    }

    public int getIntPal() {
        return intPal;
    }

    public boolean sequancia(Carta other)
    {
        if (this.intNumeracio == 1 && other.intNumeracio == 12
                || this.intNumeracio == 12 && other.intNumeracio == 1)
            return true;

        return this.intNumeracio + 1 == other.intNumeracio || this.intNumeracio - 1 == other.intNumeracio;
    }

    public boolean equals(Carta other){
        return this.intNumeracio == other.intNumeracio && this.intPal == other.intPal;
    }
    private String toStringPal (){
        switch (this.intPal){
            case 1:
                return "COPES";
            case 2:
                return "ESPASES";
            case 3:
                return "OROS";
            case 4:
                return "BASTONS";
        }
        return null;
    }

    @Override
    public String toString() {
        String strCarta = "";
        if (this.intNumeracio == 1)
            strCarta += "AS";
        else{
            strCarta += this.intNumeracio;
        }
        strCarta += " de " + this.toStringPal();

        return strCarta;
    }
}
