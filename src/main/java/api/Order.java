package api;

public class Order {

    public String orderNumber;
    public String customerName;
    public String addressToDeliver;
    public String items;

    Order(String on, String cn, String atd, String i) {
        this.orderNumber = on;
        this.customerName = cn;
        this.addressToDeliver = atd;
        this.items = i;
    }

    public String getOrderNumber() {
        return this.orderNumber;
    }

    public String getCustomerName() {
        return this.customerName;
    }

    public String getAddressToDeliver() {
        return this.addressToDeliver;
    }

    public String getItems() {
        return this.items;
    }

}
