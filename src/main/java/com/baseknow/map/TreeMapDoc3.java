package com.baseknow.map;

import java.util.LinkedList;
import java.util.List;

public class TreeMapDoc3 {

    public static List<Integer> li =new LinkedList<>();
    /**
     * 给定一个二叉树，找出其最大深度。
     *
     * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
     *
     * 说明: 叶子节点是指没有子节点的节点。
     *
     * 示例：
     * 给定二叉树 [3,9,20,null,null,15,7]，
     *
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     * 返回它的最大深度 3 。
     */


    public int maxDepth(TreeNode root) {

        if (root == null) {
            return 0;
        } else {
            int left_height =maxDepth(root.left);
            int right_height =maxDepth(root.right);
            return java.lang.Math.max(left_height,right_height)+1;
        }

    }

    /**
     * 二叉树的前序遍历
     * 从根节点开始->左->右
     */
    public static List<Integer>  preTravel(TreeNode node){


        if( null !=node){
            li.add(node.val);
            preTravel(node.left);
            preTravel(node.right);
        }
        return li;
    }


    /**
     * 后续遍历
     */

    public static List<Integer>  postTravel(TreeNode node){


        if( null !=node){
            postTravel(node.left);
            postTravel(node.right);
            li.add(node.val);
        }
        return li;
    }

    /**
     * 二叉树的中序遍历
     */
    public static List<Integer>  cenTravel(TreeNode node){


        if( null !=node){
            cenTravel(node.left);
            li.add(node.val);
            cenTravel(node.right);
        }
        return li;
    }

    /**
     * 层序遍历：
     * 数的每一层每一层的进行查找
     * 采用栈进行遍历
     */



     class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
}
