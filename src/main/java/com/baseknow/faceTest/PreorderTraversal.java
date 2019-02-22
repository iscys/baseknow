package com.baseknow.faceTest;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树前序遍历
 * 给定一个二叉树，返回它的 前序 遍历。
 *
 *  示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [1,2,3]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 */
public class PreorderTraversal {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> sum =new ArrayList<>();

        return preTravvel(root,sum);
    }

    private List<Integer> preTravvel(TreeNode root, List<Integer> sum) {
        if(root ==null) return sum;
        if(root!=null){
            sum.add(root.val);
        }
        if(root.left!=null){
            preTravvel(root.left,sum);
        }
        if(root.right!=null){
            preTravvel(root.right,sum);
        }
        return sum;
    }


    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
     TreeNode(int x) { val = x; }
  }

}
