package exception.originalcode;

import java.util.Scanner;

public class Login {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Login login = new Login();
        try {
            System.out.print("아이디를 입력해주세요 : ");
            String id = input.next();
            login.checkId(id);
            System.out.print("비밀번호를 입력해주세요 : ");
            String password = input.next();
            login.checkPassword(password);
            System.out.println(user.getId() + "님 로그인 되셨습니다.");
        } catch (NotExitIdPasswordException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("예외가 발생했습니다.");
        }
    }

    static User user = new User("admin1", "admin1234!");

    public void checkId(String id) throws NotExitIdPasswordException {
        if (id == null) {
            throw new NotExitIdPasswordException("아이디를 입력해주세요");
        } else if (!id.equals(user.getId())) {
            throw new NotExitIdPasswordException("아이디가 일치하지 않습니다.");
        }
    }
    public void checkPassword(String password) throws NotExitIdPasswordException {
        if (password == null) {
            throw new NotExitIdPasswordException("비밀번호를 입력해주세요");
        } else if (!password.equals(user.getPassword())) {
            throw new NotExitIdPasswordException("비밀번호가 일치하지 않습니다.");
        }
    }

}
