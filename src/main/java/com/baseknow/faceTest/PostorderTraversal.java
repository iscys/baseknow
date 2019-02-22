package com.baseknow.faceTest;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树，返回它的 后序 遍历。
 *
 * 示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [3,2,1]
 */
public class PostorderTraversal {


    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    public List<Integer> postorderTraversal(TreeNode root) {

        List<Integer> sum =new ArrayList<>();
        return post(root,sum);
    }

    private List<Integer> post(TreeNode root, List<Integer> sum) {
        if(root ==null) return sum;
        if(root!=null){
            post(root.left,sum);
            post(root.right,sum);
            sum.add(root.val);
        }
        return sum;
    }


}
