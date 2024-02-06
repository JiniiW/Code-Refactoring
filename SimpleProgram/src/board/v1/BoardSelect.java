package board.v1;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BoardSelect {
    static Connection conn = null;
    static Scanner in = new Scanner(System.in);
    static List<Board> boardList = new ArrayList<>();

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sqldb", "root", "1111");

            System.out.println("---모든 게시글 가져오기---");
            String sql = new StringBuilder().append("SELECT * FROM board1").toString();

            PreparedStatement pstmt = conn.prepareStatement(sql);

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()){
                Board board = new Board();
                board.setBno(rs.getInt("bno"));
                board.setBtitle(rs.getString("btitle"));
                board.setBcontent(rs.getString("bcontent"));
                board.setDate(rs.getDate("bdate"));

                boardList.add(board);
            }

            boardList.stream().forEach(System.out::println);

            rs.close();
            pstmt.close();



            System.out.println("\n---선택 게시글 가져오기---");


            String sql2 = new StringBuilder().append("SELECT * FROM board1").append(" WHERE bno = ?").toString();
            PreparedStatement pstmt2 = conn.prepareStatement(sql2);

            System.out.print("게시글 번호 : ");
            int bno = Integer.parseInt(in.nextLine());

            pstmt2.setInt(1, bno);

            ResultSet rs2 = pstmt2.executeQuery();

            if(rs2.next()){
                Board board = new Board();
                board.setBno(rs2.getInt("bno"));
                board.setBtitle(rs2.getString("btitle"));
                board.setBcontent(rs2.getString("bcontent"));
                board.setDate(rs2.getDate("bdate"));

                System.out.println(board);
            }

            rs2.close();
            pstmt2.close();

            conn.close();

        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
