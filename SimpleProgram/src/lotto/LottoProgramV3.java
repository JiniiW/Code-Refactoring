package lotto;
//hashMap 사용해보기

import java.util.*;

public class LottoProgramV3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("[로또 당첨 프로그램]\n");
        //내 로또 추출
        System.out.print("로또 개수룰 입력해주세요.(숫자 1 ~ 10) : ");
        int count = sc.nextInt();
        List<List<Integer>> mylotto = new ArrayList<>(new ArrayList<>()); //구매한 모든 로또 번호
        List<Integer> lottoOneLine; //로또 한 줄

        for (int i = 0; i < count; i++) {
            System.out.print((char) (i + 65) + "\t");
            lottoOneLine = lottoNumber();
            mylotto.add(lottoOneLine);
            System.out.println();
        }

        //로또 발표
        System.out.println("\n[로또 발표]");
        System.out.print("\t");
        List<Integer> lotto = lottoNumber();


        //로또 번호 비교
        System.out.println("\n\n[내 로또 결과]");
        for (int i = 0; i < count; i++) {
            System.out.print((char) (i + 65) + "\t");
            printLottoNumbers(mylotto.get(i));
            mylotto.get(i).retainAll(lotto);
            System.out.printf(" -> %d개", mylotto.get(i).size());
            System.out.println();
        }
    }

    //로또번호 추가 메서드
    public static List<Integer> lottoNumber() {
        //HashSet으로 중복 제거
        HashSet<Integer> arraySet = new HashSet<>();
        for (int i = 0; arraySet.size() < 6; i++) {
            int num = (int) (Math.random() * 45 + 1);
            arraySet.add(num);
        }

        //hashSet은 요소의 삽입순서를 보장하지 않기 때문에 정렬이 불가능
        List<Integer> numbers = new ArrayList<>(arraySet);

        Collections.sort(numbers);
        printLottoNumbers(numbers);

        return numbers;
    }

    //로또 출력 메서드
    public static void printLottoNumbers(List<Integer> list) {
        list.forEach(number -> System.out.printf("%2d ", number));
    }

}