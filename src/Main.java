
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;


import gianttictactoe.server.MainServer;
import gianttictactoe.testClient.MainClient;
import gianttictactoe.garbageAI.MainAI;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author HP
 */
public class Main {
    public static void main(String[] args) { 
        
    JFrame f=new JFrame("giantTicTacToe");    
    JButton buttonServer=new JButton("Run server");
    JButton buttonClient=new JButton("Run client");
    JButton buttonAI=new JButton("Run AI");
    buttonServer.setBounds(50,100,150,30);  
    buttonServer.addActionListener((ActionEvent e) -> {
        MainServer mainServer = new MainServer(); 
    });
    buttonClient.setBounds(50,150,150,30);
    buttonServer.addActionListener((ActionEvent e) -> {
        MainClient mainClient = new MainClient();
    });
    buttonAI.setBounds(50,200,150,30); 
    buttonServer.addActionListener((ActionEvent e) -> {
        MainAI mainAI = new MainAI();
    });
    f.add(buttonServer);
    f.add(buttonClient);
    f.add(buttonAI); 
    f.setSize(400,400);
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.setLayout(null);  
    f.setVisible(true);   
} 
}
