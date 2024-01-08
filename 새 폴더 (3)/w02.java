import java.util.ArrayList;
import java.util.Scanner;

// 메뉴 클래스
class Menu {
    protected String name;
    protected String description;

    public Menu(String name, String description) {
        this.name = name;
        this.description = description;
    }
}

// 상품 클래스
class Product extends Menu {
    protected double price;

    public Product(String name, double price, String description) {
        super(name, description);
        this.price = price;
    }
}

// 주문 클래스
class Order {
    private ArrayList<Product> cart;

    public Order() {
        this.cart = new ArrayList<>();
    }

    public void addToCart(Product product) {
        cart.add(product);
    }

    public void displayCart() {
        System.out.println("[ Orders ]");
        for (Product product : cart) {
            System.out.println(product.name + " | W " + product.price + " | " + product.description);
        }

        double total = cart.stream().mapToDouble(p -> p.price).sum();
        System.out.println("\n[ Total ]\nW " + total);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Order order = new Order();

        while (true) {
            System.out.println("\n아래와 같이 주문 하시겠습니까?\n");
            displayMenu();
            System.out.println("1. 주문      2. 메뉴판");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    orderMenu(scanner, order);
                    break;
                case 2:
                    // Display menu again
                    displayMenu();
                    break;
                default:
                    System.out.println("올바른 선택이 아닙니다. 다시 선택해주세요.");
            }
        }
    }

    private static void displayMenu() {
        System.out.println("[ Orders ]");
        System.out.println("ShackBurger   | W 6.9 | 토마토, 양상추, 쉑소스가 토핑된 치즈버거");
        System.out.println("SmokeShack    | W 8.9 | 베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거\n");
        System.out.println("[ Total ]\nW 15.8");
    }

    private static void orderMenu(Scanner scanner, Order order) {
        while (true) {
            System.out.println("\n[ Orders ]");
            order.displayCart();
            System.out.println("\n1. ShackBurger 주문      2. SmokeShack 주문      3. 주문 완료");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    order.addToCart(new Product("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
                    break;
                case 2:
                    order.addToCart(new Product("SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
                    break;
                case 3:
                    System.out.println("주문이 완료되었습니다. 주문 내역을 확인합니다.");
                    order.displayCart();
                    return;
                default:
                    System.out.println("올바른 선택이 아닙니다. 다시 선택해주세요.");
            }
        }
    }
}
