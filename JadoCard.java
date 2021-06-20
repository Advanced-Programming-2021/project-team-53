import java.util.*;

public class JadoCard {
    private   String Name;
    private  String Type;
   private String Icon;
   private String Status;
    private  String Description;
    private int price;
    static  ArrayList<JadoCard> jadocards = new ArrayList<JadoCard>();
    public   JadoCard(String name, String type,String icon, String description,String status,  int price){
        this.price = price;
        this.Status = status;
        this.Name = name;
        this.Icon = icon;
        this.Type = type;
        this.Description = description;
        jadocards.add(this);
    }
    public static JadoCard IsNameExist(String name){
        int i;
        for ( i = 0 ; i < jadocards.size(); i++) {
          if (name.equals(jadocards.get(i).getname()))       break;
        }       
       if (i == jadocards.size())     return null;
       else  return  jadocards.get(i);
        
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
