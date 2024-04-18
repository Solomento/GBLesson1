package family_tree;

import human.Human;
import human.HumanComparatorByBirthDate;
import human.HumanComparatorByName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree implements Serializable {
    private long countPeople;
    private final List<Human> humanList;

    public FamilyTree(List<Human> humanList) {
        this.humanList = humanList;
    }

    public FamilyTree() {
        this(new ArrayList<>());
    }

    public boolean add(Human human){
        if (human == null) {
            return false;
        }
        if (!humanList.contains(human)) {
            humanList.add(human);
            human.setId(countPeople++);

            addToParents(human);
            addToChildren(human);

            return true;
        }
        return false;
    }

    private void addToParents(Human human) {
        for (Human parent: human.getParents()) {
            parent.addChild(human);
        }
    }

    private void addToChildren(Human human) {
        for (Human parent: human.getChildren()) {
            parent.addChild(human);
        }
    }

    public String toString() { return getInfo(); }

    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("At the tree ");
        sb.append(humanList.size());
        sb.append(" objects: \n");
        for (Human human: humanList) {
            sb.append(human);
            sb.append("\n");
        }
        return sb.toString();
    }

    public void sortByName() { humanList.sort(new HumanComparatorByName());}

    public void sortByDeathDate() { humanList.sort(new HumanComparatorByBirthDate());}

    public Iterator<Human> iterator() {return new FamilyTreeIterator(humanList);}
}
