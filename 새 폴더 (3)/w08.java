public class Main {
    public static void main(String[] args) {
        // 주문이 취소되면 출력할 환영 메시지와 메뉴판
        System.out.println("진행하던 주문이 취소되었습니다.");
        System.out.println("\"SHAKESHACK BURGER\"에 오신걸 환영합니다.");

        // 메뉴를 출력하는 메서드 호출
        printMenu();
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
