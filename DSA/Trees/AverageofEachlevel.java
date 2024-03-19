import java.util.*;
public class AverageofEachlevel {
    public List<Double> averageOfLevels(TreeNode root) {
            List<Double> result = new ArrayList<>();
            if (root==null) {
                return result;
            }
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                int levelSize = queue.size();
                double averageLevel = 0;
                for (int i = 0; i < levelSize; i++) {
                    TreeNode currentNode = queue.poll();
                    averageLevel += currentNode.val;
                    if (currentNode.left != null) {
                        queue.offer(currentNode.left);
                    }
                    if (currentNode.right != null) {
                        queue.offer(currentNode.right);
                    }
                }
                averageLevel = averageLevel/levelSize;
                result.add(averageLevel);
            }
            
        return result;
    }
}
