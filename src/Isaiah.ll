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

@x = global i8* null
@y = global i8* null
@m = global i32 0
@test = global %a* null
@pp = global i1 false
@.str.0 = constant [1 x i8] c"\00"
@.str.1 = constant [8 x i8] c"justice\00"

%a = type { i32 }

define i32 @main(){
	call void @global_var_init()
	ret i32 0
}

define void @global_var_init(){
	%1 = bitcast [1 x i8]* @.str.0 to i8*
	store i8* %1, i8** @x
	%2 = bitcast [8 x i8]* @.str.1 to i8*
	store i8* %2, i8** @y
	store i32 0, i32* @m
	ret void
}

define void @a(%a* %0){
	%2 = alloca %a*
	store %a* %0, %a** %2
	ret void
}

