import java.lang.*;
import java.util.*;
import java.io.*;
public class Main {
    
public static void main(String[] args) {
 ReadMonsterCardFromFile(); 
 ReadTrapSpellCardFromFile();
   ProgramController test = new ProgramController();
   test.run();
     

  
          }
          
public static void ReadMonsterCardFromFile(){
    
    String monstercard[] = new String[369];
    int i = 0;
    try (Scanner scanner = new Scanner(new File("MonsterCard.txt"))) {
 
    while (scanner.hasNext()){
        if ((i % 10) == 9)  continue;
        monstercard[i] = scanner.nextLine();
        i=i+1;
    }
 
} catch (IOException e) {
    System.out.println("ERROR FROM REDING FILE");
}
   for (i = 0; i < 369; i=i+9){
   new MonsterCard(monstercard[i], Integer.parseInt(monstercard[i+1]), monstercard[i+2], monstercard[i+3], monstercard[i+4], Integer.parseInt(monstercard[i+5]), Integer.parseInt(monstercard[i+6]), monstercard[i+7],Integer.parseInt(monstercard[i+8]) );
 
}

}
public static void ReadTrapSpellCardFromFile(){
    String spelltarpcard[] = new String[210];
    int i = 0;
    try (Scanner scanner = new Scanner(new File("SpellTrapCard.txt"))) {
 
    while (scanner.hasNext()){
        if ((i % 7) == 6)  continue;
        spelltarpcard[i] = scanner.nextLine();
        i=i+1;
    }
 
} catch (IOException e) {
    System.out.println("ERROR FROM REDING FILE");
}
   for (i = 0; i < 210; i=i+6){
    if (spelltarpcard[i+1].equals("Spell")) 
    {new JadoCard(spelltarpcard[i], spelltarpcard[i+1], spelltarpcard[i+2], spelltarpcard[i+3],spelltarpcard[i+4], Integer.parseInt(spelltarpcard[i+5]));}
    else
    {new TaleCard(spelltarpcard[i], spelltarpcard[i+1], spelltarpcard[i+2], spelltarpcard[i+3],spelltarpcard[i+4], Integer.parseInt(spelltarpcard[i+5]));}
  
}

}


    }

