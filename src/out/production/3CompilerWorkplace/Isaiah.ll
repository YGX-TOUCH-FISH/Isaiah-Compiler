declare i8* @malloc(i64)
declare i8* @__built_in_string_add(i8*, i8*)
declare i1 @__built_in_string_less_than(i8*, i8*)
declare i1 @__built_in_string_greater_than(i8*, i8*)
declare i1 @__built_in_string_less_equal(i8*, i8*)
declare i1 @__built_in_string_greater_equal(i8*, i8*)
declare i1 @__built_in_string_equal(i8*, i8*)
declare i1 @__built_in_string_not_equal(i8*, i8*)
declare i32 @__built_in_string_length(i8*)
declare i8* @__built_in_string_substring(i8*, i32, i32)
declare i32 @__built_in_string_parseInt(i8*)
declare i32 @__built_in_string_ord(i8*, i32)
declare i32 @__built_in_array_size(i8*)
declare void @print(i8*)
declare void @println(i8*)
declare void @printInt(i32)
declare void @printlnInt(i32)
declare i8* @getString()
declare i32 @getInt()
declare i8* @toString(i32)

@a = global i32 0
@b = global i32 0
@c = global i32 0
@array = global i32* null
@d = global i8* null
@x = global %mm* null
@.str.0 = constant [7 x i8] c"branch\00"

%mm = type { i32, i32 }

define i32 @abs(i32 %0){
	%2 = alloca i32
	store i32 %0, i32* %2
	%3 = load i32, i32* %2
	%4 = add i32 %3, 1
	ret i32 %4
}

define i32 @main(){
	call void @global_var_init()
	%1 = alloca %mm*
	%2 = call i8* @malloc(i64 8)
	%3 = bitcast i8* %2 to %mm*
	call void @mm(%mm* %3)
	store %mm* %3, %mm** %1
	%4 = load %mm*, %mm** %1
	store %mm* %4, %mm** @x
	%5 = load %mm*, %mm** @x
	%6 = getelementptr inbounds %mm, %mm* %5, i32 0, i32 0
	%7 = load %mm*, %mm** @x
	%8 = getelementptr inbounds %mm, %mm* %7, i32 0, i32 1
	%9 = load i32, i32* %6
	%10 = load i32, i32* %8
	%11 = add i32 %9, %10
	ret i32 %11
}

define void @global_var_init(){
	store i32 1, i32* @b
	%1 = bitcast [7 x i8]* @.str.0 to i8*
	store i8* %1, i8** @d
	ret void
}

define void @mm(%mm* %0){
	%2 = alloca %mm*
	store %mm* %0, %mm** %2
	ret void
}

