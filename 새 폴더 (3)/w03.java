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

    public Product(String name, String description, double price) {
        super(name, description);
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
}

// 주문 클래스
class Order {
    private Product selectedItem;

    public void addItem(Product item) {
        this.selectedItem = item;
    }

    public void confirmOrder() {
        if (selectedItem != null) {
            System.out.println("장바구니에 추가되었습니다.");
        } else {
            System.out.println("장바구니 추가 실패: 상품이 선택되지 않았습니다.");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        // 메뉴 아이템 생성
        Product hamburger = new Product("Hamburger", "비프패티를 기반으로 야채가 들어간 기본버거", 5.4);

        // 주문 객체 생성
        Order order = new Order();

        // 구매 화면 출력
        System.out.println(hamburger.name + "     | W " + hamburger.getPrice() + " | " + hamburger.description);
        System.out.println("이 상품을 장바구니에 추가하시겠습니까?");
        System.out.println("1. 확인        2. 취소");

        // 사용자 입력 받기
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        // 사용자 선택에 따라 처리
        switch (choice) {
            case 1:
                order.addItem(hamburger);
                order.confirmOrder();
                // 여기에 메인 메뉴로 이동하는 코드를 추가할 수 있습니다.
                break;
            case 2:
                System.out.println("장바구니 추가를 취소했습니다.");
                // 여기에 메인 메뉴로 이동하는 코드를 추가할 수 있습니다.
                break;
            default:
                System.out.println("잘못된 선택입니다.");
                // 여기에 메인 메뉴로 이동하는 코드를 추가할 수 있습니다.
        }
    }
}
