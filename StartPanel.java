import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class StartPanel extends JPanel {
    
    StartPanel(){
        this.setSize(420,420);
        this.setBackground(new Color(0xFFC107));
        this.setLayout(new BorderLayout());
    }

    
    public void addGameTitle(){
        JPanel topLayer = new JPanel();
        topLayer.setLayout(new GridBagLayout());
        topLayer.setBackground(new Color(0xFFC107));

        JLabel gameName = new JLabel("Hangman");
        gameName.setFont(new Font("Showcard Gothic", Font.BOLD, 40));
        gameName.setBorder(new EmptyBorder(10,0,0,0));
        
        ImageIcon gameIcon = new ImageIcon("rope.png");
        gameName.setIcon(gameIcon);
        gameName.setIconTextGap(-20);

        topLayer.add(gameName, new GridBagConstraints());

        this.add(topLayer, BorderLayout.NORTH);
    }

    public void addStartButton(){
        JPanel centerLayer = new JPanel();
        centerLayer.setLayout(new GridBagLayout());
        centerLayer.setBackground(new Color(0xFFC107));

        JButton startButton = new JButton("Start");
        Font buttonFont = new Font("MV Boli", Font.BOLD, 25);
        startButton.setFont(buttonFont);
        startButton.setPreferredSize(new Dimension(150,50));
        startButton.setBorderPainted(false);
        startButton.setFocusPainted(false);
        startButton.setBackground(new Color(0xAFD5AA));
        //startButton.setContentAreaFilled(false);

        centerLayer.add(startButton, new GridBagConstraints());
        this.add(centerLayer, BorderLayout.CENTER);
    }

    public void addFooter(){
        JPanel bottomLayer = new JPanel();
        bottomLayer.setLayout(new GridBagLayout());
        bottomLayer.setBackground(new Color(0xFFC107));
        
        JLabel copyright = new JLabel("All rights reserved © 2024");
        copyright.setFont(new Font("Calibri", Font.BOLD, 10));
        
        copyright.setBorder(new EmptyBorder(0,0,10,0));

        bottomLayer.add(copyright, new GridBagConstraints());
   
        this.add(bottomLayer, BorderLayout.SOUTH);
    }
}
