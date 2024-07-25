import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class StartPanel extends JPanel implements ActionListener{
    private JButton startButton;
    private CardLayout cardLayout;
    private JPanel mainPanel;

    StartPanel(CardLayout cardLayout, JPanel mainPanel){
        this.setPreferredSize(new Dimension(500,500));
        this.setBackground(new Color(0xF0F4F8));
        this.setLayout(new BorderLayout());
        this.cardLayout = cardLayout;
        this.mainPanel = mainPanel;
    }

    //add title of game at the top
    public void addGameTitle(){
        JPanel topLayer = new JPanel();
        topLayer.setLayout(new GridBagLayout());

        JLabel gameName = new JLabel("Hangman");
        gameName.setFont(new Font("Showcard Gothic", Font.BOLD, 40));
        gameName.setBorder(new EmptyBorder(10,0,0,0));
        
        ImageIcon gameIcon = new ImageIcon("rope.png");
        gameName.setIcon(gameIcon);
        gameName.setIconTextGap(-20);

        topLayer.add(gameName, new GridBagConstraints());

        this.add(topLayer, BorderLayout.NORTH);
    }

    //add start button in the center
    public void addStartButton(){
        JPanel centerLayer = new JPanel();
        centerLayer.setLayout(new GridBagLayout());

        startButton = new JButton("Start");
        startButton.addActionListener(this);
        Font buttonFont = new Font("Agency FB", Font.BOLD, 30);
        startButton.setFont(buttonFont);
        startButton.setPreferredSize(new Dimension(150,50));
        startButton.setBorderPainted(false);
        startButton.setFocusPainted(false);
        startButton.setBackground(new Color(0x00796B));
        startButton.setForeground(new Color(0xFFFFFF));

        centerLayer.add(startButton, new GridBagConstraints());
        this.add(centerLayer, BorderLayout.CENTER);
    }

    //start game when button is pressed
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == startButton){
            cardLayout.show(mainPanel, "Game Panel");
        }
    }

    //add a copyright footer on start page
    public void addFooter(){
        JPanel bottomLayer = new JPanel();
        bottomLayer.setLayout(new GridBagLayout());
        
        JLabel copyright = new JLabel("All rights reserved © 2024");
        copyright.setFont(new Font("Calibri", Font.BOLD, 10));
        
        copyright.setBorder(new EmptyBorder(0,0,10,0));

        bottomLayer.add(copyright, new GridBagConstraints());

        this.add(bottomLayer, BorderLayout.SOUTH);
    }
}
