@llvm.global_ctors = appending global [1 x { i32, void ()*, i8* }] [{ i32, void ()*, i8* } { i32 65535, void ()* @global_var_init, i8* null }]

define dso_local i32 @tak(i32 %0, i32 %1, i32 %2){
	%4 = alloca i32
	store i32 %0, i32* %4
	%5 = alloca i32
	store i32 %1, i32* %5
	%6 = alloca i32
	store i32 %2, i32* %6
	%7 = load i32, i32* %5
	%8 = load i32, i32* %4
	%9 = icmp slt i32 %7, %8
	%10 = icmp ne i1 %9, 0
	br i1 %10, label %11, label %29
11:
	%12 = load i32, i32* %4
	%13 = sub i32 %12, 1
	%14 = load i32, i32* %5
	%15 = load i32, i32* %6
	%16 = call i32 @tak(i32 %13, i32 %14, i32 %15)
	%17 = load i32, i32* %5
	%18 = sub i32 %17, 1
	%19 = load i32, i32* %6
	%20 = load i32, i32* %4
	%21 = call i32 @tak(i32 %18, i32 %19, i32 %20)
	%22 = load i32, i32* %6
	%23 = sub i32 %22, 1
	%24 = load i32, i32* %4
	%25 = load i32, i32* %5
	%26 = call i32 @tak(i32 %23, i32 %24, i32 %25)
	%27 = call i32 @tak(i32 %16, i32 %21, i32 %26)
	%28 = add i32 1, %27
	ret i32 %28
29:
	%30 = load i32, i32* %6
	ret i32 %30
31:
	ret i32 0
}

define dso_local i32 @main(){
	%1 = alloca i32
	%2 = alloca i32
	%3 = alloca i32
	%4 = call i32 @getInt()
	store i32 %4, i32* %1
	%5 = call i32 @getInt()
	store i32 %5, i32* %2
	%6 = call i32 @getInt()
	store i32 %6, i32* %3
	%7 = load i32, i32* %1
	%8 = load i32, i32* %2
	%9 = load i32, i32* %3
	%10 = call i32 @tak(i32 %7, i32 %8, i32 %9)
	%11 = call i8* @toString(i32 %10)
	call void @println(i8* %11)
	ret i32 0
}

define dso_local void @global_var_init(){
	ret void
}

declare dso_local i8* @malloc(i64)
declare dso_local i8* @__built_in_string_add(i8*, i8*)
declare dso_local i1 @__built_in_string_less_than(i8*, i8*)
declare dso_local i1 @__built_in_string_greater_than(i8*, i8*)
declare dso_local i1 @__built_in_string_less_equal(i8*, i8*)
declare dso_local i1 @__built_in_string_greater_equal(i8*, i8*)
declare dso_local i1 @__built_in_string_equal(i8*, i8*)
declare dso_local i1 @__built_in_string_not_equal(i8*, i8*)
declare dso_local i32 @__built_in_string_length(i8*)
declare dso_local i8* @__built_in_string_substring(i8*, i32, i32)
declare dso_local i32 @__built_in_string_parseInt(i8*)
declare dso_local i32 @__built_in_string_ord(i8*, i32)
declare dso_local i32 @__built_in_array_size(i8*)
declare dso_local void @print(i8*)
declare dso_local void @println(i8*)
declare dso_local void @printInt(i32)
declare dso_local void @printlnInt(i32)
declare dso_local i8* @getString()
declare dso_local i32 @getInt()
declare dso_local i8* @toString(i32)
