package com.amazon.ask.helloworldservlet;

import java.sql.Timestamp;
import java.util.Optional;

public class DrinkItem {
    private Optional<String> userID, meal, drink, amount_drink;
    private Timestamp loggedAt;

    public int getUserID() {
        return Integer.parseInt(userID.get());
    }

    public Optional<String> getDrink() {
        return drink;
    }

    public Optional<String> getAmount_drink() {
        return amount_drink;
    }

    public DrinkItem(Optional<String> userID, Optional<String> meal, Optional<String> drink, Optional<String> amount_drink, Timestamp loggedAt) {
        this.userID = userID;
        this.meal = meal;
        this.drink = drink;
        this.amount_drink = amount_drink;
        this.loggedAt = loggedAt;
    }
}
