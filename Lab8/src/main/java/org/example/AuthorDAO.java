package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthorDAO {
    public void create(String name, String surname) throws SQLException {
        Connection con = Database.getConnection();
        System.out.println(con);
        try (PreparedStatement pstmt = con.prepareStatement("INSERT INTO author (name, surname) VALUES (?, ?)")) {
            pstmt.setString(1, name);
            pstmt.setString(2, surname);
            pstmt.executeUpdate();
        }
    }

    public Integer findByName(String name) throws SQLException {
        Connection con = Database.getConnection();
        try (PreparedStatement stmt = con.prepareStatement("SELECT author_id FROM author WHERE name = ?")) {
            stmt.setString(1, name);
            ResultSet rs = stmt.executeQuery();
            return rs.next() ? rs.getInt("author_id") : null;
        }
    }

    public String findById(int id) throws SQLException {
        Connection con = Database.getConnection();
        try (PreparedStatement pstmt = con.prepareStatement("SELECT name, surname FROM author WHERE author_id = ?")) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getString("name") + " " + rs.getString("surname");
            }
            return null;
        }
    }
}
