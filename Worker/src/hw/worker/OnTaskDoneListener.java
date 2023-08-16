package hw.worker;

@FunctionalInterface
public interface OnTaskDoneListener {

    void onDone(String result);
}