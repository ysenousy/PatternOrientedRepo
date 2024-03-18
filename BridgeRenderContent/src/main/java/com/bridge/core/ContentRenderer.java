package com.bridge.core;

public abstract class ContentRenderer {
    protected Renderer renderer;

    public ContentRenderer(Renderer renderer) {
        this.renderer = renderer;
    }

    public abstract String renderContent(String content);
}
