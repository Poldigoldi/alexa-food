package com.amazon.ask.helloworldservlet.handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.impl.IntentRequestHandler;
import com.amazon.ask.helloworldservlet.Database;
import com.amazon.ask.helloworldservlet.FoodItem;
import com.amazon.ask.model.IntentRequest;
import com.amazon.ask.model.Response;
import com.amazon.ask.request.RequestHelper;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Optional;

import static com.amazon.ask.request.Predicates.intentName;

public class LogFoodIntentHandler implements IntentRequestHandler {

    //  Since this handler only needs to handle IntentRequest requests, it implement
    //  the typed request handler interface (IntentRequestHandler) instead
    //  of the generic interface (RequestHandler). This eliminates the need to
    //  retrieve the request, check its type, and cast to the correct type.

    @Override
    public boolean canHandle(HandlerInput handlerInput, IntentRequest intentRequest) {
        return handlerInput.matches(intentName("LogFoodIntent"));
    }

    @Override
    public Optional<Response> handle(HandlerInput handlerInput, IntentRequest intentRequest) {
        // This handler greets the user by name if it was provided, otherwise
        // just do a generic Hello World response
        String speechText;

        try {
            RequestHelper requestHelper = RequestHelper.forHandlerInput(handlerInput);

            // Use a helper method to get the slot value wrapped in an Optional.
            Optional<String> userIDValue = requestHelper.getSlotValue("userID");

            Optional<String> mealValue = Optional.ofNullable(requestHelper.getSlot("meal")
                    .get()
                    .getResolutions()
                    .getResolutionsPerAuthority()
                    .get(0)
                    .getValues()
                    .get(0)
                    .getValue()
                    .getName());
            Optional<String> foodValue = requestHelper.getSlotValue("food");
            Optional<String> amount_foodValue = Optional.ofNullable(requestHelper.getSlot("amount_food")
                    .get()
                    .getResolutions()
                    .getResolutionsPerAuthority()
                    .get(0)
                    .getValues()
                    .get(0)
                    .getValue()
                    .getName());

            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            FoodItem foodItem = new FoodItem(userIDValue, mealValue, foodValue, amount_foodValue, timestamp);

            Database database = new Database("jdbc:mysql://localhost:3306/foodDiary?user=student");

            database.connect();
            database.updateUsers(foodItem.getUserID());
            database.insertFoodItem(foodItem);
            database.updateIntakeEvents(foodItem.getUserID(), Optional.of("Food"), timestamp.toString());

            speechText =
                    userIDValue.map(userID -> "User ID logged as " + userID + "! ")
                            .orElse("User ID was not defined. ").concat(
                    mealValue.map(meal -> "Meal type logged as " + meal + "! ")
                            .orElse("Meal type was not defined. "))
                    .concat(foodValue.map(food -> "Food logged was " + food + "! ")
                            .orElse("Food was not defined. "))
                    .concat(amount_foodValue.map(amount -> "Amount logged as " + amount + "! ")
                            .orElse("Amount was not defined. "));

            database.disconnect();
        } catch (SQLException e) {
            speechText = "Oh, I'm sorry! There was a problem with logging your food item.";
            e.printStackTrace();
        }

        return handlerInput.getResponseBuilder()
                .withSpeech(speechText)
                .build();
    }
}