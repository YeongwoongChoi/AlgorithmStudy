# 문제 풀이
  ## 개요
  + 출처: 백준 (Baekjoon Online Judge)
  + 문제 번호: 30024 (https://www.acmicpc.net/problem/30024)
  + 문제 이름: 옥수수밭
  + 문제 등급: Gold 4
  + 제한 사항
    + 시간: 1s
    + 메모리: 1024MB
  ## 풀이 방법
  + 우선순위 큐, 너비 우선 탐색(BFS)
    + 문제 조건에 의해 K개의 옥수수를 수확하되, 가장 가치가 높은 옥수수만을 수확해야한다.
    + 따라서 옥수수의 위치, 가치 정보를 담는 Corn 객체를 생성하고 Comparable 인터페이스를 구현하여 가치 기준으로 내림차순으로 오도록 하였다.
     
      ```java
      class Corn implements Comparable<Corn> {
          int x;
          int y;
          int profit;
          Corn(int x, int y, int profit) {
              this.x = x;
              this.y = y;
              this.profit = profit;
          }
          @Override
          public int compareTo(Corn c) {
              return Integer.compare(c.profit, profit);
          }
      }
      ```
    + 먼저 가장자리에 위치한 옥수수를 우선순위 큐에 넣어준 후, 해당 위치에서 상하좌우를 이동하며 탐색해나가고, K개를 수확했다면 break 한다.
    
  ## 풀이 정보
  + 언어: Java 11
  + 수행 시간
    + 메모리: 120416KB
    + 시간: 856ms
  + 결과: <b>맞았습니다(AC)</b>
