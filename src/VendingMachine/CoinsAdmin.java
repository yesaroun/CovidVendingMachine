package VendingMachine;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.InputMismatchException;
import java.util.Scanner;

// ③ 돈 재고관리 클래스
class CoinsAdmin implements Admin {
    private Scanner sc = new Scanner(System.in);
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String con;

    // 메뉴 선택
    void select() throws IOException {
        do {
            // 디스플레이
            System.out.println("<< 잔돈 관리 현황 >>");
            System.out.println("1. 잔돈 확인");
            System.out.println("2. 잔돈 재고 추가");
            System.out.println("3. 잔돈 재고 삭제");
            System.out.println("4. 관리자 메뉴로 이동");

            do {
                System.out.print(">> ");
                con = br.readLine();

                if (Integer.parseInt(con) < 1 && Integer.parseInt(con) > 4)
                    System.out.println("잘못 입력하셨습니다.");
            }
            while (Integer.parseInt(con) < 1 && Integer.parseInt(con) > 4);

            System.out.println();

            switch (con) {
                case "1":
                    show();
                    break;    // 잔돈 확인
                case "2":
                    add();
                    break;    // 잔돈 추가
                case "3":
                    delete();
                    break;    // 잔돈 삭제
            }
        }
        while (!con.equals("4"));
    }

    // 돈 재고 보기 → 인터넷 참고
    @Override
    public void show() {
        Changes cha = new Changes();
        //Set<Map.Entry<String, Integer>> set = changesNum.entrySet();
        int[] MoneyName = {5000, 1000, 500, 100};
        int[] MoneyNumber = {cha.getChanges(5000),cha.getChanges(1000),cha.getChanges(500),cha.getChanges(100)};
        System.out.println("\n<<전체 잔돈 현황 조회>>");
        for (int i=0;i<MoneyName.length;i++)
        {
            System.out.printf("%d원 %d개",MoneyName[i],MoneyNumber[i]);
        }
        //Iterator<Map.Entry<String, Integer>> cha = set.iterator();

    }

    // 재고 관리
    @Override
    public void add() {
        System.out.println("[잔돈 관리]");
        try
        {
            Changes cha = new Changes();
            System.out.println("잔돈 단위와 수량을 입력하세요");
            int name = sc.nextInt();
            int i = sc.nextInt();
            cha.addChanges(name,i);
        }
        catch (InputMismatchException e) {
            System.out.println("입력 형식이 틀립니다.");
            sc.nextLine();
        }
    }

    @Override
    public void delete() {
/*
      String temp;

      System.out.println("< 상품 정보 삭제 >");
      System.out.print("상품 이름 : ");
      temp = br.readLine();

      System.out.println();
      System.out.println("< 상품 정보 삭제 결과>");

      if (구매클래스.상품정보메소드.containsKey(temp)) // 입력한 값이 있다면
      {
         구매클래스.상품정보메소드.remove(temp);

         System.out.println("상품" + temp + "을/를 삭제했습니다.");
      }
      else
         System.out.println(temp + "는 존재하지 않는 상품입니다.");
*/

        System.out.println("[잔돈 관리(삭제)]");
        try {
            Changes cha = new Changes();
            System.out.println("제거할 잔돈 단위와 수량을 입력하세요");
            //int name = sc.nextInt();
            int i = sc.nextInt();
            cha.useChanges(i); //??
        } catch (InputMismatchException i) {
            System.out.println("입력 형식이 틀립니다.");
            sc.nextLine();
        }
    }

    /*
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
}*/
    @Override
    public void onOff() {
        // 내용 없음
    }
}