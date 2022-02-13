package VendingMachine;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

// 장바구니 클래스
class Cart
{
    // 장바구니에 담긴 각 물품의 가격
    private static Vector<Integer> price = new Vector<Integer>();

    // 장바구니에 담긴 물품과 그 개수 key-value값
    private static Map<String, Integer> nameCount = new HashMap<String, Integer>();

    // 금액 추가 메소드
    public void addPrice(int num)
    {
        price.add(num);
    }

    // 장바구니에 담긴 물품의 총 금액 반환 메소드
    public int getPrice()
    {
        int total = 0;
        for(Integer a : price)
        {
            total += a;
        }
        return total;
    }

    // 장바구니에 담긴 물건의 이름과 개수 반환 메소드
    public String getCartItems()
    {
        String items = "";

        for (Map.Entry<String, Integer> entry : nameCount.entrySet())
        {
            items += entry.getKey() + " - " + entry.getValue() + "개 ";
        }
        return items;
    }

    // 장바구니에 물건 추가 (나중에 User에 옮길 것?)
    public void addItems(String name, int n)
    {
        if(nameCount.containsKey(name))
        {
            nameCount.put(name, nameCount.get(name)+n);
        }
        else
        {
            nameCount.put(name, n);
        }
    }
}

