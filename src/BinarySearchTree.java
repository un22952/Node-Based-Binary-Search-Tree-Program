/*
 * BinarySearchTree class.
 */
public BinarySearchTree<T extends Comparable<T>> {

    // The tree root
    private NodeType<T> root;
    // the leaf count
    private int leafCount = 0;

    /*
     * Inserts the value to the tree.
     *
     * @param T the value.
     */
    public void insert(T key) {
        insertLoop(root, key, 0);
    } // insert

    /*
     * Recursively inserts the value.
     *
     * @param NodeType<T>.
     * @param T key.
     */
    public void insertLoop(NodeType<T> node, T key, int button) {
        // add the new node to the tree
        if (node == null) {
            // this is used for search function when the item is not in the tree
            if (button == 1) {
                System.out.println("The item is not in the tree!");
                return;
            } // if
            // create new node
            node = new NodeType<T>();
            node.info = key;
            return;
        } // if
        // go the left of the node
        if (node.info.compareTo(key) > 0) {
            insertLoop(node.left, key, searchSwitch);
        }
        // go the right of the node
        else if (node.info.compareTo(key) < 0) {
            insertLoop(node.right, key, searchSwitch);
        } else {
            // this is for search function when the item is in the tree
            if (button == 1) {
                System.out.println("The item is present in the tree!");
                return;
            } // if
            // print warning
            System.out.println("Cannot insert duplicate item!");
        } // else
    } // insertLoop

    /*
     * Searches the value, and returns true if the value exists and false otherwise.
     *
     * @param T item.
     */
    public boolean search(T item) {
        if (root == null) {
            System.out.println("The tree is empty!");
            return true;
        } // if
        insertLoop(root, item, 1);
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

            getNumLeafNodes(node.left);
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

            getNumLeafNodes(node.right);
        } // if
    } // getLeaf

    /*
     * Returns the number of leaves.
     *
     */
    public void getNumLeafNodes() {
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

    } // getCousins


} // BinarySearchTree class
