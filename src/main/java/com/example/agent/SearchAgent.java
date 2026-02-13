package com.example.agent;

import com.google.adk.agents.BaseAgent;
import com.google.adk.agents.LlmAgent;
import com.google.adk.tools.Annotations.Schema;
import com.google.adk.tools.FunctionTool;

import java.util.Map;

public class SearchAgent {

    public static BaseAgent ROOT_AGENT = initAgent();

    private static BaseAgent initAgent() {
        return LlmAgent.builder()
                .name("search-agent")
                .description("Performs web searches and returns top results")
                .instruction("""
                        You are a helpful assistant that searches the web.
                        Use the 'performSearch' tool to return top search results.
                        """)
                .model("gemini-2.5-flash")
                .tools(FunctionTool.create(SearchAgent.class, "performSearch"))
                .build();
    }

    /** Mock search tool */
    @Schema(description = "Perform a search and return top results")
    public static Map<String, String> performSearch(
            @Schema(name = "query", description = "Search query") String query) {

        // Should be replaced with any docbase/GenAI/wiki/Jira ......
        String result = "Top search results for '" + query + "':\\n" +
                "1. Example result 1\\n" +
                "2. Example result 2\\n" +
                "3. Example result 3";

        return Map.of(
                "query", query,
                "results", result
        );
    }
}


