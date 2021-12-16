@llvm.global_ctors = appending global [1 x { i32, void ()*, i8* }] [{ i32, void ()*, i8* } { i32 65535, void ()* @global_var_init, i8* null }]
@p = dso_local global i32 0
@a = dso_local global i32** null
@.str.0 = constant [15 x i8] c"10 time to try\00"

%test_master = type { i32, i32 }

define dso_local i32 @main(){
	%1 = bitcast [15 x i8]* @.str.0 to i8*
	call void @println(i8* %1)
	br label %2
2:
	%3 = load i32, i32* @p
	%4 = icmp slt i32 %3, 10
	%5 = icmp ne i1 %4, 0
	br i1 %5, label %6, label %19
6:
	%7 = call i8* @getString()
	%8 = alloca i8*
	store i8* %7, i8** %8
	%9 = call i32 @getInt()
	%10 = alloca i32
	store i32 %9, i32* %10
	%11 = load i8*, i8** %8
	%12 = load i32, i32* %10
	%13 = load i32, i32* %10
	%14 = add i32 %13, 1
	%15 = call i8* @__built_in_string_substring(i8* %11, i32 %12, i32 %14)
	call void @println(i8* %15)
	%16 = load i8*, i8** %8
	%17 = load i32, i32* %10
	%18 = call i32 @__built_in_string_ord(i8* %16, i32 %17)
	call void @printlnInt(i32 %18)
	br label %2
19:
	ret i32 0
}

define dso_local void @global_var_init(){
	store i32 0, i32* @p
	ret void
}

define dso_local void @test_master(%test_master* %0){
	%2 = alloca %test_master*
	store %test_master* %0, %test_master** %2
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