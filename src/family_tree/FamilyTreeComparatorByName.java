package family_tree;

import human.Human;

import java.util.Comparator;

public class FamilyTreeComparatorByName<T extends TreeNode<T>> implements Comparator<T> {
    public int compare(T o1, T o2) { return o1.getName().compareTo(o2.getName());}
}
