public class Plansza {

    private Pole[] pola;

    private int rozmiarBoku;

    public Plansza() {
        this(3);
    }

    public Plansza(int rozmiarBoku){
        this.rozmiarBoku = rozmiarBoku;
        pola = new Pole[rozmiarBoku * rozmiarBoku];
        for(int i=0; i< pola.length; i++){
            pola[i] = Pole.PUSTE;
        }
    }

    public void setField(int index, Pole action){
        pola[index-1] = action;
    }

    public int getRozmiarBoku(){
        return this.rozmiarBoku;
    }

    public Pole getState(int index){
        return pola[index];
    }
    public int getSize(){
        return rozmiarBoku*rozmiarBoku;
    }

}