public class BST {
    public class Node {
        int value;
        Node left;
        Node right;
        int height;

        public Node(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    private Node root;

    public BST() {

    }

    public void insert(int value) {
        root = insert(value, root);
    }

    public Node insert(int value, Node node) {
        if (node == null) {
            node = new Node(value);
            return node;
        }
        if (value < node.value) {
            node.left = insert(value, node.left);
        }

        if (value > node.value) {
            node.right = insert(value, node.right);
        }
        node.height = Math.max(getheight(node.left), getheight(node.right)) + 1;
        return node;
    }

    public void populate(int[] nums){
        for (int i = 0; i < nums.length; i++) {
            this.insert(nums[i]);
        }
    }

    public void populateSorted(int[] nums){
        populateSorted(nums,0,nums.length-1);
    }

    public void populateSorted(int[] nums,int start,int end){
        if (start>=end) {
            return;
        }
        int mid = (start+end)/2;
        this.insert(nums[mid]);
        populateSorted(nums, start, mid);
        populateSorted(nums, mid+1, end);
    }

    public int getheight(Node node) {
        if (node == null) {
            return -1;
        }
        return node.height;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void display() {
        display(root, "Root Node : ");
    }

    private void display(Node node, String details) {
        if (node == null) {
            return;
        }
        System.out.println(details + node.getValue());
        display(node.left, details + " Left child of " + node.getValue() + " : ");
        display(node.right, details + " Right child of " + node.getValue() + " : ");
    }

    public boolean balenced(){
        return balenced(root);
    }

    private boolean balenced(Node node) {
        if (node == null) {
            return true;
        }
        return Math.abs(getheight(node.left)-getheight(node.right)) <= 1 && balenced(node.left) && balenced(node.right);
    }

    

    public static void main(String[] args) {
        BST tree = new BST();
        int[] nums={
            5,2,8,7,1,4,6,9,8,3,10
        };
        int[] nums2={
            1,2,3,4,5,6,7,8,9,10
        };
        tree.populate(nums);
        tree.display();
        System.out.println();
        tree.populateSorted(nums2);
        tree.display();
    }
}
