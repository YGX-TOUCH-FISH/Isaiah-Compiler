#include <iostream>
#include <string.h>
using namespace std;
//string test_x = "sdfs";
//string test_y = "dffdd";
class test_type_class {
public:
    int test_type_class_te() {
        int  p = 1;
        for (int i = 0 ; i < 100 ; i++) {
            p += i;
        }
        return p;
    }
    int test_type_class_insert() {
        int  p =5;
            for (int i = 0 ; i < 100 ; i++) {
                p += i;
            }
            return p;
    }
    test_type_class* test_type_class_return() {
        int  p = 1;
        for (int i = 0 ; i < 100 ; i++) {
            p += i;
        }
        return this;
    }
};
//class tp{
// public:
//     int test_type_class_te() { return 1;}
//     int tst() {return 2;}
// };
int sum(int x) ;
int test(int y ) {
    return sum(y);
}
string r;
int *a;
int main() {
    int *b;
    test_type_class x, y;
    if (nullptr == nullptr) return 1;
    else return 0;
}
int sum(int x) {
return 0;}