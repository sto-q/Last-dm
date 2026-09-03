#include<stdio.h>
#include<string.h>
int main() {
    char n[100]; 
    gets_s(n, sizeof(n)); 
    printf(" %d", strlen(n));
    return 0;
}