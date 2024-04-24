package presenter;
import java.util.Scanner;

public class prompt_user_input {
    private Scanner scanner;

    public void FamilyTreeView() {
        this.scanner = new Scanner(System.in);
    }

    public void displayFamilyTree(String familyTreeInfo) {
        System.out.println("Family tree:");
        System.out.println(familyTreeInfo);
    }

    public void promptUserInput(String message) {
        System.out.println(message);
        scanner.nextLine();
    }

    public int getUserChoice() {
        return scanner.nextInt();
    }

    public void closeScanner() {
        scanner.close();
    }

    public void displayMessage(String string) {
        System.out.println(string);
    }
}
