package org.datastructure.java.tries.patternMatching;

import java.util.ArrayList;

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

    public boolean search(String word) {
        return search(root, word);
    }

    private boolean search(TrieNode root, String word) {
        if (word.length() == 0) {
            return true;
        }
        int childIndex = word.charAt(0) - 'a';
        TrieNode child = root.children[childIndex];
        if (child == null) {
            return false;
        }
        return search(child, word.substring(1));
    }


    public boolean patternMatching(ArrayList<String> vect, String pattern) {
        // Write your code here
        if (vect.isEmpty()) return false;
        for (String element : vect) {
            /////now use the add FUNC() to add this to the root
            add(element);
        }

        return checkMatching(root, pattern);
    }

    //static boolean isFound=false;
    boolean checkMatching(TrieNode treeNode, String pattern) {
        if(treeNode==null) return false;

        if(search(treeNode, pattern)) {
            //isFound=true;
            return true;
        }
        ///////////finally use the search FUNC to search for the pattern
        for (int i = 0; i < treeNode.children.length; i++) {
            TrieNode trieNode = treeNode.children[i];
            boolean found=checkMatching(trieNode, pattern);
            if(found)return true;
        }

        return false;
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
}