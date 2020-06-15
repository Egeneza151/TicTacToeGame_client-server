/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gianttictactoe.testClient;

import java.awt.*;
import java.awt.event.*;

import javax.swing.JPanel;

import gianttictactoe.server.PlayingBoard.CellState;
import gianttictactoe.util.Renderer;

@SuppressWarnings("serial")
public class GamePanel extends JPanel implements MouseListener
{
	private int Ux, Uy;
	
	public GamePanel()
	{
		addMouseListener(this);
	}
	
	@Override
	public void paint(Graphics g)
	{
		Ux = g.getClipBounds().width / 9; Uy = g.getClipBounds().height / 9;
		if(MainClient.state.symbol == null) MainClient.frame.setTitle("Ultimate Tic Tac Toe Client: Waiting for game to start");
		else if(MainClient.state.symbol == CellState.X) MainClient.frame.setTitle("Ultimate Tic Tac Toe Client: Client 1 (X)");
		else if(MainClient.state.symbol == CellState.O) MainClient.frame.setTitle("Ultimate Tic Tac Toe Client: Client 2 (O)");
		if(MainClient.state.initialized) Renderer.renderPlayingBoard(g, MainClient.state.bigBoard, MainClient.state.board, MainClient.state.activeX, MainClient.state.activeY, MainClient.state.myTurn);
	}

	@Override
	public void mouseClicked(MouseEvent e)
	{
		int cellX = e.getX() / Ux, cellY = e.getY() / Uy;
		if(MainClient.state.myTurn)
		{
			MainClient.state.board[cellX][cellY] = MainClient.state.symbol;
			MainClient.frame.repaint();
			MainClient.server.sendMoveMessage(cellX, cellY);
			MainClient.state.myTurn = false;
		}
	}

	@Override public void mouseEntered(MouseEvent arg0) {}
	@Override public void mouseExited(MouseEvent arg0) {}
	@Override public void mousePressed(MouseEvent arg0) {}
	@Override public void mouseReleased(MouseEvent arg0) {}
}