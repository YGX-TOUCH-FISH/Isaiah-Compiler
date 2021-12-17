@llvm.global_ctors = appending global [1 x { i32, void ()*, i8* }] [{ i32, void ()*, i8* } { i32 65535, void ()* @global_var_init, i8* null }]
@.str.0 = constant [6 x i8] c"move \00"
@.str.1 = constant [6 x i8] c" --> \00"
@.str.2 = constant [6 x i8] c"move \00"
@.str.3 = constant [6 x i8] c" --> \00"
@.str.4 = constant [2 x i8] c"A\00"
@.str.5 = constant [2 x i8] c"B\00"
@.str.6 = constant [2 x i8] c"C\00"

define dso_local i32 @cd(i32 %0, i8* %1, i8* %2, i8* %3, i32 %4){
	%6 = alloca i32
	store i32 %0, i32* %6
	%7 = alloca i8*
	store i8* %1, i8** %7
	%8 = alloca i8*
	store i8* %2, i8** %8
	%9 = alloca i8*
	store i8* %3, i8** %9
	%10 = alloca i32
	store i32 %4, i32* %10
	%11 = load i32, i32* %6
	%12 = icmp eq i32 %11, 1
	%13 = icmp ne i1 %12, 0
	br i1 %13, label %14, label %24
14:
	%15 = bitcast [6 x i8]* @.str.0 to i8*
	%16 = load i8*, i8** %7
	%17 = call i8* @__built_in_string_add(i8* %15, i8* %16)
	%18 = bitcast [6 x i8]* @.str.1 to i8*
	%19 = call i8* @__built_in_string_add(i8* %17, i8* %18)
	%20 = load i8*, i8** %9
	%21 = call i8* @__built_in_string_add(i8* %19, i8* %20)
	call void @println(i8* %21)
	%22 = load i32, i32* %10
	%23 = add i32 %22, 1
	store i32 %23, i32* %10
	br label %48
24:
	%25 = load i32, i32* %6
	%26 = sub i32 %25, 1
	%27 = load i8*, i8** %7
	%28 = load i8*, i8** %9
	%29 = load i8*, i8** %8
	%30 = load i32, i32* %10
	%31 = call i32 @cd(i32 %26, i8* %27, i8* %28, i8* %29, i32 %30)
	store i32 %31, i32* %10
	%32 = bitcast [6 x i8]* @.str.2 to i8*
	%33 = load i8*, i8** %7
	%34 = call i8* @__built_in_string_add(i8* %32, i8* %33)
	%35 = bitcast [6 x i8]* @.str.3 to i8*
	%36 = call i8* @__built_in_string_add(i8* %34, i8* %35)
	%37 = load i8*, i8** %9
	%38 = call i8* @__built_in_string_add(i8* %36, i8* %37)
	call void @println(i8* %38)
	%39 = load i32, i32* %6
	%40 = sub i32 %39, 1
	%41 = load i8*, i8** %8
	%42 = load i8*, i8** %7
	%43 = load i8*, i8** %9
	%44 = load i32, i32* %10
	%45 = call i32 @cd(i32 %40, i8* %41, i8* %42, i8* %43, i32 %44)
	store i32 %45, i32* %10
	%46 = load i32, i32* %10
	%47 = add i32 %46, 1
	store i32 %47, i32* %10
	br label %48
48:
	%49 = load i32, i32* %10
	ret i32 %49
}

define dso_local i32 @main(){
	%1 = bitcast [2 x i8]* @.str.4 to i8*
	%2 = alloca i8*
	store i8* %1, i8** %2
	%3 = bitcast [2 x i8]* @.str.5 to i8*
	%4 = alloca i8*
	store i8* %3, i8** %4
	%5 = bitcast [2 x i8]* @.str.6 to i8*
	%6 = alloca i8*
	store i8* %5, i8** %6
	%7 = call i32 @getInt()
	%8 = alloca i32
	store i32 %7, i32* %8
	%9 = load i32, i32* %8
	%10 = load i8*, i8** %2
	%11 = load i8*, i8** %4
	%12 = load i8*, i8** %6
	%13 = call i32 @cd(i32 %9, i8* %10, i8* %11, i8* %12, i32 0)
	%14 = alloca i32
	store i32 %13, i32* %14
	%15 = load i32, i32* %14
	%16 = call i8* @toString(i32 %15)
	call void @println(i8* %16)
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
