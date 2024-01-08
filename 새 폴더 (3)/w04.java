import java.util.Scanner;

// 메뉴 클래스
class Menu {
    String name;
    String description;

    public Menu(String name, String description) {
        this.name = name;
        this.description = description;
    }
}

// 상품 클래스
class Product extends Menu {
    int price;

    public Product(String name, int price, String description) {
        super(name, description);
        this.price = price;
    }
}

// 주문 클래스
class Order {
    Product[] cart;

    public Order() {
        this.cart = new Product[10]; // 최대 10개 상품을 담을 수 있는 장바구니
    }

    public void addToCart(Product product) {
        // 장바구니에 상품 추가 로직
        // 여기에서는 배열의 비어있는 공간에 추가하는 방식으로 구현
        for (int i = 0; i < cart.length; i++) {
            if (cart[i] == null) {
                cart[i] = product;
                break;
            }
        }
        System.out.println("장바구니에 상품이 추가되었습니다.");
    }

    public void displayCart() {
        System.out.println("장바구니 내역:");
        for (Product product : cart) {
            if (product != null) {
                System.out.println(product.name + " - " + product.price + "원");
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        // 환영 메시지 출력
        System.out.println("\"SHAKESHACK BURGER에 오신걸 환영합니다.\"");

        // 메뉴 생성
        Menu burgersMenu = new Menu("Burgers", "앵거스 비프 통살을 다져만든 버거");
        Menu frozenCustardMenu = new Menu("Frozen Custard", "매장에서 신선하게 만드는 아이스크림");
        Menu drinksMenu = new Menu("Drinks", "매장에서 직접 만드는 음료");
        Menu beerMenu = new Menu("Beer", "뉴욕 브루클린 브루어리에서 양조한 맥주");

        // 주문 생성
        Order order = new Order();

        // 메뉴 출력
        System.out.println("[ SHAKESHACK MENU ]");
        System.out.println("1. " + burgersMenu.name + "         | " + burgersMenu.description);
        System.out.println("2. " + frozenCustardMenu.name + "  | " + frozenCustardMenu.description);
        System.out.println("3. " + drinksMenu.name + "          | " + drinksMenu.description);
        System.out.println("4. " + beerMenu.name + "            | " + beerMenu.description);
        System.out.println("[ ORDER MENU ]");
        System.out.println("5. Order       | 장바구니를 확인 후 주문합니다.");
        System.out.println("6. Cancel      | 진행중인 주문을 취소합니다.");

        // 사용자 입력 처리
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                // 사용자가 1을 선택한 경우, 해당 메뉴에 대한 추가 로직을 구현
                break;
            case 2:
                // 사용자가 2를 선택한 경우, 해당 메뉴에 대한 추가 로직을 구현
                break;
            // 나머지 메뉴에 대한 처리도 유사하게 진행
            case 5:
                // 사용자가 주문을 선택한 경우, 장바구니 확인 후 주문 로직을 구현
                order.displayCart();
                break;
            case 6:
                // 사용자가 취소를 선택한 경우, 주문 취소 로직을 구현
                System.out.println("진행하던 주문이 취소되었습니다.");
                break;
            default:
                System.out.println("올바른 선택이 아닙니다. 종료합니다.");
        }
    }
}
