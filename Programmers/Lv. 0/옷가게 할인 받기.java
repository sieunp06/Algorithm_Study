class Solution {
    private final int ten = 100000;
    private final int thirty = 300000;
    private final int fifty = 500000;
    public int solution(int price) {
        int answer = price;
        if (price >= ten && price < thirty) return discountTen(price);
        if (price >= thirty && price < fifty) return discountThirty(price);
        if (price >= fifty) return discountFifty(price);
        return answer;
    }
    
    private int discountTen(int price) {
        return price * 95 / 100;
    }
    
    private int discountThirty(int price) {
        return price * 90 / 100;
    }

    private int discountFifty(int price) {
        return price * 80 / 100;
    }
}