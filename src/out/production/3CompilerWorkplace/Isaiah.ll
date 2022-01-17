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

@.str.0 = constant [20 x i8] c"Hello, Wenrui Han!\0A\00"

define i32 @main(){
	call void @global_var_init()
	%1 = bitcast [20 x i8]* @.str.0 to i8*
	call void @print(i8* %1)
	ret i32 0
}

define void @global_var_init(){
	ret void
}

