import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;


//import java.awt.Color;

public class MyFrame extends JFrame{
    
    MyFrame(){
        this.setTitle("Hangman");
        // this.setVisible(true);
        this.setSize(420,420);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false); //prevent frame from being resized

        ImageIcon logo = new ImageIcon("hangman-game.png"); //create an image icon
        this.setIconImage(logo.getImage()); //change icon logo of frame
        this.setLayout(new FlowLayout());

        //this.getContentPane().setBackground(new Color(0xFFC107));

        
    }
    
}
