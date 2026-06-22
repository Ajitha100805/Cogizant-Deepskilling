public class FactoryMethodTest {

    interface Document {
        void open();
    }

    static class WordDocument implements Document {
        public void open() {
            System.out.println("Opening Word Document");
        }
    }

    static class PdfDocument implements Document {
        public void open() {
            System.out.println("Opening PDF Document");
        }
    }

    static class ExcelDocument implements Document {
        public void open() {
            System.out.println("Opening Excel Document");
        }
    }

    static abstract class DocumentFactory {
        abstract Document createDocument();
    }

    static class WordFactory extends DocumentFactory {
        Document createDocument() {
            return new WordDocument();
        }
    }

    static class PdfFactory extends DocumentFactory {
        Document createDocument() {
            return new PdfDocument();
        }
    }

    static class ExcelFactory extends DocumentFactory {
        Document createDocument() {
            return new ExcelDocument();
        }
    }

    public static void main(String[] args) {

        DocumentFactory wordFactory = new WordFactory();
        wordFactory.createDocument().open();

        DocumentFactory pdfFactory = new PdfFactory();
        pdfFactory.createDocument().open();

        DocumentFactory excelFactory = new ExcelFactory();
        excelFactory.createDocument().open();
    }
}