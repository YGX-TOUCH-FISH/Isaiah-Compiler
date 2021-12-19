@llvm.global_ctors = appending global [1 x { i32, void ()*, i8* }] [{ i32, void ()*, i8* } { i32 65535, void ()* @global_var_init, i8* null }]
@N = dso_local global i32 0
@M = dso_local global i32 0
@i = dso_local global i32 0
@j = dso_local global i32 0
@primeCount = dso_local global i32 0
@resultCount = dso_local global i32 0
@b = dso_local global i32* null
@prime = dso_local global i32* null
@gps = dso_local global i32* null
@tmp = dso_local global i32* null
@result = dso_local global i32** null
@.str.0 = constant [2 x i8] c" \00"
@.str.1 = constant [2 x i8] c"\0A\00"
@.str.2 = constant [8 x i8] c"Total: \00"

define dso_local void @origin(i32 %0){
	%2 = alloca i32
	store i32 %0, i32* %2
	%3 = load i32, i32* %2
	%4 = zext i32 %3 to i64
	%5 = mul i64 %4, 8
	%6 = add i64 %5, 4
	%7 = call i8* @malloc(i64 %6)
	%8 = bitcast i8* %7 to i32*
	store i32 %3, i32* %8
	%9 = getelementptr inbounds i8, i8* %7, i64 4
	%10 = bitcast i8* %9 to i32**
	%11 = alloca i32**
	store i32** %10, i32*** %11
	%12 = load i32**, i32*** %11
	store i32** %12, i32*** @result
	store i32 0, i32* @i
	br label %13
13:
	%14 = load i32, i32* @i
	%15 = load i32, i32* %2
	%16 = icmp slt i32 %14, %15
	%17 = icmp ne i1 %16, 0
	br i1 %17, label %18, label %51
18:
	%19 = load i32, i32* @i
	%20 = load i32**, i32*** @result
	%21 = getelementptr inbounds i32*, i32** %20, i32 %19
	%22 = load i32, i32* %2
	%23 = zext i32 %22 to i64
	%24 = mul i64 %23, 4
	%25 = add i64 %24, 4
	%26 = call i8* @malloc(i64 %25)
	%27 = bitcast i8* %26 to i32*
	store i32 %22, i32* %27
	%28 = getelementptr inbounds i8, i8* %26, i64 4
	%29 = bitcast i8* %28 to i32*
	%30 = alloca i32*
	store i32* %29, i32** %30
	%31 = load i32*, i32** %30
	store i32* %31, i32** %21
	store i32 0, i32* @j
	br label %32
32:
	%33 = load i32, i32* @j
	%34 = load i32, i32* %2
	%35 = icmp slt i32 %33, %34
	%36 = icmp ne i1 %35, 0
	br i1 %36, label %37, label %47
37:
	%38 = load i32, i32* @i
	%39 = load i32**, i32*** @result
	%40 = getelementptr inbounds i32*, i32** %39, i32 %38
	%41 = load i32, i32* @j
	%42 = load i32*, i32** %40
	%43 = getelementptr inbounds i32, i32* %42, i32 %41
	store i32 0, i32* %43
	br label %44
44:
	%45 = load i32, i32* @j
	%46 = add i32 %45, 1
	store i32 %46, i32* @j
	br label %32
47:
	br label %48
48:
	%49 = load i32, i32* @i
	%50 = add i32 %49, 1
	store i32 %50, i32* @i
	br label %13
51:
	ret void
}

define dso_local void @getPrime(i32 %0){
	%2 = alloca i32
	store i32 %0, i32* %2
	%3 = alloca i32
	%4 = alloca i32
	store i32 2, i32* %3
	store i32 2, i32* %4
	br label %5
5:
	%6 = load i32, i32* %4
	%7 = load i32, i32* %2
	%8 = icmp sle i32 %6, %7
	%9 = icmp ne i1 %8, 0
	br i1 %9, label %10, label %56
10:
	%11 = load i32, i32* %4
	%12 = load i32*, i32** @b
	%13 = getelementptr inbounds i32, i32* %12, i32 %11
	%14 = load i32, i32* %13
	%15 = icmp eq i32 %14, 1
	%16 = icmp ne i1 %15, 0
	br i1 %16, label %17, label %36
17:
	%18 = load i32*, i32** @tmp
	%19 = getelementptr inbounds i32, i32* %18, i32 0
	%20 = load i32*, i32** @tmp
	%21 = getelementptr inbounds i32, i32* %20, i32 0
	%22 = load i32, i32* %21
	%23 = add i32 %22, 1
	store i32 %23, i32* %19
	%24 = load i32*, i32** @tmp
	%25 = getelementptr inbounds i32, i32* %24, i32 0
	%26 = load i32, i32* %25
	%27 = load i32*, i32** @prime
	%28 = getelementptr inbounds i32, i32* %27, i32 %26
	%29 = load i32, i32* %4
	store i32 %29, i32* %28
	%30 = load i32, i32* %4
	%31 = load i32*, i32** @gps
	%32 = getelementptr inbounds i32, i32* %31, i32 %30
	%33 = load i32*, i32** @tmp
	%34 = getelementptr inbounds i32, i32* %33, i32 0
	%35 = load i32, i32* %34
	store i32 %35, i32* %32
	br label %36
36:
	br label %37
37:
	%38 = load i32, i32* %4
	%39 = load i32, i32* %3
	%40 = mul i32 %38, %39
	%41 = load i32, i32* %2
	%42 = icmp sle i32 %40, %41
	%43 = icmp ne i1 %42, 0
	br i1 %43, label %44, label %52
44:
	%45 = load i32, i32* %4
	%46 = load i32, i32* %3
	%47 = mul i32 %45, %46
	%48 = load i32*, i32** @b
	%49 = getelementptr inbounds i32, i32* %48, i32 %47
	store i32 0, i32* %49
	%50 = load i32, i32* %3
	%51 = add i32 %50, 1
	store i32 %51, i32* %3
	br label %37
52:
	store i32 2, i32* %3
	br label %53
53:
	%54 = load i32, i32* %4
	%55 = add i32 %54, 1
	store i32 %55, i32* %4
	br label %5
56:
	ret void
}

define dso_local i32 @getResult(i32 %0, i32 %1, i32 %2){
	%4 = alloca i32
	store i32 %0, i32* %4
	%5 = alloca i32
	store i32 %1, i32* %5
	%6 = alloca i32
	store i32 %2, i32* %6
	%7 = load i32, i32* %5
	%8 = load i32**, i32*** @result
	%9 = getelementptr inbounds i32*, i32** %8, i32 %7
	%10 = load i32, i32* %6
	%11 = load i32*, i32** %9
	%12 = getelementptr inbounds i32, i32* %11, i32 %10
	%13 = load i32, i32* %12
	%14 = icmp eq i32 %13, -1
	%15 = icmp ne i1 %14, 0
	br i1 %15, label %16, label %72
16:
	%17 = load i32, i32* %6
	%18 = load i32*, i32** @prime
	%19 = getelementptr inbounds i32, i32* %18, i32 %17
	%20 = load i32, i32* %19
	%21 = mul i32 %20, 2
	%22 = load i32, i32* %5
	%23 = load i32*, i32** @prime
	%24 = getelementptr inbounds i32, i32* %23, i32 %22
	%25 = load i32, i32* %24
	%26 = sub i32 %21, %25
	%27 = load i32, i32* %4
	%28 = icmp sle i32 %26, %27
	%29 = icmp ne i1 %28, 0
	br i1 %29, label %30, label %71
30:
	%31 = load i32, i32* %6
	%32 = load i32*, i32** @prime
	%33 = getelementptr inbounds i32, i32* %32, i32 %31
	%34 = load i32, i32* %33
	%35 = mul i32 %34, 2
	%36 = load i32, i32* %5
	%37 = load i32*, i32** @prime
	%38 = getelementptr inbounds i32, i32* %37, i32 %36
	%39 = load i32, i32* %38
	%40 = sub i32 %35, %39
	%41 = load i32*, i32** @b
	%42 = getelementptr inbounds i32, i32* %41, i32 %40
	%43 = load i32, i32* %42
	%44 = icmp ne i32 %43, 0
	%45 = icmp ne i1 %44, 0
	br i1 %45, label %46, label %70
46:
	%47 = load i32, i32* %5
	%48 = load i32**, i32*** @result
	%49 = getelementptr inbounds i32*, i32** %48, i32 %47
	%50 = load i32, i32* %6
	%51 = load i32*, i32** %49
	%52 = getelementptr inbounds i32, i32* %51, i32 %50
	%53 = load i32, i32* %4
	%54 = load i32, i32* %6
	%55 = load i32, i32* %6
	%56 = load i32*, i32** @prime
	%57 = getelementptr inbounds i32, i32* %56, i32 %55
	%58 = load i32, i32* %57
	%59 = mul i32 %58, 2
	%60 = load i32, i32* %5
	%61 = load i32*, i32** @prime
	%62 = getelementptr inbounds i32, i32* %61, i32 %60
	%63 = load i32, i32* %62
	%64 = sub i32 %59, %63
	%65 = load i32*, i32** @gps
	%66 = getelementptr inbounds i32, i32* %65, i32 %64
	%67 = load i32, i32* %66
	%68 = call i32 @getResult(i32 %53, i32 %54, i32 %67)
	%69 = add i32 %68, 1
	store i32 %69, i32* %52
	br label %70
70:
	br label %71
71:
	br label %72
72:
	%73 = load i32, i32* %5
	%74 = load i32**, i32*** @result
	%75 = getelementptr inbounds i32*, i32** %74, i32 %73
	%76 = load i32, i32* %6
	%77 = load i32*, i32** %75
	%78 = getelementptr inbounds i32, i32* %77, i32 %76
	%79 = load i32, i32* %78
	%80 = icmp eq i32 %79, -1
	%81 = icmp ne i1 %80, 0
	br i1 %81, label %82, label %89
82:
	%83 = load i32, i32* %5
	%84 = load i32**, i32*** @result
	%85 = getelementptr inbounds i32*, i32** %84, i32 %83
	%86 = load i32, i32* %6
	%87 = load i32*, i32** %85
	%88 = getelementptr inbounds i32, i32* %87, i32 %86
	store i32 1, i32* %88
	br label %89
89:
	%90 = load i32, i32* %5
	%91 = load i32**, i32*** @result
	%92 = getelementptr inbounds i32*, i32** %91, i32 %90
	%93 = load i32, i32* %6
	%94 = load i32*, i32** %92
	%95 = getelementptr inbounds i32, i32* %94, i32 %93
	%96 = load i32, i32* %95
	ret i32 %96
}

define dso_local void @printF(i32 %0, i32 %1, i32 %2){
	%4 = alloca i32
	store i32 %0, i32* %4
	%5 = alloca i32
	store i32 %1, i32* %5
	%6 = alloca i32
	store i32 %2, i32* %6
	%7 = load i32, i32* %4
	%8 = call i8* @toString(i32 %7)
	call void @print(i8* %8)
	br label %9
9:
	%10 = load i32, i32* %6
	%11 = icmp sgt i32 %10, 0
	%12 = icmp ne i1 %11, 0
	br i1 %12, label %13, label %27
13:
	%14 = bitcast [2 x i8]* @.str.0 to i8*
	call void @print(i8* %14)
	%15 = load i32, i32* %5
	%16 = call i8* @toString(i32 %15)
	call void @print(i8* %16)
	%17 = load i32, i32* %5
	%18 = mul i32 %17, 2
	%19 = load i32, i32* %4
	%20 = sub i32 %18, %19
	store i32 %20, i32* %5
	%21 = load i32, i32* %4
	%22 = load i32, i32* %5
	%23 = add i32 %21, %22
	%24 = sdiv i32 %23, 2
	store i32 %24, i32* %4
	%25 = load i32, i32* %6
	%26 = sub i32 %25, 1
	store i32 %26, i32* %6
	br label %9
27:
	%28 = bitcast [2 x i8]* @.str.1 to i8*
	call void @print(i8* %28)
	ret void
}

define dso_local i32 @main(){
	call void @origin(i32 170)
	store i32 1000, i32* @N
	%1 = call i32 @getInt()
	store i32 %1, i32* @M
	store i32 0, i32* @primeCount
	store i32 0, i32* @resultCount
	%2 = load i32*, i32** @tmp
	%3 = getelementptr inbounds i32, i32* %2, i32 0
	store i32 0, i32* %3
	store i32 0, i32* @i
	br label %4
4:
	%5 = load i32, i32* @N
	%6 = add i32 %5, 1
	%7 = load i32, i32* @i
	%8 = icmp slt i32 %7, %6
	%9 = icmp ne i1 %8, 0
	br i1 %9, label %10, label %20
10:
	%11 = load i32, i32* @i
	%12 = load i32*, i32** @b
	%13 = getelementptr inbounds i32, i32* %12, i32 %11
	store i32 1, i32* %13
	%14 = load i32, i32* @i
	%15 = load i32*, i32** @gps
	%16 = getelementptr inbounds i32, i32* %15, i32 %14
	store i32 0, i32* %16
	br label %17
17:
	%18 = load i32, i32* @i
	%19 = add i32 %18, 1
	store i32 %19, i32* @i
	br label %4
20:
	store i32 0, i32* @i
	br label %21
21:
	%22 = load i32, i32* @M
	%23 = add i32 %22, 1
	%24 = load i32, i32* @i
	%25 = icmp slt i32 %24, %23
	%26 = icmp ne i1 %25, 0
	br i1 %26, label %27, label %34
27:
	%28 = load i32, i32* @i
	%29 = load i32*, i32** @prime
	%30 = getelementptr inbounds i32, i32* %29, i32 %28
	store i32 0, i32* %30
	br label %31
31:
	%32 = load i32, i32* @i
	%33 = add i32 %32, 1
	store i32 %33, i32* @i
	br label %21
34:
	store i32 0, i32* @i
	br label %35
35:
	%36 = load i32, i32* @i
	%37 = load i32, i32* @M
	%38 = icmp sle i32 %36, %37
	%39 = icmp ne i1 %38, 0
	br i1 %39, label %40, label %60
40:
	store i32 0, i32* @j
	br label %41
41:
	%42 = load i32, i32* @j
	%43 = load i32, i32* @M
	%44 = icmp sle i32 %42, %43
	%45 = icmp ne i1 %44, 0
	br i1 %45, label %46, label %56
46:
	%47 = load i32, i32* @i
	%48 = load i32**, i32*** @result
	%49 = getelementptr inbounds i32*, i32** %48, i32 %47
	%50 = load i32, i32* @j
	%51 = load i32*, i32** %49
	%52 = getelementptr inbounds i32, i32* %51, i32 %50
	store i32 -1, i32* %52
	br label %53
53:
	%54 = load i32, i32* @j
	%55 = add i32 %54, 1
	store i32 %55, i32* @j
	br label %41
56:
	br label %57
57:
	%58 = load i32, i32* @i
	%59 = add i32 %58, 1
	store i32 %59, i32* @i
	br label %35
60:
	%61 = load i32, i32* @N
	call void @getPrime(i32 %61)
	%62 = load i32*, i32** @tmp
	%63 = getelementptr inbounds i32, i32* %62, i32 0
	%64 = load i32, i32* %63
	store i32 %64, i32* @primeCount
	store i32 1, i32* @i
	br label %65
65:
	%66 = load i32, i32* @i
	%67 = load i32, i32* @primeCount
	%68 = icmp slt i32 %66, %67
	%69 = icmp ne i1 %68, 0
	br i1 %69, label %70, label %135
70:
	%71 = load i32, i32* @i
	%72 = add i32 %71, 1
	store i32 %72, i32* @j
	br label %73
73:
	%74 = load i32, i32* @j
	%75 = load i32, i32* @primeCount
	%76 = icmp sle i32 %74, %75
	%77 = icmp ne i1 %76, 0
	br i1 %77, label %78, label %131
78:
	%79 = load i32, i32* @i
	%80 = load i32**, i32*** @result
	%81 = getelementptr inbounds i32*, i32** %80, i32 %79
	%82 = load i32, i32* @j
	%83 = load i32*, i32** %81
	%84 = getelementptr inbounds i32, i32* %83, i32 %82
	%85 = load i32, i32* %84
	%86 = icmp eq i32 %85, -1
	%87 = icmp ne i1 %86, 0
	br i1 %87, label %88, label %127
88:
	%89 = load i32, i32* @i
	%90 = load i32**, i32*** @result
	%91 = getelementptr inbounds i32*, i32** %90, i32 %89
	%92 = load i32, i32* @j
	%93 = load i32*, i32** %91
	%94 = getelementptr inbounds i32, i32* %93, i32 %92
	%95 = load i32, i32* @N
	%96 = load i32, i32* @i
	%97 = load i32, i32* @j
	%98 = call i32 @getResult(i32 %95, i32 %96, i32 %97)
	store i32 %98, i32* %94
	%99 = load i32, i32* @i
	%100 = load i32**, i32*** @result
	%101 = getelementptr inbounds i32*, i32** %100, i32 %99
	%102 = load i32, i32* @j
	%103 = load i32*, i32** %101
	%104 = getelementptr inbounds i32, i32* %103, i32 %102
	%105 = load i32, i32* %104
	%106 = icmp sgt i32 %105, 1
	%107 = icmp ne i1 %106, 0
	br i1 %107, label %108, label %126
108:
	%109 = load i32, i32* @i
	%110 = load i32*, i32** @prime
	%111 = getelementptr inbounds i32, i32* %110, i32 %109
	%112 = load i32, i32* %111
	%113 = load i32, i32* @j
	%114 = load i32*, i32** @prime
	%115 = getelementptr inbounds i32, i32* %114, i32 %113
	%116 = load i32, i32* %115
	%117 = load i32, i32* @i
	%118 = load i32**, i32*** @result
	%119 = getelementptr inbounds i32*, i32** %118, i32 %117
	%120 = load i32, i32* @j
	%121 = load i32*, i32** %119
	%122 = getelementptr inbounds i32, i32* %121, i32 %120
	%123 = load i32, i32* %122
	call void @printF(i32 %112, i32 %116, i32 %123)
	%124 = load i32, i32* @resultCount
	%125 = add i32 %124, 1
	store i32 %125, i32* @resultCount
	br label %126
126:
	br label %127
127:
	br label %128
128:
	%129 = load i32, i32* @j
	%130 = add i32 %129, 1
	store i32 %130, i32* @j
	br label %73
131:
	br label %132
132:
	%133 = load i32, i32* @i
	%134 = add i32 %133, 1
	store i32 %134, i32* @i
	br label %65
135:
	%136 = bitcast [8 x i8]* @.str.2 to i8*
	call void @print(i8* %136)
	%137 = load i32, i32* @resultCount
	%138 = call i8* @toString(i32 %137)
	call void @println(i8* %138)
	ret i32 0
}

define dso_local void @global_var_init(){
	%1 = add i64 4004, 4
	%2 = call i8* @malloc(i64 %1)
	%3 = bitcast i8* %2 to i32*
	store i32 1001, i32* %3
	%4 = getelementptr inbounds i8, i8* %2, i64 4
	%5 = bitcast i8* %4 to i32*
	%6 = alloca i32*
	store i32* %5, i32** %6
	%7 = load i32*, i32** %6
	store i32* %7, i32** @b
	%8 = add i64 680, 4
	%9 = call i8* @malloc(i64 %8)
	%10 = bitcast i8* %9 to i32*
	store i32 170, i32* %10
	%11 = getelementptr inbounds i8, i8* %9, i64 4
	%12 = bitcast i8* %11 to i32*
	%13 = alloca i32*
	store i32* %12, i32** %13
	%14 = load i32*, i32** %13
	store i32* %14, i32** @prime
	%15 = add i64 4004, 4
	%16 = call i8* @malloc(i64 %15)
	%17 = bitcast i8* %16 to i32*
	store i32 1001, i32* %17
	%18 = getelementptr inbounds i8, i8* %16, i64 4
	%19 = bitcast i8* %18 to i32*
	%20 = alloca i32*
	store i32* %19, i32** %20
	%21 = load i32*, i32** %20
	store i32* %21, i32** @gps
	%22 = add i64 4, 4
	%23 = call i8* @malloc(i64 %22)
	%24 = bitcast i8* %23 to i32*
	store i32 1, i32* %24
	%25 = getelementptr inbounds i8, i8* %23, i64 4
	%26 = bitcast i8* %25 to i32*
	%27 = alloca i32*
	store i32* %26, i32** %27
	%28 = load i32*, i32** %27
	store i32* %28, i32** @tmp
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
