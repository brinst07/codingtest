# 완주하지 못한 선수

## 문제 설명
수많은 마라톤 선수들이 마라톤에 참여하였습니다. 단 한 명의 선수를 제외하고는 모든 선수가 마라톤을 완주하였습니다.

마라톤에 참여한 선수들의 이름이 담긴 배열 participant와 완주한 선수들의 이름이 담긴 배열 completion이 주어질 때, 완주하지 못한 선수의 이름을 return 하도록 solution 함수를 작성해주세요.

## 제한사항
* 마라톤 경기에 참여한 선수의 수는 1명 이상 100,000명 이하입니다.
* completion의 길이는 participant의 길이보다 1작습니다.
* 참가자의 이름은 1개이상 20개 이하의 알파벳 소문자로 이루어져 있다.
* 참가자 중에는 동명이인이 있을 수 있습니다.

### sort를 이용한 방법
 a b c d  -> 참가자 배열 <br>
 a c d    -> 완주자 배열
 이처럼 위에서 주는 배열을 sort로 정렬을 한뒤에 하나씩 비교해서 없는 값을 리턴해주면 된다.
 
~~~
        Arrays.sort(participant);
        Arrays.sort(completion);
        
        int i;
        for(i = 0; i<completion.length; i++){
            if(!participant[i].equals(completion[i])){
                return participant[i];
            }
        }
        
        return participant[i];
~~~

따라서 다음과 같이 쉽게 해결할 수 있다.
<br>

### HashMap을 이용한 방법
* getorDefault() 메소드를 이용해서 풀면 쉽게 풀 수 있다.
* 찾는 키가 존재하면 해당키의 값을 반환하고 존재하지 않는다면 기본키를 반환한다.

~~~
    Hash<String, Integer> hm = new HashMap<>();
    //참가자 배열을 추출하여 hashmap에 넣으면서 value에 1씩 더해준다.
    //getorDefault를 통해 중복된 인원이 있으면 value값이 1이상인 값이 되게 된다.
    for(String player : 참가자배열){
        hm.put(player, hm.getorDefault(player,0)+1);
    }
    //완주자배열을 받아 hashmap에서 1씩 빼주게 된다.
    for(String player : 완주자배열){
        hm.put(player, hm.get(player)-1);
    }
    //value가 0이 아닌 사람을 리턴한다.
    for(String key : hm.keySet()){
        if(hm.get(key) != 0){
             answer = key;
        }
    }
~~~