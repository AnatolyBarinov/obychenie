import hw.worker.Work;

import hw.worker.OnTaskDoneListener;
import hw.worker.OnTaskError;

public class Main {
    public static void main(String[] args) {

        OnTaskDoneListener listener = System.out::println;
        OnTaskError errorListener = System.out::println;

        Work worker = new Work(listener, errorListener);

        worker.start();
    }
}