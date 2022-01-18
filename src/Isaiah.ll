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

@N = global i32 0
@M = global i32 0
@check = global i1* null

define i32 @main(){
	call void @global_var_init()
	%1 = call i32 @getInt()
	store i32 %1, i32* @N
	%2 = load i32, i32* @N
	%3 = add i32 %2, 5
	%4 = mul i32 %3, 1
	%5 = add i32 %4, 4
	%6 = call i8* @malloc(i32 %5)
	%7 = bitcast i8* %6 to i32*
	store i32 %3, i32* %7
	%8 = getelementptr inbounds i8, i8* %6, i32 4
	%9 = bitcast i8* %8 to i1*
	%10 = alloca i1*
	store i1* %9, i1** %10
	%11 = load i1*, i1** %10
	store i1* %11, i1** @check
	%12 = alloca i32
	store i32 0, i32* %12
	br label %13
13:
	%14 = load i32, i32* %12
	%15 = load i32, i32* @N
	%16 = icmp sle i32 %14, %15
	%17 = icmp ne i1 %16, 0
	br i1 %17, label %18, label %23
18:
	%19 = load i32, i32* %12
	%20 = add i32 %19, 1
	store i32 %20, i32* %12
	%21 = load i1*, i1** @check
	%22 = getelementptr inbounds i1, i1* %21, i32 %19
	store i1 true, i1* %22
	br label %13
23:
	%24 = load i32, i32* @N
	%25 = add i32 %24, 5
	%26 = mul i32 %25, 4
	%27 = add i32 %26, 4
	%28 = call i8* @malloc(i32 %27)
	%29 = bitcast i8* %28 to i32*
	store i32 %25, i32* %29
	%30 = getelementptr inbounds i8, i8* %28, i32 4
	%31 = bitcast i8* %30 to i32*
	%32 = alloca i32*
	store i32* %31, i32** %32
	%33 = load i32*, i32** %32
	%34 = alloca i32*
	store i32* %33, i32** %34
	%35 = load i32, i32* @N
	%36 = add i32 %35, 5
	%37 = mul i32 %36, 4
	%38 = add i32 %37, 4
	%39 = call i8* @malloc(i32 %38)
	%40 = bitcast i8* %39 to i32*
	store i32 %36, i32* %40
	%41 = getelementptr inbounds i8, i8* %39, i32 4
	%42 = bitcast i8* %41 to i32*
	%43 = alloca i32*
	store i32* %42, i32** %43
	%44 = load i32*, i32** %43
	%45 = alloca i32*
	store i32* %44, i32** %45
	%46 = load i32*, i32** %34
	%47 = getelementptr inbounds i32, i32* %46, i32 1
	store i32 1, i32* %47
	store i32 2, i32* %12
	br label %48
48:
	br label %49
49:
	%50 = load i32, i32* %12
	%51 = load i32, i32* @N
	%52 = icmp sgt i32 %50, %51
	%53 = icmp ne i1 %52, 0
	br i1 %53, label %54, label %55
54:
	br label %165
55:
	%56 = load i32, i32* %12
	%57 = load i1*, i1** @check
	%58 = getelementptr inbounds i1, i1* %57, i32 %56
	%59 = load i1, i1* %58
	%60 = icmp ne i1 %59, 0
	br i1 %60, label %61, label %73
61:
	%62 = load i32, i32* @M
	%63 = add i32 %62, 1
	store i32 %63, i32* @M
	%64 = load i32, i32* @M
	%65 = load i32*, i32** %45
	%66 = getelementptr inbounds i32, i32* %65, i32 %64
	%67 = load i32, i32* %12
	store i32 %67, i32* %66
	%68 = load i32, i32* %12
	%69 = load i32*, i32** %34
	%70 = getelementptr inbounds i32, i32* %69, i32 %68
	%71 = load i32, i32* %12
	%72 = sub i32 %71, 1
	store i32 %72, i32* %70
	br label %73
73:
	%74 = load i32, i32* %12
	%75 = alloca i32
	store i32 %74, i32* %75
	%76 = alloca i32
	store i32 1, i32* %76
	br label %77
77:
	%78 = load i32, i32* %76
	%79 = load i32, i32* @M
	%80 = icmp sle i32 %78, %79
	%81 = icmp ne i1 %80, false
	br i1 %81, label %82, label %92
82:
	%83 = load i32, i32* %76
	%84 = load i32*, i32** %45
	%85 = getelementptr inbounds i32, i32* %84, i32 %83
	%86 = load i32, i32* %75
	%87 = load i32, i32* %85
	%88 = mul i32 %86, %87
	%89 = load i32, i32* @N
	%90 = icmp sle i32 %88, %89
	%91 = icmp ne i1 %90, false
	br label %92
92:
	%93 = phi i1 [ false, %77 ], [ %91, %82 ]
	%94 = icmp ne i1 %93, 0
	br i1 %94, label %95, label %156
95:
	%96 = load i32, i32* %76
	%97 = load i32*, i32** %45
	%98 = getelementptr inbounds i32, i32* %97, i32 %96
	%99 = load i32, i32* %75
	%100 = load i32, i32* %98
	%101 = mul i32 %99, %100
	%102 = alloca i32
	store i32 %101, i32* %102
	%103 = load i32, i32* %102
	%104 = load i32, i32* @N
	%105 = icmp sgt i32 %103, %104
	%106 = icmp ne i1 %105, 0
	br i1 %106, label %107, label %108
107:
	br label %153
108:
	%109 = load i32, i32* %102
	%110 = load i1*, i1** @check
	%111 = getelementptr inbounds i1, i1* %110, i32 %109
	store i1 false, i1* %111
	%112 = load i32, i32* %76
	%113 = load i32*, i32** %45
	%114 = getelementptr inbounds i32, i32* %113, i32 %112
	%115 = load i32, i32* %75
	%116 = load i32, i32* %114
	%117 = srem i32 %115, %116
	%118 = icmp eq i32 %117, 0
	%119 = icmp ne i1 %118, 0
	br i1 %119, label %120, label %133
120:
	%121 = load i32, i32* %102
	%122 = load i32*, i32** %34
	%123 = getelementptr inbounds i32, i32* %122, i32 %121
	%124 = load i32, i32* %75
	%125 = load i32*, i32** %34
	%126 = getelementptr inbounds i32, i32* %125, i32 %124
	%127 = load i32, i32* %76
	%128 = load i32*, i32** %45
	%129 = getelementptr inbounds i32, i32* %128, i32 %127
	%130 = load i32, i32* %126
	%131 = load i32, i32* %129
	%132 = mul i32 %130, %131
	store i32 %132, i32* %123
	br label %156
133:
	%134 = load i32, i32* %76
	%135 = load i32*, i32** %45
	%136 = getelementptr inbounds i32, i32* %135, i32 %134
	%137 = load i32, i32* %75
	%138 = load i32, i32* %136
	%139 = mul i32 %137, %138
	%140 = load i32*, i32** %34
	%141 = getelementptr inbounds i32, i32* %140, i32 %139
	%142 = load i32, i32* %75
	%143 = load i32*, i32** %34
	%144 = getelementptr inbounds i32, i32* %143, i32 %142
	%145 = load i32, i32* %76
	%146 = load i32*, i32** %45
	%147 = getelementptr inbounds i32, i32* %146, i32 %145
	%148 = load i32, i32* %147
	%149 = sub i32 %148, 1
	%150 = load i32, i32* %144
	%151 = mul i32 %150, %149
	store i32 %151, i32* %141
	br label %152
152:
	br label %153
153:
	%154 = load i32, i32* %76
	%155 = add i32 %154, 1
	store i32 %155, i32* %76
	br label %77
156:
	%157 = load i32, i32* %75
	%158 = load i32*, i32** %34
	%159 = getelementptr inbounds i32, i32* %158, i32 %157
	%160 = load i32, i32* %159
	%161 = call i8* @toString(i32 %160)
	call void @println(i8* %161)
	br label %162
162:
	%163 = load i32, i32* %12
	%164 = add i32 %163, 1
	store i32 %164, i32* %12
	br label %48
165:
	ret i32 0
}

define void @global_var_init(){
	store i32 0, i32* @M
	ret void
}

