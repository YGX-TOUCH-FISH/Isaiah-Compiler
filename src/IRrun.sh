clang -S -emit-llvm builtIn.c
clang Isaiah.ll builtIn.ll -o test
./test