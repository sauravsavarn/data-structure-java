package org.datastructure.java.testrounds.doesscontainst;

/**
 *
 */
public class Solution3 {

    static boolean exists = true;
    public static boolean checkSequence(String a, String b) {

        if(!exists)
            return exists;
        if( (a.isEmpty() && b.isEmpty()) || (!a.isEmpty() && b.isEmpty()) )
            return exists;

        char temp = 0;
        if(!b.isEmpty()) {
            temp = b.charAt(0);
            exists = true;
//            return exists;
        }
        if (!a.isEmpty()) {
            exists = true;
            for (int i = 0; i < a.length(); i++) {
                if (a.charAt(i) == temp) {
                    System.out.print(" - " + a.charAt(i) + " - ");
                    a = a.substring(i + 1);
                    exists = true;
                    break;
                } else {
                    System.out.print("" + a.charAt(i));
                    exists = false;
                }
            }
        }
        else
            return false;

        if (!exists)
            return exists;

        boolean output = checkSequence(a, b.substring(1));
        return output;
    }
}
