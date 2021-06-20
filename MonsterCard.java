import java.util.ArrayList;



public class MonsterCard {
  private   String Name;
  private  String MonsterType;
  private  String CardType;
  private String Attribute;
  private  String Description;
  private  int Price;
  private  int Level;
  private  int Attack;
  private  int Defend;
  static  ArrayList<MonsterCard> monstercards = new ArrayList<MonsterCard>();
  public   MonsterCard(String name, int level,String attribute,String monstertype,String cardtype, int attack,int defend,String description, int price){
    this.Price = price;  
    this.Name = name;
    this.Level = level;
    this.Attribute = attribute;
    this.CardType = cardtype;
    this.MonsterType = monstertype;
    this.Description = description;
    this.Attack = attack;
    this.Defend = defend;
    monstercards.add(this);
}
public static MonsterCard IsNameExist(String name){
    int i;
    for ( i = 0 ; i < monstercards.size(); i++) {
      if (name.equals(monstercards.get(i).getname()))       break;
    }       
   if (i == monstercards.size())     return null;
   else  return  monstercards.get(i);
    
}
public String getname(){
    return Name;
}
public String getCardType() {
    return CardType;
}
public String getDescription(){
    return Description;
}
public int getLevel(){
    return Level;
}
public int getAttack(){
    return Attack;
}
public int getDefend(){
    return Defend;
}
public int getPrice(){
    return Price;
}
public String getAttribute() {
    return Attribute;
}
public String getMonsterType() {
    return MonsterType;
}





}