package at.kaindorf.ahi18.fontend;

import java.util.Scanner;

public class UI {
    public void menu() {
        Scanner in = new Scanner(System.in);

        System.out.println("0... Beenden");
        System.out.println("1... Daten von Verzeichnis Resourcen laden");
        System.out.println("2... allData.xml laden");
        System.out.println("3... Duplikate entfernen (WHILE)");
        System.out.println("4... Duplkate entfernen (stream)");
        System.out.println("5... Maximaler Temperaturwert\n");

        int value;
        do {
            System.out.print("Wahl [0,5] = ");
            value = in.nextInt();
        } while(value < 0 || value > 5);


    }
}
