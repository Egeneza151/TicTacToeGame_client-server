/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gianttictactoe.garbageAI;

import gianttictactoe.server.PlayingBoard.CellState;

public class Move implements Comparable<Move>
{
	public int x, y;
	public CellState symbol;
	public int value = 0;

	public Move(int x, int y, CellState symbol)
	{
		this.x = x;
		this.y = y;
		this.symbol = symbol;
	}
	
	@Override
	public int compareTo(Move m)
	{
		return Integer.compare(value, m.value);
	}
}