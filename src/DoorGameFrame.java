import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.NumericShaper;
import java.util.Random;

/**
 *
 * Created by praveensingh on 14/06/16.
 */
public class DoorGameFrame extends JFrame implements OpenDoorListner,ActionListener {

    private JPanel mainPanel;
    private JButton resetButton;
    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;
    private JLabel result_label;


    private Door door1;
    private Door door2;
    private Door door3;
    private int score=200;
    private static final String WINDOW_TITLE = "Three Door Game";

    public DoorGameFrame() {
        this(WINDOW_TITLE);
    }

    public DoorGameFrame(String title){
        super(title);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setContentPane(this.mainPanel);
        this.setResizable(false);



       this.door1=new Door();
        this.door2=new Door();
        this.door3=new Door();

        this.door1.setOpenDoorListner(this);
        this.door2.setOpenDoorListner(this);
        this.door3.setOpenDoorListner(this);

        this.panel1.add(door1);
         this.panel2.add(door2);
        this.panel3.add(door3);

        this.hideTreasure();




        this.resetButton.addActionListener(this);

        pack();

    }

    private void hideTreasure() {
        Random r=new Random();
        int x=r.nextInt(3);
        if(x==0){
            door1.setTresure(true);
        }else if(x==1){

            door2.setTresure(true);
        }else{

            door3.setTresure(true);
        }
    }


    @Override
    public void doorOpened(Boolean treaserFound) {
        if(treaserFound){
            score+=20;
        }else{
            score-=15;
        }

        this.result_label.setText(Integer.toString(score));
        door1.open();
        door2.open();
        door3.open();

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        door1.reset();
        door2.reset();
        door3.reset();

        this.hideTreasure();
    }


}
