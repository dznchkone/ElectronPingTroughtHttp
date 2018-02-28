package ru.rt;


import java.io.IOException;

public class Main {

    public static void main (String[] args) {
        Utils t = new Utils();
       // t.test();
        do {
            try {
                System.out.print("С каким файлом работаем[Enter - файл по дефолту]: ");
                String file = t.smplInput();
                if (file.equals("null")){
                    t.readFromFile("xlsx/IPs.xlsx");
                } else {
                    t.readFromFile("xlsx/"+ file);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        } while (!t.toExit());
    }


}
