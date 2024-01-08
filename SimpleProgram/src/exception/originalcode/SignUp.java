package exception.originalcode;

import java.util.Scanner;

public class SignUp {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        User user = new User();
        SignUp sign = new SignUp();
        String id = null;
        String password = null;

        try {
            System.out.print("아이디를 입력하세요 : ");
            id = input.next();
            sign.setUserId(id);
            System.out.print("비밀번호를 입력하세요 : ");
            password = input.next();
            sign.setUserPassword(password);
            System.out.println(user.getId() + "회원가입 완료");
        } catch (SignUpFormatException sf) {
            System.out.println(sf.getMessage());
        } catch (Exception e) {
            System.out.println("예외가 발생했습니다.");
        }
    }
    User user = new User();

    public void setUserId(String id) throws SignUpFormatException {
        if (id == null) {
            throw new SignUpFormatException("아이디를 입력해주세요");
        } else if (!id.matches("^[a-zA-Z]+[0-9]+$")) {
            throw new SignUpFormatException("문자와 숫자를 입력해주세요");
        } else if (id.length() < 3 || id.length() > 11) {
            throw new SignUpFormatException("아이디는 5글자 이상 10글자 이하로 입력해주세요.");
        }
        user.setId(id);
    }

    public void setUserPassword(String password) throws SignUpFormatException {
        if (password == null) {
            throw new SignUpFormatException("비밀번호를 입력해주세요");
        } else if (!password.matches("^[a-zA-Z]+[0-9]+[@$!%*#?&]+$")) {
            throw new SignUpFormatException("비밀번호는 문자, 숫자, 특수기호로 작성되어야 합니다.");
        } else if (password.length() < 5 || password.length() > 11) {
            throw new SignUpFormatException("비밀번호는 3글자 이상 10글자 이하로 입력해주세요.");
        }
        user.setPassword(password);
    }


}
