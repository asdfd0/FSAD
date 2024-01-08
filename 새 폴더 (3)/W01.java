import java.util.Scanner;

class Menu {
    protected String name;
    protected String description;

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
    protected int price;

    public Product(String name, String description, int price) {
        super(name, description);
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}

class Order {
    private Product[] products;
    private int quantity;

    public Order(Product[] products, int quantity) {
        this.products = products;
        this.quantity = quantity;
    }

    public int getTotalPrice() {
        int totalPrice = 0;
        for (Product product : products) {
            totalPrice += product.getPrice() * quantity;
        }
        return totalPrice;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("SHAKESHACK BURGER 에 오신걸 환영합니다.");
        System.out.println("아래 상품메뉴판을 보시고 상품을 골라 입력해주세요.");

        System.out.println("** Burgers MENU **");
        System.out.println("1. ShackBurger | W 6.9 | 토마토, 양상추, 쉑소스가 토핑된 치즈버거");
        System.out.println("2. SmokeShack | W 8.9 | 베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거");
        System.out.println("3. Shroom Burger | W 9.4 | 몬스터 치즈와 체다 치즈로 속을 채운 베지테리안 버거");
        System.out.println("4. Cheeseburger | W 6.9 | 포테이토 번과 비프패티, 치즈가 토핑된 치즈버거");
        System.out.println("5. Hamburger | W 5.4 | 비프패티를 기반으로 야채가 들어간 기본버거");

        int choice = scanner.nextInt();

        if (choice > 0 && choice <= 5) {
            // 상품을 주문한다.
            Product product = new Product(
                    switch (choice) {
                        case 1 -> "ShackBurger";
                        case 2 -> "SmokeShack";
                        case 3 -> "Shroom Burger";
                        case 4 -> "Cheeseburger";
                        default -> "Unknown";
                    },
                    "토마토, 양상추, 쉑소스가 토핑된 치즈버거",
                    switch (choice) {
                        case 1 -> 6900;
                        case 2 -> 8900;
                        case 3 -> 9400;
                        case 4 -> 6900;
                        default -> 0;
                    }
            );

            // 주문에 추가한다.
            Order order = new Order(new Product[]{product}, 1);
            System.out.println("상품이 주문되었습니다.");
            System.out.println("총 주문 금액은 " + order.getTotalPrice() + "원입니다.");
        } else {
            System.out.println("잘못된 입력입니다.");
        }

        System.out.println("감사합니다.");
    }
}