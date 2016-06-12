package com.kalah.controller;

public class Players {

	String player;
	
	private int[] pit=new int[7];
	
	
	Players(){	 
		for(int i =0; i<pit.length; i++){
			pit[i]=6;
		}
		pit[6]=0;
		
	}
	
	public void setPlayers(String player){
		this.player = player;
	}
	
	public String getPlayer(){
		return this.player;
		
	}
	
	public int getKalah(){
		return this.pit[6];
	} 
	
	public int[] getPit(){
		return this.pit;
	}
	
	public void setPit(int pit[]){
	this.pit =pit;
	}
}
