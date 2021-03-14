package rsmyrnov.parser;

public class Product {

    private int    id;
    private String name;
    private String oldPrice;
    private String newPrice;
    private String discount;
    private String priceWithShipping;
    private String peoplesCount;

    public Product() {

    }


    //==============================================


    public int getId() {
        return id;
    }

    public String getDiscount() {
        return discount;
    }

    public String getPriceWithShipping() {
        return priceWithShipping;
    }

    public String getNewPrice() {
        return newPrice;
    }

    public String getOldPrice() {
        return oldPrice;
    }

    public String getName() {
        return name;
    }

    public String getPeoplesCount() {
        return peoplesCount;
    }
    //------------------------------------


    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        if(name!=null) {
            this.name = name;
        }
    }

    public void setOldPrice(String oldPrice) {
        this.oldPrice = oldPrice;
    }

    public void setNewPrice(String newPrice) {
        this.newPrice = newPrice;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public void setPeoplesCount(String  peoplesCount) {
        this.peoplesCount = peoplesCount;
    }

    public void setPriceWithShipping(String priceWithShipping) {
        this.priceWithShipping = priceWithShipping;
    }
}
