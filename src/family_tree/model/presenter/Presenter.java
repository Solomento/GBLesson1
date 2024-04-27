package family_tree.model.presenter;

import family_tree.model.human.Gender;
import family_tree.model.human.Human;
import family_tree.model.service.Service;
import family_tree.model.view.View;

import java.time.LocalDate;
import java.util.List;

public class Presenter {
    private View view;
    private Service service;

    public Presenter(View view) {
        this.view = view;
        service = new Service();
    }

    public void addHuman(String name, LocalDate birthDate, LocalDate deathDate, Gender gender) {
        service.addHuman(name, birthDate, deathDate, gender);
    }

    public void setMother(int parentID, int childID) {
        service.addMother(parentID, childID);
    }

    public void setFather(int parentID, int childID) {
        service.addFather(parentID, childID);
    }

    public void showFamilyTree() {
        view.printText(service.printFamilyTree());
    }

    public void sortByAge() {
        service.sortByAge();
        showFamilyTree();
    }

    public void sortByName() {
        service.sortByName();
        showFamilyTree();
    }

    public Human findByID(int requiredID) {
        return service.findHumanByID(requiredID);
    }

    public List<String> showParentName(int childID) {
        return service.getParentName(childID);
    }

    public boolean saveFile(String filePath) {
        return service.saveFile(filePath);
    }

    public boolean loadFile(String filePath) {
        return service.loadFile(filePath);
    }
}
