package com.example.agent;

import com.google.adk.agents.BaseAgent;
import com.google.adk.agents.LlmAgent;
import com.google.adk.tools.Annotations.Schema;
import com.google.adk.tools.FunctionTool;

import java.util.Map;

public class GrammarAgent {

    public static BaseAgent ROOT_AGENT = initAgent();

    private static BaseAgent initAgent() {
        return LlmAgent.builder()
                .name("grammar-agent")
                .description("Corrects grammar in the provided text")
                .instruction("""
                        You are a helpful assistant that corrects grammar.
                        Use the 'correctGrammar' tool to fix any grammatical errors.
                        """)
                .model("gemini-2.5-flash")
                .tools(FunctionTool.create(GrammarAgent.class, "correctGrammar"))
                .build();
    }

    /** Tool that corrects grammar (mock implementation) */
    @Schema(description = "Corrects grammar for the provided text")
    public static Map<String, String> correctGrammar(
            @Schema(name = "text", description = "Text to correct") String text) {
        // Simple mock grammar correction . Should be replaced with customized grammar correction/Genai
        String corrected = text.replaceAll("\\bteh\\b", "the")
                .replaceAll("\\brecieved\\b", "received");
        return Map.of(
                "original", text,
                "corrected", corrected
        );
    }
}


