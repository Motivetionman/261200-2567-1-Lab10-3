package com.teamrocket;

public class ImageFileHandler implements Handler {
    private Handler nextHandler;
    private final String handlerName;

    public ImageFileHandler(String handlerName) {
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
        if (file.getFileType().equalsIgnoreCase("image")) {
            System.out.println("Processing IMAGE file by " + handlerName);
        } else if (nextHandler != null) { // Pass request to the next handler
            System.out.println(handlerName + " forwards request to " + nextHandler.getHandlerName());
            nextHandler.process(file);
        } else {
            System.out.println("File type not supported");
        }
    }
}
