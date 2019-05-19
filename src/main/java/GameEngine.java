import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class GameEngine {

    public static void run(Plansza plansza) {

        for (int i = 0; i < plansza.getRozmiarBoku() * plansza.getRozmiarBoku(); i++) {

            UserInterface.wyswietlaniePlanszy(plansza);
            if (i % 2 == 0) {
                UserInterface.gracz1();
                plansza.setField(UserInterface.pobranieIndeksu(plansza.getSize()), Pole.KOLKO);
            } else
                UserInterface.gracz2();
                plansza.setField(UserInterface.pobranieIndeksu(plansza.getSize()), Pole.KRZYZYK);
            }
            Optional<Pole> wynik = GameEngine.sprawdzanieWyniku(plansza);
            if (wynik.isPresent()) {

                if (wynik.get() == Pole.KRZYZYK) {
                    UserInterface.wyswietlanieWynikuKrzyzyk();
                    return;
                } else
                    UserInterface.wyswietlanieWynikuKolko();
                    return;
            }
            if(i == plansza.getSize() - 1)
                UserInterface.wyswietlanieWynikuRemis();
        }
    }

    public static Optional<Pole> sprawdzanieWyniku(Plansza plansza) {
        for (int i = 0; i < plansza.getSize(); i = i + plansza.getRozmiarBoku()) {  // w3
            Set<Pole> poleSet = new HashSet<>();
            for (int j = i; j < i + plansza.getRozmiarBoku(); j++) {
                poleSet.add(plansza.getState(j));
            }
            if ((poleSet.size() == 1) && poleSet.contains(Pole.KOLKO)) {
                return Optional.of(Pole.KOLKO);
            }
            if ((poleSet.size() == 1) && poleSet.contains(Pole.KRZYZYK)) {
                return Optional.of(Pole.KRZYZYK);
            }
        }
        return Optional.empty();
    }
}
