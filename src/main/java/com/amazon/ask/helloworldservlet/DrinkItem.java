package com.amazon.ask.helloworldservlet;

import java.sql.Timestamp;
import java.util.Optional;

public class DrinkItem {
    private Optional<String> meal, drink, amount_drink;
    private int eventId;
    private Timestamp loggedAt;

    public Optional<String> getMeal() {
        return meal;
    }

    public Optional<String> getDrink() {
        return drink;
    }

    public Optional<String> getAmount_drink() {
        return amount_drink;
    }

    public int getEventId() {
        return eventId;
    }

    public Timestamp getLoggedAt() {
        return loggedAt;
    }

    public DrinkItem(Optional<String> meal, Optional<String> drink, Optional<String> amount_drink, int eventId, Timestamp loggedAt) {
        this.meal = meal;
        this.drink = drink;
        this.amount_drink = amount_drink;
        this.eventId = eventId;
        this.loggedAt = loggedAt;
    }
}