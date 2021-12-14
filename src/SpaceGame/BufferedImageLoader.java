
// Class: BufferedImageLoader

package SpaceGame;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;


public class BufferedImageLoader {
 
   private BufferedImage m_buffImage;  
    
   public BufferedImage loadImage(String strPath) throws IOException {   
      m_buffImage = ImageIO.read(getClass().getResource(strPath));
      return m_buffImage;      
   }
   
}
