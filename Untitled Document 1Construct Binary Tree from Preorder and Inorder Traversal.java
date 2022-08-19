class Solution {
    HashMap<Integer,Integer> map = new HashMap<>();
    int preIndex = 0;
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i=0;i<inorder.length;i++)
        {
            map.put(inorder[i],i);
        }
        
        return create(preorder,inorder,0,inorder.length-1);
    }
    
    TreeNode create(int pre[],int in[],int s,int e)
    {
        if(s>e)
        {
            return null;
        }
        
        TreeNode root = new TreeNode(pre[preIndex++]);
        
        if(root==null)
        {
            return null;
        }
        
        if(s==e)
        {
            return root;
        }
        
        int index = map.get(root.val);
        
        root.left = create(pre,in,s,index-1);
        root.right = create(pre,in,index+1,e);
        
        return root;
    }
}
