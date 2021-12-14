#include <iostream>
#include <string.h>
int r = 1;
int sum(int x) {
    if (x < 0 ) return 1;
    else return x*sum(x-1);
}
int p;
void test(int a, int b) {

    for ( ; a < b ; a--) {
        p = p + (a-b);
    }
}
int main() {
    int x = 1;
    return x*3;
    for (x = 0 ; x < r ; x++) {

        x = x+1;
    }
    return 1;
}