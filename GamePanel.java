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
import javax.swing.JOptionPane;
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
    int wrongGuesses;
    int numLettersFound;
    GamePanel(CardLayout cardLayout, JPanel mainPanel){
        this.setPreferredSize(new Dimension(500,500));
        this.setBackground(new Color(0xECEFF1));
        this.setLayout(new BorderLayout());
        this.cardLayout = cardLayout;
        this.mainPanel = mainPanel;
        this.image = new ImageIcon("tag.png").getImage();
        this.answerGridPanel = new JPanel();
        this.lettersPanel = new JPanel();
        this.drawingPanel = new JPanel();
        this.drawingPanel.setPreferredSize(new Dimension(0,250));
        this.drawingPanel.setBackground(new Color(0xF0F4F8));
        this.add(drawingPanel,BorderLayout.NORTH);
        this.wrongGuesses = 0;
        this.numLettersFound = 0;    
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
        g2D.drawImage(image, 350, 20, null);
        g2D.setPaint(new Color(0x000000));
        g2D.setFont(new Font("Calibri",Font.BOLD,26));
        g2D.drawString(wordTypeChosen,385,90);

        //check number of wrong guesses and part of hangman accordingly
        switch (wrongGuesses) {
            case 1:

                drawLine1(g2D,200,20,200,40);
                break;
            
            case 2:

                drawLine1(g2D,200,20,200,40);
                drawLine2(g2D,180, 40, 40, 40);
            
                break;
            
            case 3:

                drawLine1(g2D,200,20,200,40);
                drawLine2(g2D,180, 40, 40, 40);
                drawLine3(g2D,180,40,40,40);
    
                break;

            case 4:

                drawLine1(g2D,200,20,200,40);
                drawLine2(g2D,180, 40, 40, 40);
                drawLine3(g2D,180,40,40,40);
                drawLine4(g2D, 200,80,200,100);

                break;

            case 5:

                drawLine1(g2D,200,20,200,40);
                drawLine2(g2D,180, 40, 40, 40);
                drawLine3(g2D,180,40,40,40);
                drawLine4(g2D, 200,80,200,100);
                drawLine5(g2D, 200, 100, 160, 120);
            
                break;

            case 6:

                drawLine1(g2D,200,20,200,40);
                drawLine2(g2D,180, 40, 40, 40);
                drawLine3(g2D,180,40,40,40);
                drawLine4(g2D, 200,80,200,100);
                drawLine5(g2D, 200, 100, 160, 120);
                drawLine6(g2D, 200, 100, 240, 120);
        
                break;

            case 7:

                drawLine1(g2D,200,20,200,40);
                drawLine2(g2D,180, 40, 40, 40);
                drawLine3(g2D,180,40,40,40);
                drawLine4(g2D, 200,80,200,100);
                drawLine5(g2D, 200, 100, 160, 120);
                drawLine6(g2D, 200, 100, 240, 120);
                drawLine7(g2D, 200,100,200,140);
                
                break;

            case 8:

                drawLine1(g2D,200,20,200,40);
                drawLine2(g2D,180, 40, 40, 40);
                drawLine3(g2D,180,40,40,40);
                drawLine4(g2D, 200,80,200,100);
                drawLine5(g2D, 200, 100, 160, 120);
                drawLine6(g2D, 200, 100, 240, 120);
                drawLine7(g2D, 200,100,200,140);
                drawLine8(g2D, 200,140,160,180);

                break;

            case 9:

                drawLine1(g2D,200,20,200,40);
                drawLine2(g2D,180, 40, 40, 40);
                drawLine3(g2D,180,40,40,40);
                drawLine4(g2D, 200,80,200,100);
                drawLine5(g2D, 200, 100, 160, 120);
                drawLine6(g2D, 200, 100, 240, 120);
                drawLine7(g2D, 200,100,200,140);
                drawLine8(g2D, 200,140,160,180);
                drawLine9(g2D, 200,140,240,180);
        
                break;

            default:
                break;
        }
    }

    public void drawLine1(Graphics2D g2D, int x1, int y1, int x2, int y2){
        g2D.setPaint(new Color(0x37474F));
        g2D.setStroke(new BasicStroke(5));
        g2D.drawLine(x1,y1,x2,y2);
    }

    public void drawLine2(Graphics2D g2D, int x, int y, int width, int height){
        g2D.setPaint(new Color(0x37474F));
        g2D.setStroke(new BasicStroke(5));
        g2D.drawOval(x,y,width,height);
    }

    public void drawLine3(Graphics2D g2D, int x, int y, int width, int height){
        g2D.setPaint(new Color(0x37474F));
        g2D.setStroke(new BasicStroke(5));
        g2D.fillOval(x,y,width,height);
    }

    public void drawLine4(Graphics2D g2D, int x1, int y1, int x2, int y2){
        g2D.setPaint(new Color(0x37474F));
        g2D.setStroke(new BasicStroke(5));
        g2D.drawLine(x1,y1,x2,y2);
    }

    public void drawLine5(Graphics2D g2D, int x1, int y1, int x2, int y2){
        g2D.setPaint(new Color(0x37474F));
        g2D.setStroke(new BasicStroke(5));
        g2D.drawLine(x1,y1,x2,y2);
    }

    public void drawLine6(Graphics2D g2D, int x1, int y1, int x2, int y2){
        g2D.setPaint(new Color(0x37474F));
        g2D.setStroke(new BasicStroke(5));
        g2D.drawLine(x1,y1,x2,y2);
    }

    public void drawLine7(Graphics2D g2D, int x1, int y1, int x2, int y2){
        g2D.setPaint(new Color(0x37474F));
        g2D.setStroke(new BasicStroke(5));
        g2D.drawLine(x1,y1,x2,y2);
    }

    public void drawLine8(Graphics2D g2D, int x1, int y1, int x2, int y2){
        g2D.setPaint(new Color(0x37474F));
        g2D.setStroke(new BasicStroke(5));
        g2D.drawLine(x1,y1,x2,y2);
    }

    public void drawLine9(Graphics2D g2D, int x1, int y1, int x2, int y2){
        g2D.setPaint(new Color(0x37474F));
        g2D.setStroke(new BasicStroke(5));
        g2D.drawLine(x1,y1,x2,y2);
    }


    //draw letters panel where user can click on a letter to guess the word
    public void drawLetters(){
        lettersPanel.setPreferredSize(new Dimension(0,150));
        lettersPanel.setLayout(new GridLayout(4,8,1,1));

        //creating the letters buttons
        for (char alphabet = 'A'; alphabet <= 'Z'; alphabet++){
            JButton alphabetKey = new JButton(String.valueOf(alphabet));
            alphabetKey.setBackground(Color.GRAY);
            alphabetKey.setForeground(new Color(0xFFFFFF));
            alphabetKey.setFont(new Font("Arial", Font.PLAIN, 20));
            alphabetKey.setFocusPainted(false);
            alphabetKey.setBorderPainted(false);
            lettersPanel.add(alphabetKey);

            alphabetKey.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e){
                    String letterClicked = alphabetKey.getText();
                    boolean letterFound = updateAnswerGrid(letterClicked.charAt(0));
                    if (letterFound){
                        alphabetKey.setBackground(new Color(0x388E3C));
                    } else {
                        alphabetKey.setBackground(new Color(0xD32F2F));
                    }
                    alphabetKey.setEnabled(false);
                }
            });
        }

        this.add(lettersPanel, BorderLayout.SOUTH);
        this.revalidate();
        this.repaint();
    }

    //generate word to be guessed
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
    }

    //draw the answer grid where the correct word will appear
    public void drawAnswerGrids(){
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
    }

    //update the answer grid whenever a correct letter is pressed
    public boolean updateAnswerGrid(char letter){
        boolean letterFound = false;
        for(int i = 0; i < wordChosen.length(); i++){
            if(Character.toLowerCase(wordChosen.charAt(i)) == Character.toLowerCase(letter)){
                chosenWordCharacters[i].setText(String.valueOf(letter));
                letterFound = true;
                numLettersFound++;
            }
        }
        
        if (!letterFound){
            wrongGuesses++;
            repaint();
        }

        if (wrongGuesses == 9){
            JOptionPane.showMessageDialog(null, "You unfortunately could not guess the word!", "You Lost!",JOptionPane.WARNING_MESSAGE);
            resetGame();
        } else if (numLettersFound == wordChosen.length()){
            JOptionPane.showMessageDialog(null, "You successfully guessed the word!", "You Won!", JOptionPane.INFORMATION_MESSAGE);
            resetGame();
        }

        return letterFound;
    }

    //reset the game after a win or loss
    public void resetGame(){  
        numLettersFound = 0;
        wrongGuesses = 0;
        answerGridPanel.removeAll();
        lettersPanel.removeAll();
        chooseWord();
        drawAnswerGrids();
        drawLetters();
        revalidate();
        repaint();    
    }
}
