import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DuelProgram {
 private String[] Phase = {"draw phase","draw phase","main phase 1"," battle phase","main phase 2","end phase"} ;
 private int CurrentPhase = 0;
 private String  SelectedCard;
 private boolean Summon = false;
 private  String UsernameNumberOne;
 private  String UsernameNumberTwo;
 private boolean UserNumberOneTurn = true;
 public void DuelGame(String usernumberone,String usernumbertwo){
this.UsernameNumberOne = usernumberone;
this.UsernameNumberTwo = usernumbertwo;




 }
 public void ChangeUserNumberOneTurn() {
   
    if (UserNumberOneTurn==true ) {System.out.println("its "+Player.GetPlayerBySTH(UsernameNumberTwo, 1).getNickname()+"’s turn");UserNumberOneTurn = false ;}
    else {System.out.println("its "+Player.GetPlayerBySTH(UsernameNumberOne, 1).getNickname()+"’s turn");UserNumberOneTurn = true;}
 
}

public void ChangeCurrentPhase(){
    CurrentPhase = CurrentPhase + 1;
    if (CurrentPhase == 7) {CurrentPhase = 0;ChangeUserNumberOneTurn();}
    
    System.out.println("phase:"+Phase [CurrentPhase - 1]);
}

public void Summon(){
    if (getSelectedCard() == null) System.out.println("no card is selected yet");
    else if ((Duel.getDuelByUsernameNumberOne(UsernameNumberOne, UsernameNumberTwo).CheckCardInUsernameNumberOneByCardName(SelectedCard) == false)||(Duel.getDuelByUsernameNumberOne(UsernameNumberOne, UsernameNumberTwo).CheckCardInUsernameNumberTwoByCardName(SelectedCard) == false)||
    (MonsterCard.IsNameExist(SelectedCard) == null)||(!(MonsterCard.IsNameExist(SelectedCard).getCardType().equals("Normall")))) System.out.println("you can’t summon this card");
else if  ((CurrentPhase!=3)&&(CurrentPhase!=5)) System.out.println("action not allowed in this phase");
else if ((UserNumberOneTurn == true)&&(Duel.getDuelByUsernameNumberOne(UsernameNumberOne, UsernameNumberTwo).AmountCardInUsernameNumberOneMonsterCard()==5)) System.out.println("monster card zone is full");
else if ((UserNumberOneTurn == false)&&(Duel.getDuelByUsernameNumberOne(UsernameNumberOne, UsernameNumberTwo).AmountCardInUsernameNumberTwoMonsterCard()==5)) System.out.println("monster card zone is full");
else if (Summon == true) System.out.println("you already summoned/set on this turn");
else {
if (MonsterCard.IsNameExist(SelectedCard).getLevel() < 5) {
  for (int i = 1 ; i < 6 ; i++){if (Duel.getDuelByUsernameNumberOne(UsernameNumberOne, UsernameNumberTwo).CheckEmptyUsernameNumberOneMonsterCard(i) == true) {
    Duel.getDuelByUsernameNumberOne(UsernameNumberOne, UsernameNumberTwo).AddCardToUsernameNumberOneMonsterCard(SelectedCard, i);
    System.out.println("summoned successfully");
  }}
}
else if (MonsterCard.IsNameExist(SelectedCard).getLevel() < 7) {



}
}
    
    




private void SelectCardRegexCheck() {
    Scanner scan = new Scanner(System.in);
    String name;
    for(int i = 0;i < 1;i++){
    name = scan.nextLine();
    if (getCommandMatcher(name, ("^select monster ([0-9]*)$"))!=null) 
    {/*erja tabe;*/continue;}

    if (getCommandMatcher(name, ("^select ([a-zA-Z0-9_]*) ([a-zA-Z0-9_]*) ([0-9]*)$"))!=null) 
    {/*erja tabe;*/continue;}

    if (getCommandMatcher(name, ("^select spell ([0-9]+)$"))!=null) 
    {/*erja tabe;*/continue;}

    if (getCommandMatcher(name, ("^select ([a-zA-Z0-9_]*) ([a-zA-Z0-9_]*) ([0-9]*)$"))!=null) 
    {/*erja tabe;*/continue;}

    if (getCommandMatcher(name, ("^select field$"))!=null) 
    {/*erja tabe;*/continue;}

    if (getCommandMatcher(name, ("^select ([a-zA-Z0-9_]*) ([a-zA-Z0-9_]*)$"))!=null) 
    {/*erja tabe;*/continue;}

    if (getCommandMatcher(name, ("^select hand ([0-9]+)$"))!=null) 
    {/*erja tabe;*/continue;}

    if (getCommandMatcher(name, ("^select -d$"))!=null) 
    {/*erja tabe;*/continue;}

    if (getCommandMatcher(name, ("^next phase$"))!=null) 
    {ChangeCurrentPhase(); continue;}

    

    if (getCommandMatcher(name, ("^summon$"))!=null) 
    {/*erja tabe;*/continue;}

    
    

    

  
  }
}  



private void SelectMonsterCardUserNumberOne(int number){
    
    int newnumber = ChangeNumberforUserNumberOne(number);
    if (newnumber > 5) System.out.println("invalid selection");
    else if (Duel.getDuelByUsernameNumberOne(UsernameNumberOne, UsernameNumberTwo).CheckEmptyUsernameNumberOneMonsterCard(number) == false) System.out.println("no card found in the given position");
    else {SelectedCard = Duel.getDuelByUsernameNumberOne(UsernameNumberOne, UsernameNumberTwo).getCardFromUsernameNumberOneMonsterCard(newnumber);
    System.out.println("card selected");
   }}

    private void SelectMonsterCardUserNumberTwo(Matcher matcher){
    
    if (!(( (matcher.group(1).equals("monster")) && (matcher.group(2).equals("opponent") ) ) || ((matcher.group(2).equals("monster")) && (matcher.group(1).equals("opponent") )  ))) System.out.println("invalid command");
    else {
       int number = Integer.parseInt(matcher.group(3)) ;
       int newnumber = ChangeNumberforUserNumberTwo(number);
       if (newnumber > 5) System.out.println("invalid selection");
       else if (Duel.getDuelByUsernameNumberOne(UsernameNumberOne, UsernameNumberTwo).CheckEmptyUsernameNumberTwoMonsterCard(number) == false) System.out.println("no card found in the given position");
       else {SelectedCard = Duel.getDuelByUsernameNumberOne(UsernameNumberOne, UsernameNumberTwo).getCardFromUsernameNumberTwoMonsterCard(newnumber);
       System.out.println("card selected");
      }
     }}

   private void SelectSpelTrapCardUserNumberOne(int number){
     
     int newnumber = ChangeNumberforUserNumberOne(number);
     if (newnumber > 5) System.out.println("invalid selection");
     else if (Duel.getDuelByUsernameNumberOne(UsernameNumberOne, UsernameNumberTwo).CheckEmptyUsernameNumberOneSpellCard(number) == false) System.out.println("no card found in the given position");
     else {SelectedCard = Duel.getDuelByUsernameNumberOne(UsernameNumberOne, UsernameNumberTwo).getCardFromUsernameNumberOneSpellCard(newnumber);
     System.out.println("card selected");
    }
     }
 
     private void SelectSpellTrapCardUserNumberTwo(Matcher matcher){
      
     if (!(( (matcher.group(1).equals("spell")) && (matcher.group(2).equals("opponent") ) ) || ((matcher.group(2).equals("spell")) && (matcher.group(1).equals("opponent") )  ))) System.out.println("invalid command");
     else {
        int number = Integer.parseInt(matcher.group(3)) ;
        int newnumber = ChangeNumberforUserNumberTwo(number);
        if (newnumber > 5) System.out.println("invalid selection");
        else if (Duel.getDuelByUsernameNumberOne(UsernameNumberOne, UsernameNumberTwo).CheckEmptyUsernameNumberTwoSpellCard(number) == false) System.out.println("no card found in the given position");
        else {SelectedCard = Duel.getDuelByUsernameNumberOne(UsernameNumberOne, UsernameNumberTwo).getCardFromUsernameNumberTwoSpellCard(newnumber);
        System.out.println("card selected");
       }}}
      private void SelectFieldZoneCardUserNumberOne(){
    
         if (Duel.getDuelByUsernameNumberOne(UsernameNumberOne, UsernameNumberTwo).CheckEmptyUsernameNumberOneFieldZoneCard() == false) System.out.println("no card found in the given position");
         else {SelectedCard = Duel.getDuelByUsernameNumberOne(UsernameNumberOne, UsernameNumberTwo).getUsernameNumberOneFieldZone();
           System.out.println("card selected");
       
         } }
  
       private void SelectFieldZoneCardUserNumberTwo(Matcher matcher){
        
       if (!(( (matcher.group(1).equals("field")) && (matcher.group(2).equals("opponent") ) ) || ((matcher.group(2).equals("field")) && (matcher.group(1).equals("opponent") )  ))) System.out.println("invalid command");
       else {
          if (Duel.getDuelByUsernameNumberOne(UsernameNumberOne, UsernameNumberTwo).CheckEmptyUsernameNumberTwoFieldZoneCard() == false) System.out.println("no card found in the given position");
         else {SelectedCard = Duel.getDuelByUsernameNumberOne(UsernameNumberOne, UsernameNumberTwo).getUsernameNumberTwoFieldZone();
           System.out.println("card selected");
       
         }}}

      private void SelectHandCard(int number) {
       
        if (number > Duel.getDuelByUsernameNumberOne(UsernameNumberOne, UsernameNumberTwo).AmountCardInUsernameNumberOneHandCard()) System.out.println("invalid selection");
        else   if ( Duel.getDuelByUsernameNumberOne(UsernameNumberOne, UsernameNumberTwo).CheckCardInUsernameNumberOneHandCard(number)== false) System.out.println("no card found in the given position");
        else  {System.out.println("card selected");
        SelectedCard = Duel.getDuelByUsernameNumberOne(UsernameNumberOne, UsernameNumberTwo).getCardUsernameNumberOneHandCard(number);

        }

      } 


   private void deselect(){
     
       if (SelectedCard==null) System.out.println("no card is selected yet");
       else {SelectedCard=null;
       System.out.println("card deselected");}

   }  
   
   private void AddCardFromDeckToHand(String name){
     
       int i ;
      if (Duel.getDuelByUsernameNumberOne(UsernameNumberOne, UsernameNumberTwo).getCurrentPhase().equals("draw phase")) System.out.println("we are in wrong phase");
    else {if ((Duel.getDuelByUsernameNumberOne(UsernameNumberOne, UsernameNumberTwo).AmountCardInUsernameNumberOneDeck() == 0) &&(UserNumberOneTurn==true)) System.out.println(UsernameNumberOne+"lose");
    else if ((Duel.getDuelByUsernameNumberOne(UsernameNumberOne, UsernameNumberTwo).AmountCardInUsernameNumberTwoDeck() == 0) &&(UserNumberOneTurn==false)) System.out.println(UsernameNumberTwo+"lose");
    else if (UserNumberOneTurn==true) {
      Duel.getDuelByUsernameNumberOne(UsernameNumberOne, UsernameNumberTwo).DeleteOneCardFromUsernameNumberOneDeck(name);
      for ( i = 0 ; i < 6 ; i++){if (Duel.getDuelByUsernameNumberOne(UsernameNumberOne, UsernameNumberTwo).CheckCardInUsernameNumberOneHandCard(i) == false) break;}
      Duel.getDuelByUsernameNumberOne(UsernameNumberOne, UsernameNumberTwo).AddCardToUsernameNumberOneHandCard(name, i);
     System.out.println("new card added to the hand : "+name);

    }
    else {
      Duel.getDuelByUsernameNumberOne(UsernameNumberOne, UsernameNumberTwo).DeleteOneCardFromUsernameNumberTwoDeck(name);
     for ( i = 0 ; i < 6 ; i++){if (Duel.getDuelByUsernameNumberOne(UsernameNumberOne, UsernameNumberTwo).CheckCardInUsernameNumberTwoHandCard(i) == false) break;}
     Duel.getDuelByUsernameNumberOne(UsernameNumberOne, UsernameNumberTwo).AddCardToUsernameNumberTwoHandCard(name, i);
    System.out.println("new card added to the hand : "+name);

   }

 }
   }  
   
   private int ChangeNumberforUserNumberOne(int number){
    if (number == 1) return 3;
    if (number == 2) return 4;
    if (number == 3) return 2;
    if (number == 4) return 5;
    return 1;

  }
  private int ChangeNumberforUserNumberTwo(int number){
   if (number == 1) return 3;
   if (number == 2) return 2;
   if (number == 3) return 4;
   if (number == 4) return 2;
   return 5;

 }

   
private Matcher getCommandMatcher(String input,String regex){               

    Pattern pattern = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(input);

    if (matcher.find()) return matcher; 
     else    return null;
}  
public void setSelectedCard(String selectedCard) {
    SelectedCard = selectedCard;
}
public String getSelectedCard() {
    return SelectedCard;
}        

    
}
