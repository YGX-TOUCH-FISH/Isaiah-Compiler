declare i8* @malloc(i32)
declare i8* @__built_in_string_add(i8*, i8*)
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


define i32 @main(){
	call void @global_var_init()
	%1 = add i32 12, 4
	%2 = call i8* @malloc(i32 %1)
	%3 = bitcast i8* %2 to i32*
	store i32 3, i32* %3
	%4 = getelementptr inbounds i8, i8* %2, i32 4
	%5 = bitcast i8* %4 to i32*
	%6 = alloca i32*
	store i32* %5, i32** %6
	%7 = load i32*, i32** %6
	%8 = alloca i32*
	store i32* %7, i32** %8
	%9 = load i32*, i32** %8
	%10 = bitcast i32* %9 to i8*
	%11 = call i32 @array_size(i8* %10)
	ret i32 %11
}

define void @global_var_init(){
	ret void
}

