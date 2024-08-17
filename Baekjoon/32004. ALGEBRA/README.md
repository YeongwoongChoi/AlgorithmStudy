# 문제 풀이
  ## 개요
  + 출처: 백준 (Baekjoon Online Judge)
  + 문제 번호: 32004 ([링크](https://www.acmicpc.net/problem/32004))
  + 문제 이름: ALGEBRA
  + 문제 등급: Silver 5
  + 제한 사항
    + 시간: 1s
    + 메모리: 1024MB
  ## 풀이 방법
  + Task #1
    + 입력으로 주어지는 배열 길이의 합
    + 입력 변수 ($M$)가 주어지므로 그대로 더해줌
  + Task #2
    + $A$번째 배열과 $B$번째 배열에 공통으로 존재하는 원소의 합
    + 문제 조건에 의해 중복 값은 더하면 안되므로, set에 넣고 intersection (and operator 연산) 이용
      
      ```python
      sumOfElements = sum({*arrays[A - 1]} & {*arrays[B - 1]})
      ```
+ Task #3
     + 모든 배열의 인덱스 당 최댓값을 이용하여 새로운 배열 생성
     + 입력 조건에서 각 원소 $x$에 대해 $x \ge 1$이므로 0을 (배열 길이의 최댓값 - 해당 배열 길이) 만큼 넣어줌
     + 이후 배열의 리스트를 전치하여 최댓값을 계산, 결과 배열에 넣어준다.

       ```python
       ...
       maxLength = max(arrayLength)
       for i in range(N):
           for _ in range(arrayLength[i], maxLength):
               arrays[i].append(0)
       
       res = [max(*_) for _ in zip(*arrays)]
       ```
  ## 풀이 정보
  + 언어: Python 3
  + 수행 시간
    + 메모리: 31120KB
    + 시간: 36ms
    
  + 결과: <b>맞았습니다(AC)</b>
