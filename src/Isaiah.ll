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

@hashsize = global i32 0
@table = global %node** null
@.str.0 = constant [2 x i8] c" \00"

%node = type { i32, i32, %node* }

define i32 @getHash(i32 %0){
	%2 = alloca i32
	store i32 %0, i32* %2
	%3 = load i32, i32* %2
	%4 = mul i32 %3, 237
	%5 = load i32, i32* @hashsize
	%6 = srem i32 %4, %5
	ret i32 %6
}

define void @put(i32 %0, i32 %1){
	%3 = alloca i32
	store i32 %0, i32* %3
	%4 = alloca i32
	store i32 %1, i32* %4
	%5 = alloca i32
	%6 = alloca %node*
	store %node* null, %node** %6
	%7 = load i32, i32* %3
	%8 = call i32 @getHash(i32 %7)
	store i32 %8, i32* %5
	%9 = load i32, i32* %5
	%10 = load %node**, %node*** @table
	%11 = getelementptr inbounds %node*, %node** %10, i32 %9
	%12 = load %node*, %node** %11
	%13 = icmp eq %node* %12, null
	%14 = icmp ne i1 %13, 0
	br i1 %14, label %15, label %40
15:
	%16 = load i32, i32* %5
	%17 = load %node**, %node*** @table
	%18 = getelementptr inbounds %node*, %node** %17, i32 %16
	%19 = alloca %node*
	%20 = call i8* @malloc(i32 12)
	%21 = bitcast i8* %20 to %node*
	call void @node(%node* %21)
	store %node* %21, %node** %19
	%22 = load %node*, %node** %19
	store %node* %22, %node** %18
	%23 = load i32, i32* %5
	%24 = load %node**, %node*** @table
	%25 = getelementptr inbounds %node*, %node** %24, i32 %23
	%26 = load %node*, %node** %25
	%27 = getelementptr inbounds %node, %node* %26, i32 0, i32 0
	%28 = load i32, i32* %3
	store i32 %28, i32* %27
	%29 = load i32, i32* %5
	%30 = load %node**, %node*** @table
	%31 = getelementptr inbounds %node*, %node** %30, i32 %29
	%32 = load %node*, %node** %31
	%33 = getelementptr inbounds %node, %node* %32, i32 0, i32 1
	%34 = load i32, i32* %4
	store i32 %34, i32* %33
	%35 = load i32, i32* %5
	%36 = load %node**, %node*** @table
	%37 = getelementptr inbounds %node*, %node** %36, i32 %35
	%38 = load %node*, %node** %37
	%39 = getelementptr inbounds %node, %node* %38, i32 0, i32 2
	store %node* null, %node** %39
	ret void
40:
	%41 = load i32, i32* %5
	%42 = load %node**, %node*** @table
	%43 = getelementptr inbounds %node*, %node** %42, i32 %41
	%44 = load %node*, %node** %43
	store %node* %44, %node** %6
	br label %45
45:
	%46 = load %node*, %node** %6
	%47 = getelementptr inbounds %node, %node* %46, i32 0, i32 0
	%48 = load i32, i32* %47
	%49 = load i32, i32* %3
	%50 = icmp ne i32 %48, %49
	%51 = icmp ne i1 %50, 0
	br i1 %51, label %52, label %78
52:
	%53 = load %node*, %node** %6
	%54 = getelementptr inbounds %node, %node* %53, i32 0, i32 2
	%55 = load %node*, %node** %54
	%56 = icmp eq %node* %55, null
	%57 = icmp ne i1 %56, 0
	br i1 %57, label %58, label %74
58:
	%59 = load %node*, %node** %6
	%60 = getelementptr inbounds %node, %node* %59, i32 0, i32 2
	%61 = alloca %node*
	%62 = call i8* @malloc(i32 12)
	%63 = bitcast i8* %62 to %node*
	call void @node(%node* %63)
	store %node* %63, %node** %61
	%64 = load %node*, %node** %61
	store %node* %64, %node** %60
	%65 = load %node*, %node** %6
	%66 = getelementptr inbounds %node, %node* %65, i32 0, i32 2
	%67 = load %node*, %node** %66
	%68 = getelementptr inbounds %node, %node* %67, i32 0, i32 0
	%69 = load i32, i32* %3
	store i32 %69, i32* %68
	%70 = load %node*, %node** %6
	%71 = getelementptr inbounds %node, %node* %70, i32 0, i32 2
	%72 = load %node*, %node** %71
	%73 = getelementptr inbounds %node, %node* %72, i32 0, i32 2
	store %node* null, %node** %73
	br label %74
74:
	%75 = load %node*, %node** %6
	%76 = getelementptr inbounds %node, %node* %75, i32 0, i32 2
	%77 = load %node*, %node** %76
	store %node* %77, %node** %6
	br label %45
78:
	%79 = load %node*, %node** %6
	%80 = getelementptr inbounds %node, %node* %79, i32 0, i32 1
	%81 = load i32, i32* %4
	store i32 %81, i32* %80
	ret void
}

define i32 @get(i32 %0){
	%2 = alloca i32
	store i32 %0, i32* %2
	%3 = alloca %node*
	store %node* null, %node** %3
	%4 = load i32, i32* %2
	%5 = call i32 @getHash(i32 %4)
	%6 = load %node**, %node*** @table
	%7 = getelementptr inbounds %node*, %node** %6, i32 %5
	%8 = load %node*, %node** %7
	store %node* %8, %node** %3
	br label %9
9:
	%10 = load %node*, %node** %3
	%11 = getelementptr inbounds %node, %node* %10, i32 0, i32 0
	%12 = load i32, i32* %11
	%13 = load i32, i32* %2
	%14 = icmp ne i32 %12, %13
	%15 = icmp ne i1 %14, 0
	br i1 %15, label %16, label %20
16:
	%17 = load %node*, %node** %3
	%18 = getelementptr inbounds %node, %node* %17, i32 0, i32 2
	%19 = load %node*, %node** %18
	store %node* %19, %node** %3
	br label %9
20:
	%21 = load %node*, %node** %3
	%22 = getelementptr inbounds %node, %node* %21, i32 0, i32 1
	%23 = load i32, i32* %22
	ret i32 %23
}

define i32 @main(){
	call void @global_var_init()
	%1 = alloca i32
	%2 = add i32 400, 4
	%3 = call i8* @malloc(i32 %2)
	%4 = bitcast i8* %3 to i32*
	store i32 100, i32* %4
	%5 = getelementptr inbounds i8, i8* %3, i32 4
	%6 = bitcast i8* %5 to %node**
	%7 = alloca %node**
	store %node** %6, %node*** %7
	%8 = load %node**, %node*** %7
	store %node** %8, %node*** @table
	store i32 0, i32* %1
	br label %9
9:
	%10 = load i32, i32* %1
	%11 = load i32, i32* @hashsize
	%12 = icmp slt i32 %10, %11
	%13 = icmp ne i1 %12, 0
	br i1 %13, label %14, label %21
14:
	%15 = load i32, i32* %1
	%16 = load %node**, %node*** @table
	%17 = getelementptr inbounds %node*, %node** %16, i32 %15
	store %node* null, %node** %17
	br label %18
18:
	%19 = load i32, i32* %1
	%20 = add i32 %19, 1
	store i32 %20, i32* %1
	br label %9
21:
	store i32 0, i32* %1
	br label %22
22:
	%23 = load i32, i32* %1
	%24 = icmp slt i32 %23, 1000
	%25 = icmp ne i1 %24, 0
	br i1 %25, label %26, label %32
26:
	%27 = load i32, i32* %1
	%28 = load i32, i32* %1
	call void @put(i32 %27, i32 %28)
	br label %29
29:
	%30 = load i32, i32* %1
	%31 = add i32 %30, 1
	store i32 %31, i32* %1
	br label %22
32:
	store i32 0, i32* %1
	br label %33
33:
	%34 = load i32, i32* %1
	%35 = icmp slt i32 %34, 1000
	%36 = icmp ne i1 %35, 0
	br i1 %36, label %37, label %49
37:
	%38 = load i32, i32* %1
	%39 = call i8* @toString(i32 %38)
	%40 = bitcast [2 x i8]* @.str.0 to i8*
	%41 = call i8* @string_add(i8* %39, i8* %40)
	%42 = load i32, i32* %1
	%43 = call i32 @get(i32 %42)
	%44 = call i8* @toString(i32 %43)
	%45 = call i8* @string_add(i8* %41, i8* %44)
	call void @println(i8* %45)
	br label %46
46:
	%47 = load i32, i32* %1
	%48 = add i32 %47, 1
	store i32 %48, i32* %1
	br label %33
49:
	ret i32 0
}

define void @global_var_init(){
	store i32 100, i32* @hashsize
	ret void
}

define void @node(%node* %0){
	%2 = alloca %node*
	store %node* %0, %node** %2
	ret void
}

