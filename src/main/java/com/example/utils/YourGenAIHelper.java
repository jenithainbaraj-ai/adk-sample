package com.example.utils;
import com.google.genai.Client;
import com.google.genai.types.GenerateContentResponse;

public class YourGenAIHelper {
    // Corrects grammar by calling Google Gemini
    public static String correctGrammar(String text) {
        try {
            // Create client — reads GOOGLE_API_KEY from environment
            Client client = Client.builder().apiKey("XXXXXXx").build();

            // Ask model to correct grammar
            GenerateContentResponse response = client.models.generateContent(
                    "gemini-2.5-flash",  // model name
                    "Correct the grammar:\n" + text,
                    null
            );

            // Return text result
            return response.text();

        } catch (Exception e) {
            System.out.println("exception ");
            return text +"not corrected";
        }
    }
}


