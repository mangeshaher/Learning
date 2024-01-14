public class PrintInOrderSynchronizedMethod {
    private boolean oneDone = false;
    private boolean twoDone = false;
    private synchronized void one(){
        System.out.println("In first");
        oneDone = true;
        notifyAll();
    }

    private synchronized void two() throws InterruptedException {
        while(!oneDone){
            wait();
        }
        System.out.println("In second");
        twoDone = true;
        notifyAll();
    }

    private synchronized void third() throws InterruptedException {
        while(!twoDone){
            wait();
        }
        System.out.println("In third");
    }

    public static void main(String[] args) throws InterruptedException {
        PrintInOrderSynchronizedMethod printInOrder = new PrintInOrderSynchronizedMethod();
        Thread t1 = new Thread(() -> printInOrder.one());
        Thread t2 = new Thread(() -> {
            try {
                printInOrder.two();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread t3 = new Thread(() -> {
            try {
                printInOrder.third();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        t3.start();
        t2.start();
        t1.start();

        t1.join();
        t2.join();
        t3.join();
    }

}
