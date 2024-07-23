import java.awt.CardLayout;

import javax.swing.JPanel;
import javax.swing.UIManager;

public class Main{
    public static void main(String[] args){

        try{
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } 
        catch (Exception e){
            System.out.println("Look and feel not set!");
        }

        MyFrame frame  = new MyFrame();  
        
        //using the cardLayout so as to set different panels to navigate to
        CardLayout cardLayout = new CardLayout();

        //main panel to contain the other panels
        JPanel mainPanel = new JPanel(cardLayout);

        //first panel --- Start Panel
        StartPanel startPanel =  new StartPanel(cardLayout,mainPanel);
        startPanel.addGameTitle();
        startPanel.addStartButton();
        startPanel.addFooter();

        //second panel --- Game Panel
        GamePanel gamePanel = new GamePanel(cardLayout,mainPanel);
        gamePanel.drawLetters();
        gamePanel.chooseWord();
        
        //adding both panels to main panel
        mainPanel.add(startPanel,"Start Panel");
        mainPanel.add(gamePanel, "Game Panel");

        frame.add(mainPanel);
        frame.setVisible(true);
    }
}