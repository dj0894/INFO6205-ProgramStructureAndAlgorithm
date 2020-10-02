//https://leetcode.com/problems/backspace-string-compare/

public class LeetCode844 {

    public boolean backspaceCompare(String S, String T) {
        int lenS = S.length() - 1;
        int lenT = T.length() - 1;

        while(lenS >= 0 || lenT >= 0) {

            lenS = updateIndex(S, lenS);
            lenT = updateIndex(T, lenT);


            if(lenS < 0 && lenT < 0) {
                return true;
            }

            if(lenS < 0 || lenT < 0){
                return false;
            }

            if(S.charAt(lenS) != T.charAt(lenT)) {
                return false;
            }

            lenS--;
            lenT--;
        }

        return true;
    }

    private int updateIndex(String str, int index) {
        if(index < 0 || str.charAt(index) != '#'){
            return index;
        }

        int numPound = 0;
        while(index >= 0 && (numPound > 0 || str.charAt(index) == '#')) {
            numPound += str.charAt(index) == '#' ? 1 : -1;
            index--;
        }

        return index;

    }
}
