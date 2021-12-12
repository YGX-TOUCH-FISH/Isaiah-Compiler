#include <stdio.h>
#include <string.h>
int sum(int x) { return 0;}
int test(int y ) {
    if (sum(y-1) >= 0 ) return sum(y);
    else return sum(y-1);
}
void *_malloc(int x) {
    return malloc(x);
}
int main() {
    int x = 1;
    printf("%d\n", x+2);
    return 0;
}