
// Class: MainMenu

package SpaceGame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;


public class MainMenu {
   
   public Rectangle m_PlayButton = new Rectangle(SpaceGame.WIDTH / 2 + 120, 
                                                                150, 100, 50); 
   public Rectangle m_HelpButton = new Rectangle(SpaceGame.WIDTH / 2 + 120, 
                                                                250, 100, 50);
   public Rectangle m_QuitButton = new Rectangle(SpaceGame.WIDTH / 2 + 120, 
                                                                350, 100, 50);   
   public TextLabel m_TextLabel;
   
   public MainMenu(TextLabel lblText) {
   
      this.m_TextLabel = lblText;    
       
   }
   
   
   public void render(Graphics g) {
   
      Graphics2D g2d = (Graphics2D) g; 
      
      // MainMenu information text.
      Font menuFont = new Font("Arial", Font.BOLD, 50);     
      g.setFont(menuFont);
      g.setColor(Color.white);
      g.drawString("Space Game!", SpaceGame.WIDTH / 2, 100);
      
      // MainMenu button text.
      Font buttonFont = new Font("Arial", Font.BOLD, 30);      
      g.setFont(buttonFont);
      g.setColor(Color.yellow);
           
      g.drawString("Play", m_PlayButton.x + 20, m_PlayButton.y + 35);
      g.drawString("Help", m_HelpButton.x + 20, m_HelpButton.y + 35); 
      g.drawString("Quit", m_QuitButton.x + 20, m_QuitButton.y + 35);
      
      // Player name text.
      String strTextInfo = "Click/Write player name: ";
      String strPlayerName = SpaceGame.m_StrPlayerName;      
      Font playerNameFont = new Font("Arial", Font.BOLD, 14);

      m_TextLabel.setTextFont(playerNameFont);
      m_TextLabel.setTextOne(strTextInfo);
      m_TextLabel.setTextTwo(strPlayerName);
      m_TextLabel.render(g);
      
      g.setColor(Color.white);
      
      // Draw the Buttons.
      g2d.draw(m_PlayButton);
      g2d.draw(m_HelpButton);
      g2d.draw(m_QuitButton);
      
   } 
        
}
