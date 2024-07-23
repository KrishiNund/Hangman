import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class GamePanel extends JPanel {
    JButton startButton;
    CardLayout cardLayout;
    JPanel mainPanel;
    String wordChosen;
    String wordTypeChosen;
    Image image;
    GamePanel(CardLayout cardLayout, JPanel mainPanel){
        this.setPreferredSize(new Dimension(500,500));
        this.setBackground(new Color(0xECEFF1));
        this.setLayout(new BorderLayout());
        this.cardLayout = cardLayout;
        this.mainPanel = mainPanel;
        image = new ImageIcon("folded-ribbon.png").getImage();
        drawLetters();
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D) g;

        //draw hanging pole
        g2D.setPaint(new Color(0x37474F));
        g2D.setStroke(new BasicStroke(5));
        g2D.drawLine(100, 30, 100, 250);
        g2D.drawLine(80,250,200,250);
        g2D.drawLine(100,30,200,30);

        //draw wordType banner
        g2D.drawImage(image, 355, 10, null);
        g2D.setFont(new Font("Arial",Font.BOLD,25));
        g2D.setPaint(new Color(0x000000));
        g2D.drawString(wordTypeChosen,380,80);

        //draw word chosen's grids
        

    }

    public void drawLetters(){
        JPanel lettersPanel = new JPanel();
        lettersPanel.setLayout(new GridLayout(4,8,5,5));

        //creating the letters buttons
        for (char alphabet = 'A'; alphabet <= 'Z'; alphabet++){
            JButton alphabetKey = new JButton(String.valueOf(alphabet));
            alphabetKey.setBackground(new Color(0x0288D1));
            alphabetKey.setForeground(new Color(0xFFFFFF));
            alphabetKey.setFont(new Font("Arial", Font.PLAIN, 20));
            alphabetKey.setFocusPainted(false);
            alphabetKey.setBorderPainted(false);
            lettersPanel.add(alphabetKey);
        }

        this.add(lettersPanel, BorderLayout.SOUTH);
        this.revalidate();
        this.repaint();
    }

    public void chooseWord(){
        String[] wordType = {"Animal", "Plant", "Verb"};
        String[] animalList = {"Dog", "Cat", "Lion", "Hippopotamus", "Mouse"};
        String[] plantList = {"Rose","Cactus", "Lily","Orchid", "Sunflower"};
        String[] verbList = {"Walk", "Talk", "Examine", "Understand", "Gather"};

        int randomIndex = new Random().nextInt(wordType.length);
        wordTypeChosen = wordType[randomIndex];

        switch (wordTypeChosen) {
            case "Animal":

                randomIndex = new Random().nextInt(animalList.length);
                wordChosen = animalList[randomIndex];
                
                break;

            case "Plant":

                randomIndex = new Random().nextInt(plantList.length);
                wordChosen = plantList[randomIndex];
                
                break;

            case "Verb":

                randomIndex = new Random().nextInt(verbList.length);
                wordChosen = verbList[randomIndex];
                
                break;

            default:
                break;
        }

        System.out.println(wordTypeChosen + ": " + wordChosen);

    }

}
