import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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

    public void populate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            this.insert(nums[i]);
        }
    }

    public void populateSorted(int[] nums) {
        populateSorted(nums, 0, nums.length - 1);
    }

    public void populateSorted(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = (start + end) / 2;
        this.insert(nums[mid]);
        populateSorted(nums, start, mid);
        populateSorted(nums, mid + 1, end);
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

    public boolean balenced() {
        return balenced(root);
    }

    private boolean balenced(Node node) {
        if (node == null) {
            return true;
        }
        return Math.abs(getheight(node.left) - getheight(node.right)) <= 1 && balenced(node.left)
                && balenced(node.right);
    }

    public void levelOrder(){
        List<List<Integer>> result = levelOrder(root);
        for (List<Integer> list : result) {
            for (Integer ele : list) {
                System.out.println(ele+" ");
            }
        }
    }

    public void sumOfleftLeavs(){
       System.out.println(sumOfleftLeavs(root));
    }

    private int sumOfleftLeavs(Node root) {
        if (root == null) {
            return 0;
        }
        int res = 0;

        if (root.left != null) {
            if (root.left.left == null && root.left.right == null) {
                res+=root.left.value;
            }
            else{
                res+=sumOfleftLeavs(root.left);
            }
        }

        res+=sumOfleftLeavs(root.right);

        return res;

    }

    public void sumNumbers() {
        System.out.println(sumNumbers(root,0,22));
    }

    private int sumNumbers(Node root, int pathSum,int target) {
        if (root == null) {
            return 0;
        }
        pathSum = pathSum*10 + root.value;
        if (root.left == null && root.right == null) {
            return pathSum;
        }

        if (pathSum == target) {
            System.out.println("true");
            return target;
        }

        // System.out.println(root.value);
        return sumNumbers(root.left, pathSum,target)+sumNumbers(root.right, pathSum,target);
        
    }

    public List<List<Integer>> levelOrder(Node root) {

        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
          return result;
        }
  
        Queue<Node> queue = new LinkedList<>();
  
        queue.offer(root);
  
        while (!queue.isEmpty()) {
  
          int levelSize = queue.size();
  
          List<Integer> currentLevel = new ArrayList<>(levelSize);
  
          for (int i = 0; i < levelSize; i++) {
  
            Node currentNode = queue.poll(); // remove the current nodes.
            currentLevel.add(currentNode.value);
  
            if (currentNode.right != null) {
              queue.offer(currentNode.right);
            }
            if (currentNode.left != null) {
              queue.offer(currentNode.left);
            }
  
          }
  
          result.add(currentLevel);
        }
        
        return result;
      }

    public static void main(String[] args) {
        BST tree = new BST();
        int[] nums = {
                5, 2, 8, 7, 1, 4, 6, 9, 8, 3, 10
        };
        int[] nums2 = {
                1, 2, 3, 4, 5, 6, 7, 8, 9, 10
        };
        tree.populate(nums);
        tree.display();
        tree.sumNumbers();
        // System.out.println();
        // tree.populateSorted(nums2);
        // tree.display();
        
    }
}
