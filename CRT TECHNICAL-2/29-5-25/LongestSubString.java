import java.util.*;
public class LongestSubString {
    public static int lengthOfLongestSubString(String s){
        Set<Character> seen=new HashSet<>();
        int left=0,maxlen=0;
        for(int right=0;right<s.length();right++){
            if(seen.contains(s.charAt(right))){
                seen.remove(s.charAt(left));
                left++;
            }
            seen.add(s.charAt(right));
            maxlen=Math.max(maxlen,right-left+1);
        }
        return maxlen;
    }
    public static void main(String args[]) {
        String s="abcabcbb";
        System.out.println(lengthOfLongestSubString(s));
    }
}
