package com.teamrocket;

public interface Handler {
    void setHandler(Handler handler);
    void process(File file);
    String getHandlerName();
}
