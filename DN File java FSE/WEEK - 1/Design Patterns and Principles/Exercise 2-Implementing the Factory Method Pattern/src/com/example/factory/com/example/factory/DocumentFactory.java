package com.example.factory;

// abstract factory class - this is the heart of the Factory Method pattern
// each subclass decides which actual Document object to create
public abstract class DocumentFactory {

    // the factory method - subclasses will override this
    public abstract Document createDocument();

    // this method is common for every factory, it uses createDocument()
    // without knowing which exact document type it's dealing with
    public Document getDocument() {
        Document document = createDocument();
        document.open();
        return document;
    }
}