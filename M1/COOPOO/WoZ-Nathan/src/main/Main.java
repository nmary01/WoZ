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
        Room poolroom = new Room ("PoolRoom", "../pictures/Rooms/billard.png");
        Enemy mr_Wellington = new Enemy("Mr Wellington","I was in the dancing room with my wife", poolroom, 1,10,7, null);
        //
        g.play();
        Display window = new Display(g);
        window.generateDisplay(g);
        //DisplaySpeak windowSpeak = new DisplaySpeak(g);
        //DisplayFight windowFight = new DisplayFight(g, mr_Wellington);
    }
}
