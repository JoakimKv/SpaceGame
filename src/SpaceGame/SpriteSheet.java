
// Class: SpriteSheet


package SpaceGame;

import java.awt.image.BufferedImage;


public class SpriteSheet {
 
   private BufferedImage m_BuffImage;    
    
   public SpriteSheet(BufferedImage buffImage) {
      this.m_BuffImage = buffImage;
   }
 
   public BufferedImage grabImage(int iRow, int iCol, 
                                            int iWidth, int iHeight) {
       
      BufferedImage buffImage = m_BuffImage.getSubimage((iCol - 1) * 32, 
              (iRow - 1) * 32, iWidth, iHeight);
      return buffImage;
      
   }   
   
}
