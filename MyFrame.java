import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class MyFrame extends JFrame{
    //initialize frame attributes
    MyFrame(){
        this.setTitle("Hangman");
        this.setSize(500,500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //close the app when x is pressed
        this.setResizable(false); //prevent frame from being resized
        this.setLocationRelativeTo(null); //center frame whenever it pops up

        ImageIcon logo = new ImageIcon("rope.png"); //create an image icon
        this.setIconImage(logo.getImage()); //change icon logo of frame
    }
}
