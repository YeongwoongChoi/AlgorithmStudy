# 문제 풀이
  ## 개요
  + 출처: 백준 (Baekjoon Online Judge)
  + 문제 번호: 31860 ([링크](https://www.acmicpc.net/problem/31860))
  + 문제 이름: 열심히 일하는 중
  + 문제 등급: Silver 2
  + 제한 사항
    + 시간: 1s
    + 메모리: 512MB
  ## 풀이 방법
  + 우선순위 큐
    + 문제 조건에 의해 중요도가 높은 일부터 수행 (최대 힙 이용)
      
      ```java
      import java.util.Collections;
      import java.util.PriorityQueue;
      ...
      ProrityQueue <Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
      ...
      ```
    + 큐가 빌 때까지 시뮬레이션 돌리면 어렵지 않게 통과
    
  ## 풀이 정보
  + 언어: Java 11
  + 수행 시간
    + 메모리: 134548KB
    + 시간: 916ms
  + 결과: <b>맞았습니다(AC)</b>
