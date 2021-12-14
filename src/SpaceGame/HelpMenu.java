
// Class: HelpMenu

package SpaceGame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;


public class HelpMenu {

   public Rectangle m_PlayButton = new Rectangle(SpaceGame.WIDTH / 2 + 120, 
                                                                150, 100, 50); 

   public Rectangle m_QuitButton = new Rectangle(SpaceGame.WIDTH / 2 + 120, 
                                                                250, 100, 50);   
   
   
   public void render(Graphics g) {
   
      Graphics2D g2d = (Graphics2D) g; 
      
      // Menu information text.
      Font menuFont = new Font("Arial", Font.BOLD, 40);     
      g.setFont(menuFont);
      g.setColor(Color.white);
      g.drawString("No help is implemented yet!", SpaceGame.WIDTH / 5, 100);
      
      // Menu button text.
      Font buttonFont = new Font("Arial", Font.BOLD, 30);      
      g.setFont(buttonFont);
      g.setColor(Color.yellow);
      
      g.drawString("Play", m_PlayButton.x + 20, m_PlayButton.y + 35);
      g.drawString("Quit", m_QuitButton.x + 20, m_QuitButton.y + 35);      
      
      g.setColor(Color.white);
      
      // Draw the Buttons.
      g2d.draw(m_PlayButton);
      g2d.draw(m_QuitButton);
      
   }     
    
}
