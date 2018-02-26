package ru.rt;


import java.io.IOException;

public class Main {

    public static void main (String[] args) {
        Utils t = new Utils();
        t.test();
        do {
            try {
                t.readFromFile("xlsx/IPs.xlsx");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } while (!t.toExit());
    }


}
