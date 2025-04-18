
class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        return solve(root, key);
    }

    
    TreeNode solve(TreeNode root, int key) {
        if(root == null) {
            return null;
        }


        
        if(root.val == key) {
            
            // case 1 (if key node is a leaf node)
            if(root.left == null && root.right == null) {
                return null;
            }


            // case 2  (if one side is null)
            if(root.left == null) { 
                return root.right;
            } else if(root.right == null) {
                return root.left;
            }

            // case 3 (if a tree exist after the key node)
            int IS = inorderSuccessor(root.right);
            root.val = IS;

            root.right = solve(root.right, IS);
            return root;

        } else if(root.val < key) {
            root.right = solve(root.right, key);

        } else {
            root.left = solve(root.left, key);
        }


        return root;
    }  





    int inorderSuccessor(TreeNode root) {
        while(root.left != null) {
            root = root.left;
        }

        return root.val;
    } 
}
