package com.amazon.ask.helloworldservlet;

import java.sql.Timestamp;
import java.util.Optional;

public class FoodItem {
    private Optional<String> userID, meal, food, drink, amount;
    private Timestamp loggedAt;

    public Optional<String> getUserID() {
        return userID;
    }

    public Optional<String> getMeal() {
        return meal;
    }

    public Optional<String> getFood() {
        return food;
    }

    public Optional<String> getDrink() {
        return drink;
    }

    public Optional<String> getAmount() {
        return amount;
    }

    public Timestamp getLoggedAt() {
        return loggedAt;
    }

    public FoodItem(Optional<String> userID, Optional<String> meal, Optional<String> food, Optional<String> drink, Optional<String> amount, Timestamp loggedAt) {
        this.userID = userID;
        this.meal = meal;
        this.food = food;
        this.drink = drink;
        this.amount = amount;
        this.loggedAt = loggedAt;
    }
}
