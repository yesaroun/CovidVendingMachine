package VendingMachine;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.Map;
import java.util.HashMap;


class PhraseMenus
{
    public static final int E_ADD = 1;          //-- 요소 추가
    public static final int E_DISP = 2;         //-- 요수 출력
    public static final int E_FIND = 3;         //-- 요소 검색
    public static final int E_DEL = 4;          //-- 요소 삭제
    public static final int E_CHA = 5;          //-- 요소 변경
    public static final int E_EXIT = 6;         //-- 종료
}

public class TextAdmin
{
    private static final HashMap<Integer, String> hm;
    private static BufferedReader br;
    private static Integer sel;                 //-- 선택값
    private static String con;                  //-- 계속 여부

    static
    {
        hm = new HashMap<Integer, String>();

        //BufferedReader 클래스 인스턴스 생성
        br = new BufferedReader(new InputStreamReader(System.in));

        // 사용자 입력값 초기화
        sel = 1;
        con = "Y";

        hm.put(1, "마스크를 꼭 착용해주세요!");
        hm.put(2, "코로나 19 함께 이겨내요~");
        hm.put(3, "방역지침을 지켜주세요!");
        hm.put(4, "건강하게 극복해요!");
        hm.put(5, "우리는 할 수 있습니다!");
        hm.put(6, "거리는 멀어져도 마음은 가까이");
        hm.put(7, "코로나 19를 이기는 새로운 일상, 함께 만들어요!");
    }

    public static void menuDisp()
    {
        System.out.println("\n\t[메뉴 선택]");
        System.out.println("1. 요소 추가");
        System.out.println("2. 요소 출력");
        System.out.println("3. 요소 검색");
        System.out.println("4. 요소 삭제");
        System.out.println("5. 요소 변경");
        System.out.println("6. 종료");
    }

    // 메뉴 선택 메소드
    public static void menuSelect() throws IOException, NumberFormatException
    {
        System.out.print(">> 메뉴 선택(1~6) : ");
        sel = Integer.parseInt(br.readLine());
    }

    // 선택된 메뉴 실행에 따른 기능 호출 메소드
    public static void menuRun() throws IOException
    {
        switch (sel)
        {
            case PhraseMenus.E_ADD: addElement(); break;
            case PhraseMenus.E_DISP: dispElement(); break;
            case PhraseMenus.E_FIND: findElement(); break;
            case PhraseMenus.E_DEL: delElement(); break;
            case PhraseMenus.E_CHA: chaElement(); break;
            case PhraseMenus.E_EXIT: exit(); break;
        }
    }

    // 자료구조에 요소 추가(입력) 메소드
    public static void addElement() throws IOException
    {
        do
        {
            System.out.print("입력할 문구 번호 입력 : ");
            int num = Integer.parseInt(br.readLine());

            System.out.printf("%d번째 문구 입력 : ", num);
            hm.put(num, br.readLine());

            System.out.print("요소 입력 계속(Y/N)? : ");
            con = br.readLine();
        }
        while (con.equals("Y") || con.equals("y"));
    }

    // 자료구조 전체 요소 출력 메소드
    public static void dispElement()
    {
        System.out.println("\t[전체 출력]");
        for (Map.Entry<Integer, String> entrySet : hm.entrySet())
            System.out.println(entrySet.getKey() + " : " + entrySet.getValue());
        System.out.println("전체 출력 완료");
    }

    // 자료구조 내 요소 검색 메소드
    public static void findElement() throws IOException
    {
        System.out.print("\n검색할 요소 번호 입력 : ");
        int sSearch = Integer.parseInt(br.readLine());

        if(hm.get(sSearch) != null)
        {
            System.out.println("\t[검색 결과 출력]");
            System.out.println(hm.get(sSearch));
        }
        else
        {
            System.out.println("\n\t[검색 결과 출력]");
            System.out.println("항목이 존재하지 않습니다.");
        }
    }

    // 자료구조 내 요소 삭제 메소드
    public static void delElement() throws IOException
    {
        System.out.print(">> 삭제할 문구 번호 입력 : ");
        int del = Integer.parseInt(br.readLine());
        System.out.println("\n[삭제 문구 출력]");

        if(hm.containsKey(del))
        {
            hm.remove(del);
            System.out.println(del + " 번 문구가 삭제되었습니다. ");
        }
        else
            System.out.println("해당 문구 번호가 존재하지 않아 삭제할 수 없습니다.");
    }

    // 자료구조 내 요소 수정 메소드

    public static void chaElement() throws IOException
    {

        System.out.print(">> 변경할 문구 번호 입력 : ");
        int cha = Integer.parseInt(br.readLine());
        if (hm.containsKey(cha))
        {
            System.out.print(">> 수정할 문구 입력 : ");
            String newM = br.readLine();
            hm.put(cha, newM);
            System.out.println("\n[변경 문구 출력]");
            System.out.println("문구 변경이 완료되었습니다.");
        }
        else
        {
            System.out.println("\n[변경 문구 출력]");
            System.out.println("변경할 문구가 존재하지 않습니다.");
        }
    }

    // 종료 메소드
    public static void exit()
    {
        System.out.println("\n -= 문구 관리 창을 종료하고 관리자 메뉴로 돌아갑니다 =- ");
        System.exit(-1);
    }

    public HashMap<Integer, String> getHm()
    {
        return hm;
    }
}