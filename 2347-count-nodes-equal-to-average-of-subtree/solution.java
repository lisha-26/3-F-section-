class Solution {
    private int matchingNodesCount = 0;

    public int averageOfSubtree(TreeNode root) {
        calculateSumAndCount(root);
        return matchingNodesCount;
    }

    private int[] calculateSumAndCount(TreeNode node) {
        if (node == null) {
            return new int[]{0, 0}; // {sum, count}
        }

        // Post-order traversal: visit children first
        int[] leftSubtree = calculateSumAndCount(node.left);
        int[] rightSubtree = calculateSumAndCount(node.right);

        // Aggregate results for the current node's subtree
        int currentSum = leftSubtree[0] + rightSubtree[0] + node.val;
        int currentCount = leftSubtree[1] + rightSubtree[1] + 1;

        // Check if the node's value equals the floor average of its subtree
        if (node.val == (currentSum / currentCount)) {
            matchingNodesCount++;
        }

        return new int[]{currentSum, currentCount};
    }
}
