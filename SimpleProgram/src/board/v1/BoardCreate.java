package board.v1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class BoardCreate {
    static Connection conn = null;
    static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sqldb", "root", "1111");

            String sql = "INSERT INTO board1 VALUES (null, ?, ?, now())";

            PreparedStatement pstmt = conn.prepareStatement(sql);

            System.out.print("제목 : ");
            String title = in.nextLine();
            System.out.print("내용 : ");
            String content = in.nextLine();

            pstmt.setString(1, title);
            pstmt.setString(2, content);

            pstmt.execute(); //ja 쿼리는 꼭 실행하자!!!

            pstmt.close();
            conn.close();

            System.out.println("게시글이 추가");

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
