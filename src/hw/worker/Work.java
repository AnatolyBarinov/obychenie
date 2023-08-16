package hw.worker;

public class Work {

    private final OnTaskDoneListener cb;
    private final OnTaskError error;

    public Work(OnTaskDoneListener callback, OnTaskError errorCallback) {
        this.cb = callback;
        this.error = errorCallback;
    }

    public void start() {
        for (int i = 0; i < 100; i++) {
            if (i == 33){
                this.error.onError("Task " + i + " Это очень печально!");
                continue;
            }
            this.cb.onDone("Task " + i + " is done");
        }
    }
}