import java.io.File;

public class WordCountTask implements Runnable{
    private final File file;
    private final TotalWordCounter totalCounter;

    public WordCountTask(File file, TotalWordCounter totalCounter){
        this.file = file;
        this.totalCounter = totalCounter;
    }

    public synchronized void run(){
        WordCounter counter = new WordCounter(file);
        int wordCount = counter.countWords();
        System.out.println(counter.getFilename() + " — " + wordCount + " words");
        totalCounter.add(wordCount);
    }
}
