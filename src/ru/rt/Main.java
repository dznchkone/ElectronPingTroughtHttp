package ru.rt;


import java.io.IOException;

public class Main {

    public static void main (String[] args) {
        int fr =1;
        Utils t = new Utils();
        do {
            fr =0;
            t.test();
            t.ping("10.107.3.19");
        } while (!t.toExit() && fr!=0);
    }
}
