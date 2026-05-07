package mvc_pratice.mvc.entity;

public class OrderDetail {
    private Product product;
    private Integer quantity;
    private Double price;

    public OrderDetail() {
    }

    public OrderDetail(Product product, int quantity, double price) {
        this.product = product;
        this.quantity = quantity;
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

    public String toString() {
        return product.getName() + " - SL: " + quantity + " - Giá: " + price + " - Thành tiền: " + getTotalPrice();
    }
}
