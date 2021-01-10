package testMoveClassToPackage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Collections {
  public static String[] langs = {"Java", "C#", "Python", "PHP"};
  public static List<String> languages = new ArrayList<>(); // Cлева указываем интерфейс List  а справа конкретный класс с реализацией
  public static List<String> languages1 =  Arrays.asList("Java","Python","BrainFuck");

 public static void main(String[] args) {

   for (int i = 0; i < langs.length; i ++) {
     System.out.println( "Я хочу выучить " + langs[i]);
   }
   // Создание ArrayList
   languages.add("Java");
   languages.add("C#");
   languages.add("Python");

   Collections.specialIterationSyntax();

 }
  public static void specialIterationSyntax() {
   for (String l : languages1) { // l здесь сам объект а не индекс
     System.out.println("Я хочу выучить " + l);
   }
  }
}
