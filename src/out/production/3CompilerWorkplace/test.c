
#include<stdio.h>
int n,a[20];
int jud(int x){
	int i,j;
	for(i=0;i<n/x;i++){
		int flag=0;
		for(j=0;j<x-1;j++){
			if(a[i*x+j]>a[i*x+j+1])flag=1;
		}
		if(!flag)return 1;
	}
	return 0;
}
int main(){
	int i;
	scanf("%d",&n);
	for(i=0;i<n;i++)scanf("%d",&a[i]);
	for(i=n;i;i>>=1)if(jud(i))return printf("%d",i),0;
	return 0;
}