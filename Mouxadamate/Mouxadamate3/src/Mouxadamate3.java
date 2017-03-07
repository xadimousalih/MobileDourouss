/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;


/**
 * @author xadimousalih
 */
public class Mouxadamate3 extends MIDlet {

    private Display display;

    public void startApp() {
        display = Display.getDisplay(this);
        display.setCurrent(new IconsCanvas());
    }

    public void pauseApp() {
    }

    public void destroyApp(boolean unconditional) {
        notifyDestroyed();
    }
}
class IconsCanvas extends Canvas implements Runnable {

    Mouxadamate3Menu menu = null;

    public IconsCanvas() {
        Image[] image = new Image[10];
        try {
            image[0] = Image.createImage("/img/0.jpg");
            image[1] = Image.createImage("/img/1.jpg");
            image[2] = Image.createImage("/img/2.jpg");
            image[3] = Image.createImage("/img/3.jpg");
            image[4] = Image.createImage("/img/4.jpg");
            image[5] = Image.createImage("/img/5.jpg");
            image[6] = Image.createImage("/img/6.jpg");
            image[7] = Image.createImage("/img/7.jpg");
            image[8] = Image.createImage("/img/8.jpg");
            image[9] = Image.createImage("/img/9.jpg");
            menu = new Mouxadamate3Menu(new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"},
                    image, getWidth(), getHeight());
            new Thread(this).start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void paint(Graphics g) {
        menu.paint(g);
    }

    public void keyPressed(int key) {
        int gameKey = getGameAction(key);
        if (gameKey == Canvas.RIGHT) {
            menu.slideItem(1);
        } else if (gameKey == Canvas.LEFT) {
            menu.slideItem(- 1);
        }
    }

    public void run() {
        try {
            while (true) {
                repaint();
                synchronized (this) {
                    wait(100L);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
