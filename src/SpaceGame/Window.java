
// Class: Window

package SpaceGame;

import java.awt.Dimension;
import javax.swing.JFrame;


public class Window {
   
    
   public Window(int iWidth, int iHeight, String strTitle, 
                                                     SpaceGame spaceGame) {
   
      JFrame frame = new JFrame(strTitle);
      
      frame.setPreferredSize(new Dimension(iWidth, iHeight));
      frame.setMaximumSize(new Dimension(iWidth, iHeight));
      frame.setMinimumSize(new Dimension(iWidth, iHeight));
      
      frame.add(spaceGame);
      frame.pack();
      frame.setResizable(false);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setLocationRelativeTo(null);
      frame.setVisible(true);
      
   }      
        
}
