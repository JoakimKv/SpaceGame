
// Class: Physics

package SpaceGame;

import java.util.LinkedList;


public class Physics {

   public static boolean Collision(EntityA newEntityA, 
                                           LinkedList<EntityB> pEntitiesB) {
          
      int iCount; 
            
      for (iCount = 0; iCount < pEntitiesB.size(); ++iCount) {
      
         if (newEntityA.getBounds().intersects(
                                        pEntitiesB.get(iCount).getBounds())) {
            return true;
         }
          
      }
        
      return false;    
       
   } 

   public static boolean Collision(EntityB newEntityB, 
                                           LinkedList<EntityA> pEntitiesA) {
          
      int iCount; 
            
      for (iCount = 0; iCount < pEntitiesA.size(); ++iCount) {
      
         if (newEntityB.getBounds().intersects(
                                        pEntitiesA.get(iCount).getBounds())) {
            return true;
         }
          
      }
        
      return false;    
       
   }    
 
   public static boolean Collision(EntityA newEntityA, EntityB newEntityB) {
                
      if (newEntityA.getBounds().intersects(newEntityB.getBounds())) {
          
         return true;
         
      }
        
      return false;    
       
   }     

   public static boolean Collision(EntityB newEntityB, EntityA newEntityA) {
                
      if (newEntityB.getBounds().intersects(newEntityA.getBounds())) {
          
         return true;
         
      }
        
      return false;    
       
   }     
   
}
