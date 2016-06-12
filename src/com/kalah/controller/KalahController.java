package com.kalah.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class KalahController {
	Game g = new Game();
	
   @RequestMapping(value="/welcome", method=RequestMethod.GET)
   public ModelAndView game() {
		String message = "<H2>Welcome to Kalah Game </H3>";
      return new ModelAndView("welcome", "message", message);
   }
	
	@RequestMapping(value="/game", method=RequestMethod.POST, params={"p1_name", "p2_name"})
    public String joinGame(@RequestParam(value="p1_name", required=true) String p1_name, @RequestParam(value="p2_name", required=true) String p2_name, ModelMap model) 
	{
		Players[] p = new Players[2];
		
		g.initialiseGame(p1_name, p2_name);
        p = g.getPlayers();
        
        for (int i=0; i < p.length ; i++){
        	int[] pits = p[i].getPit();
	        for (int j=0; j < pits.length ; j++){
	        	model.addAttribute("P" + (i+1) + (j+1) , pits[j]);
        	}
        }
        
        model.addAttribute("player_1", p[0].getPlayer());
        model.addAttribute("player_2", p[1].getPlayer());
        model.addAttribute("message", g.showStatus());
        
        return "game";
    }
    
	@RequestMapping(value="/game", method=RequestMethod.POST, params={"pit_number"})
    public String playGame(@RequestParam(value="pit_number", required=true) int pit_number, ModelMap model) 
	{
        model.addAttribute("next_player", g.playWebGame(pit_number));
		Players[] p = new Players[2];
        p = g.getPlayers();
        
        for (int i=0; i < p.length ; i++){
        	int[] pits = p[i].getPit();
	        for (int j=0; j < pits.length ; j++){
	        	model.addAttribute("P" + (i+1) + (j+1) , pits[j]);
        	}
        }
        
        model.addAttribute("player_1", p[0].getPlayer());
        model.addAttribute("player_2", p[1].getPlayer());
        model.addAttribute("message", g.showStatus());
        
        return "game";
    }
	
	@RequestMapping(value="/welcome", method=RequestMethod.POST)
	   public ModelAndView reset() {
			g = new Game();
			String message = "<H2>Welcome to Kalah Game </H3>";
			return new ModelAndView("welcome", "message", message);
	   }

}
