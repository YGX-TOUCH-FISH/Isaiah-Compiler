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


define i32 @gcd(i32 %0, i32 %1, i32 %2, i32 %3, i32 %4, i32 %5, i32 %6, i32 %7, i32 %8, i32 %9, i32 %10, i32 %11, i32 %12, i32 %13, i32 %14, i32 %15, i32 %16, i32 %17, i32 %18, i32 %19, i32 %20, i32 %21, i32 %22, i32 %23, i32 %24, i32 %25, i32 %26, i32 %27, i32 %28, i32 %29, i32 %30, i32 %31){
	%33 = alloca i32
	store i32 %0, i32* %33
	%34 = alloca i32
	store i32 %1, i32* %34
	%35 = alloca i32
	store i32 %2, i32* %35
	%36 = alloca i32
	store i32 %3, i32* %36
	%37 = alloca i32
	store i32 %4, i32* %37
	%38 = alloca i32
	store i32 %5, i32* %38
	%39 = alloca i32
	store i32 %6, i32* %39
	%40 = alloca i32
	store i32 %7, i32* %40
	%41 = alloca i32
	store i32 %8, i32* %41
	%42 = alloca i32
	store i32 %9, i32* %42
	%43 = alloca i32
	store i32 %10, i32* %43
	%44 = alloca i32
	store i32 %11, i32* %44
	%45 = alloca i32
	store i32 %12, i32* %45
	%46 = alloca i32
	store i32 %13, i32* %46
	%47 = alloca i32
	store i32 %14, i32* %47
	%48 = alloca i32
	store i32 %15, i32* %48
	%49 = alloca i32
	store i32 %16, i32* %49
	%50 = alloca i32
	store i32 %17, i32* %50
	%51 = alloca i32
	store i32 %18, i32* %51
	%52 = alloca i32
	store i32 %19, i32* %52
	%53 = alloca i32
	store i32 %20, i32* %53
	%54 = alloca i32
	store i32 %21, i32* %54
	%55 = alloca i32
	store i32 %22, i32* %55
	%56 = alloca i32
	store i32 %23, i32* %56
	%57 = alloca i32
	store i32 %24, i32* %57
	%58 = alloca i32
	store i32 %25, i32* %58
	%59 = alloca i32
	store i32 %26, i32* %59
	%60 = alloca i32
	store i32 %27, i32* %60
	%61 = alloca i32
	store i32 %28, i32* %61
	%62 = alloca i32
	store i32 %29, i32* %62
	%63 = alloca i32
	store i32 %30, i32* %63
	%64 = alloca i32
	store i32 %31, i32* %64
	%65 = alloca i32
	%66 = alloca i32
	store i32 0, i32* %65
	br label %67
67:
	%68 = load i32, i32* %65
	%69 = icmp sle i32 %68, 10
	%70 = icmp ne i1 %69, 0
	br i1 %70, label %71, label %135
71:
	%72 = load i32, i32* %35
	%73 = load i32, i32* %36
	%74 = add i32 %72, %73
	%75 = load i32, i32* %37
	%76 = add i32 %74, %75
	%77 = load i32, i32* %38
	%78 = add i32 %76, %77
	%79 = load i32, i32* %39
	%80 = add i32 %78, %79
	%81 = load i32, i32* %40
	%82 = add i32 %80, %81
	%83 = load i32, i32* %41
	%84 = add i32 %82, %83
	%85 = load i32, i32* %42
	%86 = add i32 %84, %85
	%87 = load i32, i32* %43
	%88 = add i32 %86, %87
	%89 = load i32, i32* %44
	%90 = add i32 %88, %89
	%91 = load i32, i32* %45
	%92 = add i32 %90, %91
	%93 = load i32, i32* %46
	%94 = add i32 %92, %93
	%95 = load i32, i32* %47
	%96 = add i32 %94, %95
	%97 = load i32, i32* %48
	%98 = add i32 %96, %97
	%99 = load i32, i32* %49
	%100 = add i32 %98, %99
	%101 = load i32, i32* %50
	%102 = add i32 %100, %101
	%103 = load i32, i32* %51
	%104 = add i32 %102, %103
	%105 = load i32, i32* %52
	%106 = add i32 %104, %105
	%107 = load i32, i32* %53
	%108 = add i32 %106, %107
	%109 = load i32, i32* %54
	%110 = add i32 %108, %109
	%111 = load i32, i32* %55
	%112 = add i32 %110, %111
	%113 = load i32, i32* %56
	%114 = add i32 %112, %113
	%115 = load i32, i32* %57
	%116 = add i32 %114, %115
	%117 = load i32, i32* %58
	%118 = add i32 %116, %117
	%119 = load i32, i32* %59
	%120 = add i32 %118, %119
	%121 = load i32, i32* %60
	%122 = add i32 %120, %121
	%123 = load i32, i32* %61
	%124 = add i32 %122, %123
	%125 = load i32, i32* %62
	%126 = add i32 %124, %125
	%127 = load i32, i32* %63
	%128 = add i32 %126, %127
	%129 = load i32, i32* %64
	%130 = add i32 %128, %129
	%131 = srem i32 %130, 100
	store i32 %131, i32* %66
	br label %132
132:
	%133 = load i32, i32* %65
	%134 = add i32 %133, 1
	store i32 %134, i32* %65
	br label %67
135:
	%136 = load i32, i32* %33
	%137 = load i32, i32* %34
	%138 = srem i32 %136, %137
	%139 = icmp eq i32 %138, 0
	%140 = icmp ne i1 %139, 0
	br i1 %140, label %141, label %143
141:
	%142 = load i32, i32* %34
	ret i32 %142
143:
	%144 = load i32, i32* %34
	%145 = load i32, i32* %33
	%146 = load i32, i32* %34
	%147 = srem i32 %145, %146
	%148 = load i32, i32* %66
	%149 = call i32 @gcd(i32 10, i32 68, i32 0, i32 2, i32 4, i32 6, i32 8, i32 10, i32 12, i32 14, i32 16, i32 18, i32 20, i32 22, i32 24, i32 26, i32 28, i32 30, i32 32, i32 34, i32 36, i32 38, i32 40, i32 42, i32 44, i32 46, i32 48, i32 50, i32 52, i32 54, i32 56, i32 58)
	%150 = load i32, i32* %37
	%151 = load i32, i32* %38
	%152 = load i32, i32* %39
	%153 = load i32, i32* %40
	%154 = load i32, i32* %41
	%155 = load i32, i32* %42
	%156 = load i32, i32* %43
	%157 = load i32, i32* %44
	%158 = load i32, i32* %45
	%159 = load i32, i32* %46
	%160 = load i32, i32* %47
	%161 = load i32, i32* %48
	%162 = load i32, i32* %49
	%163 = load i32, i32* %50
	%164 = load i32, i32* %51
	%165 = load i32, i32* %52
	%166 = load i32, i32* %53
	%167 = load i32, i32* %54
	%168 = load i32, i32* %55
	%169 = load i32, i32* %56
	%170 = load i32, i32* %57
	%171 = load i32, i32* %58
	%172 = load i32, i32* %59
	%173 = load i32, i32* %60
	%174 = load i32, i32* %61
	%175 = load i32, i32* %62
	%176 = load i32, i32* %63
	%177 = load i32, i32* %64
	%178 = call i32 @gcd1(i32 %144, i32 %147, i32 %148, i32 %149, i32 %150, i32 %151, i32 %152, i32 %153, i32 %154, i32 %155, i32 %156, i32 %157, i32 %158, i32 %159, i32 %160, i32 %161, i32 %162, i32 %163, i32 %164, i32 %165, i32 %166, i32 %167, i32 %168, i32 %169, i32 %170, i32 %171, i32 %172, i32 %173, i32 %174, i32 %175, i32 %176, i32 %177)
	ret i32 %178
179:
	ret i32 0
}

define i32 @gcd1(i32 %0, i32 %1, i32 %2, i32 %3, i32 %4, i32 %5, i32 %6, i32 %7, i32 %8, i32 %9, i32 %10, i32 %11, i32 %12, i32 %13, i32 %14, i32 %15, i32 %16, i32 %17, i32 %18, i32 %19, i32 %20, i32 %21, i32 %22, i32 %23, i32 %24, i32 %25, i32 %26, i32 %27, i32 %28, i32 %29, i32 %30, i32 %31){
	%33 = alloca i32
	store i32 %0, i32* %33
	%34 = alloca i32
	store i32 %1, i32* %34
	%35 = alloca i32
	store i32 %2, i32* %35
	%36 = alloca i32
	store i32 %3, i32* %36
	%37 = alloca i32
	store i32 %4, i32* %37
	%38 = alloca i32
	store i32 %5, i32* %38
	%39 = alloca i32
	store i32 %6, i32* %39
	%40 = alloca i32
	store i32 %7, i32* %40
	%41 = alloca i32
	store i32 %8, i32* %41
	%42 = alloca i32
	store i32 %9, i32* %42
	%43 = alloca i32
	store i32 %10, i32* %43
	%44 = alloca i32
	store i32 %11, i32* %44
	%45 = alloca i32
	store i32 %12, i32* %45
	%46 = alloca i32
	store i32 %13, i32* %46
	%47 = alloca i32
	store i32 %14, i32* %47
	%48 = alloca i32
	store i32 %15, i32* %48
	%49 = alloca i32
	store i32 %16, i32* %49
	%50 = alloca i32
	store i32 %17, i32* %50
	%51 = alloca i32
	store i32 %18, i32* %51
	%52 = alloca i32
	store i32 %19, i32* %52
	%53 = alloca i32
	store i32 %20, i32* %53
	%54 = alloca i32
	store i32 %21, i32* %54
	%55 = alloca i32
	store i32 %22, i32* %55
	%56 = alloca i32
	store i32 %23, i32* %56
	%57 = alloca i32
	store i32 %24, i32* %57
	%58 = alloca i32
	store i32 %25, i32* %58
	%59 = alloca i32
	store i32 %26, i32* %59
	%60 = alloca i32
	store i32 %27, i32* %60
	%61 = alloca i32
	store i32 %28, i32* %61
	%62 = alloca i32
	store i32 %29, i32* %62
	%63 = alloca i32
	store i32 %30, i32* %63
	%64 = alloca i32
	store i32 %31, i32* %64
	%65 = alloca i32
	%66 = load i32, i32* %35
	%67 = load i32, i32* %36
	%68 = add i32 %66, %67
	%69 = load i32, i32* %37
	%70 = add i32 %68, %69
	%71 = load i32, i32* %38
	%72 = add i32 %70, %71
	%73 = load i32, i32* %39
	%74 = add i32 %72, %73
	%75 = load i32, i32* %40
	%76 = add i32 %74, %75
	%77 = load i32, i32* %41
	%78 = add i32 %76, %77
	%79 = load i32, i32* %42
	%80 = add i32 %78, %79
	%81 = load i32, i32* %43
	%82 = add i32 %80, %81
	%83 = load i32, i32* %44
	%84 = add i32 %82, %83
	%85 = load i32, i32* %45
	%86 = add i32 %84, %85
	%87 = load i32, i32* %46
	%88 = add i32 %86, %87
	%89 = load i32, i32* %47
	%90 = add i32 %88, %89
	%91 = load i32, i32* %48
	%92 = add i32 %90, %91
	%93 = load i32, i32* %49
	%94 = add i32 %92, %93
	%95 = load i32, i32* %50
	%96 = add i32 %94, %95
	%97 = load i32, i32* %51
	%98 = add i32 %96, %97
	%99 = load i32, i32* %52
	%100 = add i32 %98, %99
	%101 = load i32, i32* %53
	%102 = add i32 %100, %101
	%103 = load i32, i32* %54
	%104 = add i32 %102, %103
	%105 = load i32, i32* %55
	%106 = add i32 %104, %105
	%107 = load i32, i32* %56
	%108 = add i32 %106, %107
	%109 = load i32, i32* %57
	%110 = add i32 %108, %109
	%111 = load i32, i32* %58
	%112 = add i32 %110, %111
	%113 = load i32, i32* %59
	%114 = add i32 %112, %113
	%115 = load i32, i32* %60
	%116 = add i32 %114, %115
	%117 = load i32, i32* %61
	%118 = add i32 %116, %117
	%119 = load i32, i32* %62
	%120 = add i32 %118, %119
	%121 = load i32, i32* %63
	%122 = add i32 %120, %121
	%123 = load i32, i32* %64
	%124 = add i32 %122, %123
	%125 = srem i32 %124, 100
	store i32 %125, i32* %65
	%126 = load i32, i32* %33
	%127 = load i32, i32* %34
	%128 = srem i32 %126, %127
	%129 = icmp eq i32 %128, 0
	%130 = icmp ne i1 %129, 0
	br i1 %130, label %131, label %133
131:
	%132 = load i32, i32* %34
	ret i32 %132
133:
	%134 = load i32, i32* %34
	%135 = load i32, i32* %33
	%136 = load i32, i32* %34
	%137 = srem i32 %135, %136
	%138 = load i32, i32* %65
	%139 = load i32, i32* %36
	%140 = load i32, i32* %37
	%141 = load i32, i32* %38
	%142 = load i32, i32* %39
	%143 = load i32, i32* %40
	%144 = load i32, i32* %41
	%145 = load i32, i32* %42
	%146 = load i32, i32* %43
	%147 = load i32, i32* %44
	%148 = load i32, i32* %45
	%149 = load i32, i32* %46
	%150 = load i32, i32* %47
	%151 = load i32, i32* %48
	%152 = load i32, i32* %49
	%153 = load i32, i32* %50
	%154 = load i32, i32* %51
	%155 = load i32, i32* %52
	%156 = load i32, i32* %53
	%157 = load i32, i32* %54
	%158 = load i32, i32* %55
	%159 = load i32, i32* %56
	%160 = load i32, i32* %57
	%161 = load i32, i32* %58
	%162 = load i32, i32* %59
	%163 = load i32, i32* %60
	%164 = load i32, i32* %61
	%165 = load i32, i32* %62
	%166 = load i32, i32* %63
	%167 = load i32, i32* %64
	%168 = call i32 @gcd2(i32 %134, i32 %137, i32 %138, i32 %139, i32 %140, i32 %141, i32 %142, i32 %143, i32 %144, i32 %145, i32 %146, i32 %147, i32 %148, i32 %149, i32 %150, i32 %151, i32 %152, i32 %153, i32 %154, i32 %155, i32 %156, i32 %157, i32 %158, i32 %159, i32 %160, i32 %161, i32 %162, i32 %163, i32 %164, i32 %165, i32 %166, i32 %167)
	ret i32 %168
169:
	ret i32 0
}

define i32 @gcd2(i32 %0, i32 %1, i32 %2, i32 %3, i32 %4, i32 %5, i32 %6, i32 %7, i32 %8, i32 %9, i32 %10, i32 %11, i32 %12, i32 %13, i32 %14, i32 %15, i32 %16, i32 %17, i32 %18, i32 %19, i32 %20, i32 %21, i32 %22, i32 %23, i32 %24, i32 %25, i32 %26, i32 %27, i32 %28, i32 %29, i32 %30, i32 %31){
	%33 = alloca i32
	store i32 %0, i32* %33
	%34 = alloca i32
	store i32 %1, i32* %34
	%35 = alloca i32
	store i32 %2, i32* %35
	%36 = alloca i32
	store i32 %3, i32* %36
	%37 = alloca i32
	store i32 %4, i32* %37
	%38 = alloca i32
	store i32 %5, i32* %38
	%39 = alloca i32
	store i32 %6, i32* %39
	%40 = alloca i32
	store i32 %7, i32* %40
	%41 = alloca i32
	store i32 %8, i32* %41
	%42 = alloca i32
	store i32 %9, i32* %42
	%43 = alloca i32
	store i32 %10, i32* %43
	%44 = alloca i32
	store i32 %11, i32* %44
	%45 = alloca i32
	store i32 %12, i32* %45
	%46 = alloca i32
	store i32 %13, i32* %46
	%47 = alloca i32
	store i32 %14, i32* %47
	%48 = alloca i32
	store i32 %15, i32* %48
	%49 = alloca i32
	store i32 %16, i32* %49
	%50 = alloca i32
	store i32 %17, i32* %50
	%51 = alloca i32
	store i32 %18, i32* %51
	%52 = alloca i32
	store i32 %19, i32* %52
	%53 = alloca i32
	store i32 %20, i32* %53
	%54 = alloca i32
	store i32 %21, i32* %54
	%55 = alloca i32
	store i32 %22, i32* %55
	%56 = alloca i32
	store i32 %23, i32* %56
	%57 = alloca i32
	store i32 %24, i32* %57
	%58 = alloca i32
	store i32 %25, i32* %58
	%59 = alloca i32
	store i32 %26, i32* %59
	%60 = alloca i32
	store i32 %27, i32* %60
	%61 = alloca i32
	store i32 %28, i32* %61
	%62 = alloca i32
	store i32 %29, i32* %62
	%63 = alloca i32
	store i32 %30, i32* %63
	%64 = alloca i32
	store i32 %31, i32* %64
	%65 = alloca i32
	%66 = load i32, i32* %35
	%67 = load i32, i32* %36
	%68 = add i32 %66, %67
	%69 = load i32, i32* %37
	%70 = add i32 %68, %69
	%71 = load i32, i32* %38
	%72 = add i32 %70, %71
	%73 = load i32, i32* %39
	%74 = add i32 %72, %73
	%75 = load i32, i32* %40
	%76 = add i32 %74, %75
	%77 = load i32, i32* %41
	%78 = add i32 %76, %77
	%79 = load i32, i32* %42
	%80 = add i32 %78, %79
	%81 = load i32, i32* %43
	%82 = add i32 %80, %81
	%83 = load i32, i32* %44
	%84 = add i32 %82, %83
	%85 = load i32, i32* %45
	%86 = add i32 %84, %85
	%87 = load i32, i32* %46
	%88 = add i32 %86, %87
	%89 = load i32, i32* %47
	%90 = add i32 %88, %89
	%91 = load i32, i32* %48
	%92 = add i32 %90, %91
	%93 = load i32, i32* %49
	%94 = add i32 %92, %93
	%95 = load i32, i32* %50
	%96 = add i32 %94, %95
	%97 = load i32, i32* %51
	%98 = add i32 %96, %97
	%99 = load i32, i32* %52
	%100 = add i32 %98, %99
	%101 = load i32, i32* %53
	%102 = add i32 %100, %101
	%103 = load i32, i32* %54
	%104 = add i32 %102, %103
	%105 = load i32, i32* %55
	%106 = add i32 %104, %105
	%107 = load i32, i32* %56
	%108 = add i32 %106, %107
	%109 = load i32, i32* %57
	%110 = add i32 %108, %109
	%111 = load i32, i32* %58
	%112 = add i32 %110, %111
	%113 = load i32, i32* %59
	%114 = add i32 %112, %113
	%115 = load i32, i32* %60
	%116 = add i32 %114, %115
	%117 = load i32, i32* %61
	%118 = add i32 %116, %117
	%119 = load i32, i32* %62
	%120 = add i32 %118, %119
	%121 = load i32, i32* %63
	%122 = add i32 %120, %121
	%123 = load i32, i32* %64
	%124 = add i32 %122, %123
	%125 = srem i32 %124, 100
	store i32 %125, i32* %65
	%126 = load i32, i32* %33
	%127 = load i32, i32* %34
	%128 = srem i32 %126, %127
	%129 = icmp eq i32 %128, 0
	%130 = icmp ne i1 %129, 0
	br i1 %130, label %131, label %133
131:
	%132 = load i32, i32* %34
	ret i32 %132
133:
	%134 = load i32, i32* %34
	%135 = load i32, i32* %33
	%136 = load i32, i32* %34
	%137 = srem i32 %135, %136
	%138 = load i32, i32* %35
	%139 = load i32, i32* %36
	%140 = load i32, i32* %37
	%141 = load i32, i32* %38
	%142 = load i32, i32* %39
	%143 = load i32, i32* %40
	%144 = load i32, i32* %41
	%145 = load i32, i32* %42
	%146 = load i32, i32* %43
	%147 = load i32, i32* %44
	%148 = load i32, i32* %45
	%149 = load i32, i32* %46
	%150 = load i32, i32* %47
	%151 = load i32, i32* %48
	%152 = load i32, i32* %49
	%153 = load i32, i32* %50
	%154 = load i32, i32* %51
	%155 = load i32, i32* %52
	%156 = load i32, i32* %53
	%157 = load i32, i32* %54
	%158 = load i32, i32* %55
	%159 = load i32, i32* %56
	%160 = load i32, i32* %57
	%161 = load i32, i32* %58
	%162 = load i32, i32* %59
	%163 = load i32, i32* %60
	%164 = load i32, i32* %61
	%165 = load i32, i32* %62
	%166 = load i32, i32* %63
	%167 = load i32, i32* %64
	%168 = call i32 @gcd(i32 %134, i32 %137, i32 %138, i32 %139, i32 %140, i32 %141, i32 %142, i32 %143, i32 %144, i32 %145, i32 %146, i32 %147, i32 %148, i32 %149, i32 %150, i32 %151, i32 %152, i32 %153, i32 %154, i32 %155, i32 %156, i32 %157, i32 %158, i32 %159, i32 %160, i32 %161, i32 %162, i32 %163, i32 %164, i32 %165, i32 %166, i32 %167)
	ret i32 %168
169:
	ret i32 0
}

define i32 @main(){
	call void @global_var_init()
	%1 = call i32 @gcd(i32 10, i32 1, i32 0, i32 2, i32 4, i32 6, i32 8, i32 10, i32 12, i32 14, i32 16, i32 18, i32 20, i32 22, i32 24, i32 26, i32 28, i32 30, i32 32, i32 34, i32 36, i32 38, i32 40, i32 42, i32 44, i32 46, i32 48, i32 50, i32 52, i32 54, i32 56, i32 58)
	%2 = add i32 %1, 1024
	%3 = call i8* @toString(i32 %2)
	call void @println(i8* %3)
	ret i32 0
}

define void @global_var_init(){
	ret void
}

