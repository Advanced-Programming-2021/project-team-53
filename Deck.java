import java.util.*;

public class Deck {
    
    private String Username ;
    private String DeckName ;
    static  ArrayList<Deck> PlayerDeck = new ArrayList<Deck>();
    private ArrayList<String> MainDeck = new ArrayList<String>();
    private ArrayList<String> SideDeck = new ArrayList<String>();
    
    

    public   Deck (String username,String deckname  ){
        DeckName = deckname;
        Username = username;
        PlayerDeck.add(this);
    }

    public static Deck GetDeckByName(String username,String deckname){
      //boolean ExistCheck = false;
        for (Deck deck : PlayerDeck) {
            if   ((deck.getUsername().equals(username))&&(deck.getDeckname().equals(deckname)))  return deck;
           }

            return null;

    }

     public void DeleteDeck (String username,String deckname){
      int i = 0 ;
        for (Deck deck : PlayerDeck) {
            if ((deck.getUsername().equals(username))&&(deck.getDeckname().equals(deckname)))  PlayerDeck.remove(i);
       i++;
        }
     }

     public void AddCardToMainDeck (String name){
         MainDeck.add(name);
     }
 
     public void AddCardToSideDeck (String name){
        SideDeck.add(name);
    }

    public int MainDecksize (){
       return MainDeck.size();
    }

    public int SideDecksize (){
        return SideDeck.size();
     }

     public void DeleteCardFromMainDeck (String cardname){
        int i = 0 ;
        for (String maindeck : MainDeck) {
            if   (maindeck.equals(cardname)) MainDeck.remove(i);
       i++;
     }}

     public void DeleteCardFromSideDeck (String cardname){
        int i = 0 ;
        for (String sidedeck : SideDeck) {
            if   (sidedeck.equals(cardname))  SideDeck.remove(i);
       i++;
     }
    }

    public int AmountCardInDeck (String name){
      int amount = 0;
        for (int i = 0 ; i < MainDeck.size() ;i++){
            if (name.equals(MainDeck.get(i))) amount=amount+1;
        }

        for (int j= 0 ; j < SideDeck.size() ;j++){
            if (name.equals(SideDeck.get(j))) amount=amount+1;
        }
        return amount;
    }

  
    
    
    
    public void ShowOnedeck(String name,int number){
        int i = 0 ;
        for (String sidedeck : MainDeck) {
            if   (sidedeck.equals(name)) break;
       i++;
     }
     
    }

    public String getUsername(){
        return Username;
    }
    public String getDeckname(){
        return DeckName;
    }
    





}
