#include <iostream>
#include <string.h>
class test_class{
public:
    int p = 3;
    test_class() {
        p = 4;
    }
    int show(int a, int b) { return a+b;}
};
int sum_function(int x) {
    if (x > 0) return x*sum_function(x-1);
    else return 1;
}
int r;
int main() {
    test_class t, h;
    t = h;
    int p = t.p;
//    if (t.p == t.show(3, 4) && sum_function(3) + sum_function(4) != sum_function(7)) r= 3;
//    bool x = t.p == t.show(3, 4) || sum_function(3) + sum_function(4) != sum_function(7);
    int x = t.p;
}