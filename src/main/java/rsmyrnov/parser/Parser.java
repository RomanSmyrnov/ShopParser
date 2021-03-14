package rsmyrnov.parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.List;



public class Parser {


    public void Read(List list, String category) throws IOException {
        System.out.println("Reading: "+ category);
        int counter = 0;
        boolean full = false;

        // String url = URL_SUPERMARKET;
        for (int i = 0; i < 10; i++) {
            String tempUrl = category + i;

            Document doc = Jsoup.connect(tempUrl).timeout(60000).userAgent("Chrome/51.0.2704.84 Safari/537.36").get();
            Elements sectionsStorage = doc.getElementsByTag("section");

            Element targetSection;

            if (category.contains("moda?")) {
                sectionsStorage.get(0);///0
                 targetSection = sectionsStorage.get(0);
            } else {
                sectionsStorage.get(1);
                targetSection = sectionsStorage.get(1);
            }

            // Page articles storage:
            Elements articles = targetSection.getElementsByTag("article");

            for (int j = 0; j < articles.size() - 1; j++) {

                Product product = new Product();

                //Get  article and read:
                Element articleCurrent = articles.get(j);//--------------INCREMENT


                //Read name
                Elements name = articleCurrent.getElementsByAttribute("title");
                product.setName(name.text());

                //Read actual price
                Elements price = articleCurrent.getElementsByClass("_1svub _lf05o");
                product.setNewPrice(price.text());


                //Read discount
                Elements discount = articleCurrent.getElementsByClass("_9c44d_1uHr2");
                if (discount.text().contains("wyprzedaż")) {
                    product.setDiscount("Sale");
                    if (discount.text().contains("hit")) {
                        continue;
                    }

                } else {
                    product.setDiscount(discount.text());
                }

                //Read old price
                Elements oldPrice = articleCurrent.getElementsByClass("mpof_uk mqu1_ae _9c44d_18kEF m9qz_yp _9c44d_2BSa0  _9c44d_KrRuv");
                if (oldPrice.text().length() == 0) {
                    continue;
                }
                product.setOldPrice(oldPrice.text());

                //Read price  with delivery
                Elements priceWithDelivery = articleCurrent.getElementsByClass("mqu1_g3");
                product.setPriceWithShipping(priceWithDelivery.text());


                //Read buyCount
                Elements peoplesCount = articleCurrent.getElementsByClass("mpof_ki m389_6m munh_56_l");
                product.setPeoplesCount(peoplesCount.text().replaceAll("\\D+", ""));



                if (list.size() < 100) {
                    list.add(product);
                }


            }

        }
        System.out.println("End reading");
    }


}
