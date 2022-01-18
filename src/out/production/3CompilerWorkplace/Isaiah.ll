declare i8* @malloc(i32)
declare i8* @string_add(i8*, i8*)
declare i1 @string_lt(i8*, i8*)
declare i1 @string_gt(i8*, i8*)
declare i1 @string_le(i8*, i8*)
declare i1 @string_ge(i8*, i8*)
declare i1 @string_eq(i8*, i8*)
declare i1 @string_ne(i8*, i8*)
declare i32 @string_length(i8*)
declare i8* @string_subString(i8*, i32, i32)
declare i32 @string_parseInt(i8*)
declare i32 @string_ord(i8*, i32)
declare i32 @array_size(i8*)
declare void @print(i8*)
declare void @println(i8*)
declare void @printInt(i32)
declare void @printlnInt(i32)
declare i8* @getString()
declare i32 @getInt()
declare i8* @toString(i32)

@.str.0 = constant [2 x i8] c"\0A\00"

define i32 @main(){
	call void @global_var_init()
	%1 = alloca i32
	store i32 10000, i32* %1
	%2 = alloca i32
	store i32 0, i32* %2
	%3 = alloca i32
	store i32 2800, i32* %3
	%4 = alloca i32
	store i32 0, i32* %4
	%5 = alloca i32
	store i32 0, i32* %5
	%6 = add i32 11204, 4
	%7 = call i8* @malloc(i32 %6)
	%8 = bitcast i8* %7 to i32*
	store i32 2801, i32* %8
	%9 = getelementptr inbounds i8, i8* %7, i32 4
	%10 = bitcast i8* %9 to i32*
	%11 = alloca i32*
	store i32* %10, i32** %11
	%12 = load i32*, i32** %11
	%13 = alloca i32*
	store i32* %12, i32** %13
	%14 = alloca i32
	store i32 0, i32* %14
	br label %15
15:
	%16 = load i32, i32* %2
	%17 = load i32, i32* %3
	%18 = sub i32 %16, %17
	%19 = icmp ne i32 %18, 0
	%20 = icmp ne i1 %19, 0
	br i1 %20, label %21, label %30
21:
	%22 = load i32, i32* %2
	%23 = load i32*, i32** %13
	%24 = getelementptr inbounds i32, i32* %23, i32 %22
	%25 = load i32, i32* %1
	%26 = sdiv i32 %25, 5
	store i32 %26, i32* %24
	br label %27
27:
	%28 = load i32, i32* %2
	%29 = add i32 %28, 1
	store i32 %29, i32* %2
	br label %15
30:
	br label %31
31:
	br label %32
32:
	store i32 0, i32* %4
	%33 = load i32, i32* %3
	%34 = mul i32 %33, 2
	store i32 %34, i32* %14
	%35 = load i32, i32* %14
	%36 = icmp eq i32 %35, 0
	%37 = icmp ne i1 %36, 0
	br i1 %37, label %38, label %39
38:
	br label %88
39:
	%40 = load i32, i32* %3
	store i32 %40, i32* %2
	br label %41
41:
	br label %42
42:
	%43 = load i32, i32* %2
	%44 = load i32*, i32** %13
	%45 = getelementptr inbounds i32, i32* %44, i32 %43
	%46 = load i32, i32* %45
	%47 = load i32, i32* %1
	%48 = mul i32 %46, %47
	%49 = load i32, i32* %4
	%50 = add i32 %49, %48
	store i32 %50, i32* %4
	%51 = load i32, i32* %2
	%52 = load i32*, i32** %13
	%53 = getelementptr inbounds i32, i32* %52, i32 %51
	%54 = load i32, i32* %14
	%55 = sub i32 %54, 1
	store i32 %55, i32* %14
	%56 = load i32, i32* %4
	%57 = load i32, i32* %14
	%58 = srem i32 %56, %57
	store i32 %58, i32* %53
	%59 = load i32, i32* %4
	%60 = load i32, i32* %14
	%61 = sdiv i32 %59, %60
	store i32 %61, i32* %4
	%62 = load i32, i32* %14
	%63 = sub i32 %62, 1
	store i32 %63, i32* %14
	%64 = load i32, i32* %2
	%65 = sub i32 %64, 1
	store i32 %65, i32* %2
	%66 = load i32, i32* %2
	%67 = icmp eq i32 %66, 0
	%68 = icmp ne i1 %67, 0
	br i1 %68, label %69, label %70
69:
	br label %75
70:
	br label %71
71:
	%72 = load i32, i32* %4
	%73 = load i32, i32* %2
	%74 = mul i32 %72, %73
	store i32 %74, i32* %4
	br label %41
75:
	%76 = load i32, i32* %3
	%77 = sub i32 %76, 14
	store i32 %77, i32* %3
	%78 = load i32, i32* %4
	%79 = load i32, i32* %1
	%80 = sdiv i32 %78, %79
	%81 = load i32, i32* %5
	%82 = add i32 %81, %80
	%83 = call i8* @toString(i32 %82)
	call void @print(i8* %83)
	br label %84
84:
	%85 = load i32, i32* %4
	%86 = load i32, i32* %1
	%87 = srem i32 %85, %86
	store i32 %87, i32* %5
	br label %31
88:
	%89 = bitcast [2 x i8]* @.str.0 to i8*
	call void @print(i8* %89)
	ret i32 0
}

define void @global_var_init(){
	ret void
}

