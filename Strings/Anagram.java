class Solution {
    final int CHAR=256;
    public boolean isAnagram(String s1, String s2) {
        if(s1.length()!=s2.length())
            return false;
        int count[]=new int[CHAR];

        for(int i=0;i<s1.length();i++){
            count[s1.charAt(i)]++;
            count[s2.charAt(i)]--;
        }
        for(int i=0;i<CHAR;i++)
        {
            if(count[i]!=0)
                return false;
        }
        return true;
    }
}