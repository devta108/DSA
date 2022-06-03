public class Biweekly291 {
}
class Solution {
    public String removeDigit(String number, char digit) {
        StringBuilder sb = new StringBuilder();
        char[] charArr = number.toCharArray();
        for(char ch: charArr){
            if(ch == digit)continue;
            sb.append(ch);
        }
        return sb.toString();
    }
}
