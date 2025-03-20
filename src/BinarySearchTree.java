
/*
 * BinarySearchTree class.
 */
public class BinarySearchTree<T extends Comparable<T>> {

    // The tree root
    private NodeType<T> root;
    // The tree root temp
    private NodeType<T> rootTemp;

    // the leaf count
    private int leafCount = 0;

    /*
     * Inserts the value to the tree.
     *
     * @param T the value.
     */
    public void insert(T key) {
        root = loopp(root, key);
    } // insert

    /*
     * Loops to insert item.
     *
     * @param NodeType<T> root.
     * @param T key.
     */
    public NodeType<T> loopp(NodeType<T> node, T key) {
        if (node == null) {
            node = new NodeType<T>();
            node.info = key;
            node.left = null;
            node.right = null;
            return node;
        } // if
        if (node.info.compareTo(key) > 0) {
            node.left = loopp(node.left, key);
        } else if (node.info.compareTo(key) < 0) {
            node.right = loopp(node.right, key);
        } else {
            System.out.println("Cannot insert duplicate item!");
        } // else
        return node;
    } //

    /*
     * Recursively inserts the value.
     *
     * @param NodeType<T>.
     * @param T key.
     */
    public void searchLoop(NodeType<T> node, T key) {

        rootTemp = node;
        if (rootTemp == null) {
            // this is used for search function when the item is not in the tree
            System.out.println("The item is not in the tree!");
            return;
        } // if
        // go the left of the node
        if (rootTemp.info.compareTo(key) > 0) {
            rootTemp = rootTemp.left;
            searchLoop(rootTemp, key);
        }
        // go the right of the node
        else if (rootTemp.info.compareTo(key) < 0) {
            rootTemp = rootTemp.right;
            searchLoop(rootTemp, key);
        } else {
            // this is for search function when the item is in the tree
            System.out.println("The item is present in the tree!");
            return;
        } // else
    } // insertLoop

    /*
     * Searches the value, and returns true if the value exists and false otherwise.
     *
     * @param T item.
     */
    public boolean search(T item) {
        inOrder();
        if (root == null) {
            System.out.println("The tree is empty!");
            return true;
        } // if
        searchLoop(root, item);
        return true;
    } // search

    /*
     * Prints the tree in order.
     */
    public void inOrder() {
        if (root == null) {
            System.out.println("The tree is empty!");
            return;
        } // if
        System.out.print("In Order: ");
        printInOrder(root);
        System.out.print("\n");
    } // inOrder

    /*
     * Loops to print items in order.
     *
     * @param NodeType<T>.
     */
    public void printInOrder(NodeType<T> node) {
        // recursively print values in order
        if (node != null) {
            printInOrder(node.left);
            System.out.print(node.info + " ");
            printInOrder(node.right);
        } // if
    } // printInOrder

    /*
     * Gets number of leaves.
     *
     */
    public void getLeaf(NodeType<T> node, int button) {
        // recursively get to the end of each branch
        if (node != null) {
            // go to the left
            getLeaf(node.left, button);
            // this is for leaf counting
            if (node.left == null && node.right == null) {
                leafCount += 1; // update the number of leaves
            }
            // this is for finding single parent function.
            else if (
                // when the current node has only one left child.
                (node.left != null && node.right == null
                 && node.left.left == null && node.left.right == null)
                ||
                // when the current node has only one right child.
                (node.left == null && node.right != null
                 && node.right.right == null && node.right.left == null)) {
                // print the single parent
                if (button == 2) {
                    System.out.print(node.info + " ");
                } // if
            } // else if
            // go to the right
            getLeaf(node.right, button);
        } // if
    } // getLeaf

    /*
     * Returns the number of leaves.
     *
     */
    public void getNumLeafNodes() {
        leafCount = 0;
        getLeaf(root, 0);
        System.out.println("The number of leaves in the tree is " + leafCount);
    } // getNumLeafNodes

    /*
     * Prints the single parents.
     *
     */
    public void getSingleParent() {
        System.out.print("The single parents: ");
        getLeaf(root, 2);
        System.out.println("");
    } // getSingleParent

    /*
     * Gets cousins.
     *
     * @param T.
     */
    public void getCousins(T item) {
        NodeType<T> p1 = getRoot(item); // parent of the item
        System.out.print("The cousins: ");
        if (p1 != null) { // check the parent of the item
            NodeType<T> p2 = getRoot(p1.info); // grandparent of the item
            if (p2 != null) { // check the grandparent of the item
                if (p2.info.compareTo(item) > 0) {
                    p2 = p2.right; // uncle or aunt of the item on the right of the grandparent
                    if (p2 != null) { // check the right uncle's/ aunt's item
                        if (p2.left != null) { // print the left cousin
                            System.out.print(p2.left.info + " ");
                        } // if
                        if (p2.right != null) { // print the right cousin
                            System.out.print(p2.right.info);
                        } // if
                    } // if
                } else {
                    p2 = p2.left; // uncle or aunt of the left of the grand parent
                    if (p2 != null) { // check the uncle's/aunt's item
                        if (p2.left != null) { // print the left cousin
                            System.out.print(p2.left.info + " ");
                        } // if
                        if (p2.right != null) { // print the right cousin
                            System.out.println(p2.right.info);
                        } // if
                    } // if

                } // else

            } // if
        } // if
        System.out.println("");
    } // getCousins

    /*
     * Deletes a node.
     *
     */
    public void delete(T key) {
        if (root == null) {
            System.out.println("The tree is empty!");
            return;
        } // if

        NodeType<T> targetP = getRoot(key); // parent of the target
        NodeType<T> target = null;
        NodeType<T> oldest; // the predecessor of the target
        NodeType<T> oldestP; // the parent of the target's predecessor
        NodeType<T> oldestC; // the smallest child of the target's predecessor
        // case we're removing the root
        if (root.info.compareTo(key) == 0) {
            target = root;
        } // if
        if (targetP != null && targetP.info.compareTo(key) < 0) {
            target = targetP.right; // target is the right child
        } else if (targetP != null && targetP.info.compareTo(key) > 0) {
            target = targetP.left; // target is the left child
        } //
        // get the largest value on the left side of the target
        if (target != null) {
            oldest = target.left; // go left
            while (oldest != null && oldest.right != null) {
                oldest = oldest.right; // keep going right
            } // while
            if (oldest == null) { // go to right to get the predecessor
                oldest = target.right;
            } // if


            if (oldest != null) {
                oldestP = getRoot(oldest.info);
                oldestC = oldest;
                // get the left most child of oldest
                while (oldestC.left != null) {
                    oldestC = oldestC.left;
                } // while
                if (oldestP.info.compareTo(oldest.info) < 0) {
                    oldestP.right = null; // remove the largest node on the right
                    // connect the oldest right to the right child of the target
                    if (target.right != null) {
                        oldest.right = target.right;

                    } // if
                    // connect the left most child of the oldest to the left of the target
                    if (target.left != null) {
                        oldestC.left = target.left;
                    } // if

                } else if (oldestP.info.compareTo(oldest.info) > 0) {
                    oldestP.left = null; // remove the largest node on the left
                    if (oldestP.right != null) {
                        oldest.right = oldestP.right;
                    } // if
                } // else if

            } // if
            // link the parent of the target to the oldest
            if (targetP != null) {
                if (targetP.info.compareTo(target.info) > 0) {
                    targetP.left = oldest; // oldest is on the left side of the target parent
                } else {
                    targetP.right = oldest; // odest is on the right side of the target parent
                } // else
            } else {
                root = oldest;// this is when the root is removed
            } // else
        } // if
        System.out.println("After deletion:");
        inOrder();

    } // delete

    /*
     * Gets root.
     *
     * @param T item.
     */
    public NodeType<T> getRoot(T item) {
        NodeType<T> parent = root;

        while (parent != null) {

            if ((parent.left != null && parent.left.info.compareTo(item) == 0)
                || (parent.right != null && parent.right.info.compareTo(item) == 0)) {

                return parent;
            } // if
            if (parent.info.compareTo(item) < 0) {
                parent = parent.right;
            } else if (parent.info.compareTo(item) > 0) {
                parent = parent.left;
            } else {

                return null;
            } // else
        } // while
        return null;
    } // getRoot


} // BinarySearchTree class
