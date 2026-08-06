/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeLinkNode connect(TreeLinkNode root) {
        if(root==null){
            return root;
        }
        
       TreeLinkNode originalHead = root;
       TreeLinkNode dummy = new TreeLinkNode(-1);
       TreeLinkNode temp = dummy;

       while(root!=null){
           if(root.left !=null){
               temp.next = root.left;
               temp = temp.next;
           }
           if(root.right !=null){
               temp.next = root.right;
               temp = temp.next;
           } 

           root = root.next;
           if(root==null){
               root = dummy.next;
               temp = dummy;
               dummy.next = null;
           }          
       }
       return originalHead;
        
    }
}
