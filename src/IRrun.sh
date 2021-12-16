clang -S -emit-llvm builtIn.c
clang test.ll builtIn.ll -o test
./test