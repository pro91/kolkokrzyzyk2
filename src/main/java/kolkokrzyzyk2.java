import java.sql.SQLOutput;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class kolkokrzyzyk2 {

    public static void main(String[] args) {

        UserInterface.powitanie();
        Plansza plansza = new Plansza(UserInterface.pobranieRozmiaruPlanszy());
        GameEngine.run(plansza);
        UserInterface.wyswietlaniePlanszy(plansza);

    }

}
