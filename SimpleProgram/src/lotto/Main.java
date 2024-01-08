package lotto;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //내 로또 추출
        Scanner sc = new Scanner(System.in);
        System.out.println("[로또 당첨 프로그램]\n");
        System.out.print("로또 개수룰 입력해주세요.(숫자 1 ~ 10) : ");
        int count = sc.nextInt(); //로또 개수 입력
        int[][] mylotto = new int[count][6]; //나의 로또 배열 선언
        for (int i = 0; i < mylotto.length; i++) {
            System.out.print((char) (i + 65) + "\t");
            lottoNumber(mylotto[i]); //로또 번호 생성 및 출력 메서드 호출
            System.out.println();
        }

        //로또 발표
        System.out.println("\n[로또 발표]");
        int[] lotto = new int[6]; //당첨 로또 배열 선언
        System.out.print("\t");
        lottoNumber(lotto); //로또 번호 생성 및 출력 메서드 호출
        System.out.println("\n");


        //로또 번호 비교
        System.out.println("[내 로또 결과]");
        for (int i = 0; i < mylotto.length; i++) { //입력받은 개수만큼 for문 진행
            System.out.print((char) (i + 65) + "\t");
            int duplicationNumber = 0; //중복값 초기화
            for (int j = 0; j < mylotto[i].length; j++) { //해당 행의 로또 번호 비교
                System.out.printf("%2d", mylotto[i][j]);
                for (int k = 0; k < 6; k++) { //기존 lotto의 값과 mylotto의 값을 비교
                    if (lotto[k] == mylotto[i][j]) {
                        duplicationNumber++;
                    }
                }
                if (j < 5) {
                    System.out.print(", ");
                }
            }
            System.out.printf(" => %d개 일치", duplicationNumber);
            System.out.println();
        }
    }

    //로또 출력 메서드
    static void lottoNumber(int[] lottoName) {
        //중복 제거하여 배열에 값 저장 for문
        for (int i = 0; i < 6; i++) {
            lottoName[i] = (int) (Math.random() * 45) + 1;
            // 중복 번호 제거
            for (int j = 0; j < i; j++) {
                if (lottoName[i] == lottoName[j]) {
                    i--;
                    break;
                }
            }
        }
        //배열 오름차순 정렬
        Arrays.sort(lottoName);

        //로또 번호를 출력해주는 for문
        for (int i = 0; i < 6; i++) {
            System.out.printf("%2d", lottoName[i]);
            if (i < 5) {
                System.out.print(", ");
            }
        }
    }

}
