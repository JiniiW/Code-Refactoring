package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class LottoProgramV2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("[로또 당첨 프로그램]\n");
        //내 로또 추출
        System.out.print("로또 개수룰 입력해주세요.(숫자 1 ~ 10) : ");
        int count = sc.nextInt();
        //배열 대신 ArrayList 선언
        ArrayList<Integer>[] mylotto = new ArrayList[count];
        for (int i = 0; i < count; i++) {
            System.out.print((char) (i + 65) + "\t");
            //번호 추가 메서드 호출
            mylotto[i] = lottoNumber();
            System.out.println();
        }

        //로또 발표
        System.out.println("\n[로또 발표]");
        ArrayList<Integer> lotto;
        System.out.print("\t");
        //번호 추가 메서드 호출
        lotto = lottoNumber();
        System.out.println("\n");


        //로또 번호 비교
        System.out.println("[내 로또 결과]");
        for (int i = 0; i < count; i++) {
            System.out.print((char) (i + 65) + "\t");
            //출력 메서드 호출
            printLottoNumbers(mylotto[i]);
            //중복되는 부분만 남김
            mylotto[i].retainAll(lotto);
            System.out.print("-> " + mylotto[i].size() + "개");
            System.out.println();
        }
    }

    //로또번호 추가 메서드
    static ArrayList<Integer> lottoNumber() {
        ArrayList<Integer> lottoNumber = new ArrayList<>();
        //ArrayList에 1부터 45까지 넣어줌
        for (int i = 1; i <= 45; i++) {
            lottoNumber.add(i);
        }
        //list의 순서 변경
        Collections.shuffle(lottoNumber);
        //6자리 출력
        lottoNumber = new ArrayList<Integer>(lottoNumber.subList(0, 6));

        Collections.sort(lottoNumber);

        //로또 출력 메서드 호출
        printLottoNumbers(lottoNumber);

        return lottoNumber;
    }

    //로또 출력 메서드
    public static void printLottoNumbers(ArrayList<Integer> lottoNumber) {
        for (int number : lottoNumber) {
            System.out.printf("%2d ", number);
        }
    }

}