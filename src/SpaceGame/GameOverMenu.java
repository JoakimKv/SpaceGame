
// Class: GameOverMenu

package SpaceGame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;


public class GameOverMenu {
 
   public void render(Graphics g) {
      
      // Menu information text (when the game is over (finnished)).
      Font menuFont = new Font("Arial", Font.BOLD, 50);     
      g.setFont(menuFont);
      g.setColor(Color.white);
      g.drawString("Game Over!", SpaceGame.WIDTH / 2, 100);
      
      Font infoFont = new Font("Arial", Font.BOLD, 20);     
      g.setFont(infoFont);
      g.setColor(Color.white);
      g.drawString("Finnish the game by pressing any ", SpaceGame.WIDTH / 3, 
                                                                         150); 
                 
      g.drawString("of the q, escape or space bar key!", SpaceGame.WIDTH / 3, 
                                                                         175);
      
   }     
    
}
