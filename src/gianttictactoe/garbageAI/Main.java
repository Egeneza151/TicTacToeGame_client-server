/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gianttictactoe.garbageAI;

import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;

import gianttictactoe.testClient.ServerInterface;
import gianttictactoe.util.ActiveState;

public class Main
{
	public static ServerInterface server;
	public static GarbageAI ai;
	public static ActiveState state = new ActiveState();
	
	public static final int PORT = 3141;
	
	public static void main(String[] args)
	{
		System.out.println("Garbage AI (GAI) running");
		
		try
		{
			server = new ServerInterface(new Socket(InetAddress.getByAddress(new byte[] {127, 0, 0, 1}), PORT));
			ai = new GarbageAI();
			
			while(true) 
			{
				server.waitForMessage(state);
				int[] move = ai.calculateBestMove(state);
				server.sendMoveMessage(move[0], move[1]);
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