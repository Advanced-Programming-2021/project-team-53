import java.util.*;

public class Player {
    private String ActiveDeckName;
    private String Username;
    private String Password;
    private String Nickname;
    private int  Score = 0 ;
    private int Money ;
    static  ArrayList<Player> palyers = new ArrayList<Player>();
    private  ArrayList<String> card = new ArrayList<String>();
    public static String CurrentUsername;
   

   public static  Player GetPlayerBySTH(String name , int number){
  // boolean ExistCheck = false ;
    if (number == 1){for (Player player : palyers) {
      if   (player.getUsername().equals(name)) {return player;}
     }}
    else if (number == 2){for (Player player : palyers) {
         if   (player.getNickname().equals(name)) {return player;}
       }}
        else if (number ==3){for (Player player : palyers) {
             if   (player.Password.equals(name)) {return player;}
           }
        
        }
        
      return null;
   
    }


  public  Player ( String username, String password, String nickname, int score, int money,String activedeckname ){
    this.Money = money;
    this.Username = username ;
    this.Password = password ;
    this.Nickname = nickname ;
    this.Score = score ;
    this.ActiveDeckName = activedeckname;
    palyers.add(this);


  }
public String getNickname(){
    return Nickname;
}
public String getPassword(){
    return Password;
}
public String getUsername(){
    return Username;
}

public int getMoney(){
  return Money;
}

public int getScore(){
    return Score;
}

public String getplayerActiceDeckName(){
  return ActiveDeckName;
}

public void SetNickname(String NewNickname){
    Nickname = NewNickname;
}

public void ChangePlayerActiveDeckName(String NewActiveDeckName){
  ActiveDeckName = NewActiveDeckName;
}
public void SetPasswrd(String NewPassword){
    Password = NewPassword;
}

public void IncreaseScore(int NewScore){
Score =Score+ NewScore;
}

public void IncreaseMoney(int NewMoney){
  Money = Money + NewMoney;
  }

  public void addcard(String newcard){
   card.add(newcard);
    }


}
