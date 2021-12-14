
// Class: KeyInput

package SpaceGame;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class KeyInput extends KeyAdapter {
 
   SpaceGame m_SpaceGame;
   
   public KeyInput(SpaceGame spaceGame) {
      this.m_SpaceGame = spaceGame;
   }
    
   public void keyPressed(KeyEvent ke) {
      m_SpaceGame.keyPressed(ke);
   }    
    
   public void keyReleased(KeyEvent ke) {
      m_SpaceGame.keyReleased(ke);
   }    
   
}
