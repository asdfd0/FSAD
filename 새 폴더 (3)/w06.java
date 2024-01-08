import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 메뉴 클래스
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

// 상품 클래스
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

// 주문 클래스
class Order {
    private List<Product> products;

    public Order() {
        products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public List<Product> getProducts() {
        return products;
    }

    public int getPrice() {
        int price = 0;
        for (Product product : products) {
            price += product.getPrice();
        }
        return price;
    }

    public void showMenu() {
        System.out.println("SHAKESHACK BURGER 에 오신걸 환영합니다.");
        System.out.println("아래 메뉴판을 보시고 메뉴를 골라 입력해주세요.");
        System.out.println();
        System.out.println("[ SHAKESHACK MENU ]");
        System.out.println("1. Burgers");
        System.out.println("2. Forzen Custard");
        System.out.println("3. Drinks");
        System.out.println("4. Beer");
        System.out.println();
        System.out.println("[ ORDER MENU ]");
        System.out.println("5. Order");
        System.out.println("6. Cancel");
    }
}

public class Main {
    public static void main(String[] args) {
        // 메뉴판 생성
        Menu menu1 = new Menu("버거", "앵거스 비프 통살을 다져만든 버거");
        Menu menu2 = new Menu("치즈버거", "버거에 치즈를 추가한 버거");
        Menu menu3 = new Menu("와퍼", "버거에 베이컨을 추가한 버거");

        // 상품 생성
        Product product1 = new Product(menu1.getName(), menu1.getDescription(), 5000);
        Product product2 = new Product(menu2.getName(), menu2.getDescription(), 5500);
        Product product3 = new Product(menu3.getName(), menu3.getDescription(), 6000);

        // 주문 생성
        Order order = new Order();
        order.addProduct(product1);
        order.addProduct(product2);
        order.addProduct(product3);

        // 메인 메뉴판 출력
        order.showMenu();

        // 주문
        Scanner scanner = new Scanner(System.in);
        int menuNumber = scanner.nextInt();

        if (menuNumber == 5) {
            // 주문
            System.out.println("주문하신 메뉴는 다음과 같습니다.");
            for (Product product : order.getProducts()) {
                System.out.println(product.getName() + " - " + product.getPrice() + "원");
            }
            System.out.println("총 주문 금액은 " + order.getPrice() + "원입니다.");
        } else if (menuNumber == 6) {
            // 주문 취소
            System.out.println("주문이 취소되었습니다.");
            order.getProducts().clear();
        } else {
            // 잘못된 메뉴 번호
            System.out.println("잘못된 메뉴 번호입니다. 다시 입력해주세요.");
        }

    }
}