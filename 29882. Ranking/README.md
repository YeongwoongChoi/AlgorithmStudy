# 문제 풀이
  ## 개요
  + 출처: 백준 (Baekjoon Online Judge)
  + 문제 번호: 29882 ([링크](https://www.acmicpc.net/problem/29882))
  + 문제 이름: Ranking
  + 문제 등급: Silver 3
  + 제한 사항
    + 시간: 1s
    + 메모리: 1024MB
  ## 풀이 방법
  + HashMap
    + 사람의 이름, 문제에 대한 이름, 점수를 모두 저장해야 함
    + Java의 HashMap 이용
    + 구현
      + <b>1. 이중 해시 맵 </b>
        + 직관적인 방법
        + Key로 사람 이름, Value로 (Key는 문제 이름, Value는 점수 이름을 갖는) 해시 맵을 갖는 해시 맵 생성
      
          ```java
          import java.util.HashMap;
          ...
          HashMap <String, HashMap<String, Integer>> map = new HashMap<>();
          ...
          ```
      + <b>2.  단일 해시 맵 </b>
        + Key로 사람 이름, Value로 문제 정보를 모두 포함하는 객체(Pair)를 갖는 해시 맵 생성
        + 총점 계산 시, Pair에서 계산 담당

          ```java
          static class Pair {
              int totalScore;
              HashMap<String, Integer> problemMap;

              Pair() {
                  totalScore = 0;
                  problemMap = new HashMap<>();
              }

              void put(final String problem, final int x) {
                  final var prev = problemMap.computeIfAbsent(problem, k -> x);
                  problemMap.replace(problem, Math.max(prev, x));
              }
              void setScore() { problemMap.values().forEach(x -> totalScore += x); }
            }
          ...

          HashMap <String, Pair> map = new HashMap<>();
          ```
    + 각 입력마다 점수를 최고점으로 갱신
      
      ```java
      final var prev = problemMap.computeIfAbsent(problem, k -> x);
      problemMap.replace(problem, Math.max(prev, x));
      ```
  ## 풀이 정보
  + 언어: Java 11
  + 수행 시간
    + 1번
      + 메모리: 95652KB
      + 시간: 676ms
    + 2번
      + 메모리: 94732KB
      + 시간: 680ms
  + 결과: <b>맞았습니다(AC)</b>
