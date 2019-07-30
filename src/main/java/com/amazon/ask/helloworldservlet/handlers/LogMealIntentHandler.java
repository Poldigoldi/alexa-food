/*
     Copyright 2018 Amazon.com, Inc. or its affiliates. All Rights Reserved.

     Licensed under the Apache License, Version 2.0 (the "License"). You may not use this file
     except in compliance with the License. A copy of the License is located at

         http://aws.amazon.com/apache2.0/

     or in the "license" file accompanying this file. This file is distributed on an "AS IS" BASIS,
     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for
     the specific language governing permissions and limitations under the License.
*/

package com.amazon.ask.helloworldservlet.handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.impl.IntentRequestHandler;
import com.amazon.ask.helloworldservlet.Database;
import com.amazon.ask.helloworldservlet.DrinkItem;
import com.amazon.ask.helloworldservlet.FoodItem;
import com.amazon.ask.model.IntentRequest;
import com.amazon.ask.model.Response;
import com.amazon.ask.request.RequestHelper;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Optional;

import static com.amazon.ask.request.Predicates.intentName;

public class LogMealIntentHandler implements IntentRequestHandler {

    //  Since this handler only needs to handle IntentRequest requests, it implement
    //  the typed request handler interface (IntentRequestHandler) instead
    //  of the generic interface (RequestHandler). This eliminates the need to
    //  retrieve the request, check its type, and cast to the correct type.

    @Override
    public boolean canHandle(HandlerInput handlerInput, IntentRequest intentRequest) {
        return handlerInput.matches(intentName("LogMealIntent"));
    }

    @Override
    public Optional<Response> handle(HandlerInput handlerInput, IntentRequest intentRequest) {
        // This handler greets the user by name if it was provided, otherwise
        // just do a generic Hello World response
        String speechText = "LogMealIntentHandler";
/*
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
            Optional<String> drinkValue = requestHelper.getSlotValue("drink");
            Optional<String> amount_foodValue = Optional.ofNullable(requestHelper.getSlot("amountFood")
                    .get()
                    .getResolutions()
                    .getResolutionsPerAuthority()
                    .get(0)
                    .getValues()
                    .get(0)
                    .getValue()
                    .getName());
            Optional<String> amount_drinkValue = Optional.ofNullable(requestHelper.getSlot("amountDrink")
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
            DrinkItem drinkItem = new DrinkItem(userIDValue, mealValue, drinkValue, amount_foodValue, timestamp);

            Database database = new Database("jdbc:mysql://localhost:3306/foodDiary?user=student");

            database.updateUsers(foodItem.getUserID());
            database.insertFoodItem(foodItem);
            database.insertDrinkItem(drinkItem);
            database.updateIntakeEvents(foodItem.getUserID(), Optional.of("Food/Drink"), timestamp.toString());

            speechText =
                    userIDValue.map(userID -> "User ID logged as " + userID + "! ")
                            .orElse("User ID was not defined. ").concat(
                            mealValue.map(meal -> "Meal type logged as " + meal + "! ")
                                    .orElse("Meal type was not defined. "))
                            .concat(foodValue.map(food -> "Food logged was " + food + "! ")
                                    .orElse("Food was not defined. "))
                            .concat(drinkValue.map(drink -> "Drink logged as " + drink + "! ")
                                    .orElse("Food was not defined. "))
                            .concat(amount_foodValue.map(amount -> "Food amount logged as " + amount + "! ")
                                    .orElse("Food amount was not defined. "))
                            .concat(amount_drinkValue.map(amount -> "Drink amount logged as " + amount + "! ")
                                    .orElse("Drink amount was not defined. "));

            database.disconnect();
        } catch (SQLException e) {
            speechText = "Oh, I'm sorry! There was a problem with logging your meal.";
            e.printStackTrace();
        }
*/
        return handlerInput.getResponseBuilder()
                .withSpeech(speechText)
                .build();
    }
}