package com.baseknow.faceTest;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 *
 * 二叉树的层次遍历 facebook
 * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
 *
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其层次遍历结果：
 *
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 */
public class Leetcode102 {
    /**
     * 1。记录当前层的长度
     * @param root
     * @return
     */

    public List<List<Integer>> levelOrder(TreeNode root) {

        LinkedList<TreeNode> queue =new LinkedList<>();

        List<List<Integer>> array =new ArrayList<>();


        if(root !=null) {
            queue.offer(root);

            //BFS 模板
        while(!queue.isEmpty()) {
            int size = queue.size();//当前层的长度
            List<Integer> a = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                a.add(poll.val);
                TreeNode left = poll.left;
                TreeNode right = poll.right;
                if (left != null) queue.offer(left);
                if (right != null) queue.offer(right);

            }
            array.add(a);
        }
        }
        return array;

    }


    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }


}
