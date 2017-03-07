/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;


/**
 * @author xadimousalih
 */
public class YaRahmanouYaRahimou extends MIDlet{
  private Display display;

  public void startApp(){
    display = Display.getDisplay(this);
    display.setCurrent(new IconsCanvas());
  }

  public void pauseApp(){}

  public void destroyApp(boolean unconditional){
    notifyDestroyed();
  }
}
class IconsCanvas extends Canvas implements Runnable{
  YaRahmanouYaRahimouMenu menu = null;

  public IconsCanvas(){
    Image[] image = new Image[11];
    try{
      image[0] = Image.createImage("/img/accueil.jpg");
      image[1] = Image.createImage("/img/Rabbi1.jpg");
      image[2] = Image.createImage("/img/Rabbi2.jpg");
      image[3] = Image.createImage("/img/Rabbi3.jpg");image[4] = Image.createImage("/img/fin.jpg");
      menu = new YaRahmanouYaRahimouMenu(new String[]{"1", "2", "3", "4", "5"},
        image,  getWidth(),  getHeight());
      new Thread(this).start();
    }catch(Exception e){
      e.printStackTrace();
    }
  }

  protected void paint(Graphics g){
    menu.paint(g);
  }

  public void keyPressed(int key){
    int gameKey = getGameAction(key);
    if(gameKey == Canvas.RIGHT){
      menu.slideItem(1);
    }else if(gameKey == Canvas.LEFT){
      menu.slideItem(- 1);
    }
  }

  public void run(){
    try{
      while(true){
        repaint();
        synchronized(this){
          wait(100L);
        }
      }
    }catch(Exception e){
      e.printStackTrace();
    }
  }
}