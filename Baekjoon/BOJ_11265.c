// 백준 11265(끝나지 않는 파티) https://www.acmicpc.net/problem/11265
// C언어로 풀이
/* 간단한 Floyd-Warshall 문제
골드 문제이지만, 푸는 방법이 정해져 있으니 그것대로 풀면 쉽게 해결. */

#include <stdio.h>
#include <malloc.h>
#define MIN(x, y) x < y ? x : y

int** timeArray;
const char* results[2] = { "Stay here\n", "Enjoy other party\n" };

void initializeArray(int V) {
	timeArray = (int**)malloc(sizeof(int*) * (V + 1));
	for (int i = 1; i <= V; i++) {
		timeArray[i] = (int*)malloc(sizeof(int) * (V + 1));
		for (int j = 1; j <= V; j++)
			scanf("%d", &timeArray[i][j]);
	}
}

void clearArray(int V) {
	for (int i = 1; i <= V; i++)
		free(timeArray[i]);
	free(timeArray);
}

void floydWarshall(int V) {
	for (int mid = 1; mid <= V; mid++) {
		for (int from = 1; from <= V; from++) {
			for (int to = 1; to <= V; to++) {
				if (from == to)
					continue;
				timeArray[from][to] = MIN(timeArray[from][to], timeArray[from][mid] + timeArray[mid][to]);
			}
		}
	}
}

int main() {
	int V, services;
	scanf("%d %d", &V, &services);
	initializeArray(V);

	floydWarshall(V);
	int from, to, time;

	while (services--) {
		scanf("%d %d %d", &from, &to, &time);
		printf(results[timeArray[from][to] <= time]);
	}
	clearArray(V);
	return 0;
}
