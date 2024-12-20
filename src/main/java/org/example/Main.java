package org.example;

import java.sql.*;

public class Main {
    public static void main(String[] args) {

        String mutateQuery = "INSERT INTO users (id, username) VALUES (?, ?)";

        try{
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/JDBCPractice", "postgres", "KoushiK11@");
            Statement stmt = con.createStatement();
            // for table creation
//            stmt.executeQuery("CREATE TABLE IF NOT EXISTS users(id int primary key unique not null, username varchar(255))");
//            stmt.close();

            // for mutate/update the table
//            PreparedStatement pstmt = con.prepareStatement(mutateQuery);
//            pstmt.setInt(1, 2);
//            pstmt.setString(2, "Sai Teja");
//            pstmt.executeUpdate();

//            pstmt.setInt(1, 2);
//            pstmt.setString(2, "Sai Teja");
//            pstmt.executeUpdate();

            ResultSet rs = stmt.executeQuery("SELECT * FROM users");



            while(rs.next()){
                System.out.println(rs.getString("username"));
            }

            rs.close();
            stmt.close();
//            pstmt.close();
            con.close();

        }catch (Exception e){
            System.out.println(e);
        }
    }
}