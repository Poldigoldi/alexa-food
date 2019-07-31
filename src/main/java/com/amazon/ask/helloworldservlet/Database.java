package com.amazon.ask.helloworldservlet;


import java.sql.*;
import java.util.Optional;

public class Database {
    private Connection c;
    private String connectionString;


    /*Connect immediately to database once it's constructed*/
    public Database(String connectionString) throws SQLException {
        this.connectionString = connectionString;
        //connect();
    }


    public void connect() throws SQLException {
        c = DriverManager.getConnection(connectionString);
    }

    public void disconnect() throws SQLException {
        c.close();
    }

    public void insertFoodItem(FoodItem foodItem) throws SQLException {
        String defaultString = "N/A";
        PreparedStatement s = c.prepareStatement(
                "INSERT INTO Foods (loggedBy, description, amount)" +
                        "VALUES (?, ?, ?)"
        );
        s.setInt(1, foodItem.getUserID());
        if (foodItem.getFood().isPresent()) {
            s.setString(2, foodItem.getFood().get());
        } else {
            s.setString(2, defaultString);
        }
        if (foodItem.getAmount_food().isPresent()) {
            s.setString(3, foodItem.getAmount_food().get());
        } else {
            s.setString(3, defaultString);
        }
        s.execute();
        s.close();
    }

    public void insertDrinkItem(DrinkItem drinkItem) throws SQLException {
        String defaultString = "N/A";
        PreparedStatement s = c.prepareStatement(
                "INSERT INTO Drinks (loggedBy, description, amount)" +
                        "VALUES (?, ?, ?)"
        );
        s.setInt(1, drinkItem.getUserID());
        if (drinkItem.getDrink().isPresent()) {
            s.setString(2, drinkItem.getDrink().get());
        } else {
            s.setString(2, defaultString);
        }
        if (drinkItem.getAmount_drink().isPresent()) {
            s.setString(3, drinkItem.getAmount_drink().get());
        } else {
            s.setString(3, defaultString);
        }
        s.execute();
        s.close();
    }

    public void updateIntakeEvents(int loggedBy, Optional<String> mealType, String loggedAt) throws SQLException {
        PreparedStatement s = c.prepareStatement(
                "INSERT INTO IntakeEvents (loggedBy, mealType, loggedAt)" +
                        "VALUES (?, ?, ?)"
        );
        s.setInt(1, loggedBy);
        s.setString(2, mealType.get());
        s.setString(3, loggedAt);
        s.execute();
        s.close();
    }

    public void updateUsers(int loggedBy) throws SQLException {
        PreparedStatement s = c.prepareStatement(
                "INSERT INTO Users (userID) VALUES (?)"
        );
        s.setInt(1, loggedBy);
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
