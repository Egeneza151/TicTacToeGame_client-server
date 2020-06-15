/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gianttictactoe.testClient;

import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;

import javax.swing.JFrame;

import gianttictactoe.util.ActiveState;

public class MainClient
{
        
	public static ServerInterface server;
	public static ActiveState state = new ActiveState();
	public static JFrame frame;
	
	public static final int PORT = 3141;
	
	public static void main(String[] args)
	{
		System.out.println("Testing Client running");
		
		frame = new JFrame();
		frame.setSize(900, 900);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(new GamePanel());
		frame.setVisible(true);
			
		try
		{
			server = new ServerInterface(new Socket(InetAddress.getLocalHost(), PORT));
			
			while(true) 
			{
				server.waitForMessage(state);
				MainClient.frame.repaint();
			}
		}
		catch(SocketException e1)
		{
			if(state.done) System.out.println("Game finished. Server closed.");
			else e1.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}