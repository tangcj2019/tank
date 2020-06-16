import javax.crypto.KeyAgreement;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class tankFrame extends Frame {
    private Tank myTank;
    private Tank enemy;


    public tankFrame()
    {
        this.setTitle("tank war");
        this.setLocation(400,200);
        this.setSize(800,600);//大小 显示出来

        myTank=new Tank(100,100,Dir.R);
        enemy=new Tank(200,200,Dir.D);
        //内部类
        this.addKeyListener(new TankKeyListener());
    }

    //画笔
    @Override
    public void paint(Graphics g) {
        //super.paint(g);
        myTank.paint(g);
        enemy.paint(g);

        //


    }
    //不是适配器模式 可以选择

    private class TankKeyListener extends KeyAdapter {
        //键盘按下去
        @Override
        public void keyPressed(KeyEvent e) {
          //  super.keyPressed(e);
            myTank.keyPressed(e);
        }
       //键盘抬起
        @Override
        public void keyReleased(KeyEvent e) {
           // super.keyReleased(e);
            myTank.keyReleased(e);
        }

    }
}
