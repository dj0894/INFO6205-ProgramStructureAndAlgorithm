//https://leetcode.com/problems/decoded-string-at-index/


public class LeetCode880 {
    public String decodeAtIndex(String S, int K) {
        int len = S.length();
        long decodedLen = 0;
        for(int i = 0; i<len; i++)
            if(Character.isDigit(S.charAt(i)))
                decodedLen *= S.charAt(i)-'0';
            else
                decodedLen++;
        for(int j = len-1; j>=0; j--){
            if(Character.isDigit(S.charAt(j))){
                decodedLen /= S.charAt(j)-'0';
                continue;
            }
            if(K>decodedLen)
                K = (int)(K % decodedLen);
            if( K == decodedLen || K == 0 )
                return ""+S.charAt(j);
            decodedLen--;
        }
        return null;

    }
}
