
#include<stdio.h>
struct test{
    int a;
    int b[3];
    double x;
};
struct test function(struct test *P) {
    P[3].a = P[2].b[2]+P[1].x;
    return *P;
}
struct test just_ret;
int main(){
    struct test *P;
    just_ret = function(P);
	return 0;
}