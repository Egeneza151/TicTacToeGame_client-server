/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gianttictactoe.server;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import gianttictactoe.util.Renderer;

@SuppressWarnings("serial")
public class ServerGamePanel extends JPanel
{
	public GameState state;
	
	@Override
	public void paint(Graphics g)
	{
		if(state != null)
		Renderer.renderPlayingBoard(g, state.bigBoard, state.board, state.activeX, state.activeY, true);
		else
		{
			g.setColor(Color.PINK);
			g.fillRect(0, 0, g.getClipBounds().width, g.getClipBounds().height);
		}
	}
}