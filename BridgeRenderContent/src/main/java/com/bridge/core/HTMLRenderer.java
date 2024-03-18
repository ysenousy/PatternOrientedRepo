package com.bridge.core;

public class HTMLRenderer implements Renderer {
    @Override
    public String render(String content) {
        // Simple HTML implementation for demonstration
        // Wrapping the content in paragraph tags as an example
        return "<p>" + escapeHtml(content) + "</p>";
    }

    // Utility method to escape HTML special characters in the content
    private String escapeHtml(String content) {
        return content.replace("&", "&amp;")
                      .replace("<", "&lt;")
                      .replace(">", "&gt;")
                      .replace("\"", "&quot;")
                      .replace("'", "&#39;");
    }
}
