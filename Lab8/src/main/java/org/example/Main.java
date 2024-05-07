package org.example;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        try {
            AuthorDAO DAO = new AuthorDAO();
            DAO.create("Avram", "Iancu");
            DAO.create("abcd", "Iancu");

            Integer authorId = DAO.findByName("Avram");
            if (authorId != null) {
                System.out.println("Author ID: " + authorId);
            }

            String authorName = DAO.findById(authorId);
            if (authorName != null) {
                System.out.println("Author Found: " + authorName);
            }

            Database.getConnection().commit();
        } catch (SQLException e) {
            System.err.println("Database error: " + e.getMessage());
            Database.rollback();
        } finally {
            Database.closeConnection();
        }
    }
}
