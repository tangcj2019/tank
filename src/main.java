import java.util.concurrent.TimeUnit;

public class main {
    public static void main(String[] args) {
        tankFrame tf = new tankFrame();
        tf.setVisible(true);
        //
        for (; ; ) {
            try {
                 Thread.sleep(25);
               // TimeUnit.MICROSECONDS.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            tf.repaint();

        }
    }
}
//repaint->update->paint
