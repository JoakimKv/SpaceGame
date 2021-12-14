
// Class: SpaceGame

package SpaceGame;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.LinkedList;


public class SpaceGame extends Canvas implements Runnable {
  
   private static final long serialVersionUID = 1L; 
   public static final int WIDTH = 320;
   public static final int HEIGHT = 3 * WIDTH / 4;
   public static final int SCALE = 2;
   public final String TITLE = "2D Space Game";
   
   private boolean bRunning = false;
   private Thread m_Thread;
   
   private BufferedImage buffImage = new BufferedImage(WIDTH, HEIGHT, 
                                                 BufferedImage.TYPE_INT_RGB);
   
   private BufferedImage spriteSheet = null;
   private BufferedImage background = null;   
   
   private boolean m_bIsShooting = false;
   
   private int m_iEnemyCount = 5;
   private int m_iEnemyKilled = 0;
   
   private Player m_Player;
   private Controller m_Controller;
   private Textures m_Textures;
   private Window m_Window;
   public TextLabel m_TextLabel;
   
   public LinkedList<EntityA> m_pEntitiesA;
   public LinkedList<EntityB> m_pEntitiesB;
   
   public static int m_iHealth = 200;
   
   public static enum STATE {
      MAINMENU,
      GAME,
      GAMEOVER,
      HELPMENU
   };
   
   public static STATE m_State = STATE.MAINMENU;
   
   private MainMenu m_MainMenu;
   private GameOverMenu m_GameOverMenu;   
   private HelpMenu m_HelpMenu;
   
   public static String m_StrPlayerName = "";
   
   
   public SpaceGame() {
     
      int iWidth = SpaceGame.WIDTH * SpaceGame.SCALE;
      int iHeight = SpaceGame.HEIGHT * SpaceGame.SCALE;
       
      m_Window = new Window(iWidth, iHeight, this.TITLE, this);
      
   } 
      
   public void init() {
       
      requestFocus(); 
       
      BufferedImageLoader buffImageLoader = new BufferedImageLoader();
      
      try {
         spriteSheet = buffImageLoader.loadImage("Res/Game_Objects.png");
         background = buffImageLoader.loadImage("Res/Background.png");
      }
      catch (IOException e) {
         e.printStackTrace();
      }
      
      int iX = SpaceGame.WIDTH / 2 + 120 - 240;
      int iY = 250 - 5;
      int iWidth = 200;
      int iHeight = 65;
      
      m_TextLabel = new TextLabel(iX, iY, iWidth, iHeight);
      
      // Add the key listener before the Player is created.
      this.addKeyListener(new KeyInput(this));
      
      // Add the key listener before the Player is created.
      this.addMouseListener(new MouseInput(this)); 
      
      // Menus.
      m_MainMenu = new MainMenu(m_TextLabel);
      m_GameOverMenu = new GameOverMenu();
      m_HelpMenu = new HelpMenu();
      
      // The Textures need to be created before the Player and Controller
      // objects are created.
      m_Textures = new Textures(this);
      
      // The parameter "this" is a SpaceGame object here.
      m_Controller = new Controller(this, m_Textures);
      m_Player = new Player(200, 200, m_Textures, this, m_Controller);
      

      
      // Linked lists for A and B objects.
      m_pEntitiesA = m_Controller.getEntityA();
      m_pEntitiesB = m_Controller.getEntityB();
      
      m_Controller.createEnemy(m_iEnemyCount);
      
   }
   
   private synchronized void start() {
       
      if (bRunning) {
         return;
      }
      
      // If the thread isn't running, set bRunning true and
      // create a new thread to run. Note that "this" is connected
      // to the SpaceGame object. Start the thread.
      bRunning = true;
      m_Thread = new Thread(this);
      m_Thread.start();
      
   }
 
   private synchronized void stop() {
       
      if (!bRunning) {
         return;
      }
      
      // If the thread is running, set bRunning false and
      // join the threads and exit the program.
      bRunning = false;
      try {
         m_Thread.join();
      }
      catch (InterruptedException e) {
         e.printStackTrace();
      }
      System.exit(1);
      
   }   
   
   public void run() {
      
      init(); 
      long lLastTime = System.nanoTime();
      final double dAmountOfTicks = 60.0;
      double dNs = 1000000000 / dAmountOfTicks;
      double dDelta = 0;
      long lNow;
      int iUpdates = 0;
      int iFrames = 0;
      long lTimer = System.currentTimeMillis();
      
      while (bRunning) {
         
         // The game loop.
                    
         lNow = System.nanoTime();
         dDelta += (lNow - lLastTime) / dNs;
         lLastTime = lNow;         
         if (dDelta > 1) {          
            tick();
            iUpdates++;
            dDelta--;
         }
         render();
         iFrames++;
         
         if (System.currentTimeMillis() - lTimer > 1000) {
            lTimer += 1000;
            System.out.println(iUpdates + " Ticks, Fps " + iFrames + ".");
            iUpdates = 0;
            iFrames = 0;
         }
         
      }
      stop();
   
   }
   
   private void tick() {
       
      if (m_State == STATE.GAME) { 
       
         m_Player.tick();
         m_Controller.tick();
      
      }
      
      if (m_iEnemyKilled >= m_iEnemyCount) {
          
         m_iEnemyCount += 2;
         m_iEnemyKilled = 0;
         m_Controller.createEnemy(m_iEnemyCount);
         
      }
      
   }
   
   private void render() {
   
      BufferStrategy buffStrategy = this.getBufferStrategy();
      
      if (buffStrategy == null) {      
         createBufferStrategy(3);
         return;         
      }
      
      Graphics g = buffStrategy.getDrawGraphics();
      
      // Draw graphics in here.
      
      // Start drawing.
      
      g.drawImage(buffImage, 0, 0, getWidth(), getHeight(), this);
      g.setColor(Color.black);
      g.fillRect(0, 0, getWidth(), getHeight());
      
      // Draw the background.
      g.drawImage(background, 0, 0, null);
 
      // In the game.
      if (m_State == STATE.GAME) { 
      
         m_Player.render(g);
         m_Controller.render(g);
         
         g.setColor(Color.gray);
         g.fillRect(5, 5, 200, 50);
         
         g.setColor(Color.green);
         g.fillRect(5, 5, m_iHealth, 50);
         
         g.setColor(Color.white);
         g.drawRect(5, 5, 200, 50);
         
         Font myFont = new Font("Arial", Font.PLAIN, 20);
         g.setFont(myFont);
         g.setColor(Color.white);
         g.drawString("Player: " + SpaceGame.m_StrPlayerName, 10, 80);         
         
      }
      
      // In the menu.
      else if (m_State == STATE.MAINMENU) {
       
         m_MainMenu.render(g);
          
      }
      
      // In the game over menu.
      else if (m_State == STATE.GAMEOVER) {
       
         m_GameOverMenu.render(g);
          
      } 
      
      // In the help menu.
      else if (m_State == STATE.HELPMENU) {
       
         m_HelpMenu.render(g);
          
      }      
      // End drawing.
      
      g.dispose();
      buffStrategy.show();
      
   }
   
   public BufferedImage getSpriteSheet() {
      return spriteSheet;
   }

   public void keyPressed(KeyEvent ke) {
      
      int iKey = ke.getKeyCode();
      char chKey = ke.getKeyChar();

      int iStrLength = SpaceGame.m_StrPlayerName.length();
      
      // In the game.
      if (m_State == STATE.GAME) { 
      
         if (iKey == KeyEvent.VK_RIGHT) {
            m_Player.setVelX(5);
         }
         else if (iKey == KeyEvent.VK_LEFT) {
            m_Player.setVelX(-5);      
         } 
         else if (iKey == KeyEvent.VK_DOWN) {
            m_Player.setVelY(5);      
         }       
         else if (iKey == KeyEvent.VK_UP) {
            m_Player.setVelY(-5);      
         } 
         else if (iKey == KeyEvent.VK_SPACE && !m_bIsShooting) {
            m_bIsShooting = true;
            m_Controller.addEntity(new Bullet(m_Player.getX(), 
                                           m_Player.getY(), m_Textures, this));      
         }   // End if (iKey == ...)   
         
      }   // End if (m_State == ...)
      
      // In the Game over menu.
      if (m_State == STATE.GAMEOVER) {
  
         if (iKey == KeyEvent.VK_Q || iKey == KeyEvent.VK_ESCAPE || 
                                                  iKey == KeyEvent.VK_SPACE) {
             
            System.exit(1);
            
         }   // End if (iKey == ...)
                   
      }   // End if (m_State == ...) 
 
      // In the Main menu.
      if (m_State == STATE.MAINMENU) {
          
         boolean bIsClicked = false;
         
         bIsClicked = m_TextLabel.isActive();
         
         if (bIsClicked) {
  
            if (chKey >= 'A' && chKey <= 'Z' || chKey >= 'a' && chKey <= 'z' || 
                chKey == ' ' || chKey == 'å' || chKey == 'ä' || chKey == 'ö' || 
                chKey == 'Å' || chKey == 'Ä' || chKey == 'Ö' || 
                chKey >= '0' && chKey <= '9') {
             
               SpaceGame.m_StrPlayerName += chKey;
            
            }   // End if (chKey == ...)
         
            // Remove the last letter in the name if backspace is pressed
            // and the string isn't empty.
            if (iKey == KeyEvent.VK_BACK_SPACE && iStrLength >= 1) {
             
               SpaceGame.m_StrPlayerName = 
                        SpaceGame.m_StrPlayerName.substring(0, iStrLength - 1);
            
            }   // End if (iKey == ...)
            
         }   // End if (bIsClicked) ...
                   
      }   // End if (m_State == ...) 
      
   }    
    
   public void keyReleased(KeyEvent ke) {
      
      int iKey = ke.getKeyCode();
      
      if (iKey == KeyEvent.VK_RIGHT) {
         m_Player.setVelX(0);
      }
      else if (iKey == KeyEvent.VK_LEFT) {
         m_Player.setVelX(0);      
      } 
      else if (iKey == KeyEvent.VK_DOWN) {
         m_Player.setVelY(0);      
      }       
      else if (iKey == KeyEvent.VK_UP) {
         m_Player.setVelY(0);      
      } 
      else if (iKey == KeyEvent.VK_SPACE) {
         m_bIsShooting = false;
      }
            
   }       
   
   public int getEnemyCount() {
      return m_iEnemyCount;
   }
   
   public int getEnemyKilled() {
      return m_iEnemyKilled;
   }
   
   public void setEnemyCount(int iEnemyCount) {
      this.m_iEnemyCount = iEnemyCount;
   }
   
   public void setEnemyKilled(int iEnemyKilled) {
      this.m_iEnemyKilled = iEnemyKilled;
   }   
   
   public static void main(String[] args) {
       
      SpaceGame spaceGame = new SpaceGame();
            
      spaceGame.start();
      
   }
    
}
