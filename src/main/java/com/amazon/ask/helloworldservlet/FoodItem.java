package com.amazon.ask.helloworldservlet;

import java.sql.Timestamp;
import java.util.Optional;

public class FoodItem {
    private Optional<String> meal, food, amount_food;
    private int eventId;
    private Timestamp loggedAt;

    public Optional<String> getMeal() {
        return meal;
    }

    public Optional<String> getFood() {
        return food;
    }

    public Optional<String> getAmount_food() {
        return amount_food;
    }

    public int getEventId() {
        return eventId;
    }

    public Timestamp getLoggedAt() {
        return loggedAt;
    }

    public FoodItem(Optional<String> meal, Optional<String> food, Optional<String> amount_food, int eventId, Timestamp loggedAt) {
        this.meal = meal;
        this.food = food;
        this.amount_food = amount_food;
        this.eventId = eventId;
        this.loggedAt = loggedAt;
    }
}
