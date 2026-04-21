package ss12_java_collection_framework;

public class Main {
    public static void main(String[] args) {
        ProductManager manager = new ProductManager();

        manager.add(new Product(1, "Iphone", 2000));
        manager.add(new Product(2, "Samsung", 7000));
        manager.add(new Product(3, "Xiaomi", 5000));

        System.out.println("Danh sách ban đầu");
        manager.display();

        System.out.println("Sửa sản phẩm");
        manager.edit(1, "Oppo", 2500);
        manager.display();


        System.out.println("Tìm kiếm sản phẩm");
        manager.search("Iphone");

        System.out.println("Sắp xếp sản phẩm tăng dần theo giá");
        manager.sortAsc();
        manager.display();

        System.out.println("Sắp xếp sản phẩm giảm dần theo giá");
        manager.sortDesc();
        manager.display();

        System.out.println("Xóa sản phẩm");
        manager.delete(1);
        manager.display();
    }
}
