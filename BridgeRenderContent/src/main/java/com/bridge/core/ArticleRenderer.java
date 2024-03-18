package com.bridge.core;

public class ArticleRenderer extends ContentRenderer {
    public ArticleRenderer(Renderer renderer) {
        super(renderer);
    }

    @Override
    public String renderContent(String content) {
    	// Adding article-specific HTML before and after the content
        String articleHeader = "Article:";
        String articleFooter = "End of Article";
        
        // You could also include article-specific styles or scripts here
        String articleContent = renderer.render(content);
        
        // Combine header, content, and footer
        return articleHeader + articleContent + articleFooter;
    }
}
