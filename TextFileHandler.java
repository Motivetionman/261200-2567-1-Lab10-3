package com.teamrocket;

public class TextFileHandler implements Handler {
    private Handler nextHandler;
    private final String handlerName;

    public TextFileHandler(String handlerName) {
        this.handlerName = handlerName;
    }

    @Override
    public void setHandler(Handler handler) {
        this.nextHandler = handler;
    }

    @Override
    public String getHandlerName() {
        return handlerName;
    }

    @Override
    public void process(File file) {
        if (file.getFileType().equalsIgnoreCase("text")) {
            System.out.println("Processing TEXT file by " + handlerName);
        } else if (nextHandler != null) { // Pass request to the next handler
            System.out.println(handlerName + " forwards request to " + nextHandler.getHandlerName());
            nextHandler.process(file);
        } else {
            System.out.println("File type not supported");
        }
    }
}
