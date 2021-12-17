@llvm.global_ctors = appending global [1 x { i32, void ()*, i8* }] [{ i32, void ()*, i8* } { i32 65535, void ()* @global_var_init, i8* null }]
@make = dso_local global i32** null
@color = dso_local global i32* null
@count = dso_local global i32* null
@i = dso_local global i32 0
@j = dso_local global i32 0
@.str.0 = constant [2 x i8] c" \00"
@.str.1 = constant [2 x i8] c"\0A\00"
@.str.2 = constant [2 x i8] c"\0A\00"

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
	store i32** %12, i32*** @make
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
	%20 = load i32**, i32*** @make
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
	%39 = load i32**, i32*** @make
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

define dso_local void @search(i32 %0, i32 %1, i32 %2){
	%4 = alloca i32
	store i32 %0, i32* %4
	%5 = alloca i32
	store i32 %1, i32* %5
	%6 = alloca i32
	store i32 %2, i32* %6
	%7 = alloca i32
	%8 = alloca i32
	%9 = alloca i32
	%10 = load i32, i32* %5
	%11 = icmp sgt i32 %10, 0
	%12 = icmp ne i1 %11, false
	br i1 %12, label %17, label %13
13:
	%14 = load i32, i32* %5
	%15 = icmp slt i32 %14, 0
	%16 = icmp ne i1 %15, false
	br label %17
17:
	%18 = phi i1 [ true, %3 ], [ %16, %13 ]
	%19 = icmp ne i1 %18, false
	br i1 %19, label %24, label %20
20:
	%21 = load i32, i32* %4
	%22 = icmp eq i32 %21, 0
	%23 = icmp ne i1 %22, false
	br label %24
24:
	%25 = phi i1 [ true, %17 ], [ %23, %20 ]
	%26 = icmp ne i1 %25, false
	br i1 %26, label %53, label %27
27:
	%28 = load i32, i32* %4
	%29 = sub i32 %28, 1
	%30 = load i32**, i32*** @make
	%31 = getelementptr inbounds i32*, i32** %30, i32 %29
	%32 = load i32*, i32** %31
	%33 = getelementptr inbounds i32, i32* %32, i32 0
	%34 = load i32, i32* %4
	%35 = sub i32 %34, 1
	%36 = load i32**, i32*** @make
	%37 = getelementptr inbounds i32*, i32** %36, i32 %35
	%38 = load i32*, i32** %37
	%39 = getelementptr inbounds i32, i32* %38, i32 1
	%40 = load i32, i32* %33
	%41 = load i32, i32* %39
	%42 = add i32 %40, %41
	%43 = load i32, i32* %4
	%44 = sub i32 %43, 1
	%45 = load i32**, i32*** @make
	%46 = getelementptr inbounds i32*, i32** %45, i32 %44
	%47 = load i32*, i32** %46
	%48 = getelementptr inbounds i32, i32* %47, i32 2
	%49 = load i32, i32* %48
	%50 = add i32 %42, %49
	%51 = icmp eq i32 %50, 15
	%52 = icmp ne i1 %51, false
	br label %53
53:
	%54 = phi i1 [ true, %24 ], [ %52, %27 ]
	%55 = icmp ne i1 %54, 0
	br i1 %55, label %56, label %460
56:
	%57 = load i32, i32* %4
	%58 = icmp eq i32 %57, 2
	%59 = icmp ne i1 %58, false
	br i1 %59, label %60, label %64
60:
	%61 = load i32, i32* %5
	%62 = icmp eq i32 %61, 2
	%63 = icmp ne i1 %62, false
	br label %64
64:
	%65 = phi i1 [ false, %56 ], [ %63, %60 ]
	%66 = icmp ne i1 %65, 0
	br i1 %66, label %67, label %292
67:
	%68 = load i32**, i32*** @make
	%69 = getelementptr inbounds i32*, i32** %68, i32 2
	%70 = load i32*, i32** %69
	%71 = getelementptr inbounds i32, i32* %70, i32 2
	%72 = load i32, i32* %6
	%73 = sub i32 45, %72
	store i32 %73, i32* %71
	%74 = load i32**, i32*** @make
	%75 = getelementptr inbounds i32*, i32** %74, i32 0
	%76 = load i32*, i32** %75
	%77 = getelementptr inbounds i32, i32* %76, i32 0
	%78 = load i32**, i32*** @make
	%79 = getelementptr inbounds i32*, i32** %78, i32 0
	%80 = load i32*, i32** %79
	%81 = getelementptr inbounds i32, i32* %80, i32 1
	%82 = load i32, i32* %77
	%83 = load i32, i32* %81
	%84 = add i32 %82, %83
	%85 = load i32**, i32*** @make
	%86 = getelementptr inbounds i32*, i32** %85, i32 0
	%87 = load i32*, i32** %86
	%88 = getelementptr inbounds i32, i32* %87, i32 2
	%89 = load i32, i32* %88
	%90 = add i32 %84, %89
	store i32 %90, i32* %7
	%91 = load i32**, i32*** @make
	%92 = getelementptr inbounds i32*, i32** %91, i32 1
	%93 = load i32*, i32** %92
	%94 = getelementptr inbounds i32, i32* %93, i32 0
	%95 = load i32**, i32*** @make
	%96 = getelementptr inbounds i32*, i32** %95, i32 1
	%97 = load i32*, i32** %96
	%98 = getelementptr inbounds i32, i32* %97, i32 1
	%99 = load i32, i32* %94
	%100 = load i32, i32* %98
	%101 = add i32 %99, %100
	%102 = load i32**, i32*** @make
	%103 = getelementptr inbounds i32*, i32** %102, i32 1
	%104 = load i32*, i32** %103
	%105 = getelementptr inbounds i32, i32* %104, i32 2
	%106 = load i32, i32* %105
	%107 = add i32 %101, %106
	%108 = load i32, i32* %7
	%109 = icmp eq i32 %107, %108
	%110 = icmp ne i1 %109, false
	br i1 %110, label %111, label %132
111:
	%112 = load i32**, i32*** @make
	%113 = getelementptr inbounds i32*, i32** %112, i32 2
	%114 = load i32*, i32** %113
	%115 = getelementptr inbounds i32, i32* %114, i32 0
	%116 = load i32**, i32*** @make
	%117 = getelementptr inbounds i32*, i32** %116, i32 2
	%118 = load i32*, i32** %117
	%119 = getelementptr inbounds i32, i32* %118, i32 1
	%120 = load i32, i32* %115
	%121 = load i32, i32* %119
	%122 = add i32 %120, %121
	%123 = load i32**, i32*** @make
	%124 = getelementptr inbounds i32*, i32** %123, i32 2
	%125 = load i32*, i32** %124
	%126 = getelementptr inbounds i32, i32* %125, i32 2
	%127 = load i32, i32* %126
	%128 = add i32 %122, %127
	%129 = load i32, i32* %7
	%130 = icmp eq i32 %128, %129
	%131 = icmp ne i1 %130, false
	br label %132
132:
	%133 = phi i1 [ false, %67 ], [ %131, %111 ]
	%134 = icmp ne i1 %133, false
	br i1 %134, label %135, label %156
135:
	%136 = load i32**, i32*** @make
	%137 = getelementptr inbounds i32*, i32** %136, i32 0
	%138 = load i32*, i32** %137
	%139 = getelementptr inbounds i32, i32* %138, i32 0
	%140 = load i32**, i32*** @make
	%141 = getelementptr inbounds i32*, i32** %140, i32 1
	%142 = load i32*, i32** %141
	%143 = getelementptr inbounds i32, i32* %142, i32 0
	%144 = load i32, i32* %139
	%145 = load i32, i32* %143
	%146 = add i32 %144, %145
	%147 = load i32**, i32*** @make
	%148 = getelementptr inbounds i32*, i32** %147, i32 2
	%149 = load i32*, i32** %148
	%150 = getelementptr inbounds i32, i32* %149, i32 0
	%151 = load i32, i32* %150
	%152 = add i32 %146, %151
	%153 = load i32, i32* %7
	%154 = icmp eq i32 %152, %153
	%155 = icmp ne i1 %154, false
	br label %156
156:
	%157 = phi i1 [ false, %132 ], [ %155, %135 ]
	%158 = icmp ne i1 %157, false
	br i1 %158, label %159, label %180
159:
	%160 = load i32**, i32*** @make
	%161 = getelementptr inbounds i32*, i32** %160, i32 0
	%162 = load i32*, i32** %161
	%163 = getelementptr inbounds i32, i32* %162, i32 1
	%164 = load i32**, i32*** @make
	%165 = getelementptr inbounds i32*, i32** %164, i32 1
	%166 = load i32*, i32** %165
	%167 = getelementptr inbounds i32, i32* %166, i32 1
	%168 = load i32, i32* %163
	%169 = load i32, i32* %167
	%170 = add i32 %168, %169
	%171 = load i32**, i32*** @make
	%172 = getelementptr inbounds i32*, i32** %171, i32 2
	%173 = load i32*, i32** %172
	%174 = getelementptr inbounds i32, i32* %173, i32 1
	%175 = load i32, i32* %174
	%176 = add i32 %170, %175
	%177 = load i32, i32* %7
	%178 = icmp eq i32 %176, %177
	%179 = icmp ne i1 %178, false
	br label %180
180:
	%181 = phi i1 [ false, %156 ], [ %179, %159 ]
	%182 = icmp ne i1 %181, false
	br i1 %182, label %183, label %204
183:
	%184 = load i32**, i32*** @make
	%185 = getelementptr inbounds i32*, i32** %184, i32 0
	%186 = load i32*, i32** %185
	%187 = getelementptr inbounds i32, i32* %186, i32 2
	%188 = load i32**, i32*** @make
	%189 = getelementptr inbounds i32*, i32** %188, i32 1
	%190 = load i32*, i32** %189
	%191 = getelementptr inbounds i32, i32* %190, i32 2
	%192 = load i32, i32* %187
	%193 = load i32, i32* %191
	%194 = add i32 %192, %193
	%195 = load i32**, i32*** @make
	%196 = getelementptr inbounds i32*, i32** %195, i32 2
	%197 = load i32*, i32** %196
	%198 = getelementptr inbounds i32, i32* %197, i32 2
	%199 = load i32, i32* %198
	%200 = add i32 %194, %199
	%201 = load i32, i32* %7
	%202 = icmp eq i32 %200, %201
	%203 = icmp ne i1 %202, false
	br label %204
204:
	%205 = phi i1 [ false, %180 ], [ %203, %183 ]
	%206 = icmp ne i1 %205, false
	br i1 %206, label %207, label %228
207:
	%208 = load i32**, i32*** @make
	%209 = getelementptr inbounds i32*, i32** %208, i32 0
	%210 = load i32*, i32** %209
	%211 = getelementptr inbounds i32, i32* %210, i32 0
	%212 = load i32**, i32*** @make
	%213 = getelementptr inbounds i32*, i32** %212, i32 1
	%214 = load i32*, i32** %213
	%215 = getelementptr inbounds i32, i32* %214, i32 1
	%216 = load i32, i32* %211
	%217 = load i32, i32* %215
	%218 = add i32 %216, %217
	%219 = load i32**, i32*** @make
	%220 = getelementptr inbounds i32*, i32** %219, i32 2
	%221 = load i32*, i32** %220
	%222 = getelementptr inbounds i32, i32* %221, i32 2
	%223 = load i32, i32* %222
	%224 = add i32 %218, %223
	%225 = load i32, i32* %7
	%226 = icmp eq i32 %224, %225
	%227 = icmp ne i1 %226, false
	br label %228
228:
	%229 = phi i1 [ false, %204 ], [ %227, %207 ]
	%230 = icmp ne i1 %229, false
	br i1 %230, label %231, label %252
231:
	%232 = load i32**, i32*** @make
	%233 = getelementptr inbounds i32*, i32** %232, i32 2
	%234 = load i32*, i32** %233
	%235 = getelementptr inbounds i32, i32* %234, i32 0
	%236 = load i32**, i32*** @make
	%237 = getelementptr inbounds i32*, i32** %236, i32 1
	%238 = load i32*, i32** %237
	%239 = getelementptr inbounds i32, i32* %238, i32 1
	%240 = load i32, i32* %235
	%241 = load i32, i32* %239
	%242 = add i32 %240, %241
	%243 = load i32**, i32*** @make
	%244 = getelementptr inbounds i32*, i32** %243, i32 0
	%245 = load i32*, i32** %244
	%246 = getelementptr inbounds i32, i32* %245, i32 2
	%247 = load i32, i32* %246
	%248 = add i32 %242, %247
	%249 = load i32, i32* %7
	%250 = icmp eq i32 %248, %249
	%251 = icmp ne i1 %250, false
	br label %252
252:
	%253 = phi i1 [ false, %228 ], [ %251, %231 ]
	%254 = icmp ne i1 %253, 0
	br i1 %254, label %255, label %291
255:
	%256 = load i32*, i32** @count
	%257 = getelementptr inbounds i32, i32* %256, i32 0
	%258 = load i32*, i32** @count
	%259 = getelementptr inbounds i32, i32* %258, i32 0
	%260 = load i32, i32* %259
	%261 = add i32 %260, 1
	store i32 %261, i32* %257
	store i32 0, i32* %8
	br label %262
262:
	%263 = load i32, i32* %8
	%264 = icmp sle i32 %263, 2
	%265 = icmp ne i1 %264, 0
	br i1 %265, label %266, label %289
266:
	store i32 0, i32* %9
	br label %267
267:
	%268 = load i32, i32* %9
	%269 = icmp sle i32 %268, 2
	%270 = icmp ne i1 %269, 0
	br i1 %270, label %271, label %284
271:
	%272 = load i32, i32* %8
	%273 = load i32**, i32*** @make
	%274 = getelementptr inbounds i32*, i32** %273, i32 %272
	%275 = load i32, i32* %9
	%276 = load i32*, i32** %274
	%277 = getelementptr inbounds i32, i32* %276, i32 %275
	%278 = load i32, i32* %277
	%279 = call i8* @toString(i32 %278)
	call void @print(i8* %279)
	%280 = bitcast [2 x i8]* @.str.0 to i8*
	call void @print(i8* %280)
	br label %281
281:
	%282 = load i32, i32* %9
	%283 = add i32 %282, 1
	store i32 %283, i32* %9
	br label %267
284:
	%285 = bitcast [2 x i8]* @.str.1 to i8*
	call void @print(i8* %285)
	br label %286
286:
	%287 = load i32, i32* %8
	%288 = add i32 %287, 1
	store i32 %288, i32* %8
	br label %262
289:
	%290 = bitcast [2 x i8]* @.str.2 to i8*
	call void @print(i8* %290)
	br label %291
291:
	br label %459
292:
	%293 = load i32, i32* %5
	%294 = icmp eq i32 %293, 2
	%295 = icmp ne i1 %294, 0
	br i1 %295, label %296, label %404
296:
	%297 = load i32, i32* %4
	%298 = load i32**, i32*** @make
	%299 = getelementptr inbounds i32*, i32** %298, i32 %297
	%300 = load i32, i32* %5
	%301 = load i32*, i32** %299
	%302 = getelementptr inbounds i32, i32* %301, i32 %300
	%303 = load i32, i32* %4
	%304 = load i32**, i32*** @make
	%305 = getelementptr inbounds i32*, i32** %304, i32 %303
	%306 = load i32*, i32** %305
	%307 = getelementptr inbounds i32, i32* %306, i32 0
	%308 = load i32, i32* %307
	%309 = sub i32 15, %308
	%310 = load i32, i32* %4
	%311 = load i32**, i32*** @make
	%312 = getelementptr inbounds i32*, i32** %311, i32 %310
	%313 = load i32*, i32** %312
	%314 = getelementptr inbounds i32, i32* %313, i32 1
	%315 = load i32, i32* %314
	%316 = sub i32 %309, %315
	store i32 %316, i32* %302
	%317 = load i32, i32* %4
	%318 = load i32**, i32*** @make
	%319 = getelementptr inbounds i32*, i32** %318, i32 %317
	%320 = load i32, i32* %5
	%321 = load i32*, i32** %319
	%322 = getelementptr inbounds i32, i32* %321, i32 %320
	%323 = load i32, i32* %322
	%324 = icmp sgt i32 %323, 0
	%325 = icmp ne i1 %324, false
	br i1 %325, label %326, label %336
326:
	%327 = load i32, i32* %4
	%328 = load i32**, i32*** @make
	%329 = getelementptr inbounds i32*, i32** %328, i32 %327
	%330 = load i32, i32* %5
	%331 = load i32*, i32** %329
	%332 = getelementptr inbounds i32, i32* %331, i32 %330
	%333 = load i32, i32* %332
	%334 = icmp slt i32 %333, 10
	%335 = icmp ne i1 %334, false
	br label %336
336:
	%337 = phi i1 [ false, %296 ], [ %335, %326 ]
	%338 = icmp ne i1 %337, false
	br i1 %338, label %339, label %352
339:
	%340 = load i32, i32* %4
	%341 = load i32**, i32*** @make
	%342 = getelementptr inbounds i32*, i32** %341, i32 %340
	%343 = load i32, i32* %5
	%344 = load i32*, i32** %342
	%345 = getelementptr inbounds i32, i32* %344, i32 %343
	%346 = load i32, i32* %345
	%347 = load i32*, i32** @color
	%348 = getelementptr inbounds i32, i32* %347, i32 %346
	%349 = load i32, i32* %348
	%350 = icmp eq i32 %349, 0
	%351 = icmp ne i1 %350, false
	br label %352
352:
	%353 = phi i1 [ false, %336 ], [ %351, %339 ]
	%354 = icmp ne i1 %353, 0
	br i1 %354, label %355, label %403
355:
	%356 = load i32, i32* %4
	%357 = load i32**, i32*** @make
	%358 = getelementptr inbounds i32*, i32** %357, i32 %356
	%359 = load i32, i32* %5
	%360 = load i32*, i32** %358
	%361 = getelementptr inbounds i32, i32* %360, i32 %359
	%362 = load i32, i32* %361
	%363 = load i32*, i32** @color
	%364 = getelementptr inbounds i32, i32* %363, i32 %362
	store i32 1, i32* %364
	%365 = load i32, i32* %5
	%366 = icmp eq i32 %365, 2
	%367 = icmp ne i1 %366, 0
	br i1 %367, label %368, label %380
368:
	%369 = load i32, i32* %4
	%370 = add i32 %369, 1
	%371 = load i32, i32* %4
	%372 = load i32**, i32*** @make
	%373 = getelementptr inbounds i32*, i32** %372, i32 %371
	%374 = load i32, i32* %5
	%375 = load i32*, i32** %373
	%376 = getelementptr inbounds i32, i32* %375, i32 %374
	%377 = load i32, i32* %6
	%378 = load i32, i32* %376
	%379 = add i32 %377, %378
	call void @search(i32 %370, i32 0, i32 %379)
	br label %393
380:
	%381 = load i32, i32* %4
	%382 = load i32, i32* %5
	%383 = add i32 %382, 1
	%384 = load i32, i32* %4
	%385 = load i32**, i32*** @make
	%386 = getelementptr inbounds i32*, i32** %385, i32 %384
	%387 = load i32, i32* %5
	%388 = load i32*, i32** %386
	%389 = getelementptr inbounds i32, i32* %388, i32 %387
	%390 = load i32, i32* %6
	%391 = load i32, i32* %389
	%392 = add i32 %390, %391
	call void @search(i32 %381, i32 %383, i32 %392)
	br label %393
393:
	%394 = load i32, i32* %4
	%395 = load i32**, i32*** @make
	%396 = getelementptr inbounds i32*, i32** %395, i32 %394
	%397 = load i32, i32* %5
	%398 = load i32*, i32** %396
	%399 = getelementptr inbounds i32, i32* %398, i32 %397
	%400 = load i32, i32* %399
	%401 = load i32*, i32** @color
	%402 = getelementptr inbounds i32, i32* %401, i32 %400
	store i32 0, i32* %402
	br label %403
403:
	br label %458
404:
	store i32 1, i32* %8
	br label %405
405:
	%406 = load i32, i32* %8
	%407 = icmp sle i32 %406, 9
	%408 = icmp ne i1 %407, 0
	br i1 %408, label %409, label %457
409:
	%410 = load i32, i32* %8
	%411 = load i32*, i32** @color
	%412 = getelementptr inbounds i32, i32* %411, i32 %410
	%413 = load i32, i32* %412
	%414 = icmp eq i32 %413, 0
	%415 = icmp ne i1 %414, 0
	br i1 %415, label %416, label %453
416:
	%417 = load i32, i32* %8
	%418 = load i32*, i32** @color
	%419 = getelementptr inbounds i32, i32* %418, i32 %417
	store i32 1, i32* %419
	%420 = load i32, i32* %4
	%421 = load i32**, i32*** @make
	%422 = getelementptr inbounds i32*, i32** %421, i32 %420
	%423 = load i32, i32* %5
	%424 = load i32*, i32** %422
	%425 = getelementptr inbounds i32, i32* %424, i32 %423
	%426 = load i32, i32* %8
	store i32 %426, i32* %425
	%427 = load i32, i32* %5
	%428 = icmp eq i32 %427, 2
	%429 = icmp ne i1 %428, 0
	br i1 %429, label %430, label %436
430:
	%431 = load i32, i32* %4
	%432 = add i32 %431, 1
	%433 = load i32, i32* %6
	%434 = load i32, i32* %8
	%435 = add i32 %433, %434
	call void @search(i32 %432, i32 0, i32 %435)
	br label %443
436:
	%437 = load i32, i32* %4
	%438 = load i32, i32* %5
	%439 = add i32 %438, 1
	%440 = load i32, i32* %6
	%441 = load i32, i32* %8
	%442 = add i32 %440, %441
	call void @search(i32 %437, i32 %439, i32 %442)
	br label %443
443:
	%444 = load i32, i32* %4
	%445 = load i32**, i32*** @make
	%446 = getelementptr inbounds i32*, i32** %445, i32 %444
	%447 = load i32, i32* %5
	%448 = load i32*, i32** %446
	%449 = getelementptr inbounds i32, i32* %448, i32 %447
	store i32 0, i32* %449
	%450 = load i32, i32* %8
	%451 = load i32*, i32** @color
	%452 = getelementptr inbounds i32, i32* %451, i32 %450
	store i32 0, i32* %452
	br label %453
453:
	br label %454
454:
	%455 = load i32, i32* %8
	%456 = add i32 %455, 1
	store i32 %456, i32* %8
	br label %405
457:
	br label %458
458:
	br label %459
459:
	br label %460
460:
	ret void
}

define dso_local i32 @main(){
	%1 = load i32*, i32** @count
	%2 = getelementptr inbounds i32, i32* %1, i32 0
	store i32 0, i32* %2
	call void @origin(i32 3)
	call void @search(i32 0, i32 0, i32 0)
	%3 = load i32*, i32** @count
	%4 = getelementptr inbounds i32, i32* %3, i32 0
	%5 = load i32, i32* %4
	%6 = call i8* @toString(i32 %5)
	call void @println(i8* %6)
	ret i32 0
}

define dso_local void @global_var_init(){
	%1 = add i64 40, 4
	%2 = call i8* @malloc(i64 %1)
	%3 = bitcast i8* %2 to i32*
	store i32 10, i32* %3
	%4 = getelementptr inbounds i8, i8* %2, i64 4
	%5 = bitcast i8* %4 to i32*
	%6 = alloca i32*
	store i32* %5, i32** %6
	%7 = load i32*, i32** %6
	store i32* %7, i32** @color
	%8 = add i64 4, 4
	%9 = call i8* @malloc(i64 %8)
	%10 = bitcast i8* %9 to i32*
	store i32 1, i32* %10
	%11 = getelementptr inbounds i8, i8* %9, i64 4
	%12 = bitcast i8* %11 to i32*
	%13 = alloca i32*
	store i32* %12, i32** %13
	%14 = load i32*, i32** %13
	store i32* %14, i32** @count
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
