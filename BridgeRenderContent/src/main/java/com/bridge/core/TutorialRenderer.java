package com.bridge.core;

public class TutorialRenderer extends ContentRenderer {
  
    public TutorialRenderer(Renderer renderer) {
        super(renderer);
    }

    @Override
    public String renderContent(String content) {
        // Adding tutorial-specific HTML before and after the content
        String tutorialHeader = "Tutorial:";
        String tutorialFooter = "End of Tutorial";
        
        // You could also add tutorial-specific styles or interactive elements here
        String tutorialContent = renderer.render(content);
        
        // Combine header, content, and footer
        return tutorialHeader + tutorialContent + tutorialFooter;
    }
}
