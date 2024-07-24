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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GamePanel extends JPanel{
    JButton startButton;
    CardLayout cardLayout;
    JPanel mainPanel;
    JPanel answerGridPanel;
    JPanel drawingPanel;
    JPanel lettersPanel;
    String wordChosen;
    String wordTypeChosen;
    Image image;
    JLabel[] chosenWordCharacters;
    GamePanel(CardLayout cardLayout, JPanel mainPanel){
        this.setPreferredSize(new Dimension(500,500));
        this.setBackground(new Color(0xECEFF1));
        this.setLayout(new BorderLayout());
        this.cardLayout = cardLayout;
        this.mainPanel = mainPanel;
        this.image = new ImageIcon("folded-ribbon.png").getImage();
        this.answerGridPanel = new JPanel();
        this.lettersPanel = new JPanel();
        this.drawingPanel = new JPanel();
        this.drawingPanel.setPreferredSize(new Dimension(0,250));
        this.drawingPanel.setBackground(new Color(0xF0F4F8));
        this.add(drawingPanel,BorderLayout.NORTH);
        
    }

    public void paint(Graphics g){
        super.paint(g);
        Graphics2D g2D = (Graphics2D) g;

        //draw hanging pole
        g2D.setPaint(new Color(0x37474F));
        g2D.setStroke(new BasicStroke(5));
        g2D.drawLine(100, 20, 100, 240);
        g2D.drawLine(80,240,200,240);
        g2D.drawLine(100,20,200,20);

        //draw wordType banner
        g2D.drawImage(image, 355, 10, null);
        g2D.setFont(new Font("Arial",Font.BOLD,25));
        g2D.setPaint(new Color(0x000000));
        g2D.drawString(wordTypeChosen,380,80);

    }

    public void drawLetters(){
        lettersPanel.setPreferredSize(new Dimension(0,150));
        lettersPanel.setLayout(new GridLayout(4,8,1,1));

        //creating the letters buttons
        for (char alphabet = 'A'; alphabet <= 'Z'; alphabet++){
            JButton alphabetKey = new JButton(String.valueOf(alphabet));
            alphabetKey.setBackground(new Color(0x0288D1));
            alphabetKey.setForeground(new Color(0xFFFFFF));
            alphabetKey.setFont(new Font("Arial", Font.PLAIN, 20));
            alphabetKey.setFocusPainted(false);
            alphabetKey.setBorderPainted(false);
            lettersPanel.add(alphabetKey);

            alphabetKey.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e){
                    String letterClicked = alphabetKey.getText();
                    System.out.println(letterClicked);
                    System.out.println(letterClicked.charAt(0));
                    boolean letterFound = updateAnswerGrid(letterClicked.charAt(0));
                    if (letterFound){
                        alphabetKey.setBackground(Color.green);
                    } else {
                        alphabetKey.setBackground(Color.red);
                    }
                    alphabetKey.setEnabled(false);
                }
            });
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

    public void drawAnswerGrids(){
        // answerGridPanel.setPreferredSize(new Dimension(0,0));
        answerGridPanel.setBackground(new Color(0xF0F4F8));
        answerGridPanel.setLayout(new GridLayout(1, wordChosen.length(), 0, 0));

        chosenWordCharacters = new JLabel[wordChosen.length()];
        for(int i = 0 ; i < wordChosen.length(); i++){
            chosenWordCharacters[i] = new JLabel("_",JLabel.CENTER);
            chosenWordCharacters[i].setFont(new Font("Arial", Font.PLAIN, 20));
            chosenWordCharacters[i].setForeground(new Color(0x37474F));
            answerGridPanel.add(chosenWordCharacters[i]);
        }
        this.add(answerGridPanel,BorderLayout.CENTER);
        // this.revalidate();
        // this.repaint();
    }

    public boolean updateAnswerGrid(char letter){
        boolean letterFound = false;
        for(int i = 0; i < wordChosen.length(); i++){
            if(Character.toLowerCase(wordChosen.charAt(i)) == Character.toLowerCase(letter)){
                chosenWordCharacters[i].setText(String.valueOf(letter));
                letterFound = true;
            }
        }
        
        if (!letterFound){

        }

        return letterFound;
    }

}
