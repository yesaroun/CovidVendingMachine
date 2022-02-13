package VendingMachine;

// 판매 수익 클래스
class Revenue
{
    private static int rev = 0;

    // 수익 추가 메소드
    public static void addMoney(int m)
    {
        rev += m;
    }

    // 수익 확인 메소드
    public static int getMoney()
    {
        return rev;
    }

    // 수익 회수 메소드
    public static void removeMoney(int m) throws Exception
    {
        if(rev >= m)
        {
            rev -= m;
        }
        else
        {
            throw new Exception("돈이 모자랍니다.");
        }
    }
}