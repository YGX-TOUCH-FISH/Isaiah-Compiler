#include <stdio.h>
#include <string.h>
int r = 1;
class test_class {
    public:
    int p = 3;
    test_class() {
        p = 4;
    }
}
int main() {
    test_class p;
}