/*
 * ArgonMS MapleStory server emulator written in Java
 * Copyright (C) 2011  GoldenKevin
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package argonms.loading.reactor;

import java.awt.Point;

/**
 *
 * @author GoldenKevin
 */
public class State {
	private int type;
	private int nextState;

	//item event only
	private int itemid, quantity;
	private int ltx, lty;
	private int rbx, rby;

	protected State() {
		
	}

	protected void setType(int type) {
		this.type = type;
	}

	protected void setNextState(int state) {
		this.nextState = state;
	}

	protected void setItem(int id, int quantity) {
		this.itemid = id;
		this.quantity = quantity;
	}

	protected void setLt(int x, int y) {
		this.ltx = x;
		this.lty = y;
	}

	protected void setRb(int x, int y) {
		this.rbx = x;
		this.rby = y;
	}

	public int getType() {
		return type;
	}

	public int getNextState() {
		return nextState;
	}

	public int[] getItem() {
		return new int[] { itemid, quantity };
	}

	public Point getLt() {
		return new Point(ltx, lty);
	}

	public Point getRb() {
		return new Point(rbx, rby);
	}

	public String toString() {
		StringBuilder builder = new StringBuilder();
		boolean itemEvent = (type == 100);
		builder.append("type=").append(type).append(" (itemEvent=").append(itemEvent).append(')');
		builder.append(", nextState=").append(nextState);
		if (itemEvent) {
			builder.append(", itemid=").append(itemid).append(" (Qty=").append(quantity).append(')');
			builder.append(", lt=(").append(ltx).append(", ").append(lty).append(')');
			builder.append(", rb=(").append(rbx).append(", ").append(rby).append(')');
		}
		return builder.toString();
	}
}