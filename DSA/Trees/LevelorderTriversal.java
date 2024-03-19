import java.util.*;

public class LevelorderTriversal {
    class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {

            List<List<Integer>> result = new ArrayList<>();
            if (root == null) {
                return result;
            }

            Queue<TreeNode> queue = new LinkedList<>();

            queue.offer(root);

            while (!queue.isEmpty()) {

                int levelSize = queue.size();

                List<Integer> currentLevel = new ArrayList<>(levelSize);

                for (int i = 0; i < levelSize; i++) {

                    TreeNode currentNode = queue.poll(); //remove the current nodes.
                    currentLevel.add(currentNode.val);

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


        // Successor of the Node.
        public TreeNode findSuccessor(TreeNode root, int key){

            if (root==null) {
                return null;
            }

            Queue<TreeNode> queue = new LinkedList<>();

            queue.offer(root);

            while (!queue.isEmpty()) {
               
                TreeNode currentNode = queue.poll(); //remove the current nodes.

                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }

                if (currentNode.val == key) {
                    break;
                }

            }

            return queue.peek();
        }

        // ZigZag level order of the tree
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            List<List<Integer>> result = new ArrayList<>();

            if (root == null) {
                return result;
            }

            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);

            while (!queue.isEmpty()) {
                int levelSize = queue.size();
                
                List<Integer> currentLevel = new ArrayList<>(levelSize);
                for (int i = 0; i < levelSize; i++) {
                    TreeNode currNode = queue.poll();
                    currentLevel.add(currNode.val);
                }
                
            }

            return result;
        }
    }
}
