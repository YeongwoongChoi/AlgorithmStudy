# 문제 풀이
  ## 개요
  + 출처: 백준 (Baekjoon Online Judge)
  + 문제 번호: 1590 (https://www.acmicpc.net/problem/1590)
  + 문제 이름: 캠프가는 영식
  + 문제 등급: Silver 4
  + 제한 사항
    + 시간: 2s
    + 메모리: 128MB
  ## 풀이 방법
  + TreeSet 이용
      + implements NavigableSet extends SortedSet)
      + Red-Black Tree 구조로 데이터 저장
      + TreeSet<T> 에서 구현한 메서드들 존재 (lower_bound, upper_bound 관련)
        + T lower(T e): set에서 e <b>미만</b>의 데이터들 중 가장 큰 값 반환
        + T higher(T e): set에서 e <b>초과</b>의 데이터들 중 가장 작은 값 반환
        + T floor(T e): set에서 e <b>이하</b>의 데이터들 중 가장 큰 값 반환
        + T ceiling(T e): set에서 e <b>이상</b>의 데이터들 중 가장 작은 값 반환
  + 접근
      + 넉넉한 시간제한을 가지므로, 데이터를 입력받을 때 모든 가능한 버스 편을 TreeSet에 add 하여준다.
      + 문제의 조건 상 T를 포함한 그 이후 시간에서의 버스편 중 가장 빠른 것을 찾는 것이므로
        ```java
          TreeSet::ceiling(T);
        ```
        사용하여 풀이.
  ## 풀이 정보
  + 언어: Java 11
  + 수행 시간
    + 메모리: 15212KB
    + 시간: 112ms
  + 결과: <b>맞았습니다(AC)</b>
