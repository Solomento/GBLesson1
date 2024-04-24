package presenter;

import family_tree.FamilyTree;
import human.Human;
import view.FamilyTreeView;

public class FamilyTreePresenter {
    private final FamilyTree<Human> model;
    private final FamilyTreeView view;

    public FamilyTreePresenter(FamilyTree<Human> model, FamilyTreeView view) {
        this.model = model;
        this.view = view;
    }

    public void start() {
        int choice = 0;
        do {
            view.displayFamilyTree(model.getInfo());
            view.promptUserInput("Select action (1 - add a new family member, 2 - end the program): ");
            choice = view.getUserChoice();
            switch (choice) {
                case 1:
                    addNewFamilyMember();
                    break;
                case 2:
                    view.displayMessage("end the program.");
                    break;
                default:
                    view.displayMessage("Wrong choice. Please try again.");
                    break;
            }
        } while (choice != 2);
        view.closeScanner();
    }

    public void addNewFamilyMember() {
        view.displayMessage("The function of adding a new family member has not yet been implemented.");
    }
}
