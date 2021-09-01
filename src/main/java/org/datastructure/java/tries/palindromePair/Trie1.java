package org.datastructure.java.tries.palindromePair;


import java.util.ArrayList;

//class TrieNode {
//    char data;
//    boolean isTerminating;
//    TrieNode children[];
//    int childCount;
//
//    public TrieNode(char data) {
//        this.data = data;
//        isTerminating = false;
//        children = new TrieNode[26];
//        childCount = 0;
//    }
//}

public class Trie1 {

    private TrieNode root;
    public int count;

    public Trie1() {
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

    private boolean search(TrieNode root, String word) {
        if (word.length() == 0) {
            return root.isTerminating;
        }

        int childIndex = word.charAt(0) - 'a';
        TrieNode child = root.children[childIndex];

        if (child == null) {
            return false;
        }

        return search(child, word.substring(1));

    }

    public boolean search(String word) {
        return search(root, word);
    }

    private void print(TrieNode root, String word) {
        if (root == null) {
            return;
        }

        if (root.isTerminating) {
            System.out.println(word);
        }

        for (TrieNode child : root.children) {
            if (child == null) {
                continue;
            }
            String fwd = word + child.data;
            print(child, fwd);
        }
    }

    public void print() {
        print(this.root, "");
    }

    /*..................... Palindrome Pair................... */
    public boolean isPalindromePair(ArrayList<String> words) {
        //Your code goes here
        // Construct trie
        for (int i = 0; i < words.size(); i++) {
            if (i == 0) {/////storing all the words into normal & reverse ordering before checking & then adding another set of word.
                //add(words.get(i));
                String reversedWord = new StringBuffer(words.get(i)).reverse().toString();
                add(reversedWord); /////add the string into the TRIES in reverse ordering.
                if (search(words.get(i))) return true;
                //else add(reversedWord); /////else add the string into the TRIES in reverse ordering.
            } else {
                if (search(words.get(i))) return true;
                else {
                    ////////now proceed with breaking the word into sub-words and check if these sub-words exists into TRIES
                    if(checkMatching(root, words.get(i))) return true;
                    if (checkForPalindromeInSubWords(words.get(i))) return true;
                    else {
                        ////else reverse this word and then Store into TRIES.
                        String reversedWord = new StringBuffer(words.get(i)).reverse().toString();
                        ////and finally add the reversedWord into the TRIE
                        add(reversedWord);
                    }
                }
            }
        }

        return false;
    }

    private boolean checkForPalindromeInSubWords(String word) {
        if(word.length()==1)return false;
        //word = new StringBuffer(word).reverse().toString();
        for (int i = 0; i < root.children.length; i++) {
            if(root.children[i]==null) continue;
            int indexOf = word.indexOf(root.children[i].data);
            if(indexOf==-1)return false;
            String subWord = word.substring(indexOf); //////get the 1st index of character appearance.
            ///////////now check for this subWord into root for any Palindrome existance.
            return search(subWord);
        }
        return false;
    }

    private boolean checkMatching(TrieNode treeNode, String pattern) {
        if(treeNode==null) return false;

        if(search(treeNode, pattern)) {
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

}