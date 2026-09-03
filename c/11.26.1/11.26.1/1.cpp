#include <stdio.h>
#include <string.h>
#include <ctype.h>

int main() {
    int count[26] = { 0 };
    char ch;

    // 统计字母频率
    printf("请输入文本（按Ctrl+Z或Ctrl+D结束）：\n");
    while (scanf_s("%c", &ch) != EOF) {
        if (isalpha(ch)) {
            char upperCh = toupper(ch);
            count[upperCh - 'A']++;
        }
    }

    // 找到最大频率值用于确定行数
    int maxFreq = 0;
    for (int i = 0; i < 26; i++) {
        if (count[i] > maxFreq) {
            maxFreq = count[i];
        }
    }

    printf("\n字母频率直方图：\n");

    // 从最高频率到最低频率逐行打印
    int hasOutput = 0;  // 标记是否有内容输出

    for (int level = maxFreq; level >= 1; level--) {
        hasOutput = 1;
        for (int i = 0; i < 26; i++) {
            if (i == 0) {
                printf("%c", count[i] >= level ? '*' : ' ');
            }
            else {
                printf(" %c", count[i] >= level ? '*' : ' ');
            }
        }
        printf("\n");
    }

    // 如果所有字母频率都为0
    if (!hasOutput) {
        printf("A B C D E F G H I J K L M N O P Q R S T U V W X Y Z");
    }
    else {
        // 打印字母标签行
        printf("A B C D E F G H I J K L M N O P Q R S T U V W X Y Z\n");

        // 可选：显示具体数字
        printf("数字: ");
        for (int i = 0; i < 26; i++) {
            if (i == 0) {
                printf("%d", count[i]);
            }
            else {
                printf(" %d", count[i]);
            }
        }
        printf("\n");
    }

    return 0;
}