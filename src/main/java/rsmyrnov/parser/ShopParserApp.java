package rsmyrnov.parser;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ShopParserApp {

    public void PrintToFile(String fname, List<Product> list) throws IOException {
        System.out.println("Start print: "+fname);
        //Print
        FileWriter fileWriterEl = new FileWriter(fname, false);
        fileWriterEl.append("NAME");
        fileWriterEl.append(";");
        fileWriterEl.append("OLD PRICE");
        fileWriterEl.append(";");
        fileWriterEl.append("NEW PRICE");
        fileWriterEl.append(";");
        fileWriterEl.append("DISCOUNT");
        fileWriterEl.append(";");
        fileWriterEl.append("PRICE WITH SHIPPING");
        fileWriterEl.append(";");
        fileWriterEl.append("SALES NUMBER");
        fileWriterEl.append("\n");


        for (Product pr : list) {
            fileWriterEl.append(pr.getName());
            fileWriterEl.append(";");
            fileWriterEl.append(pr.getOldPrice());
            fileWriterEl.append(";");
            fileWriterEl.append(pr.getNewPrice());
            fileWriterEl.append(";");
            fileWriterEl.append(pr.getDiscount());
            fileWriterEl.append(";");
            fileWriterEl.append(pr.getPriceWithShipping());
            fileWriterEl.append(";");
            fileWriterEl.append(pr.getPeoplesCount());
            fileWriterEl.append("\n");

        }
        fileWriterEl.flush();
        fileWriterEl.close();
        System.out.println("End print to file: "+fname);
    }


    public static void main(String[] args) throws IOException {

        String URL_ELECTRONICA = "https://allegro.pl/kategoria/elektronika?string=bargain_zone&p=";
        String URL_MODA = "https://allegro.pl/kategoria/moda?string=bargain_zone&p=";
        String URL_DOMIOGOROD = "https://allegro.pl/kategoria/dom-i-ogrod?string=bargain_zone&p=";
        String URL_SUPERMARKET = "https://allegro.pl/kategoria/supermarket?string=bargain_zone&p=";
        String URL_DZIECKO = "https://allegro.pl/kategoria/dziecko?string=bargain_zone&p=";
        String URL_URODA = "https://allegro.pl/kategoria/uroda?string=bargain_zone&p=";
        String URL_ZDROWIE = "https://allegro.pl/kategoria/zdrowie?string=bargain_zone&p=";
        String URL_KULTURA = "https://allegro.pl/kategoria/kultura-i-rozrywka?string=bargain_zone&p=";
        String URL_SPORT = "https://allegro.pl/kategoria/sport-i-turystyka?string=bargain_zone&p=";
        String URL_MOTORYZACJA = "https://allegro.pl/kategoria/motoryzacja?string=bargain_zone&p=";
        //--------------------------------------------------------------------------------------------


        List<Product> productListEl = new ArrayList();
        List<Product> productListSup = new ArrayList();
        List<Product> productListDom = new ArrayList();

        Parser parser = new Parser();
        ShopParserApp app = new ShopParserApp();

        try {
            parser.Read(productListEl, URL_ELECTRONICA);

            System.out.println("Sleeping 10000 ms...");
            Thread.sleep(10000);
            parser.Read(productListDom,URL_DOMIOGOROD);

            System.out.println("Sleeping 10000 ms...");
            Thread.sleep(10000);
            parser.Read(productListSup,URL_SUPERMARKET);

        } catch (IOException ex) {
            System.out.println("Exception: " + ex);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        app.PrintToFile("out_electronica.csv", productListEl);
        app.PrintToFile("out_dom_ogorod.csv",productListDom);
        app.PrintToFile("out_supermarket.csv",productListSup);


    }
}

