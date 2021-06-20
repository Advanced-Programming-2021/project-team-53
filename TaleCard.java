import java.util.*;

public class TaleCard {
    private   String Name;
    private  String Type;
    private String Icon;
    private  String Description;
    private int price ;
    private String Status;
    static  ArrayList<TaleCard> talecards = new ArrayList<TaleCard>();
    public   TaleCard(String name, String type,String icon, String description,String status, int price){
        this.price = price;
        this.Name = name;
        this.Type = type;
        this.Icon = icon;
        this.Description = description;
        this.Status = status;
        talecards.add(this);
    }
    public static TaleCard IsNameExist(String name){
        int i;
        for ( i = 0 ; i < talecards.size(); i++) {
          if (name.equals(talecards.get(i).getname()))       break;
        }       
       if (i == talecards.size())     return null;
       else  return  talecards.get(i);
        
    }
    public String getname(){
        return Name;
    }
    public String gettype(){
        return Type;
    }
    public String getDescription(){
        return Description;
    }

    public int getPrice(){
        return price;
    }
    public String getIcon() {
        return Icon;
    }
    public String getStatus() {
        return Status;
    }
}
