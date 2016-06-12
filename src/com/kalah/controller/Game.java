package com.kalah.controller;

import java.util.Arrays;

public class Game {

	Players p1 = new Players();
	Players p2 = new Players();
	Players current = new Players();
	Players next = new Players();
	
	boolean next_player_turn = false;
	
	String p1_name="";
	String p2_name="";
	
	private boolean start, game_over;
	
	public Game(){
		start = true;
		game_over=false;
		System.out.println("In Constructor");
	}

	public void initialiseGame(String p1_name, String p2_name){
		p1.setPlayers(p1_name);
		p2.setPlayers(p2_name);
		System.out.println("Players : " + p1_name + " , " + p2_name);
	}
	
public String showStatus(){
		System.out.println("Player - " + p1.getPlayer() + "  : Kalah = " +p1.getKalah() + " : Pit = " +Arrays.toString(p1.getPit()) );
		System.out.println("Player - " + p2.getPlayer() + "  : Kalah = " +p2.getKalah() + " : Pit = " +Arrays.toString(p2.getPit()) );
		System.out.println(" ---------------------------------------------------------------------------------------------------");
		
		String message = "Players : <h3 style=\"background-color:yellow;\">" + 
							"Player > " + p1.getPlayer() + 
							"</h3> Kalah = " + p1.getKalah() + " and Pit = " + Arrays.toString(p1.getPit()) + 
							"<br><br>" +
							"<h3 style=\"background-color:cyan;\">" + p2_name +
							"Player > " + p2.getPlayer() + 
							"</h3>Kalah = " + p2.getKalah() + " and Pit = " + Arrays.toString(p2.getPit()) + 
							"</h2><br><br>" + "Last Played by - " + current.getPlayer();
		return message;
	}

public String playWebGame(int pit_number){

	int index,  arr_index, stones=0;
	
	if (game_over != true){
		showStatus();
		decideNextTurn();
		index = pit_number; // input selection
		arr_index = index-1;
	
		
		int current_pit[] = current.getPit();
		int next_pit[]= next.getPit();
		stones = current_pit[arr_index];
		
		if(stones == 0){
			game_over=checkAllPits();
			System.out.println("You have selected Empty pit...");
			return " Player : - " + current.getPlayer() + " Please Play." + 
					" <br> <br> You have selected Empty pit...";
		}
		int move = index;
		
		if (stones >=13) {
			game_over = true;
			System.out.println("Game Over due to sowing seed condition..");
			return "Game Over due to sowing seed condition.." + decideWinner();
		}
		
		current_pit[arr_index] = 0;
		int available_pits= current_pit.length - index;
		
		if(stones==available_pits)
			next_player_turn = false;
		else
			next_player_turn = true;
			
			while(stones>0){
				if(available_pits >0 ){
					current_pit[move] += 1;
					move++;
					stones--;	
					available_pits--;
					if(move>=current_pit.length)
						move=0;
				}
				else if(move< next_pit.length-1){
					next_pit[move] += 1;
					move++;
					stones--;
				}
				else {
					available_pits = current_pit.length;
					move=0;
				}
			}
			
			if(current.getPlayer()==p1.getPlayer()) {
				p1.setPit(current_pit);
				p2.setPit(next_pit);
			}
			else{
				p2.setPit(current_pit);
				p1.setPit(next_pit);
			}
	}
	else {
		return decideWinner();
	}
	if (next_player_turn == true){ 
		return " Player : - " + next.getPlayer() + " Please Play.";
	} else {
		return " Player : - " + current.getPlayer() + " Please Play.";
	}
}
	
	public void decideNextTurn(){
		//Players next_player = new Players();
		
		if (start==true){
			start=false;
			current = p1;
			next = p2;
		}
		else if (next_player_turn == true){ 
			Players temp = current;
			current = next;
			next = temp;
		}
		
	}
	
	
	public String decideWinner(){		
		if(current.getKalah() > next.getKalah()){
			System.out.println("Winner is "+current.getPlayer());
			return "Winner is - " + current.getPlayer();
		}
		else if(current.getKalah() < next.getKalah()) {
			System.out.println("Winner is "+ next.getPlayer());
			return "Winner is - " + next.getPlayer();
		}
		else{
			System.out.println(" cheers.... you both are winners");
			return "Cheers.... you <B> BOTH are WINNER (TIE) </B>";
		}
	}
	
	public boolean checkAllPits(){
		for(int i=0; i<current.getPit().length; i++){
			if(current.getPit()[i] ==0)
				game_over=true;
			else{ 
				game_over=false;
				return game_over;
			}
		}
		return game_over;
	}
	
	public Players[] getPlayers(){
		Players[] players = new Players[2];
		players[0] = p1;
		players[1] = p2;
		return players;
	}
	
}
