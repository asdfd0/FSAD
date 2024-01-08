import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

class Menu {
    private String name;
    private String description;

    public Menu(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}

class Product extends Menu {
    private int price;

    public Product(String name, String description, int price) {
        super(name, description);
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}

class Order {
    private static int orderCounter = 1;
    private int orderNumber;
    private ArrayList<Product> products;

    public Order() {
        this.orderNumber = orderCounter++;
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }
}

public class Main {
    public static void main(String[] args) {
        // 메뉴 생성
        Menu menu1 = new Menu("Menu 1", "Description for Menu 1");
        Product product1 = new Product("Product 1", "Description for Product 1", 10);

        // 주문 생성
        Order order = new Order();
        order.addProduct(product1);

        // 주문이 완료되었습니다 메시지 출력
        System.out.println("주문이 완료되었습니다!");
        System.out.println("대기번호는 [ " + order.getOrderNumber() + " ] 번 입니다.");

        // 3초 대기 후 메뉴판으로 돌아가기
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 여기에 메뉴판으로 돌아가는 로직을 추가하면 됩니다.
        System.out.println("3초후 메뉴판으로 돌아갑니다.");
    }
}
