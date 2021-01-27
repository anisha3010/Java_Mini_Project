
import Circle.*;
import Ellipse.*;
import Parabola.*;
import Line.*;
import java.awt.Choice;

import java.awt.event.*;
import java.awt.*;

import javax.swing.*;


public class project extends JFrame implements ItemListener,ActionListener{
    JFrame frame;
    JLabel pic;
    JPanel header;
    JPanel left,right;
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
    
    public project(){
        super("Java SlideShow");
        frame=new JFrame();
        header=new JPanel();
        left=new JPanel();
        right=new JPanel();
        pic = new JLabel();
        
             Dimension screenSize = Toolkit. getDefaultToolkit(). getScreenSize();
        pic.setBounds(screenSize.width*20/100,screenSize.height*30/100,screenSize.width*60/100,screenSize.height*60/100);
            
        Label head =new Label ("GRAPH SIMULATOR ");
          head.setFont(new Font("Serif",Font.BOLD,30));
        header.add(head); 
       
        header.setBounds(screenSize.width*10/100,screenSize.height*2/100,screenSize.width*80/100,screenSize.height*7/100);
        // for left panel
       
        left.setBounds(0,screenSize.height*9/100,screenSize.width*19/100,screenSize.height*81/100);
        left.setBackground(Color.decode("#70db70"));
         right.setBounds(screenSize.width*81/100,screenSize.height*9/100,screenSize.width*19/100,screenSize.height*81/100);
        right.setBackground(Color.decode("#70db70"));
        
       Next=new JButton("NEXT");
       Next.setToolTipText("Click Next for Graph Simulation ");
       ch=new Choice();
       ch.add("Line");
       ch.add("Circle");
       ch.add("Ellipse");
       ch.add("Parabola");
       
       ch.setBounds(screenSize.width/2-screenSize.width/10,screenSize.height*15/100,screenSize.width/5,screenSize.height*10/100);
       Next.setBounds(screenSize.width/2-screenSize.width/10,screenSize.height*20/100,screenSize.width/10,screenSize.height*5/100);
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
        frame.add(Next);
        frame.add(header);
        frame.add(left);
        frame.add(right);
        tm.start();
        ch.addItemListener(this);
        Next.addActionListener(this);
        frame.setLayout(null);
        frame.setSize(screenSize);
        frame.getContentPane().setBackground(Color.decode("#ff9933"));
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
      
    new project();
}
}