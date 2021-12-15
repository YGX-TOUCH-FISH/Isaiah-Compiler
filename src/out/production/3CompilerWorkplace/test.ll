@p = dso_local global i32 0
@q = dso_local global i32 0
@r = dso_local global i32 0

define dso_local i32 @main(){
	%1 = alloca i32***
	%2 = load i32, i32* @p
	%3 = zext i32 %2 to i64
	%4 = load i32, i32* @q
	%5 = zext i32 %4 to i64
	%6 = mul i64 %3, 8
	%7 = call i8* @malloc(i64 %6)
	%8 = bitcast i8* %7 to i32***
	%9 = alloca i32
	store i32 0, i32* %9
	br label %10
10:
	%11 = load i32, i32* %9
	%12 = zext i32 %11 to i64
	%13 = icmp slt i64 %12, %3
	br i1 %13, label %14, label %22
14:
	%15 = mul i64 %5, 8
	%16 = call i8* @malloc(i64 %15)
	%17 = bitcast i8* %16 to i32**
	%18 = getelementptr inbounds i32**, i32*** %8, i32 %11
	store i32** %17, i32*** %18
	br label %19
19:
	%20 = load i32, i32* %9
	%21 = add i32 %11, 1
	store i32 %21, i32* %9
	br label %10
22:
	%23 = alloca i32***
	store i32*** %8, i32**** %23
	%24 = load i32***, i32**** %23
	store i32*** %24, i32**** %1
	%25 = load i32***, i32**** %1
	%26 = getelementptr inbounds i32**, i32*** %25, i32 1
	%27 = load i32**, i32*** %26
	%28 = getelementptr inbounds i32*, i32** %27, i32 2
	%29 = load i32, i32* @r
	%30 = zext i32 %29 to i64
	%31 = mul i64 %30, 4
	%32 = call i8* @malloc(i64 %31)
	%33 = bitcast i8* %32 to i32*
	%34 = alloca i32*
	store i32* %33, i32** %34
	%35 = load i32*, i32** %34
	store i32* %35, i32** %28
	%36 = alloca i32
	store i32 0, i32* %36
	br label %37
37:
	%38 = load i32, i32* %36
	%39 = load i32, i32* @r
	%40 = icmp slt i32 %38, %39
	%41 = icmp ne i1 %40, 0
	br i1 %41, label %42, label %54
42:
	%43 = load i32***, i32**** %1
	%44 = getelementptr inbounds i32**, i32*** %43, i32 1
	%45 = load i32**, i32*** %44
	%46 = getelementptr inbounds i32*, i32** %45, i32 2
	%47 = load i32, i32* %36
	%48 = load i32*, i32** %46
	%49 = getelementptr inbounds i32, i32* %48, i32 %47
	%50 = load i32, i32* %36
	store i32 %50, i32* %49
	br label %51
51:
	%52 = load i32, i32* %36
	%53 = add i32 %52, 1
	store i32 %53, i32* %36
	br label %37
54:
	%55 = alloca i32
	store i32 0, i32* %55
	%56 = alloca i32
	%57 = load i32, i32* @r
	%58 = sub i32 %57, 1
	store i32 %58, i32* %56
	br label %59
59:
	%60 = load i32, i32* %56
	%61 = icmp sgt i32 %60, 0
	%62 = icmp ne i1 %61, 0
	br i1 %62, label %63, label %77
63:
	%64 = load i32***, i32**** %1
	%65 = getelementptr inbounds i32**, i32*** %64, i32 1
	%66 = load i32**, i32*** %65
	%67 = getelementptr inbounds i32*, i32** %66, i32 2
	%68 = load i32, i32* %56
	%69 = load i32*, i32** %67
	%70 = getelementptr inbounds i32, i32* %69, i32 %68
	%71 = load i32, i32* %55
	%72 = load i32, i32* %70
	%73 = add i32 %71, %72
	store i32 %73, i32* %55
	br label %74
74:
	%75 = load i32, i32* %56
	%76 = sub i32 %75, 1
	store i32 %76, i32* %56
	br label %59
77:
	%78 = load i32, i32* %55
	ret i32 %78
}

define dso_local void @global_var_init(){
	store i32 2, i32* @p
	store i32 3, i32* @q
	store i32 4, i32* @r
	ret void
}

declare dso_local i8* @malloc(i64)
