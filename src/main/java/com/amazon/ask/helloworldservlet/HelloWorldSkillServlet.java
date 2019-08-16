package com.amazon.ask.helloworldservlet;

import com.amazon.ask.Skill;
import com.amazon.ask.Skills;
import com.amazon.ask.helloworldservlet.handlers.*;
import com.amazon.ask.servlet.SkillServlet;

public class HelloWorldSkillServlet extends SkillServlet {

    public HelloWorldSkillServlet() {
        super(getSkill());
    }

    private static Skill getSkill() {
        return Skills.standard()
                .addRequestHandlers(
                        new CancelandStopIntentHandler(),
                        new HelpIntentHandler(),
                        new LaunchRequestHandler(),
                        new LogFoodIntentHandler(),
                        new LogDrinkIntentHandler(),
                        new LogMealIntentHandler(),
                        new FallbackIntentHandler())
                        //new DeleteLastEntryIntent()
                        //new SessionEndedRequestHandler())
                .withSkillId("amzn1.ask.skill.8eaf479a-f394-4f6f-a138-e6642db0b299")
                .build();
    }

}
