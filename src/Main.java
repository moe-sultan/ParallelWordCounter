import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        File folder = new File("texts");
        File[] files = folder.listFiles();

        if (files != null) {
            TotalWordCounter totalCounter = new TotalWordCounter();
            ExecutorService executorService = Executors.newFixedThreadPool(files.length);
            
            for (File file : files) {
                if (file.getName().endsWith(".txt")) {
                    WordCountTask wordCount = new WordCountTask(file, totalCounter);

                    executorService.execute(wordCount);
                }
            }

            executorService.shutdown();
            while (!executorService.isTerminated()) {}

            System.out.println("Total words across all files: " + totalCounter.getTotal());
        } else {
            System.out.println("No files found in the folder.");
        }
        
    }
}
