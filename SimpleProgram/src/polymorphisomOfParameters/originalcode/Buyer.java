package polymorphisomOfParameters.originalcode;

public class Buyer {
    private int money = 1000;
    private int bonusPoint = 0;

    public int getMoney() {
        return money;
    }

    public int getBonusPoint() {
        return bonusPoint;
    }

    public void buy(Product p){
        if(money < p.getPrice()){
            System.out.println("돈이 부족합니다.");
        } else {
            money -= p.getPrice();
            bonusPoint += (int) (p.getPrice() / 10.0);
            System.out.println(p + "을/를 구입하셨습니다.");
        }
    }
}
