package com.anfu.mina.bean;

public class SendMessage {
	private int i = 0;    
	private int j = 0;    
	private char symbol = '+';    

	public synchronized int getI() {
		return i;
	}
	public synchronized void setI(int i) {
		this.i = i;
	}
	public synchronized int getJ() {
		return j;
	}
	public synchronized void setJ(int j) {
		this.j = j;
	}
	public synchronized char getSymbol() {
		return symbol;
	}
	public synchronized void setSymbol(char symbol) {
		this.symbol = symbol;
	}	
}
