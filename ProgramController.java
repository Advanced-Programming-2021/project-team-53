
import java.util.*;
import java.util.regex.*;



public  class ProgramController {
   public String CurrentUsername;
   public boolean Islogin = false ;
   public String CurrentPassword;
   public String CurrentNickame;
   public String CurrentMenu = new String("login");
   
   public String  UserNumberOneDuel;
   public String  UserNumberTwoDuel;
   public void run(){
      Scanner scan = new Scanner(System.in);
      ArrayList<String> line = new ArrayList<String>();
        for (int i=0;true;i++){
          line.add(scan.nextLine()) ;                                                                                       //start regex      
          if (line.get(i).equals("end"))  break; 
        if (getCommandMatcher(line.get(i), ("^user create ([A-Za-z0-9_]*) ([A-Za-z0-9_]*) ([A-Za-z0-9_]*) ([A-Za-z0-9_]*) ([A-Za-z0-9_]*) ([A-Za-z0-9_]*)$"))!=null) 
         {UserCreate(getCommandMatcher(line.get(i), ("^user create ([A-Za-z0-9_]*) ([A-Za-z0-9_]*) ([A-Za-z0-9_]*) ([A-Za-z0-9_]*) ([A-Za-z0-9_]*) ([A-Za-z0-9_]*)$")));continue;}

        if (getCommandMatcher(line.get(i), ("^user login ([A-Za-z0-9_]*) ([A-Za-z0-9_]*) ([A-Za-z0-9_]*) ([A-Za-z0-9_]*)$"))!=null) 
         {/*erja tabe;*/continue;}

        if (getCommandMatcher(line.get(i), ("^user logout$"))!=null)  
        {/*erja tabe;*/continue;}

        if (getCommandMatcher(line.get(i), ("^scoreboard show$"))!=null)  
        {/*erja tabe;*/continue;}

        if (getCommandMatcher(line.get(i), ("^profile change ([A-Za-z0-9_]*) ([A-Za-z0-9_]*)$"))!=null) 
         {/*erja tabe;*/continue;}

        if (getCommandMatcher(line.get(i), ("^profile change ([A-Za-z0-9_]*) ([A-Za-z0-9_]*) ([A-Za-z0-9_]*) ([A-Za-z0-9_]*) ([A-Za-z0-9_]*)$"))!=null)  
        {/*erja tabe;*/continue;} 
       
        if (getCommandMatcher(line.get(i), ("^menu enter ([a-zA-Z0-9_])$"))!=null) 
         {/*erja tabe;*/continue;}

        if (getCommandMatcher(line.get(i), ("^menu exit$"))!=null)  {if (CurrentMenu.equals("login")) break; 
        else {/*erja tabe;*/continue;}}

        if (getCommandMatcher(line.get(i), ("^menu show-current$"))!=null) 
         {System.out.println(CurrentMenu);continue;} 
       
        if (getCommandMatcher(line.get(i), ("^deck create ([a-zA-Z0-9_]*)$"))!=null) 
         {/*erja tabe;*/continue;} 

        if (getCommandMatcher(line.get(i), ("^deck delete ([a-zA-Z0-9_]*)$"))!=null) 
         {/*erja tabe;*/continue;} 

         if (getCommandMatcher(line.get(i), ("^shop buy ([a-zA-Z0-9_]*)$"))!=null) 
         {/*erja tabe;*/continue;} 

         if (getCommandMatcher(line.get(i), ("^shop show all$"))!=null) 
         {/*erja tabe;*/continue;}  
        
         if (getCommandMatcher(line.get(i), ("^deck add-card ([a-zA-Z0-9_]*) ([a-zA-Z0-9_]*) ([a-zA-Z0-9_]*) ([a-zA-Z0-9_]*)([a-zA-Z0-9_ ]+)$"))!=null) 
         {/*erja tabe;*/continue;} 

         if (getCommandMatcher(line.get(i), ("^deck rm-card ([a-zA-Z0-9_]*) ([a-zA-Z0-9_]*) ([a-zA-Z0-9_]*) ([a-zA-Z0-9_]*)([a-zA-Z0-9_ ]+)$"))!=null) 
         {/*erja tabe;*/continue;} 

         if (getCommandMatcher(line.get(i), ("^duel ([a-zA-Z0-9_]*) ([a-zA-Z0-9_]*) ([a-zA-Z0-9_]*) ([a-zA-Z0-9_]*) ([a-zA-Z0-9_]*)"))!=null) 
         {/*erja tabe;*/continue;}

         if (getCommandMatcher(line.get(i), ("^duel ([a-zA-Z0-9_]*) ([a-zA-Z0-9_]*) ([a-zA-Z0-9_]*) ([a-zA-Z0-9_]*) ([a-zA-Z0-9_]*)"))!=null) 
         {/*erja tabe;*/continue;}
      
                   
        
          System.out.println("invalid command");
       
        }
    }
   
    private void UserCreate (Matcher matcher){
      if (CheckMenu("login")) {
      String password = new String("");
      String username = new String("");
      String nickname = new String("");
      for (int i = 1;i < 7 ;i=i+2){
         if (matcher.group(i).equals("password")) {password = matcher.group(i+1);}
      else if (matcher.group(i).equals("usename")) {username = matcher.group(i+1);}
           else  {nickname =  matcher.group(i+1);}
        }
      if (Player.GetPlayerBySTH(username, 1) != null) System.out.println("user with username "+username+" already exists");
      else if (Player.GetPlayerBySTH(nickname,2) != null)  System.out.println("user with nickname "+nickname+" already exists");
            else  {new Player(username , password , nickname , 0,0,null);CurrentUsername = username;CurrentPassword = password;CurrentNickame = nickname;}}
      
    }

      private void login(Matcher matcher){
        if (CheckMenu("login")) {
        String Password;
        String Username;
       
        if (matcher.group(1).equals("username"))  {Username = matcher.group(2); Password = matcher.group(4);}
        else {Username = matcher.group(4); Password = matcher.group(2);}
     
      if (Player.GetPlayerBySTH(Username,1) == null) System.out.println("Username and password didn’t match!");
      else if (!(Player.GetPlayerBySTH(Username,1).getPassword().equals(Password)))   System.out.println("Username and password didn’t match!");
       else {Islogin=true;CurrentUsername=Username;CurrentPassword=Password;CurrentMenu="menu";}
    }}
    
    private void logout(){
      if (CheckMenu("MainMenu")) {
     System.out.println("user logged out successfully!");
      Islogin=false;
      CurrentUsername=null;
      CurrentPassword=null;
    }}

    private void ScoreboardShow(){                                        
      if (CheckMenu("Scoreboard")) {
      String Username[] = new String[Player.palyers.size()];
     int Score[] = new int[Player.palyers.size()];
     int LastScore[] = new int[Player.palyers.size()];
     int i=0;
     for (Player player : Player.palyers) {
     Username[i] = player.getUsername();
     Score[i] = player.getScore();
    LastScore[i] = player.getScore();
     i++;
     }
    int a = 1;
     Arrays.sort(LastScore);
     for (int j = i - 1; j >= 0 ; j--){
       for (int z = 0 ; z < i;z++){
         if (LastScore[j]==Score[z])  {
          if (LastScore[j] == LastScore[j+1]) {a=a-1;}
          System.out.println(a+"-"+Username[z]+": "+LastScore[j]);a=a+1;break;}
     }   } }
    }

     private void ChangeNickname(Matcher matcher){
      if (CheckMenu("Profile")) {
      String Nickame = matcher.group(2);
      if (Player.GetPlayerBySTH(Nickame, 2) == null) System.out.println("user with nickname "+Nickame+" already exists");
      else Player.GetPlayerBySTH(CurrentUsername,1).SetNickname(Nickame);
    }}
    
    private void ChangePassword(Matcher matcher){
      if (CheckMenu("Profile")) {
      String NewPassword ;
      String LastPassword ;
      if (matcher.group(2).equals("current")) {NewPassword = matcher.group(5);LastPassword = matcher.group(3);}
      else {NewPassword = matcher.group(3);LastPassword = matcher.group(5);}
      if (!(CurrentPassword.equals(LastPassword)) )  System.out.println("current password is invalid");
      else   if (NewPassword.equals(LastPassword)) System.out.println("please enter a new password");
           else Player.GetPlayerBySTH(CurrentUsername,1).SetNickname(NewPassword);
    }}

    private void ExitMenu(){
      if (CurrentMenu.equals("MainMenu"))  CurrentMenu = "login";
      else CurrentMenu = "MainMenu" ;
    }
   
   

    private void createDeck(Matcher matcher){
      if (CheckMenu("Deck")) {
      String deckname = matcher.group(1); 
     if (Deck.GetDeckByName(CurrentUsername, deckname) != null) System.out.println("deck with name "+deckname+" already exists");
        else {new Deck(CurrentUsername, deckname);System.out.println("deck created successfully!");}
       }}

      public void DeleteDeck(Matcher matcher){
        if (CheckMenu("Deck")) {
        String deckname = matcher.group(1);
        if (Deck.GetDeckByName(CurrentUsername, deckname) == null) System.out.println("deck with name "+deckname+" does not exists");
           else {Deck.GetDeckByName(CurrentUsername, deckname).DeleteDeck(CurrentUsername, deckname);System.out.println("deck deleted successfully");}
         }}


     public void AddCardToDeck(Matcher matcher){
      if (CheckMenu("Deck")) {
      String cardname;
     String deckname;
     boolean maindeck = true;
      if (matcher.group(1).equals("card")) {cardname = matcher.group(2);deckname = matcher.group(4);}
      else {cardname = matcher.group(4);deckname = matcher.group(2);}
      if (matcher.group(5).equals("side"))  maindeck = false;
      if ((MonsterCard.IsNameExist(cardname)==null)&&(TaleCard.IsNameExist(cardname)==null)&&(JadoCard.IsNameExist(cardname)==null)) System.out.println("card with name "+cardname+" does not exis");
      else if (Deck.GetDeckByName(CurrentUsername, deckname)==null)    System.out.println("deck with name "+deckname+" does not exist");
           else if ((maindeck==true)&&(Deck.GetDeckByName(CurrentUsername, deckname).MainDecksize()==60))   System.out.println("main deck is full");
                else if ((maindeck==false)&&(Deck.GetDeckByName(CurrentUsername, deckname).SideDecksize()==15))   System.out.println("side deck is full");
                     else if ((maindeck==true)&&(Deck.GetDeckByName(CurrentUsername, deckname).AmountCardInDeck(cardname)==3))   System.out.println("there are already three cards with name "+cardname+" in deck "+deckname);
                          else if ((maindeck==false)&&(Deck.GetDeckByName(CurrentUsername, deckname).AmountCardInDeck(cardname)==3))   System.out.println("there are already three cards with name "+cardname+" in deck "+deckname);
                               else {System.out.println("card added to deck successfully");
                               if (maindeck==true)       Deck.GetDeckByName(CurrentUsername, deckname).AddCardToMainDeck(cardname);
                               else   Deck.GetDeckByName(CurrentUsername, deckname).AddCardToSideDeck(cardname);  }  
                              } } 

     public void DeleteCardToDeck(Matcher matcher){
       if (CheckMenu("Deck")) {
       String cardname;
       String deckname;
       boolean maindeck = true;
        if (matcher.group(1).equals("card")) {cardname = matcher.group(2);deckname = matcher.group(4);}
        else {cardname = matcher.group(4);deckname = matcher.group(2);}
        if (matcher.group(5).equals("side"))  maindeck = false;
        if (Deck.GetDeckByName(CurrentUsername, deckname)==null)    System.out.println("deck with name "+deckname+" does not exist");
        else if ((MonsterCard.IsNameExist(cardname)==null)&&(TaleCard.IsNameExist(cardname)==null)&&(JadoCard.IsNameExist(cardname)==null)&&(maindeck==true))    System.out.println("card with name "+cardname+" does not exist in maindeck");
             else if ((MonsterCard.IsNameExist(cardname)==null)&&(TaleCard.IsNameExist(cardname)==null)&&(JadoCard.IsNameExist(cardname)==null)&&(maindeck==false)) System.out.println("card with name "+cardname+" does not exist in sidedeck");
                   else {System.out.println("card removed form deck successfully");
                                if (maindeck==true)       Deck.GetDeckByName(CurrentUsername, deckname).DeleteCardFromMainDeck(cardname);
                                else   Deck.GetDeckByName(CurrentUsername, deckname).DeleteCardFromSideDeck(cardname);;  }  
                               } }                          
     private void BuyCard(Matcher matcher) {
       if (CheckMenu("Shop")) {
        String cardname = matcher.group(1); 
        if ((MonsterCard.IsNameExist(cardname)==null)&&(TaleCard.IsNameExist(cardname)==null)&&(JadoCard.IsNameExist(cardname)==null))  System.out.println("there is no card with this name");
        else if ((MonsterCard.IsNameExist(cardname)!=null)&&(Player.GetPlayerBySTH(CurrentUsername, 1).getMoney() < MonsterCard.IsNameExist(cardname).getPrice())) System.out.println("not enough money");
        else if ((JadoCard.IsNameExist(cardname)!=null)&&(Player.GetPlayerBySTH(CurrentUsername, 1).getMoney() < JadoCard.IsNameExist(cardname).getPrice())) System.out.println("not enough money");
        else if ((TaleCard.IsNameExist(cardname)!=null)&&(Player.GetPlayerBySTH(CurrentUsername, 1).getMoney() < TaleCard.IsNameExist(cardname).getPrice())) System.out.println("not enough money");
        else Player.GetPlayerBySTH(CurrentUsername, 1).addcard(cardname);
       }

     }    
     
     private void ShowCard(){                           //این تابع بعد از اینکه txt رو درست بکنیم کامل میکنم
      if (CheckMenu("Shop")) {
        ArrayList<String> allcard = new ArrayList<String>();
        for(int i = 0;i < JadoCard.jadocards.size();i++)        {allcard.add(JadoCard.jadocards.get(i).getname());}
        for(int j = 0;j < MonsterCard.monstercards.size();j++)  {allcard.add(MonsterCard.monstercards.get(j).getname());}
        for(int k = 0;k < TaleCard.talecards.size();k++)        {allcard.add(TaleCard.talecards.get(k).getname());}
        Arrays.sort(allcard);
     }}

     private void DuelCreate(Matcher matcher){
      if (CheckMenu("Duel")) {
        String opponentactivedeckname = "";
        int amountround = 0;
        String opponentusername = "";
      if (matcher.group(1).equals("second-player")) opponentusername = matcher.group(2);
      if (matcher.group(2).equals("second-player")) opponentusername = matcher.group(3);
      if (matcher.group(3).equals("second-player")) opponentusername = matcher.group(4);
      if (matcher.group(4).equals("second-player")) opponentusername = matcher.group(5);
      if (matcher.group(1).equals("rounds")) amountround = Integer.parseInt(matcher.group(2));
      if (matcher.group(2).equals("rounds")) amountround = Integer.parseInt(matcher.group(3));
      if (matcher.group(3).equals("rounds")) amountround = Integer.parseInt(matcher.group(4));
      if (matcher.group(4).equals("rounds")) amountround = Integer.parseInt(matcher.group(5));



      if (Player.GetPlayerBySTH(opponentusername, 1)==null)  System.out.println("there is no player with this username");
      else if (Player.GetPlayerBySTH(opponentusername, 1).getplayerActiceDeckName()==null) System.out.println(opponentusername+" has no active deck");
      else {opponentactivedeckname = Player.GetPlayerBySTH(opponentusername, 1).getplayerActiceDeckName();
      if  (Deck.GetDeckByName(opponentusername, opponentactivedeckname).MainDecksize() < 40) System.out.println(opponentusername+"’s deck is invalid");
    else  if ((amountround!=3)||(amountround!=1)) System.out.println("number of rounds is not supported");
    else if (Player.GetPlayerBySTH(CurrentUsername, 1).getplayerActiceDeckName()==null) System.out.println("you have no active deck");
    else if (Deck.GetDeckByName(CurrentUsername, Player.GetPlayerBySTH(CurrentUsername, 1).getplayerActiceDeckName()).MainDecksize()<40) System.out.println("your deck is invalid");
    else {new Duel(CurrentUsername, opponentusername, amountround);
    } } }}

    


    
     private Matcher getCommandMatcher(String input,String regex){               

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        if (matcher.find()) return matcher; 
         else    return null;
    }
    private boolean CheckMenu(String menuname){
      if (menuname.equals(CurrentMenu)) return true; //that means we are in same menu
      else {System.out.println("invalid command"); return false;}  //that means we are in two differnt menu
    }
    public static String getSelectedCard() {
        return SelectedCard;
    }
  
  
  }
