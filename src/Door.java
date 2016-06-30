import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Created by praveensingh on 14/06/16.
 */
public class Door extends JPanel implements MouseListener{
    private BufferedImage doorImage;
    private BufferedImage treasureImage;
    private BufferedImage thulluImage;

    OpenDoorListner listner;

    private boolean doorOpen = false;
    private boolean hasTreasure = false;


    public Door(){
        super();
        this.setPreferredSize(new Dimension(200, 300));
        try {
            this.doorImage = ImageIO.read(Door.class.getResource("door.png"));
            this.treasureImage = ImageIO.read(Door.class.getResource("treasure.png"));
            this.thulluImage = ImageIO.read(Door.class.getResource("thullu.png"));
        } catch (IOException e) {
          e.printStackTrace();
        }
        this.addMouseListener(this);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);


        if (doorOpen) {
            if (hasTreasure) {
                g.drawImage(this.treasureImage, 0, 0, null);
            } else {
                g.drawImage(this.thulluImage, 0, 0, null);
            }

        } else {
            g.drawImage(this.doorImage, 0, 0, null);
        }
    }



    public void setTresure(boolean hasTreasure){
        this.hasTreasure=hasTreasure;
    }


    public void open() {
        if(!doorOpen){
            doorOpen=true;
            this.repaint();
        }

    }
    public void close(){
          if(doorOpen)
          {  this.doorOpen=false;
              repaint();
          }
    }

    public void setOpenDoorListner(OpenDoorListner openDoorListner){
        if(openDoorListner instanceof OpenDoorListner)
        this.listner=(OpenDoorListner) openDoorListner;
    }


    @Override
    public void mouseClicked(MouseEvent e) {

        if(!doorOpen){
            this.open();
            if(listner!=null){
                listner.doorOpened(hasTreasure);
           }
       }
    }
    public void reset(){
        if(doorOpen){
            this.setTresure(false);
            this.close();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
