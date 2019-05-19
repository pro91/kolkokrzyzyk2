import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInterface {


    private UserInterface() {

    }

    public static int pobranieIndeksu(int maxIndeks) {
        Scanner scanner = new Scanner(System.in);
        int indeks = 0;
        boolean a = true;
        do {
            try {
                indeks = scanner.nextInt();
                if (indeks < 0 || indeks > maxIndeks) {
                    throw new InputMismatchException("nieprawdilowa wartosc");
                }
                a = false;
            } catch (InputMismatchException e) {
                System.out.println("nieprawidłowa wartość");
                scanner.nextLine();
            }


        } while (a);

        return indeks;
    }
    public static int pobranieRozmiaruPlanszy(){
        Scanner scanner = new Scanner(System.in);
        int rozmiar = 0;
        boolean a = true;
        do {
            try {
                rozmiar = scanner.nextInt();
                if(rozmiar < 3) {
                    System.out.println("za maly rozmiar planszy");
                    throw new InputMismatchException("za maly rozmiar planszy (minimum 3x3)");
                }
                a = false;
            } catch (InputMismatchException e) {
                System.out.println("Podaj cyfre (miniumum 3)");
                scanner.nextLine();
            }
        } while(a);
     return rozmiar;
    }

    public static void powitanie() {
        System.out.println("***GRA kółko i krzyżyk***\n\n Podaj rozmiar boku planszy");
    }

    public static void gracz1() {
        System.out.println("Gracz 1 - kołko - wybierz numer pola");
    }

    public static void gracz2() {
        System.out.println("Gracz 2 - krzyżyk - wybierz numer pola");

    }

    public static void wyswietlaniePlanszy(Plansza plansza) {
        for (int i = 0; i < plansza.getSize(); i++) {
            Pole pole = plansza.getState(i);
            switch (pole) {
                case PUSTE:
                    System.out.print(".");
                    break;
                case KOLKO:
                    System.out.print("O");
                    break;
                case KRZYZYK:
                    System.out.print("X");
                    break;
            }
            if ((i + 1) % plansza.getRozmiarBoku() == 0)
                System.out.println();
        }
    }
    public static void wyswietlanieWynikuKrzyzyk(){
        System.out.println("Wygrał gracz Krzyżyk");
    }
    public static void wyswietlanieWynikuKolko(){
        System.out.println("Wygrał gracz Kółko");
    }
    public static void wyswietlanieWynikuRemis(){
        System.out.println("Remis!");
    }



}
