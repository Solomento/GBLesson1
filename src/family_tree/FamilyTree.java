package family_tree;

import comparators.FamilyTreeComparatorByBirthDate;
import comparators.FamilyTreeComparatorByName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<E extends TreeNode<E>> implements Serializable, Iterable<E> {
    private long countPeople;
    private List<E> humanList;

    public FamilyTree(List<E> humanList) {
        this.humanList = humanList;
    }

    public FamilyTree() {
        this(new ArrayList<>());
    }

    public boolean add(E human){
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

    private void addToParents(E human) {
        for (E parent: human.getParents()) {
            parent.addChild(human);
        }
    }

    private void addToChildren(E human) {
        for (E parent: human.getChildren()) {
            parent.addChild(human);
        }
    }

    public String toString() { return getInfo(); }

    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("At the tree ");
        sb.append(humanList.size());
        sb.append(" objects: \n");
        for (E human: humanList) {
            sb.append(human);
            sb.append("\n");
        }
        return sb.toString();
    }

    public void sortByName() { humanList.sort(new FamilyTreeComparatorByName<>());}

    public void sortByDeathDate() { humanList.sort(new FamilyTreeComparatorByBirthDate<>());}

    public Iterator<E> iterator() {return new FamilyTreeIterator(humanList);}
}
