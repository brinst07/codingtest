package marathon;

import java.util.Arrays;

public class Solution {
    public String solution(String[] participant, String[] completion){
        //간단하게 정렬해서 푸는 방법
    	String answer = "";
        String temp = "";
        //기본값으로 sort를 하게 될경우 오름차순으로 정렬된다.
        Arrays.sort(participant);
        Arrays.sort(completion);
        
        int i;
        for(i = 0; i<completion.length; i++){
            if(!participant[i].equals(completion[i])){
                return participant[i];
            }
        }
        
        return participant[i];
    }
}