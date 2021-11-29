package Arbres;

public class AcbEnll {
    // tots els mètodes especificats per la interfície Acb
// Mètodes necessaris per fer l’arbre recorrible
    public void iniRecorregut (boolean sentit){
        /* prepara l’arbre per a ser recorregut en inordre. Després d’invocar
    aquest mètode, la invocació del mètode segRecorregut retornarà el
    primer element en inordre de l’arbre. Aquest mètode ha de emplenar la
    cua amb els elements de l’arbre aplicant un recorregut en inordre. Cal
    tenir present el paràmetre alhora d’emplenar la cua */}

    public boolean finalRecorregut (){
        /* retorna true si ja s’ha arribat al final del recorregut en inordre
    de l’arbre. Això és si:
    ‐ l’arbre és buit
    ‐ la darrera vegada que es va invocar segRecorregut aquest mètode
    ja va retornar el darrer element en inordre de l’arbre.
    Tot això és el mateix que dir que retorna true quan no té sentit
    invocar el mètode segRecorregut */}

    public E segRecorregut () throws ArbreException{
        /*retorna el següent element en inordre, si n’hi ha.
Llença una excepció si:
‐ abans d’invocar‐lo no s’ha invocat el mètode iniRecorregut
‐ la darrera vegada que es va invocar ja va retornar
el darrer element del recorregut (finalRecorregut retornaria true)
‐ s’invoca quan entre la invocació de iniRecorregut i la del
mètode s’ha produït una modificació de l’arbre, això és, s’ha
fet ús del mètode inserir, esborrar, buidar*/
    }



}

