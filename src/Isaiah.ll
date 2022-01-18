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
@r = global i32 0
@c = global i32 0
@i = global i32 0
@j = global i32 0

define i32 @abs(i32 %0){
	%2 = alloca i32
	store i32 %0, i32* %2
	%3 = load i32, i32* %2
	%4 = icmp sgt i32 %3, 0
	%5 = icmp ne i1 %4, 0
	br i1 %5, label %6, label %8
6:
	%7 = load i32, i32* %2
	ret i32 %7
8:
	%9 = load i32, i32* %2
	%10 = sub i32 0, %9
	ret i32 %10
}

define i32 @main(){
	call void @global_var_init()
	store i32 0, i32* @i
	br label %1
1:
	%2 = load i32, i32* @i
	%3 = icmp slt i32 %2, 5
	%4 = icmp ne i1 %3, 0
	br i1 %4, label %5, label %26
5:
	store i32 0, i32* @j
	br label %6
6:
	%7 = load i32, i32* @j
	%8 = icmp slt i32 %7, 5
	%9 = icmp ne i1 %8, 0
	br i1 %9, label %10, label %22
10:
	%11 = call i32 @getInt()
	store i32 %11, i32* @n
	%12 = load i32, i32* @n
	%13 = icmp eq i32 %12, 1
	%14 = icmp ne i1 %13, 0
	br i1 %14, label %15, label %18
15:
	%16 = load i32, i32* @i
	store i32 %16, i32* @r
	%17 = load i32, i32* @j
	store i32 %17, i32* @c
	br label %18
18:
	br label %19
19:
	%20 = load i32, i32* @j
	%21 = add i32 %20, 1
	store i32 %21, i32* @j
	br label %6
22:
	br label %23
23:
	%24 = load i32, i32* @i
	%25 = add i32 %24, 1
	store i32 %25, i32* @i
	br label %1
26:
	%27 = load i32, i32* @r
	%28 = sub i32 2, %27
	%29 = call i32 @abs(i32 %28)
	%30 = load i32, i32* @c
	%31 = sub i32 2, %30
	%32 = call i32 @abs(i32 %31)
	%33 = add i32 %29, %32
	call void @printInt(i32 %33)
	ret i32 0
}

define void @global_var_init(){
	ret void
}

