#include<stdlib.h>
#include<stdio.h>
#include<stdbool.h>
char *__built_in_string_add(char *x, char *y) {
    int i = 0, j = 0, k = 0;
    while(x[i] != '\0') i++;
    while(y[j] != '\0') j++;
    char *ret = malloc(i+j+1);
    for ( ; k < i ; k++)   ret[k] = x[k];
    for ( ; k < i+j ; k++) ret[k] = y[k-i];
    ret[k] = '\0';
    return ret;
}

bool __built_in_string_less_than(char *x, char *y) { return strcmp(x, y) < 0;}

bool __built_in_string_greater_than(char *x, char *y) { return strcmp(x, y) > 0;}

bool __built_in_string_less_equal(char *x, char *y) { return strcmp(x, y) <= 0;}

bool __built_in_string_greater_equal(char *x, char *y) {return strcmp(x, y) >= 0;}

bool __built_in_string_equal(char *x, char *y) { return strcmp(x, y) == 0;}

bool __built_in_string_not_equal(char *x, char *y) { return strcmp(x, y) != 0;}

int __built_in_string_length(char *x) {
    int i = 0;
    while(x[i] != '\0') i++;
    return i;
}

char *__built_in_string_substring(char *x, int l, int r) {
    int i;
    char *ret = malloc(r-l+1);
    for (i = l ; i < r ; i++) ret[i-l]=x[i];
    ret[r-l] = '\0';
    return ret;
}

int __built_in_string_parseInt(char *x) {
    int ret = 0;
    int i = x[0] == '-';
    while (x[i] >= '0' && x[i] <= '9') {
        ret *= 10;
        ret += x[i]-'0';
        i++;
    }
    return x[0] == '-' ? -ret : ret;
}

int __built_in_string_ord(char *x, int pos) {return x[pos];}

int __built_in_array_size(char *x) {return *((int *)(x-4));}

void print(char *x) {printf("%s", x);}

void println(char *x) {printf("%s\n", x);}

void printInt(int x) {printf("%d", x);}

void printlnInt(int x) {printf("%d\n", x);}

char *getString() {
//    char *p = (char *) malloc(1000);
//    int i = 0;
//    char x;
//    while(1) {
//        x = getchar();
//        if (x == '\n') return p;
//        *(p+i) = x;
//        i++;
//    }
    char* ret = malloc(1024);
    scanf("%s", ret);
    return ret;
}

int getInt() {
    int ret;
    scanf("%d", &ret);
    return ret;
//    char *p = (char *) malloc(20);
//    int i = 0;
//    char x;
//    while (1) {
//        x = getchar();
//        if (i != 0 && (x < '0' || x > '9')) break;
//        *(p+i) = x;
//        i++;
//    }
//    return __built_in_string_parseInt(p);
}

char *toString(int x) {
    char *p = malloc(13);
    char *ret = malloc(13);
    int i = 0, j = 0;
    if (x == 0) {
        ret[0] = '0';
        ret[1] = '\0';
        return ret;
    }
    else if (x > 0) {
        while (x != 0 ){
            p[i++] = '0'+x%10;
            x /= 10;
        }
        for ( ; j < i ; j++) ret[j] = p[i-1-j];
        ret[j] = '\0';
    }
    else {
        x = -x;
        while (x != 0 ){
            p[i++] = '0'+x%10;
            x /= 10;
        }
        ret[0] = '-';
        for ( ; j < i ; j++) ret[j+1] = p[i-1-j];
        ret[j+1] = '\0';
    }
    free(p);
    return ret;
}