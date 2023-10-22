import java.io.*;
import java.util.Map;
import java.util.Scanner;

public class DictionaryManagement  {

//    public String wordSearch(String word_Target) {
//        if (DictionaryUtils.dict.containsKey(word_Target)) {
//            return dictionary.get(word_Target).getWord_explain();
//        } else {
//            return null;
//        }
//    }
    /**Scanner ini.*/
    public static Scanner scn = new Scanner(System.in);

    public static void closeScanner() {
        scn.close();
    }
    /**Look up*/
    public static String dictionaryLookUp(String target) {
        if(Dictionary.dictionary.containsKey(target)) {
            Word dest  = Dictionary.dictionary.get(target);
            return dest.toString();
        }
        else {
            return "Not found!";
        }
    }
    /**Insert from cmd line.*/
    public static void insertFromCmdline() {
        System.out.println("Insert number of words");

        int N = scn.nextInt();
        System.out.println("Insert words and their definations");
        for (int i = 1; i <= N; i++) {
            String wordTarget = scn.next();
            scn.nextLine();
            String wordDef = scn.nextLine();
            Dictionary.dictionary.put(wordTarget, new Word(wordTarget, wordDef));
        }

    }
    public static void deleteWord(String target) {
        if(Dictionary.dictionary.containsKey(target)) {
            Dictionary.dictionary.remove(target);
        }
        else {
            System.out.println("No such word exists!");
        }
    }
    public static void updateWord(String target) {
        if(Dictionary.dictionary.containsKey(target)) {
            System.out.println("Enter new definition: ");
            String def = scn.nextLine();
            Dictionary.dictionary.get(target).setWord_explain(def);
            scn.nextLine();
        }
        else {
            System.out.println("No such word exists!");
        }
    }
    /**Insert from file*/
    public static void insertFromFile(String src) {
        try {
            File file = new File(src);
            Scanner scnF = new Scanner(file);
            while (scnF.hasNextLine()) {
                String line = scnF.nextLine();

                String[] stack = line.split("\t");
                if(stack.length == 2) {
                    Word newWord = new Word(stack[0],stack[1]);
                    Dictionary.dictionary.put(stack[0],newWord);
                }
                else {
                    System.err.println("Invalid line format: " + line);
                }
            }
            scnF.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static void exportToFile()  {
        try {
            FileWriter fw = new FileWriter("src/dictionaries.out");
            BufferedWriter bw = new BufferedWriter(fw);
            for (Map.Entry<String, Word> entry : Dictionary.dictionary.entrySet()) {
                Word w = entry.getValue();
                String res = w.toString() +"\n";
                bw.write(res);
            }
            bw.flush();
            bw.close();
        }
        catch(IOException e) {
            e.printStackTrace();
        }

    }
    public static void EXIT() {
        closeScanner();
        System.exit(1);
    }




}
