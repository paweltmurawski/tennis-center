package com.tennis.utils;

import java.util.ArrayList;
import java.util.List;

public class UserSatisfactionQuestionnaire {
    private String username;
    private int rating;
    private List<String> improvementSuggestions;

    public static class UserSatisfactionQuestionnaireBuilder {
        private String username;
        private int rating;
        private List<String> improvementSuggestions = new ArrayList<>();


        public UserSatisfactionQuestionnaireBuilder username(String username) {
            this.username = username;
            return this;
        }

        public UserSatisfactionQuestionnaireBuilder rating(int rating) {
            this.rating = rating;
            return this;
        }

        public UserSatisfactionQuestionnaireBuilder improvementSuggestion(String improvementSuggestion) {
            improvementSuggestions.add(improvementSuggestion);
            return this;
        }

        public UserSatisfactionQuestionnaire build() {
            return new UserSatisfactionQuestionnaire(username, rating, improvementSuggestions);
        }
    }

    private UserSatisfactionQuestionnaire(String username, int rating, List<String> improvementSuggestions) {
        this.username = username;
        this.rating = rating;
        this.improvementSuggestions = improvementSuggestions;
    }

    public String getUsername() {
        return username;
    }

    public int getRating() {
        return rating;
    }

    public List<String> getImprovementSuggestions() {
        return improvementSuggestions;
    }

    @Override
    public String toString() {
        return "Username: " + username + '\'' +
                ", gives rating'" + rating + '\'' +
                ", he made few improvement Suggestions=" + improvementSuggestions;
    }
}
