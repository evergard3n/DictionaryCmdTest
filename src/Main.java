import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)  {
//        Dictionary d = new Dictionary();

        DictionaryManagement.insertFromFile("src/dictionaries.txt");
        DictionaryUtils.dictionaryAdvanced();
    }
}