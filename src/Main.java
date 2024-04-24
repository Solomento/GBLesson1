import family_tree.FamilyTree;
import family_tree.FamilyTreeIterator;
import human.Gender;
import human.Human;
import presenter.FamilyTreePresenter;
import view.FamilyTreeView;
import writer.FileHandler;

import java.time.LocalDate;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        String filePath = "src/writer/tree.txt";

        FamilyTree tree = testTree();
        System.out.println(tree);

        //save(tree, filePath);
        System.out.println("\n");
        //FamilyTree.sortByDeathDate();

        System.out.println(tree);

        FamilyTreeView view = new FamilyTreeView();
        FamilyTreePresenter presenter = new FamilyTreePresenter(tree, view);
        presenter.start();
    }

    static FamilyTree read(String filePath) {
        FileHandler fileHandler = new FileHandler();
        return (FamilyTree) fileHandler.read(filePath);
    }

    static void save(FamilyTree familyTree, String filePath) {
        FileHandler fileHandler = new FileHandler();
        fileHandler.save(familyTree, filePath);
    }

    static FamilyTree testTree() {
        FamilyTree tree = new FamilyTree();

        Human ivan = new Human("Ivan", Gender.Male, LocalDate.of(1975, 4, 13));
        Human sveta = new Human("Svetlana", Gender.Female, LocalDate.of(1989, 12, 25));
        Human alex = new Human("Alex", Gender.Male, LocalDate.of(1978, 8, 13));
        tree.add(ivan);
        tree.add(sveta);
        tree.add(alex);

        return tree;


    }



}
