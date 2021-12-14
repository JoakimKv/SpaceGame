
// Class: MouseInput

package SpaceGame;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class MouseInput implements MouseListener {

    protected SpaceGame m_SpaceGame;
    
    public MouseInput(SpaceGame spaceGame) {
    
       this.m_SpaceGame = spaceGame;    
        
    }
    
    public void mouseClicked(MouseEvent e) {
        
       int mouseX = e.getX();
       int mouseY = e.getY();
       boolean bIsClicked = false;
       
       // If we are in the main menu.
       if (SpaceGame.m_State == SpaceGame.STATE.MAINMENU) {
           
          bIsClicked = m_SpaceGame.m_TextLabel.checkIfTextLabelIsClicked(mouseX, 
                                                                       mouseY);   
                        
          m_SpaceGame.m_TextLabel.setActive(bIsClicked);
                                
       }
       
    }

    public void mousePressed(MouseEvent e) {
    
       int mouseX = e.getX();
       int mouseY = e.getY();

       
       // If we are in the help menu.
       if (SpaceGame.m_State == SpaceGame.STATE.HELPMENU) {
       
          // Play Button.
          if (mouseX >= SpaceGame.WIDTH / 2 + 120 && 
                                        mouseX <= SpaceGame.WIDTH / 2 + 220) {
       
             if (mouseY >= 150 && mouseY <= 200) {
       
                // Pressed Play Button.           
                SpaceGame.m_State = SpaceGame.STATE.GAME;
           
             }           
                     
          }
       
          // Quit Button.
          if (mouseX >= SpaceGame.WIDTH / 2 + 120 && 
                                        mouseX <= SpaceGame.WIDTH / 2 + 220) {
       
             if (mouseY >= 250 && mouseY <= 300) {
       
                // Pressed Quit Button.           
                System.exit(1);
           
             }           
                     
          }
              
       }   // End if (SpaceGame.m_State == SpaceGame.STATE.HELPMENU) ...         

       
       // If we are in the main menu.
       if (SpaceGame.m_State == SpaceGame.STATE.MAINMENU) {
       
          // Play Button.
          if (mouseX >= SpaceGame.WIDTH / 2 + 120 && 
                                        mouseX <= SpaceGame.WIDTH / 2 + 220) {
       
             if (mouseY >= 150 && mouseY <= 200) {
       
                // Pressed Play Button.           
                SpaceGame.m_State = SpaceGame.STATE.GAME;
           
             }           
                     
          }
       
          // Quit Button.
          if (mouseX >= SpaceGame.WIDTH / 2 + 120 && 
                                        mouseX <= SpaceGame.WIDTH / 2 + 220) {
       
             if (mouseY >= 350 && mouseY <= 400) {
       
                // Pressed Quit Button.           
                System.exit(1);
           
             }           
                     
          }
       
          // Help Button.
          if (mouseX >= SpaceGame.WIDTH / 2 + 120 && 
                                        mouseX <= SpaceGame.WIDTH / 2 + 220) {
       
             if (mouseY >= 250 && mouseY <= 300) {
       
                // Pressed Help Button.
                SpaceGame.m_State = SpaceGame.STATE.HELPMENU;
           
             }           

          }
       
       }   // End if (SpaceGame.m_State == SpaceGame.STATE.MAINMENU) ...
             
    }

    public void mouseReleased(MouseEvent e) {

    }

    public void mouseEntered(MouseEvent e) {

    }

    public void mouseExited(MouseEvent e) {

    }
    
}
