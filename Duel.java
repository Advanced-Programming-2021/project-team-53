import java.util.*;
public class Duel {
   String UsernameNumberOne;
   String UsernameNumberTwo;
  private int UsernameNumberOneLife;
  private int UsernameNumberTwoLife;
  private String UsernameNumberOneFieldZone;
  private String UsernameNumberTwoFieldZone;
  private String[] UsernameNumberTwoMonsterCard = new String[5];
  private String[] UsernameNumberOneMonsterCard = new String[5];
  private String[] UsernameNumberTwoSpellCard = new String[5];
  private String[] UsernameNumberOneSpellCard = new String[5];
  private String[] UsernameNumberTwoHandCard = new String[6];
  private String[] UsernameNumberOneHandCard = new String[6];
  private  ArrayList<String> UsernameNumberOneGraveyard = new ArrayList<String>();
  private  ArrayList<String> UsernameNumberTwoGraveyard = new ArrayList<String>();
  private  ArrayList<String> UsernameNumberOneDeck = new ArrayList<String>();
  private  ArrayList<String> UsernameNumberTwoDeck = new ArrayList<String>();
  private int AmountRounds;
  private boolean NumberOneTurn = true;
  private String CurrentPhase;
  private String[] Phase = {"draw phase","draw phase","main phase 1"," battle phase","main phase 2","end phase"} ;
  static  ArrayList<Duel> duels = new ArrayList<Duel>();
  public  Duel ( String usernamenumberone, String usernamenumbertwo, int amountrounds ){
    this.AmountRounds = amountrounds;
    this.UsernameNumberOne = usernamenumberone ;
    this.UsernameNumberTwo = usernamenumbertwo ;

   duels.add(this);
  }
  public static Duel getDuelByUsernameNumberOne(String usernamenumberone ,String usernamenumbertwo ){
  for (Duel duel : duels) {
    if  ((duel.getUsernameNumberTwo().equals(usernamenumbertwo))&& (duel.getUsernameNumberOne().equals(usernamenumberone)))  return duel;
   }
return null;
}
public String getCurrentPhase(){
  return CurrentPhase;
}
////////////////////////////////////////////////////////////////////////////////////////////////////
public String getUserNumberOneCardDeck(int i ){                         // deck                                                       
  return UsernameNumberOneDeck.get(i);                                  // deck                                              
}                                                                       // deck         
public String getUserNumberTwoCardDeck(int i ){                         // deck                                                       
  return UsernameNumberTwoDeck.get(i);                                  // deck                                              
}                                                                       // deck                                                                                // deck        
public int AmountCardInUsernameNumberOneDeck(){                         // deck                                                       
 return UsernameNumberOneDeck.size();                                   // deck                                             
}                                                                       // deck                                                                                 // deck        
public int AmountCardInUsernameNumberTwoDeck(){                         // deck                                                       
  return UsernameNumberTwoDeck.size();                                  // deck                                              
}                                                                       // deck                                                                                // deck        
public void DeleteOneCardFromUsernameNumberOneDeck(String name){        // deck                                                                        
  UsernameNumberOneDeck.remove(name);                                   // deck                                             
}                                                                       // deck                                                                                 // deck        
public void DeleteOneCardFromUsernameNumberTwoDeck(String name){        // deck                                                                        
  UsernameNumberTwoDeck.remove(name);                                   // deck                                             
}                                                                       // deck                                                                                 // deck        
public void AddOneCardToUsernameNumberOneDeck(String name){             // deck                                                                   
  UsernameNumberOneDeck.add(name);                                      // deck                                          
}                                                                       // deck                                                                                 // deck        
public void AddOneCardToUsernameNumberTwoDeck(String name){             // deck                                                                   
  UsernameNumberTwoDeck.add(name);                                      // deck                                          
}
//////////////////////////////////////////////////////////////////////////////////
public String getUsernameNumberOne(){
    return UsernameNumberOne;
}

public String getUsernameNumberTwo(){
    return UsernameNumberTwo;
}

public int getUsernameNumberOneLife(){
  return UsernameNumberOneLife;
}

public int getUsernameNumberTwoLife(){
  return UsernameNumberTwoLife;
}

public void increaseUsernameNumberOneLife(int amount){
  UsernameNumberOneLife = UsernameNumberOneLife + amount;
}



public void increaseUsernameNumberTwoLife(int amount){
  UsernameNumberTwoLife = UsernameNumberTwoLife + amount;
}

///////////////////////////////////////////////////////////////////////////////////////////////////
public void AddCardToUsernameNumberOneGraveyard(String cardname){             //garva yard                                                                          
  UsernameNumberOneGraveyard.add(cardname);                                   //garva yard                                                    
}                                                                             //garva yard                                                                                       //garva yard         
public void AddCardToUsernameNumberTwoGraveyard(String cardname){             //garva yard                                                                          
  UsernameNumberTwoGraveyard.add(cardname);                                   //garva yard                                                    
}                                                                             //garva yard                                                                                       //garva yard         
public void DeleteCardFromUsernameNumberOneGraveyard(String cardname){        //garva yard                                                                               
  UsernameNumberOneGraveyard.remove(cardname);                                //garva yard                                                       
}                                                                             //garva yard                                                                                      //garva yard         
public void DeleteCardFromUsernameNumberTwoGraveyard(String cardname){        //garva yard                                                                               
  UsernameNumberTwoGraveyard.remove(cardname);                                //garva yard                                                       
}                                                                             //garva yard                                                                                      //garva yard         
public int AmountUsernameNumberOneGraveyard(){                                //garva yard                                                       
  return UsernameNumberOneGraveyard.size();                                   //garva yard                                                    
}                                                                             //garva yard          
public int AmountUsernameNumberTwoGraveyard(){                                //garva yard                                                       
  return UsernameNumberTwoGraveyard.size();                                   //garva yard                                                    
}
////////////////////////////////////////////////////////////////////////////////////////
public void AddCardToUsernameNumberOneHandCard(String cardname, int number){                //hand card                                                                            
 UsernameNumberOneHandCard[number-1] = cardname;                                            //hand card                                                
}                                                                                           //hand card                                                                                 //hand card
public void AddCardToUsernameNumberTwoHandCard(String cardname,int number){                 //hand card                                                                           
  UsernameNumberTwoHandCard[number-1] = cardname;                                           //hand card                                                 
}                                                                                           //hand card                                                                                  //hand card
public void DeleteCardFromUsernameNumberOneHandCard(int number){                            //hand card                                                                
  UsernameNumberOneHandCard[number-1] = null ;                                              //hand card                                              
}                                                                                           //hand card                                                                                 //hand card
public void DeleteCardFromUsernameNumberTwoHandCard(int number){                            //hand card                                                                
  UsernameNumberTwoHandCard[number-1] = null;                                               //hand card                                             
}                                                                                           //hand card                                                                                  //hand card
public boolean CheckCardInUsernameNumberOneHandCard( int number){                           //hand card                                                                 
  if (UsernameNumberOneHandCard[number-1]!=null) return true;                               //hand card                                                             
  else return false;                                                                        //hand card                    
 }                                                                                          //hand card 
 public boolean CheckCardInUsernameNumberTwoHandCard(int number){                           //hand card                                                                 
  if (UsernameNumberTwoHandCard[number-1]!=null) return true;                               //hand card                                                             
  else return false;                                                                        //hand card                    
 }                                                                                          //hand card                                                                                  //hand card 
 public int AmountCardInUsernameNumberOneHandCard(){                                        //hand card                                                    
  int i=0;                                                                                  //hand card          
  for(int j = 0 ; j < 6; j++){if (UsernameNumberOneHandCard[j]!=null) i++;}                 //hand card                                                                           
  return i;                                                                                 //hand card           
 }                                                                                          //hand card                                                                                 //hand card 
 public int AmountCardInUsernameNumberTwoHandCard(){                                        //hand card                                                    
  int i=0;                                                                                  //hand card          
  for(int j = 0 ; j < 6; j++){if (UsernameNumberTwoHandCard[j]!=null) i++;}                 //hand card                                                                           
  return i;                                                                                 //hand card           
 }                                                                                          //hand card
 public Boolean  CheckCardInUsernameNumberOneByCardName(String name) {                      //hand card          
  for(int j = 0 ; j < 6; j++){if (UsernameNumberOneHandCard[j].equals(name)) return true;}  //hand card                              
  return false;                                                                             //hand card                
 }                                                                                          //hand card     
 public Boolean  CheckCardInUsernameNumberTwoByCardName(String name) {                      //hand card          
  for(int j = 0 ; j < 6; j++){if (UsernameNumberTwoHandCard[j].equals(name)) return true;}  //hand card                              
  return false;                                                                             //hand card                
 }                                                                                          //hand card          
 public String getCardUsernameNumberOneHandCard(int number){                                //hand card                                                             
  return UsernameNumberOneHandCard[number-1];                                               //hand card                                              
}                                                                                           //hand card                                                                                             //hand card 
public String getCardUsernameNumberTwoHandCard(int number){                                 //hand card                                                            
  return UsernameNumberTwoHandCard[number-1];                                               //hand card                                              
}                                                                                    //hand card  

///////////////////////////////////////////////////////////////////////////////////////////////////////                                                                                        
public boolean CheckEmptyUsernameNumberOneMonsterCard(int number){                     //monster card                                                                      
  if (UsernameNumberOneMonsterCard[number - 1 ]!= null ) return true;                  //monster card                                                                         
  else return false;                                                                   //monster card                        
}                                                                                      //monster card                                                                                       //monster card    
public boolean CheckEmptyUsernameNumberTwoMonsterCard(int number){                     //monster card                                                                      
  if (UsernameNumberOneMonsterCard[number - 1 ]!= null ) return true;                  //monster card                                                                         
  else return false;                                                                   //monster card                        
}                                                                                      //monster card    
public boolean CheckUsenameNumberOneMonsterCardByName (String cardname)   {            //monster card                                                                       
  for (int i = 0 ;i < 5;i++){                                                          //monster card                         
    if (cardname.equals(UsernameNumberOneMonsterCard[i])) return true;                 //monster card                                                                  
  }                                                                                    //monster card
  return false;                                                                        //monster card           
}                                                                                      //monster card
public boolean CheckUsenameNumberTwoMonsterCardByName (String cardname)   {            //monster card                                                                       
  for (int i = 0 ;i < 5;i++){                                                          //monster card                         
    if (cardname.equals(UsernameNumberTwoMonsterCard[i])) return true;                 //monster card                                                                  
  }                                                                                    //monster card
  return false;                                                                        //monster card           
}                                                                                      //monster card                                                                                         //monster card    
public void AddCardToUsernameNumberOneMonsterCard(String cardname,int number){         //monster card                                                                                  
  UsernameNumberOneMonsterCard[number - 1] = cardname;                                 //monster card                                                          
}                                                                                      //monster card     
public void AddCardToUsernameNumberTwoMonsterCard(String cardname,int number){         //monster card                                                                                  
  UsernameNumberTwoMonsterCard[number - 1] = cardname;                                 //monster card                                                          
}                                                                                      // monster card                 
public String getCardFromUsernameNumberOneMonsterCard(int number){                     // monster card                                                                        
  return UsernameNumberOneMonsterCard[number - 1];                                     // monster card                                                        
 }                                                                                     // monster card                                                                                        // monster card       
 public String getCardFromUsernameNumberTwoMonsterCard(int number){                    // monster card                                                                         
   return UsernameNumberTwoMonsterCard[number - 1];                                    // monster card                                                         
 }                                                                                     // monster card         
 public int AmountCardInUsernameNumberOneMonsterCard(){                                // monster card                                                             
   int i = 0;                                                                          // monster card                   
   for (int j = 0 ; j < 5;j++){                                                        // monster card                                     
     if (UsernameNumberOneMonsterCard[j] != null) i++;                                 // monster card                                                            
   }                                                                                   // monster card          
   return i;                                                                           // monster card                     
 }                                                                                     // monster card            
 public int AmountCardInUsernameNumberTwoMonsterCard(){                                // monster card                                                             
  int i = 0;                                                                           // monster card                  
  for (int j = 0 ; j < 5;j++){                                                         // monster card                                    
    if (UsernameNumberTwoMonsterCard[j] != null) i++;                                  // monster card                                                           
  }                                                                                    // monster card         
  return i;                                                                            // monster card                    
}                                                                                // monster card               
/////////////////////////////////////////////////////////////////////////////////////////////                                                                                           
public boolean CheckEmptyUsernameNumberOneFieldZoneCard(){                        // field zone                                                            
  if (UsernameNumberOneFieldZone != null ) return true;                           // field zone                                                         
  else return false;                                                              // field zone                      
}                                                                                 // field zone                                                                                  // field zone  
public boolean CheckEmptyUsernameNumberTwoFieldZoneCard(){                        // field zone                                                            
  if (UsernameNumberTwoFieldZone != null ) return true;                           // field zone                                                         
  else return false;                                                              // field zone                      
}                                                                                 // field zone                                                                                    // field zone  
public void setUsernameNumberOneFieldZone(String name){                           // field zone                                                         
  UsernameNumberOneFieldZone = name;                                              // field zone                                      
}                                                                                 // field zone                                                                                    // field zone  
public void setUsernameNumberTwoFieldZone(String name){                           // field zone                                                         
  UsernameNumberTwoFieldZone = name;                                              // field zone                                      
}                                                                                 // field zone                                                                                    // field zone  
public String getUsernameNumberOneFieldZone(){                                    // field zone                                                
 return UsernameNumberOneFieldZone;                                               // field zone                                     
}                                                                                 // field zone                                                                                   // field zone  
public String getUsernameNumberTwoFieldZone(){                                    // field zone                                                
 return UsernameNumberTwoFieldZone;                                               // field zone                                     
}                                                                                 // field zone                                                                                     // field zone  
////////////////////////////////////////////////////////////////////////////////////////////////                                                                               //spell car                                                                            //spell card 
public boolean CheckEmptyUsernameNumberOneSpellCard(int number){               //spell card                                                                 
  if (UsernameNumberOneSpellCard[number - 1 ]!= null ) return true;            //spell card                                                                                                                                                   
  else return false;                                                           //spell card                                                                                                    
}                                                                              //spell card                                                                                                                                                               //spell card                                                                                
public boolean CheckEmptyUsernameNumberTwoSpellCard(int number){               //spell card                                                                                                                                                
  if (UsernameNumberOneMonsterCard[number - 1 ]!= null ) return true;          //spell card                                                                                                                                                     
  else return false;                                                           //spell card                    
}                                                                              //spell card                                                                               //spell card
public void AddCardToUsernameNumberOneSpellCard(String cardname,int number){   //spell card                                                                            
  UsernameNumberOneSpellCard[number - 1] = cardname;                           //spell card                                                    
}                                                                              //spell card                                                                                //spell card
public void AddCardToUsernameNumberTwoSpellCard(String cardname,int number){   //spell card                                                                            
  UsernameNumberTwoSpellCard[number - 1] = cardname;                           //spell card                                                    
}                                                                              //spell card                                                                               //spell card
public String getCardFromUsernameNumberOneSpellCard(int number){               //spell card                                                                
  return UsernameNumberOneSpellCard[number - 1];                               //spell card                                                
 }                                                                             //spell card                                                                                //spell card 
 public String getCardFromUsernameNumberTwoSpellCard(int number){              //spell card                                                                 
   return UsernameNumberTwoSpellCard[number - 1];                              //spell card                                                 
 }
////////////////////////////////////////////////////////////////////////////////////////

public void ShowMapForUsernameNumberOne(){
 System.out.println(Player.GetPlayerBySTH(UsernameNumberTwo, 1).getNickname()+":"+UsernameNumberTwoLife); 
 int amount;
 for (int j = 0; j < 5;j++){}
 for (int i = 0;i<6;i++){System.out.print("   "+amount);}
 System.out.println();
 System.out.println(AmountCardInUsernameNumberTwoDeck());




}

public void ShowMapForUsernameNumberTwo(){



  
}
public void setCurrentPhase(int  number) {
    CurrentPhase = Phase[number - 1];
}



}
