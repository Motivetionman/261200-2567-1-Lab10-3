package com.teamrocket;

public class Lab10_3 {
    public static void main(String[] args) {
        // Create file handlers
        Handler textHandler = new TextFileHandler("Text Handler");
        Handler docHandler = new DocFileHandler("Doc Handler");
        Handler imageHandler = new ImageFileHandler("Image Handler");

        // Create the chain: Text -> Doc -> Image
        textHandler.setHandler(docHandler);
        docHandler.setHandler(imageHandler);

        // Test different file types
        File file1 = new File("OOP.txt", "text", "C:\\OOP");
        textHandler.process(file1); // Processed by Text Handler

        File file2 = new File("HelloWorld.jpg", "image", "C:\\");
        textHandler.process(file2); // Forwarded by Text -> Doc, Processed by Image Handler

        File file3 = new File("Report.doc", "doc", "C:\\Reports");
        textHandler.process(file3); // Forwarded by Text, Processed by Doc Handler

        File file4 = new File("Unknown.xyz", "xyz", "C:\\Unknown");
        textHandler.process(file4); // Unsupported file type
    }
}
