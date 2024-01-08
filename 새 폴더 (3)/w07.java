import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        // 사용자로부터 주문 취소 여부를 확인
        System.out.println("진행하던 주문을 취소하시겠습니까?");
        System.out.println("1. 확인     2. 취소");
        choice = scanner.nextInt();

        if (choice == 1) {
            // 주문을 확인하고 장바구니 초기화
            System.out.println("주문이 취소되었습니다. 장바구니가 초기화됩니다.");

            // 여기에 장바구니 초기화 코드를 추가할 수 있습니다.
            // 예: resetShoppingCart();

            // 메뉴판을 출력
            printMenu();
        } else {
            // 주문을 취소하지 않으면 메뉴를 그대로 유지
            System.out.println("주문이 유지됩니다. 계속 주문을 진행하세요.");
        }

        scanner.close();
    }

    // 메뉴를 출력하는 메서드
    private static void printMenu() {
        System.out.println("[ SHAKESHACK MENU ]");
        System.out.println("1. Burgers         | 앵거스 비프 통살을 다져만든 버거");
        System.out.println("2. Forzen Custard  | 매장에서 신선하게 만드는 아이스크림");
        System.out.println("3. Drinks          | 매장에서 직접 만드는 음료");
        System.out.println("4. Beer            | 뉴욕 브루클린 브루어리에서 양조한 맥주");
        System.out.println("[ ORDER MENU ]");
        System.out.println("5. Order       | 장바구니를 확인 후 주문합니다.");
        System.out.println("6. Cancel      | 진행중인 주문을 취소합니다.");
    }
}
