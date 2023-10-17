import java.util.Map;
import java.util.Scanner;

public class DictionaryManagement extends Dictionary{
    public String wordSearch(String word_Target) {
        if(dictionary.containsKey(word_Target)) {
            return dictionary.get(word_Target).getWord_explain();
        }
        else {
            return  null;
        }
    }
    public Scanner scn = new Scanner(System.in);
    public void closeScanner() {
        scn.close();
    }
    public void insertFromCmdline() {
        System.out.println("Insert number of words");

        int N = scn.nextInt();
        System.out.println("Insert words and their definations");
        for(int i=1;i<=N;i++) {
            String wordTarget = scn.next();
            scn.nextLine();
            String wordDef = scn.nextLine();
            dictionary.put(wordTarget,new Word(wordTarget,wordDef));
        }

    }
    public void EXIT() {
        closeScanner();
        System.exit(1);
    }
    public String showAllWords() {
        StringBuilder sb = new StringBuilder();
        for(Map.Entry<String, Word> entry : dictionary.entrySet()) {
            Word w = entry.getValue();
            sb.append(w.toString()).append("\n");
        }
        return sb.toString();
    }
    public void dictionaryBasic() {
        System.out.println("Choose your character:");
        System.out.println("1. Insert word from command line");
        System.out.println("2. Show All Word");
        System.out.println("3. Close");


        int op;
        if(scn.hasNextInt()) {
            op = scn.nextInt();
        }
        else {
            op = 0;
        }


        switch (op) {
            case 1 -> {
                insertFromCmdline();
            }
            case 2 -> {
                System.out.println("Showing all words");
                System.out.println(showAllWords());
            }
            case 0 -> {
            }

            default -> {
                System.out.println("Invalid Operation!");
            }
        }
        System.out.println("Do you wish to continue? YES / NO");
        String string = scn.nextLine();
        if(string.equals("YES")) {
            dictionaryBasic();
            scn.nextLine();
        }
        else if(string.equals("NO")){
            EXIT();
        }
//        scn.nextLine();

    }
}
