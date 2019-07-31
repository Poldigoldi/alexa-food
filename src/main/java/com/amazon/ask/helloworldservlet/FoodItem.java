package com.amazon.ask.helloworldservlet;

import java.sql.Timestamp;
import java.util.Optional;

public class FoodItem {
    private Optional<String> userID, meal, food, amount_food;
    private Timestamp loggedAt;

    public int getUserID() {
        return Integer.parseInt(userID.get());
    }

    public Optional<String> getMeal() {
        return meal;
    }

    public Optional<String> getFood() {
        return food;
    }

    public Optional<String> getAmount_food() {
        return amount_food;
    }

    public Timestamp getLoggedAt() {
        return loggedAt;
    }

    public FoodItem(Optional<String> userID, Optional<String> meal, Optional<String> food, Optional<String> amount_food, Timestamp loggedAt) {
        this.userID = userID;
        this.meal = meal;
        this.food = food;
        this.amount_food = amount_food;
        this.loggedAt = loggedAt;
    }
}
