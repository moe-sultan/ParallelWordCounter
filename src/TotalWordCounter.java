public class TotalWordCounter {
    private int total = 0;

    public synchronized void add(int count) {
        total += count;
    }

    public int getTotal() {
        return total;
    }
}