

class GFG
{
    // Function to store the zig zag order traversal of tree in a list.
    ArrayList<Integer> zigZagTraversal(Node root)
    {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Deque<Node> deque = new LinkedList<>();
        deque.add(root);
        boolean leftToRight = true;

        while (!deque.isEmpty()) {
            int levelSize = deque.size();
            ArrayList<Integer> currentLevel = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                Node currentNode = deque.pollFirst();

                // Based on the level's direction, add the node's value accordingly.
                if (leftToRight) {
                    currentLevel.add(currentNode.data);
                } else {
                    currentLevel.add(0, currentNode.data); // Insert at the beginning for right to left traversal
                }

                // Add left and right children to deque
                if (currentNode.left != null) deque.addLast(currentNode.left);
                if (currentNode.right != null) deque.addLast(currentNode.right);
            }

            result.addAll(currentLevel);
            leftToRight = !leftToRight; // Change direction for the next level
        }

        return result;
    }
}
