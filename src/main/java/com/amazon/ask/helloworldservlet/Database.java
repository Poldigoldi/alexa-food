package com.amazon.ask.helloworldservlet;


import java.sql.*;

public class Database {
    private Connection c;
    private String connectionString;


    /*Connect immediately to database once it's constructed*/
    public Database(String connectionString) throws SQLException {
        this.connectionString = connectionString;
        connect();
    }

    void connect() throws SQLException {
        c = DriverManager.getConnection(connectionString);
    }

    public void disconnect() throws SQLException {
        c.close();
    }

    public void insertFoodItem(FoodItem foodItem) throws SQLException {
        String defaultString = "N/A";
        PreparedStatement s = c.prepareStatement(
                "INSERT INTO foodDiary (userID, meal, food, drink, amount)" +
                        "VALUES (?, ?, ?, ? ,?)"
        );
        if (foodItem.getUserID().isPresent()) {
            s.setString(1, foodItem.getUserID().get());
        } else {
            s.setString(1, defaultString);
        }
        if (foodItem.getMeal().isPresent()) {
            s.setString(2, foodItem.getMeal().get());
        } else {
            s.setString(2, defaultString);
        }
        if (foodItem.getFood().isPresent()) {
            s.setString(3, foodItem.getFood().get());
        } else {
            s.setString(3, defaultString);
        }
        if (foodItem.getDrink().isPresent()) {
            s.setString(4, foodItem.getDrink().get());
        } else {
            s.setString(4, defaultString);
        }
        if (foodItem.getAmount().isPresent()) {
            s.setString(5, foodItem.getAmount().get());
        } else {
            s.setString(5, defaultString);
        }
        s.execute();
        s.close();
    }

    public void deleteLastEntry(String userID) throws SQLException {
        PreparedStatement s = c.prepareStatement(
                "DELETE FROM foodDiary WHERE userID = ? ORDER BY id DESC LIMIT 1"
        );
        s.setString(1, userID);
        s.execute();
        s.close();
    }
}
