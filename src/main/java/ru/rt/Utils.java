package ru.rt;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.Scanner;

public class Utils  {
    private final static String GOOD_PING = "10 received";

    public void test() {
        String url = "http://www.google.com/";
    try {
        URL obj = new URL(url);
        HttpURLConnection connection = (HttpURLConnection) obj.openConnection();

        connection.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        System.out.println(response.toString());
    } catch (IOException e){
        System.out.println(e);
    }
    }

    public void ping (String ip){
        String url = "http://apis3.dtd/sendconfig.php?ip="+ip+"&action=Send+Ping&uplink=9";
        try {
            URL obj = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) obj.openConnection();

            connection.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            System.out.print("Ping: "+ip +" It's seems ");
            if (response.toString().toLowerCase().contains(GOOD_PING))
            {
                System.out.println("Good");
            } else {
                System.out.println("Bad");
            }
            System.out.println(response.toString());
        } catch (IOException e){
            System.out.println(e);
        }
    }

    public boolean toExit(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Нажмите Enter для выхода...");
        String in = sc.nextLine();
        if (in.isEmpty()){
            return true;
        } else {
            return false;
        }
    }

    public String readIP (){
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите ip контроллера: ");
        String in = sc.nextLine();
        if (in.isEmpty()){
            return null;
        } else {
            return in;
        }
    }

    public void readFromFile (String file) throws IOException{
        XSSFWorkbook ipsBook = new XSSFWorkbook(new FileInputStream(file));
        XSSFSheet ipsExcelSheet = ipsBook.getSheetAt(0);

        Iterator<Row> it = ipsExcelSheet.iterator();
        while (it.hasNext()){
            Row row = it.next();
            String ip = row.getCell(2).toString();
            System.out.println("Ping ip: "+ ip);
            ping(ip);
        }

    }

}