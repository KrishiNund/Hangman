import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JPanel;

public class GamePanel extends JPanel {
    private JButton startButton;
    private CardLayout cardLayout;
    private JPanel mainPanel;

    GamePanel(CardLayout cardLayout, JPanel mainPanel){
        this.setSize(500,500);
        this.setBackground(new Color(0xECEFF1));
        this.setLayout(new BorderLayout());
        this.cardLayout = cardLayout;
        this.mainPanel = mainPanel;
    }

    public void drawPole(){

    }

    public void drawLetters(){
        JPanel lettersPanel = new JPanel();
        lettersPanel.setLayout(new GridLayout(3,9,5,5));

        //creating the letters buttons
        for (char alphabet = 'A'; alphabet <= 'Z'; alphabet++){
            JButton alphabetKey = new JButton(String.valueOf(alphabet));
            alphabetKey.setBackground(new Color(0x0288D1));
            alphabetKey.setForeground(new Color(0xFFFFFF));
            alphabetKey.setFont(new Font("Calibri", Font.PLAIN, 20));
            alphabetKey.setFocusPainted(false);
            alphabetKey.setBorderPainted(false);
            lettersPanel.add(alphabetKey);
        }

        // GridBagConstraints gbc = new GridBagConstraints();
        // gbc.gridx = 0;
        // gbc.gridy = 1;
        // gbc.fill = GridBagConstraints.CENTER;
        // gbc.gridwidth = GridBagConstraints.REMAINDER; // Span the full width of the container
        // gbc.fill = GridBagConstraints.HORIZONTAL; // Fill the width
        // gbc.anchor = GridBagConstraints.SOUTH; // Align to the bottom
        // gbc.insets = new Insets(10, 10, 10, 10);
        this.add(lettersPanel, BorderLayout.SOUTH);
    }
    
    public void drawHangman(){

    }



}
