import java.awt.*;
import java.awt.event.KeyEvent;

public class Tank {
    private int x,y;
    private Dir dir;
    private boolean bl,bu,br,bd;//四个键是否被按下去
    public static final int SPEED=5;
    private boolean moving=false;

    public Tank(int x, int y,Dir dir) {
        this.x = x;
        this.y = y;
        this.dir=dir;
    }


    public void paint(Graphics g) {
        g.fillRect(x,y,50,50);
        move();
    }
    public void keyPressed(KeyEvent e) {

        //1。按下的是哪个键 但是不会停
        int key = e.getKeyCode();
       /* switch (key) {
            case KeyEvent.VK_LEFT:
                dir = Dir.L;
                break;
            case KeyEvent.VK_UP:
                dir = Dir.U;
                break;
            case KeyEvent.VK_RIGHT:
                dir = Dir.R;
                break;
            case KeyEvent.VK_DOWN:
                dir = Dir.D;
                break;
        }*/
        //2。综合判断4个键
        switch (key) {
            case KeyEvent.VK_LEFT:
                bl = true;
                break;
            case KeyEvent.VK_UP:
                bu= true;
                break;
            case KeyEvent.VK_RIGHT:
                br = true;
                break;
            case KeyEvent.VK_DOWN:
                bd= true;
                break;
        }
        setMainDir();
    }

    private void setMainDir() {
        //都没有被按下去时是STOP
        //何时停
        //all dir keys are released,
        if(!bl&&!bu&&!br&&!bd)
        {
            moving=false;
        }
        else {

            moving = true;

            if (bl && !bu && !br && !bd)//只按下朝左的时候朝左
            {
                dir = Dir.L;
            }
            if (!bl && !bu && br && !bd) {
                dir = Dir.R;
            }
            if (!bl && !bu && !br && bd) {
                dir = Dir.D;
            }
            if (!bl && bu && !br && !bd) {
                dir = Dir.U;
            }
        }
    }

    private void move() {
        /*switch (dir)
        {
            case L:
                x-=SPEED;break;
            case U:
                y-=SPEED;break;
            case R:
                x+=SPEED;break;
            case D:
                y+=SPEED;break;
        }*/
        if (!moving) return;
        switch (dir)
        {
            case L:
                x-=SPEED;break;
            case U:
                y-=SPEED;break;
            case R:
                x+=SPEED;break;
            case D:
                y+=SPEED;break;
        }

    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        switch (key) {
            case KeyEvent.VK_LEFT:
                bl = false;
                break;
            case KeyEvent.VK_UP:
                bu= false;
                break;
            case KeyEvent.VK_RIGHT:
                br = false;
                break;
            case KeyEvent.VK_DOWN:
                bd= false;
                break;
        }
        setMainDir();
    }
}
