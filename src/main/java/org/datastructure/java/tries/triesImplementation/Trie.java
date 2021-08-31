package org.datastructure.java.tries.triesImplementation;

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode('\0',0);
    }

    public void add(String word) {
        TrieImplementation.add(root, word);
    }

    public boolean search(String word) {
        return true;
    }

    public boolean remove(String word) {
        return true;
    }
}

class TrieImplementation {

    public static void add(TrieNode root, String word) {
        ////////base case
        if(word.isEmpty())return;

        char ch = word.charAt(0);
        word=word.substring(1);
        ///////now representing char as ASCII DEC values
        int dec = ch;

        ///////now inserting data into Trie Node.
        if(root.children[dec-31]==null) {
            TrieNode interimTrieNode = new TrieNode(ch, dec-31);
            //TrieNode interimTrieNode = root.children[dec-31];
            if(word.length()-1<0)interimTrieNode.isTerminal=true;
            root.children[dec-31]=interimTrieNode;

            ///////now pointing new root to the children
            root=interimTrieNode;
        } else {
            TrieNode interimTrieNode = root.children[dec-31];
            //if(word.length()-1==0)interimTrieNode.isTerminal=true;
            //root.children[dec-31]=interimTrieNode;

            ///////now pointing new root to the children
            root=interimTrieNode;
        }

        add(root, word);
    }
}