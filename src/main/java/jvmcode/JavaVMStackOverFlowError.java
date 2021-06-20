package jvmcode;

public class JavaVMStackOverFlowError {

    private int stackLength = 1;

    public void stackLeak() {
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) {
        JavaVMStackOverFlowError stackOverFlowError = new JavaVMStackOverFlowError();
        try {
            stackOverFlowError.stackLeak();
        } catch (Throwable e) {
            System.out.println("stackLength:" + stackOverFlowError.stackLength);
            throw e;
        }
    }
}
