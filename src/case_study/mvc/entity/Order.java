package case_study.mvc.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private int id;
    private int customerId;
    private List<OrderDetail> details;
    private LocalDate date;
    private String status;

    public Order() {
        this.details = new ArrayList<>();
    }

    public Order(int id, int customerId, LocalDate date, String status) {
        this.id = id;
        this.customerId = customerId;
        this.details = new ArrayList<>();
        this.date = date;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public List<OrderDetail> getDetails() {
        return details;
    }

    public void setDetails(List<OrderDetail> details) {
        this.details = details;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getTotalPrice() {
        double total = 0;
        for (OrderDetail detail : details) {
            total += detail.getPrice() * detail.getQuantity();
        }
        return total;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Customer ID: " + customerId + ", Date: " + date + ", Status: " + status;
    }
}
