package polymorphisomOfParameters.originalcode;

public class PolymorphismOfParameters {
    public static void main(String[] args) {
        Buyer buyer = new Buyer();
        buyer.buy(new TV());
        buyer.buy(new Computer());
        System.out.println("현재 남은 돈은 " + buyer.getMoney() +"원 입니다.");
        System.out.println("현재 적립된 포인트는 " + buyer.getBonusPoint() +"원 입니다.");
    }
}