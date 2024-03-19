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

                    TreeNode currentNode = queue.poll(); // remove the current nodes.
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
        public TreeNode findSuccessor(TreeNode root, int key) {

            if (root == null) {
                return null;
            }

            Queue<TreeNode> queue = new LinkedList<>();

            queue.offer(root);

            while (!queue.isEmpty()) {

                TreeNode currentNode = queue.poll(); // remove the current nodes.

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
        
            Deque<TreeNode> queue = new LinkedList<>();
            queue.add(root);
        
            boolean reverse = false;
            
            while (!queue.isEmpty()) {
              int levelSize = queue.size();
              List<Integer> currentLevel = new ArrayList<>(levelSize);
              for (int i=0; i < levelSize; i++) {
                if (!reverse) {
                  TreeNode currentNode = queue.pollFirst();
                  currentLevel.add(currentNode.val);
                  if (currentNode.left != null) {
                    queue.addLast(currentNode.left);
                  }
                  if (currentNode.right != null) {
                    queue.addLast(currentNode.right);
                  }
                } else {
                  TreeNode currentNode = queue.pollLast();
                  currentLevel.add(currentNode.val);
                  if (currentNode.right != null) {
                    queue.addFirst(currentNode.right);
                  }
                  if (currentNode.left != null) {
                    queue.addFirst(currentNode.left);
                  }
                }
              }
              reverse = !reverse;
              result.add(currentLevel);
            }
            return result;
        }
    }
}



// public List<List<Integer>> levelOrderBottom(TreeNode root) {
//     Queue<TreeNode> queue = new LinkedList<TreeNode>();
//     List<List<Integer>> wrapList = new LinkedList<List<Integer>>();
    
//     if(root == null) return wrapList;
    
//     queue.offer(root);
//     while(!queue.isEmpty()){
//         int levelNum = queue.size();
//         List<Integer> subList = new LinkedList<Integer>();
//         for(int i=0; i<levelNum; i++) {
//             if(queue.peek().left != null) queue.offer(queue.peek().left);
//             if(queue.peek().right != null) queue.offer(queue.peek().right);
//             subList.add(queue.poll().val);
//         }
//         wrapList.add(0, subList);
//     }
//     return wrapList;
// }