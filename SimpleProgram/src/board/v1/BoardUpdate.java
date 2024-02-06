package board.v1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class BoardUpdate {
    static Connection conn = null;
    static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sqldb", "root", "1111");

            String sql = new StringBuilder().append("UPDATE board1 SET ")
                    .append("btitle = ?,")
                    .append("bcontent = ?")
                    .append("WHERE bno = ?").toString();

            PreparedStatement pstmt = conn.prepareStatement(sql);

            System.out.print("수정할 게시글 번호 : ");
            int bno = Integer.parseInt(in.nextLine());
            System.out.print("수정할 제목 : ");
            String title = in.nextLine();
            System.out.print("수정할 내용 : ");
            String content = in.nextLine();

            pstmt.setString(1, title);
            pstmt.setString(2, content);
            pstmt.setInt(3, bno);

            pstmt.execute();

            System.out.println("게시글 수정");

            pstmt.close();
            conn.close();

        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
