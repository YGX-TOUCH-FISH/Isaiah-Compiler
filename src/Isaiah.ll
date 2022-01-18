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

@.str.0 = constant [2 x i8] c" \00"
@.str.1 = constant [1 x i8] c"\00"

define void @bubble_sort(i32* %0){
	%2 = alloca i32*
	store i32* %0, i32** %2
	%3 = alloca i32
	%4 = alloca i32
	%5 = load i32*, i32** %2
	%6 = bitcast i32* %5 to i8*
	%7 = call i32 @array_size(i8* %6)
	%8 = alloca i32
	store i32 %7, i32* %8
	store i32 0, i32* %3
	br label %9
9:
	%10 = load i32, i32* %8
	%11 = sub i32 %10, 1
	%12 = load i32, i32* %3
	%13 = icmp slt i32 %12, %11
	%14 = icmp ne i1 %13, 0
	br i1 %14, label %15, label %63
15:
	store i32 0, i32* %4
	br label %16
16:
	%17 = load i32, i32* %8
	%18 = load i32, i32* %3
	%19 = sub i32 %17, %18
	%20 = sub i32 %19, 1
	%21 = load i32, i32* %4
	%22 = icmp slt i32 %21, %20
	%23 = icmp ne i1 %22, 0
	br i1 %23, label %24, label %59
24:
	%25 = load i32, i32* %4
	%26 = load i32*, i32** %2
	%27 = getelementptr inbounds i32, i32* %26, i32 %25
	%28 = load i32, i32* %4
	%29 = add i32 %28, 1
	%30 = load i32*, i32** %2
	%31 = getelementptr inbounds i32, i32* %30, i32 %29
	%32 = load i32, i32* %27
	%33 = load i32, i32* %31
	%34 = icmp slt i32 %32, %33
	%35 = icmp ne i1 %34, 0
	br i1 %35, label %36, label %37
36:
	br label %56
37:
	%38 = load i32, i32* %4
	%39 = load i32*, i32** %2
	%40 = getelementptr inbounds i32, i32* %39, i32 %38
	%41 = load i32, i32* %40
	%42 = alloca i32
	store i32 %41, i32* %42
	%43 = load i32, i32* %4
	%44 = load i32*, i32** %2
	%45 = getelementptr inbounds i32, i32* %44, i32 %43
	%46 = load i32, i32* %4
	%47 = add i32 %46, 1
	%48 = load i32*, i32** %2
	%49 = getelementptr inbounds i32, i32* %48, i32 %47
	%50 = load i32, i32* %49
	store i32 %50, i32* %45
	%51 = load i32, i32* %4
	%52 = add i32 %51, 1
	%53 = load i32*, i32** %2
	%54 = getelementptr inbounds i32, i32* %53, i32 %52
	%55 = load i32, i32* %42
	store i32 %55, i32* %54
	br label %56
56:
	%57 = load i32, i32* %4
	%58 = add i32 %57, 1
	store i32 %58, i32* %4
	br label %16
59:
	br label %60
60:
	%61 = load i32, i32* %3
	%62 = add i32 %61, 1
	store i32 %62, i32* %3
	br label %9
63:
	ret void
}

define i32 @main(){
	call void @global_var_init()
	%1 = call i32 @getInt()
	%2 = alloca i32
	store i32 %1, i32* %2
	%3 = load i32, i32* %2
	%4 = mul i32 %3, 4
	%5 = add i32 %4, 4
	%6 = call i8* @malloc(i32 %5)
	%7 = bitcast i8* %6 to i32*
	store i32 %3, i32* %7
	%8 = getelementptr inbounds i8, i8* %6, i32 4
	%9 = bitcast i8* %8 to i32*
	%10 = alloca i32*
	store i32* %9, i32** %10
	%11 = load i32*, i32** %10
	%12 = alloca i32*
	store i32* %11, i32** %12
	%13 = alloca i32
	store i32 0, i32* %13
	br label %14
14:
	%15 = load i32, i32* %13
	%16 = load i32, i32* %2
	%17 = icmp slt i32 %15, %16
	%18 = icmp ne i1 %17, 0
	br i1 %18, label %19, label %27
19:
	%20 = load i32, i32* %13
	%21 = load i32*, i32** %12
	%22 = getelementptr inbounds i32, i32* %21, i32 %20
	%23 = call i32 @getInt()
	store i32 %23, i32* %22
	br label %24
24:
	%25 = load i32, i32* %13
	%26 = add i32 %25, 1
	store i32 %26, i32* %13
	br label %14
27:
	%28 = load i32*, i32** %12
	call void @bubble_sort(i32* %28)
	store i32 0, i32* %13
	br label %29
29:
	%30 = load i32, i32* %13
	%31 = load i32, i32* %2
	%32 = icmp slt i32 %30, %31
	%33 = icmp ne i1 %32, 0
	br i1 %33, label %34, label %45
34:
	%35 = load i32, i32* %13
	%36 = load i32*, i32** %12
	%37 = getelementptr inbounds i32, i32* %36, i32 %35
	%38 = load i32, i32* %37
	%39 = call i8* @toString(i32 %38)
	%40 = bitcast [2 x i8]* @.str.0 to i8*
	%41 = call i8* @string_add(i8* %39, i8* %40)
	call void @print(i8* %41)
	br label %42
42:
	%43 = load i32, i32* %13
	%44 = add i32 %43, 1
	store i32 %44, i32* %13
	br label %29
45:
	%46 = bitcast [1 x i8]* @.str.1 to i8*
	call void @println(i8* %46)
	ret i32 0
}

define void @global_var_init(){
	ret void
}

