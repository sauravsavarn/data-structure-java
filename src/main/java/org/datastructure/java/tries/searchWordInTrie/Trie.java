package org.datastructure.java.tries.searchWordInTrie;

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
        // Write your code here
        if(root==null)return false;

        return search(root, word);
    }

    private boolean search(TrieNode root, String word) {
        if(word.isEmpty())return true;
        if(root==null && word.isEmpty())return true;
        else if(root==null && !word.isEmpty())return false;

        char ch=word.charAt(0);
        int dec = ch;
        word=word.substring(1);

        TrieNode trieNode = root.children[dec-97];
        if(trieNode==null)return false;
        if(word.isEmpty()) {
            //////////now check if TrieNode is Terminal NOde or not.
            if(trieNode.isTerminating) return true;
            else return false;
        }

        /* ** ** */
        return search(trieNode, word);
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