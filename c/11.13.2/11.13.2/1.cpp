#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

int main() {
    FILE* file = fopen("test.txt", "r");
    if (file == NULL) {
        perror("Failed to open file");
        return 1;
    }
    int num;
    int result = vfscanf(file, L" %d", &num);
    fclose(file);
    return 0;
}