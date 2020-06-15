/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gianttictactoe.server;

import gianttictactoe.server.PlayingBoard.CellState;

public class GameState
{
	public final CellState[][] board;
	public final CellState[][] bigBoard;
	public final int activeX, activeY;
	
	public GameState(CellState[][] board, CellState[][] bigBoard, int activeX, int activeY)
	{
		this.board = board;
		this.bigBoard = bigBoard;
		this.activeX = activeX;
		this.activeY = activeY;
	}
}