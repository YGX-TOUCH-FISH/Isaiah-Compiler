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

@n = global i32 0
@a = global i32* null
@.str.0 = constant [2 x i8] c" \00"
@.str.1 = constant [2 x i8] c"\0A\00"

define void @exchange(i32 %0, i32 %1){
	%3 = alloca i32
	store i32 %0, i32* %3
	%4 = alloca i32
	store i32 %1, i32* %4
	%5 = load i32, i32* %3
	%6 = load i32*, i32** @a
	%7 = getelementptr inbounds i32, i32* %6, i32 %5
	%8 = load i32, i32* %7
	%9 = alloca i32
	store i32 %8, i32* %9
	%10 = load i32, i32* %3
	%11 = load i32*, i32** @a
	%12 = getelementptr inbounds i32, i32* %11, i32 %10
	%13 = load i32, i32* %4
	%14 = load i32*, i32** @a
	%15 = getelementptr inbounds i32, i32* %14, i32 %13
	%16 = load i32, i32* %15
	store i32 %16, i32* %12
	%17 = load i32, i32* %4
	%18 = load i32*, i32** @a
	%19 = getelementptr inbounds i32, i32* %18, i32 %17
	%20 = load i32, i32* %9
	store i32 %20, i32* %19
	ret void
}

define i32 @makeHeap(){
	%1 = alloca i32
	%2 = alloca i32
	%3 = alloca i32
	%4 = load i32, i32* @n
	%5 = sub i32 %4, 1
	%6 = sdiv i32 %5, 2
	store i32 %6, i32* %1
	store i32 0, i32* %2
	store i32 0, i32* %3
	br label %7
7:
	%8 = load i32, i32* %1
	%9 = icmp sge i32 %8, 0
	%10 = icmp ne i1 %9, 0
	br i1 %10, label %11, label %58
11:
	%12 = load i32, i32* %1
	%13 = mul i32 %12, 2
	store i32 %13, i32* %3
	%14 = load i32, i32* %1
	%15 = mul i32 %14, 2
	%16 = add i32 %15, 1
	%17 = load i32, i32* @n
	%18 = icmp slt i32 %16, %17
	%19 = icmp ne i1 %18, false
	br i1 %19, label %20, label %34
20:
	%21 = load i32, i32* %1
	%22 = mul i32 %21, 2
	%23 = add i32 %22, 1
	%24 = load i32*, i32** @a
	%25 = getelementptr inbounds i32, i32* %24, i32 %23
	%26 = load i32, i32* %1
	%27 = mul i32 %26, 2
	%28 = load i32*, i32** @a
	%29 = getelementptr inbounds i32, i32* %28, i32 %27
	%30 = load i32, i32* %25
	%31 = load i32, i32* %29
	%32 = icmp slt i32 %30, %31
	%33 = icmp ne i1 %32, false
	br label %34
34:
	%35 = phi i1 [ false, %11 ], [ %33, %20 ]
	%36 = icmp ne i1 %35, 0
	br i1 %36, label %37, label %41
37:
	%38 = load i32, i32* %1
	%39 = mul i32 %38, 2
	%40 = add i32 %39, 1
	store i32 %40, i32* %3
	br label %41
41:
	%42 = load i32, i32* %1
	%43 = load i32*, i32** @a
	%44 = getelementptr inbounds i32, i32* %43, i32 %42
	%45 = load i32, i32* %3
	%46 = load i32*, i32** @a
	%47 = getelementptr inbounds i32, i32* %46, i32 %45
	%48 = load i32, i32* %44
	%49 = load i32, i32* %47
	%50 = icmp sgt i32 %48, %49
	%51 = icmp ne i1 %50, 0
	br i1 %51, label %52, label %55
52:
	%53 = load i32, i32* %1
	%54 = load i32, i32* %3
	call void @exchange(i32 %53, i32 %54)
	br label %55
55:
	%56 = load i32, i32* %1
	%57 = sub i32 %56, 1
	store i32 %57, i32* %1
	br label %7
58:
	ret i32 0
}

define i32 @adjustHeap(i32 %0){
	%2 = alloca i32
	store i32 %0, i32* %2
	%3 = alloca i32
	store i32 0, i32* %3
	%4 = alloca i32
	store i32 0, i32* %4
	%5 = alloca i32
	store i32 0, i32* %5
	br label %6
6:
	%7 = load i32, i32* %3
	%8 = mul i32 %7, 2
	%9 = load i32, i32* %2
	%10 = icmp slt i32 %8, %9
	%11 = icmp ne i1 %10, 0
	br i1 %11, label %12, label %73
12:
	%13 = load i32, i32* %3
	%14 = mul i32 %13, 2
	store i32 %14, i32* %4
	%15 = load i32, i32* %3
	%16 = mul i32 %15, 2
	%17 = add i32 %16, 1
	%18 = load i32, i32* %2
	%19 = icmp slt i32 %17, %18
	%20 = icmp ne i1 %19, false
	br i1 %20, label %21, label %35
21:
	%22 = load i32, i32* %3
	%23 = mul i32 %22, 2
	%24 = add i32 %23, 1
	%25 = load i32*, i32** @a
	%26 = getelementptr inbounds i32, i32* %25, i32 %24
	%27 = load i32, i32* %3
	%28 = mul i32 %27, 2
	%29 = load i32*, i32** @a
	%30 = getelementptr inbounds i32, i32* %29, i32 %28
	%31 = load i32, i32* %26
	%32 = load i32, i32* %30
	%33 = icmp slt i32 %31, %32
	%34 = icmp ne i1 %33, false
	br label %35
35:
	%36 = phi i1 [ false, %12 ], [ %34, %21 ]
	%37 = icmp ne i1 %36, 0
	br i1 %37, label %38, label %42
38:
	%39 = load i32, i32* %3
	%40 = mul i32 %39, 2
	%41 = add i32 %40, 1
	store i32 %41, i32* %4
	br label %42
42:
	%43 = load i32, i32* %3
	%44 = load i32*, i32** @a
	%45 = getelementptr inbounds i32, i32* %44, i32 %43
	%46 = load i32, i32* %4
	%47 = load i32*, i32** @a
	%48 = getelementptr inbounds i32, i32* %47, i32 %46
	%49 = load i32, i32* %45
	%50 = load i32, i32* %48
	%51 = icmp sgt i32 %49, %50
	%52 = icmp ne i1 %51, 0
	br i1 %52, label %53, label %71
53:
	%54 = load i32, i32* %3
	%55 = load i32*, i32** @a
	%56 = getelementptr inbounds i32, i32* %55, i32 %54
	%57 = load i32, i32* %56
	%58 = alloca i32
	store i32 %57, i32* %58
	%59 = load i32, i32* %3
	%60 = load i32*, i32** @a
	%61 = getelementptr inbounds i32, i32* %60, i32 %59
	%62 = load i32, i32* %4
	%63 = load i32*, i32** @a
	%64 = getelementptr inbounds i32, i32* %63, i32 %62
	%65 = load i32, i32* %64
	store i32 %65, i32* %61
	%66 = load i32, i32* %4
	%67 = load i32*, i32** @a
	%68 = getelementptr inbounds i32, i32* %67, i32 %66
	%69 = load i32, i32* %58
	store i32 %69, i32* %68
	%70 = load i32, i32* %4
	store i32 %70, i32* %3
	br label %72
71:
	br label %73
72:
	br label %6
73:
	ret i32 0
}

define i32 @heapSort(){
	%1 = alloca i32
	%2 = alloca i32
	store i32 0, i32* %1
	store i32 0, i32* %2
	br label %3
3:
	%4 = load i32, i32* %2
	%5 = load i32, i32* @n
	%6 = icmp slt i32 %4, %5
	%7 = icmp ne i1 %6, 0
	br i1 %7, label %8, label %36
8:
	%9 = load i32*, i32** @a
	%10 = getelementptr inbounds i32, i32* %9, i32 0
	%11 = load i32, i32* %10
	store i32 %11, i32* %1
	%12 = load i32*, i32** @a
	%13 = getelementptr inbounds i32, i32* %12, i32 0
	%14 = load i32, i32* @n
	%15 = load i32, i32* %2
	%16 = sub i32 %14, %15
	%17 = sub i32 %16, 1
	%18 = load i32*, i32** @a
	%19 = getelementptr inbounds i32, i32* %18, i32 %17
	%20 = load i32, i32* %19
	store i32 %20, i32* %13
	%21 = load i32, i32* @n
	%22 = load i32, i32* %2
	%23 = sub i32 %21, %22
	%24 = sub i32 %23, 1
	%25 = load i32*, i32** @a
	%26 = getelementptr inbounds i32, i32* %25, i32 %24
	%27 = load i32, i32* %1
	store i32 %27, i32* %26
	%28 = load i32, i32* @n
	%29 = load i32, i32* %2
	%30 = sub i32 %28, %29
	%31 = sub i32 %30, 1
	%32 = call i32 @adjustHeap(i32 %31)
	br label %33
33:
	%34 = load i32, i32* %2
	%35 = add i32 %34, 1
	store i32 %35, i32* %2
	br label %3
36:
	ret i32 0
}

define i32 @main(){
	call void @global_var_init()
	%1 = alloca i32
	%2 = call i8* @getString()
	%3 = call i32 @string_parseInt(i8* %2)
	store i32 %3, i32* @n
	%4 = load i32, i32* @n
	%5 = mul i32 %4, 4
	%6 = add i32 %5, 4
	%7 = call i8* @malloc(i32 %6)
	%8 = bitcast i8* %7 to i32*
	store i32 %4, i32* %8
	%9 = getelementptr inbounds i8, i8* %7, i32 4
	%10 = bitcast i8* %9 to i32*
	%11 = alloca i32*
	store i32* %10, i32** %11
	%12 = load i32*, i32** %11
	store i32* %12, i32** @a
	store i32 0, i32* %1
	br label %13
13:
	%14 = load i32*, i32** @a
	%15 = bitcast i32* %14 to i8*
	%16 = call i32 @array_size(i8* %15)
	%17 = load i32, i32* %1
	%18 = icmp slt i32 %17, %16
	%19 = icmp ne i1 %18, 0
	br i1 %19, label %20, label %28
20:
	%21 = load i32, i32* %1
	%22 = load i32*, i32** @a
	%23 = getelementptr inbounds i32, i32* %22, i32 %21
	%24 = load i32, i32* %1
	store i32 %24, i32* %23
	br label %25
25:
	%26 = load i32, i32* %1
	%27 = add i32 %26, 1
	store i32 %27, i32* %1
	br label %13
28:
	%29 = call i32 @makeHeap()
	%30 = call i32 @heapSort()
	store i32 0, i32* %1
	br label %31
31:
	%32 = load i32*, i32** @a
	%33 = bitcast i32* %32 to i8*
	%34 = call i32 @array_size(i8* %33)
	%35 = load i32, i32* %1
	%36 = icmp slt i32 %35, %34
	%37 = icmp ne i1 %36, 0
	br i1 %37, label %38, label %49
38:
	%39 = load i32, i32* %1
	%40 = load i32*, i32** @a
	%41 = getelementptr inbounds i32, i32* %40, i32 %39
	%42 = load i32, i32* %41
	%43 = call i8* @toString(i32 %42)
	%44 = bitcast [2 x i8]* @.str.0 to i8*
	%45 = call i8* @string_add(i8* %43, i8* %44)
	call void @print(i8* %45)
	br label %46
46:
	%47 = load i32, i32* %1
	%48 = add i32 %47, 1
	store i32 %48, i32* %1
	br label %31
49:
	%50 = bitcast [2 x i8]* @.str.1 to i8*
	call void @print(i8* %50)
	ret i32 0
}

define void @global_var_init(){
	ret void
}

