package algorithms;

import java.util.*;

public class LinkedBinaryTree {

    class Node {
        private int data;
        private Node left;
        private Node right;
        private Node next;

        Node(int data){
            this.data = data;
        }
    }

    public void linkNodes(Node root) {
        //Node Map to store nodes at each level from left to right
        Map<Integer, List<Node>> map = new HashMap<>();

        //Traverse each node in pre-order fashion and fill map
        linkNodes(root, 1, map);

        //iterate through the map and for each level, set next node for every node in it.
        for(List<Node> nodes : map.values()) {
            Node prev = null;
            for(Node curr : nodes) {
                if(prev != null){
                    prev.next = curr;
                }

                prev = curr;
            }

            prev.next = null;
        }
    }

    private void linkNodes(Node root, int level, Map<Integer, List<Node>> map) {

        //base case
        if(root == null) {
            return;
        }

        //insert the current node and level information into the map
        if(map.get(level) == null){
            map.put(level, new ArrayList<>());
        }

        map.get(level).add(root);

        //recur for left and right subtree by increasing level by 1
        linkNodes(root.left, level + 1, map);
        linkNodes(root.right, level + 1, map);
    }
}
