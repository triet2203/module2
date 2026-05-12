package case_study.mvc.entity;

public class OrderDetail {
    private String orderId;
    private Product product;
    private Integer quantity;
    private Double price;

    public OrderDetail() {
    }

    public OrderDetail(String orderId, Product product, int quantity, double price) {
        this.orderId = orderId;
        this.product = product;
        this.quantity = quantity;
        this.price = price;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    public double getTotalPrice() {
        return price * quantity;
    }

    @Override
    public String toString() {
        return "Mã đơn: " + orderId
                + " - " + product.getName()
                + " - SL: " + quantity
                + " - Giá: " + price
                + " - Thành tiền: " + getTotalPrice();
    }
}
