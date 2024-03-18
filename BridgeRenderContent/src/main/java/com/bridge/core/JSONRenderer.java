package com.bridge.core;
import org.json.JSONObject;

public class JSONRenderer implements Renderer {
    @Override
    public String render(String content) {
    	JSONObject json = new JSONObject();
        json.put("content", content);
        return json.toString();
    }
}
