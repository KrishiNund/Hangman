import javax.swing.JLabel;

public class hangman{
    public static void main(String[] args){

        MyFrame gameFrame = new MyFrame();
        JLabel label = new JLabel("Hello world");
        label.setText("Hello World!");
        gameFrame.add(label);
        gameFrame.setVisible(true);
    }
}