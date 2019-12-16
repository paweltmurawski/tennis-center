package com.tennis.utils;

import org.junit.Assert;
import org.junit.Test;

public class UserSatisfactionQuestionnaireTest {

    @Test
    public void testUserSatisfactionQuestionnaire() {
        //Given
        UserSatisfactionQuestionnaire userSatisfactionQuestionnaire = new UserSatisfactionQuestionnaire.UserSatisfactionQuestionnaireBuilder()
                .username("Paul")
                .rating(7)
                .improvementSuggestion("add sms with information about order")
                .improvementSuggestion("make promotions for regular customer")
                .improvementSuggestion("add add more delivery methods")
                .build();

        //When
        int howManyImprovementSuggestions = userSatisfactionQuestionnaire.getImprovementSuggestions().size();
        //Then
        Assert.assertEquals(3, howManyImprovementSuggestions);
    }
}
