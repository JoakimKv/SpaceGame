
// Class: TextLabel

package SpaceGame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;


public class TextLabel {

   protected String m_StrTextOne = "";  
   protected String m_StrTextTwo = "";   
   protected int m_iWidth;
   protected int m_iHeight;
   protected int m_iX;
   protected int m_iY;
   protected int m_iX_Offset;
   protected int m_iY_Offset;
   protected int m_iTextDistX;
   protected int m_iTextDistY;
   protected Color m_BackgroundColor = Color.black;
   protected Color m_FrameColor = Color.white;
   protected Color m_TextColor = Color.white;    
   protected Color m_ActiveBackgroundColor = Color.blue;
   protected Color m_ActiveFrameColor = Color.yellow;
   protected Color m_ActiveTextColor = Color.yellow;   
   protected boolean m_bIsActive = false;
   protected Rectangle m_Rectangle;
   protected Font m_TextFont;
   
   public TextLabel() {
   
      this.m_iX = 0;
      this.m_iY = 0;
      this.m_iWidth = 200;
      this.m_iHeight = 65;
      
      this.m_iX_Offset = 20;
      this.m_iY_Offset = 25;
      
      this.m_iTextDistX = 0;
      this.m_iTextDistY = 25;
      
      m_Rectangle = getRectangle();
      m_TextFont = new Font("Arial", Font.BOLD, 16);
      
   }
   
   public TextLabel(int iX, int iY, int iWidth, int iHeight) {
   
      this.m_iX = iX;
      this.m_iY = iY;
      this.m_iWidth = iWidth;
      this.m_iHeight = iHeight;
      
      this.m_iX_Offset = 20;
      this.m_iY_Offset = 25;
      
      this.m_iTextDistX = 0;
      this.m_iTextDistY = 25;
      
      m_Rectangle = getRectangle();
      m_TextFont = new Font("Arial", Font.BOLD, 16);
      
   }
   
   public void render(Graphics g) {
   
      Graphics2D g2d = (Graphics2D) g;
      
      m_Rectangle = getRectangle();
      
      // Draw the text label.    
      g.setFont(this.m_TextFont);
      
      if (isActive()) {
          
         g.setColor(this.m_ActiveTextColor);
         g.drawString(m_StrTextOne, m_iX + m_iX_Offset, m_iY + m_iY_Offset);
         g.drawString(m_StrTextTwo, m_iX + m_iX_Offset + m_iTextDistX, 
                                       m_iY + m_iY_Offset + m_iTextDistY);
         
         g.setColor(this.m_ActiveFrameColor);         
         g2d.draw(m_Rectangle);
         
      }
      
      else 
      {
          
         g.setColor(this.m_TextColor);
         g.drawString(m_StrTextOne, m_iX + m_iX_Offset, m_iY + m_iY_Offset);
         g.drawString(m_StrTextTwo, m_iX + m_iX_Offset + m_iTextDistX, 
                                       m_iY + m_iY_Offset + m_iTextDistY);
         
         g.setColor(this.m_FrameColor);         
         g2d.draw(m_Rectangle);
               
      }
         
   }
   
   public void setTextOne(String strText) {
       
      this.m_StrTextOne = strText;
      
   }
   
   public String getTextOne() {
       
      return this.m_StrTextOne;
      
   }
   
   public void setTextTwo(String strText) {
       
      this.m_StrTextTwo = strText;
      
   }
   
   public String getTextTwo() {
       
      return this.m_StrTextTwo;
      
   }
   
   public int getX() {
       
      return this.m_iX;
      
   }
    
   public void setX(int iX) {
       
      this.m_iX = iX;
      
   }
   
   public int getY() {
       
      return this.m_iY;
      
   }
    
   public void setY(int iY) {
       
      this.m_iY = iY;
      
   }  
   
   public int getTextDistX() {
       
      return this.m_iTextDistX;
      
   }
    
   public void setTextDistX(int iTextDistX) {
       
      this.m_iTextDistX = iTextDistX;
      
   }  
   
   public int getTextDistY() {
       
      return this.m_iTextDistY;
      
   }
    
   public void setTextDistY(int iTextDistY) {
       
      this.m_iTextDistY = iTextDistY;
      
   }  
   
   public int getWidth() {
       
      return this.m_iWidth;
      
   }
    
   public void setWidth(int iWidth) {
       
      this.m_iWidth = iWidth;
      
   } 
   
   public int getHeight() {
       
      return this.m_iHeight;
      
   }
    
   public void setHeight(int iHeight) {
       
      this.m_iHeight = iHeight;
      
   }         
   
   public Rectangle getRectangle() {
       
      return new Rectangle(m_iX, m_iY, m_iWidth, m_iHeight);
      
   }
   
   public Rectangle getBounds() {
       
      return getRectangle();
      
   }   

   public Color getBackgroundColor() {
       
      return this.m_BackgroundColor;
      
   }
    
   public void setBackgroundColor(Color color) {
       
      this.m_BackgroundColor = color;
      
   }   
   
   public Color getFrameColor() {
       
      return this.m_FrameColor;
      
   }
    
   public void setFrameColor(Color color) {
       
      this.m_FrameColor = color;
      
   }
   
   public Color getTextColor() {
       
      return this.m_TextColor;
      
   }
    
   public void setTextColor(Color color) {
       
      this.m_TextColor = color;
      
   }  
   
   public Color getActiveTextColor() {
       
      return this.m_ActiveTextColor;
      
   }
    
   public void setActiveTextColor(Color color) {
       
      this.m_ActiveTextColor = color;
      
   }     
   
   public Color getActiveBackgroundColor() {
       
      return this.m_ActiveBackgroundColor;
      
   }
    
   public void setActiveBackgroundColor(Color color) {
       
      this.m_ActiveBackgroundColor = color;
      
   }   
   
   public Color getActiveFrameColor() {
       
      return this.m_ActiveFrameColor;
      
   }
    
   public void setActiveFrameColor(Color color) {
       
      this.m_ActiveFrameColor = color;
      
   } 
   
   public boolean isActive() {
       
      return this.m_bIsActive;
      
   }
    
   public void setActive(boolean bIsActive) {
       
      this.m_bIsActive = bIsActive;
      
   }
    
   public void setTextFont(Font textFont) {
       
      this.m_TextFont = textFont;
      
   }
   
   public Font getTextFont() {
       
      return this.m_TextFont;
      
   }   
   
   public boolean checkIfTextLabelIsClicked(int iMouseX, int iMouseY) {
       
      boolean bIsClicked = false;
      
      if (iMouseX >= m_iX && iMouseX <= m_iX + m_iWidth) {
          
         if (iMouseY >= m_iY && iMouseY <= m_iY + m_iHeight) {
             
            bIsClicked = true;
            
         }
         
      }
      
      return bIsClicked;
   
   }
   
}
