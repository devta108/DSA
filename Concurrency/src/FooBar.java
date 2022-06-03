public class FooBar implements Runnable{
    private int n;
    private boolean isFooPrinted = false;
    private boolean isBarPrinted = true;

    public FooBar(int n){
        this.n = n;
    }
    public void foo(Runnable printFoo) throws InterruptedException{
        for (int i = 0; i < n; i++) {
            synchronized (this) {
                if (!isBarPrinted) {
                    wait();
                }

                System.out.print("foo");
                isBarPrinted = false;
                isFooPrinted = true;
                notifyAll();
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException{
        for (int i = 0; i < n; i++) {
            synchronized (this){
                if(!isFooPrinted){
                    wait();
                }
                System.out.print("bar");
                isBarPrinted = true;
                isFooPrinted = false;
                notifyAll();
            }
        }
    }

    @Override
    public void run() {

    }

//    public static void main(String[] args) {
////        Thread t1 = new Thread()
//    }
}
