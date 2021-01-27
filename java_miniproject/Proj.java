
import Circle.*;
import Ellipse.*;
import Parabola.*;
import Line.*;
import java.awt.Choice;

import java.awt.event.*;
import java.awt.*;

import javax.swing.*;


public class Proj extends JFrame implements ItemListener,ActionListener{
    JFrame frame;
    JLabel pic;
    Timer tm;
    JButton Next;
    Choice ch;
    int x = 0;
    //Images Path In Array
    String[] list = {
                      "listzero.png",
       "listone.png",
       "listtwo.png",
       "listthree.png",
       "listfour.png",
       "listfive.png",
       "listsix.png",
       "listseven.png"
                    };
    
    public Proj(){
        super("Java SlideShow");
        frame=new JFrame();
        pic = new JLabel();
        pic.setBounds(40, 30, 700, 300);
         Color c=new Color(230, 153, 255); 
           Dimension screenSize = Toolkit. getDefaultToolkit(). getScreenSize();
       Next=new JButton("next");
       frame.add(Next);
       Next.setToolTipText("Click Next for Graph ");
       ch=new Choice();
       ch.add("Line");
       ch.add("Circle");
       ch.add("Ellipse");
       ch.add("Parabola");
       ch.setBackground(c);
       ch.setBounds(750,360,200,50);
       Next.setBounds(700,360,100,50);
        //Call The Function SetImageSize
        SetImageSize(6);
               //set a timer
        tm = new Timer(1500,new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                SetImageSize(x);
                x += 1;
                if(x >= list.length )
                    x = 0; 
            }
        });
        frame.add(pic);
        frame.add(ch);
        tm.start();
        ch.addItemListener(this);
        Next.addActionListener(this);
        frame.setLayout(null);
        frame.setSize(800, 400);
        frame.getContentPane().setBackground(Color.decode("#bdb67b"));
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    //create a function to resize the image 
    public void SetImageSize(int i){
        ImageIcon icon = new ImageIcon(list[i]);
        Image img = icon.getImage();
        Image newImg = img.getScaledInstance(pic.getWidth(), pic.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon newImc = new ImageIcon(newImg);
        pic.setIcon(newImc);
    }
     public void itemStateChanged(ItemEvent ie){
        x=ch.getSelectedIndex();// starts from 0 to soon
      
   }
   
   public void actionPerformed(ActionEvent ae){
       if(x==0)
       {

        frame.setVisible(false);
       Line.line  l= new Line.line();
     
       }
       else if(x==1)
       {
           frame.setVisible(false);
          Circle.circle c=new Circle.circle(); 
       
       }
       else if(x==2)
       {
           frame.setVisible(false);
           Ellipse.ellipse e=new Ellipse.ellipse();
          
       }
       else if(x==3)
       {
           frame.setVisible(false);
           Parabola.parabola p=new Parabola.parabola();
       }
       else
       {// if nothing selected, line will be auto selected
          frame.setVisible(false);
          Line.line  l= new Line.line();
       }
       
   }

public static void main(String[] args){ 
      
    new Proj();
}
}