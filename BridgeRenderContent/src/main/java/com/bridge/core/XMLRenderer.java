package com.bridge.core;

public class XMLRenderer implements Renderer {
    @Override
    public String render(String content) {
        // Simple XML implementation for demonstration
        return "<content>" + escapeXml(content) + "</content>";
    }

    // Utility method to escape XML special characters in the content
    private String escapeXml(String content) {
        return content.replace("&", "&amp;")
                      .replace("<", "&lt;")
                      .replace(">", "&gt;")
                      .replace("\"", "&quot;")
                      .replace("'", "&apos;");
    }
}

