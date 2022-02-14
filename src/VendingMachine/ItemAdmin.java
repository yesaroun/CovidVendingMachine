package VendingMachine;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.InputMismatchException;
import java.util.Scanner;

// ② 상품 재고관리 클래스
class ItemAdmin implements Admin
{
    private static Scanner sc = new Scanner(System.in);
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static String con;

    // 메뉴 선택
    void select() throws IOException {
        do {
            System.out.println("<< 상품 관리 현황 >>");
            System.out.println("1. 상품 재고 확인");
            System.out.println("2. 상품 재고 추가");
            System.out.println("3. 상품 재고 삭제");
            System.out.println("4. 관리자 메뉴로 이동");

            do {
                System.out.print(">> ");
                con = br.readLine();

                if (Integer.parseInt(con) < 1 && Integer.parseInt(con) > 4)
                    System.out.println("잘못 입력하셨습니다.");
            }
            while (Integer.parseInt(con) < 1 && Integer.parseInt(con) > 4);

            switch (con) {
                case "1":
                    show();
                    break;    // 재고 확인
                case "2":
                    add();
                    break;    // 재고 추가
                case "3":
                    delete();
                    break;    // 재고 삭제
            }
        }
        while (!con.equals("4"));
    }

    // 재고 보기 → 인터넷 참고
    @Override
    public void show() {
        Inventory item = new Inventory();   // -- Inventory 클래스 참조
        //Set<Map.Entry<String, Integer>> set = invenNumber.entrySet();   //--invenNumber 이부분을 어떻게 고쳐야 하지?
        String items = item.getInvens();
        // String 변수 선언

        System.out.println("\n<<전체 상품 현황 조회>>");
        System.out.printf("%s, %s", "상품명", "현재 수량");
        System.out.println(items);
    }

    // 재고 관리
    @Override
    public void add() {
        System.out.println("< 상품 추가 >");
        try {
            Inventory item = new Inventory();
            System.out.println("상품 이름과 수량을 입력하세요");
            String name = sc.next();
            int i = sc.nextInt();
            item.addInvNum(name,i);       //--add 이부분을 어떻게 고쳐야 하지?
        } catch (InputMismatchException e) {
            System.out.println("입력 형식이 틀립니다.");
            sc.nextLine();
        }
    }

    // 재고 감소
    @Override
    public void delete() {
        System.out.println("[상품의 재고 관리(삭제)]");
        try {
            Inventory item = new Inventory();
            System.out.println("제거할 상품 이름과 수량을 입력하세요");
            String name = sc.next();
            int i = sc.nextInt();
            item.sellItems(name, i);
        } catch (InputMismatchException e) {
            System.out.println("입력 형식이 틀립니다.");
            sc.nextLine();
        }
    }

    @Override
    public void onOff() {
        // 내용 없음
    }
}

