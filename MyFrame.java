import javax.swing.ImageIcon;
import javax.swing.JFrame;


//import java.awt.Color;

public class MyFrame extends JFrame{
    
    MyFrame(){
        this.setTitle("Hangman");
        this.setSize(420,420);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //close the app when x is pressed
        this.setResizable(true); //prevent frame from being resized
        this.setLocationRelativeTo(null); //center frame whenever it pops up

        ImageIcon logo = new ImageIcon("rope.png"); //create an image icon
        this.setIconImage(logo.getImage()); //change icon logo of frame

        //this.getContentPane().setBackground(new Color(0xFFC107));
    }
    
}
