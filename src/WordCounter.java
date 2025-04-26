import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class WordCounter {
    private final File file;

    public WordCounter(File file) {
        this.file = file;
    }

    public int countWords() {
        try {
            String content = Files.readString(file.toPath());
            String[] words = content.trim().split("\\s+");
            return words.length;
        } catch (IOException e) {
            System.out.println("Error reading file: " + file.getName());
            return 0;
        }
    }

    public String getFilename() {
        return file.getName();
    }
}
