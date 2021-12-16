#include <iostream>
#include <string.h>
using namespace std;
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
string p = "sfdsfd";
string q = "fsdsd";
int main() {
    int *x = new int [3];
    x[1] = 1;
    x[2] = 2;
    int y = x[2];
    string xx = p;
    string yy = q;
    std::cout << y;
}