import java.io.File;

public class Main {
    public static void main(String[] args) {
        File folder = new File("texts");
        File[] files = folder.listFiles();

        int totalWordCount = 0;

        if (files != null) {
            for (File file : files) {
                if (file.getName().endsWith(".txt")) {
                    WordCounter counter = new WordCounter(file);
                    int wordCount = counter.countWords();
                    System.out.println(counter.getFilename() + " — " + wordCount + " words");
                    totalWordCount += wordCount;
                }
            }
        }

        System.out.println("Total words across all files: " + totalWordCount);
    }
}
