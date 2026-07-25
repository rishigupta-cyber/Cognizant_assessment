package com.example.factory;

// test class to show how different document types are created
// using their respective factories, without the client code needing
// to know the concrete class being instantiated
public class FactoryMethodTest {

    public static void main(String[] args) {

        System.out.println("---- Creating a Word Document ----");
        DocumentFactory wordFactory = new WordDocumentFactory();
        Document wordDoc = wordFactory.getDocument();
        wordDoc.save();

        System.out.println("\n---- Creating a PDF Document ----");
        DocumentFactory pdfFactory = new PdfDocumentFactory();
        Document pdfDoc = pdfFactory.getDocument();
        pdfDoc.save();

        System.out.println("\n---- Creating an Excel Document ----");
        DocumentFactory excelFactory = new ExcelDocumentFactory();
        Document excelDoc = excelFactory.getDocument();
        excelDoc.save();

        System.out.println("\n---- Choosing factory dynamically ----");
        // this shows the real benefit of the pattern - client code just
        // depends on DocumentFactory / Document, not on concrete classes
        String type = "pdf";
        DocumentFactory factory = getFactoryByType(type);
        Document doc = factory.getDocument();
        doc.save();
    }

    // simple helper to pick the right factory based on a string
    // (in a real app this could come from user input or config)
    private static DocumentFactory getFactoryByType(String type) {
        switch (type.toLowerCase()) {
            case "word":
                return new WordDocumentFactory();
            case "pdf":
                return new PdfDocumentFactory();
            case "excel":
                return new ExcelDocumentFactory();
            default:
                throw new IllegalArgumentException("Unknown document type: " + type);
        }
    }
}