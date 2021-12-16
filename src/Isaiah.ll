@llvm.global_ctors = appending global [1 x { i32, void ()*, i8* }] [{ i32, void ()*, i8* } { i32 65535, void ()* @global_var_init, i8* null }]
@n = dso_local global i32 0
@p = dso_local global i32 0
@k = dso_local global i32 0
@i = dso_local global i32 0
@.str.0 = constant [4 x i8] c"<< \00"
@.str.1 = constant [2 x i8] c"(\00"
@.str.2 = constant [3 x i8] c") \00"
@.str.3 = constant [2 x i8] c" \00"
@.str.4 = constant [4 x i8] c">> \00"

define dso_local i32 @main(){
	%1 = call i32 @getInt()
	store i32 %1, i32* @n
	%2 = call i32 @getInt()
	store i32 %2, i32* @p
	%3 = call i32 @getInt()
	store i32 %3, i32* @k
	%4 = load i32, i32* @p
	%5 = load i32, i32* @k
	%6 = sub i32 %4, %5
	%7 = icmp sgt i32 %6, 1
	%8 = icmp ne i1 %7, 0
	br i1 %8, label %9, label %11
9:
	%10 = bitcast [4 x i8]* @.str.0 to i8*
	call void @print(i8* %10)
	br label %11
11:
	%12 = load i32, i32* @p
	%13 = load i32, i32* @k
	%14 = sub i32 %12, %13
	store i32 %14, i32* @i
	br label %15
15:
	%16 = load i32, i32* @p
	%17 = load i32, i32* @k
	%18 = add i32 %16, %17
	%19 = load i32, i32* @i
	%20 = icmp sle i32 %19, %18
	%21 = icmp ne i1 %20, 0
	br i1 %21, label %22, label %52
22:
	%23 = load i32, i32* @i
	%24 = icmp sle i32 1, %23
	%25 = icmp ne i1 %24, false
	br i1 %25, label %26, label %31
26:
	%27 = load i32, i32* @i
	%28 = load i32, i32* @n
	%29 = icmp sle i32 %27, %28
	%30 = icmp ne i1 %29, false
	br label %31
31:
	%32 = phi i1 [ false, %22 ], [ %30, %26 ]
	%33 = icmp ne i1 %32, 0
	br i1 %33, label %34, label %48
34:
	%35 = load i32, i32* @i
	%36 = load i32, i32* @p
	%37 = icmp eq i32 %35, %36
	%38 = icmp ne i1 %37, 0
	br i1 %38, label %39, label %44
39:
	%40 = bitcast [2 x i8]* @.str.1 to i8*
	call void @print(i8* %40)
	%41 = load i32, i32* @i
	%42 = call i8* @toString(i32 %41)
	call void @print(i8* %42)
	%43 = bitcast [3 x i8]* @.str.2 to i8*
	call void @print(i8* %43)
	br label %47
44:
	%45 = load i32, i32* @i
	call void @printInt(i32 %45)
	%46 = bitcast [2 x i8]* @.str.3 to i8*
	call void @print(i8* %46)
	br label %47
47:
	br label %48
48:
	br label %49
49:
	%50 = load i32, i32* @i
	%51 = add i32 %50, 1
	store i32 %51, i32* @i
	br label %15
52:
	%53 = load i32, i32* @p
	%54 = load i32, i32* @k
	%55 = add i32 %53, %54
	%56 = load i32, i32* @n
	%57 = icmp slt i32 %55, %56
	%58 = icmp ne i1 %57, 0
	br i1 %58, label %59, label %61
59:
	%60 = bitcast [4 x i8]* @.str.4 to i8*
	call void @print(i8* %60)
	br label %61
61:
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
