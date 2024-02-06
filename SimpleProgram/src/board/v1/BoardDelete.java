package board.v1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class BoardDelete {
    static Connection conn = null;
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sqldb", "root", "1111");

            String sql = new StringBuilder("DELETE FROM board1").append(" WHERE bno = ?").toString();

            PreparedStatement pstmt = conn.prepareStatement(sql);

            System.out.print("삭제할 게시글 번호 입력 : ");
            int bno = Integer.parseInt(in.nextLine());

            pstmt.setInt(1, bno);

            pstmt.execute();

            System.out.println("게시글 삭제");

            pstmt.close();
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
