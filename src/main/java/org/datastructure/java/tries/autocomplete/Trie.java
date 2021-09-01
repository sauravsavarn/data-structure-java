package org.datastructure.java.tries.autocomplete;

import java.util.ArrayList;
import java.util.List;

class TrieNode {
    char data;
    boolean isTerminating;
    TrieNode children[];
    int childCount;

    public TrieNode(char data) {
        this.data = data;
        isTerminating = false;
        children = new TrieNode[26];
        childCount = 0;
    }
}

public class Trie {
    private TrieNode root;
    public int count;

    public Trie() {
        root = new TrieNode('\0');
    }

    private void add(TrieNode root, String word) {
        if (word.length() == 0) {
            root.isTerminating = true;
            return;
        }
        int childIndex = word.charAt(0) - 'a';
        TrieNode child = root.children[childIndex];
        if (child == null) {
            child = new TrieNode(word.charAt(0));
            root.children[childIndex] = child;
            root.childCount++;
        }
        add(child, word.substring(1));
    }

    public void add(String word) {
        add(root, word);
    }

    public void autoComplete(ArrayList<String> input, String word) {
        // Write your code here

        ////////adding data to tries
        for (int i = 0; i < input.size(); i++) {
            add(input.get(i));
        }

        ////////now proceed to find the words with the prefix supplied as argument to this FUNC().
        List<String> list = new ArrayList<>();
        TrieNode lastNode = root;
        StringBuffer curr = new StringBuffer();

        for (char c : word.toCharArray()) {
            int dec = c;
            lastNode = lastNode.children[dec - 97];
            if (lastNode == null) {
                if (!list.isEmpty()) {
                    for (int i = 0; i < list.size(); i++) {
                        System.out.println(list.get(i));
                    }
                }
                return;
            }
            curr.append(c);
        }

        suggestHelper(lastNode, list, curr);
        //return list;
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    public void suggestHelper(TrieNode root, List<String> list, StringBuffer curr) {
        if (root.isTerminating) {
            list.add(curr.toString());
        }

        if (root.children == null || root.children.length == 0)
            return;

        for (TrieNode child : root.children) {
            if (child != null) {
                suggestHelper(child, list, curr.append(child.data));
                curr.setLength(curr.length() - 1);
            }
        }
    }

}