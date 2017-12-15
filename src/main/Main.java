/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;


import core.*;
import display.*;

/**
 *
 * @author Nathan
 */
public class Main {
    
    public static void main(String[] args) {
        Game g = new Game();
        //For the fight
        //Room poolroom = new Room ("PoolRoom", "..\\pictures\\Rooms\\billard.png");
        //Enemy mr_Wellington = new Enemy("Mr Wellington","I was in the dancing room with my wife", poolroom, 8,100,60, null);
        //
        
        g.createRooms();
        g.createCharacters();       
        g.createItem();  
        Display window = new Display(g);
        window.generateDisplay(g);
        g.play(window);
        //DisplayChest dc = new DisplayChest(window);
        //DisplayFight df =new DisplayFight(g.getPlayer(), mr_Wellington);
        //Potion p = new Potion ("Potion 1HP", "Coucou", 1);
        //g.getPlayer().addItem(p);
        //df.displayFight(window);
        //DisplaySpeak windowSpeak = new DisplaySpeak(g);
        //DisplayFight windowFight = new DisplayFight(g, mr_Wellington);
    }
}
