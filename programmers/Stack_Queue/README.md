# 코딩테스트 - 스택 / 큐 

LIFO, FIFO, push & pop! 스택과 큐를 이용해서 문제를 풀어보세요

### 문제1. [탑](#탑) 
### 문제2. [다리를 지나는 트럭](#다리를_지나는_트럭)
### 문제3. [기능개발](#기능개발) 
### 문제4. [프린터](#프린터) 
### 문제5. [쇠막대기](#쇠막대기) 
### 문제6. [주식가격](#주식가격) 


## 탑 

## 다리를_지나는_트럭

## 기능개발

## 프린터

## 쇠막대기

## 주식가격

``` java
public class Solution {
  public int[] solution(int[] prices) {
    int[] answer = new int[prices.length];
    int cursor = 0; // answer index cursor 
    
    int position = 0;
    while (position < prices.length) {
      int value = prices[position++];
      // 남는 리스트에서 비교 
      for (int i = position; i < prices.length; i++) {
          int relativeValue = prices[i];
          // 가격이 떨어진 경우 
          if (relativeValue < value) {
              answer[cursor++] = i-
          
          }
      }
    }
  }
}



```
