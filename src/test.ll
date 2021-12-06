; ModuleID = 'test.c'
source_filename = "test.c"
target datalayout = "e-m:e-p270:32:32-p271:32:32-p272:64:64-i64:64-f80:128-n8:16:32:64-S128"
target triple = "x86_64-pc-linux-gnu"

%struct.test = type { i32, [3 x i32], double }

@just_ret = common dso_local global %struct.test zeroinitializer, align 8

; Function Attrs: noinline nounwind optnone uwtable
define dso_local void @function(%struct.test* noalias sret %0, %struct.test* %1) #0 {
  %3 = alloca %struct.test*, align 8
  store %struct.test* %1, %struct.test** %3, align 8
  %4 = load %struct.test*, %struct.test** %3, align 8
  %5 = getelementptr inbounds %struct.test, %struct.test* %4, i64 2
  %6 = getelementptr inbounds %struct.test, %struct.test* %5, i32 0, i32 1
  %7 = getelementptr inbounds [3 x i32], [3 x i32]* %6, i64 0, i64 2
  %8 = load i32, i32* %7, align 4
  %9 = sitofp i32 %8 to double
  %10 = load %struct.test*, %struct.test** %3, align 8
  %11 = getelementptr inbounds %struct.test, %struct.test* %10, i64 1
  %12 = getelementptr inbounds %struct.test, %struct.test* %11, i32 0, i32 2
  %13 = load double, double* %12, align 8
  %14 = fadd double %9, %13
  %15 = fptosi double %14 to i32
  %16 = load %struct.test*, %struct.test** %3, align 8
  %17 = getelementptr inbounds %struct.test, %struct.test* %16, i64 3
  %18 = getelementptr inbounds %struct.test, %struct.test* %17, i32 0, i32 0
  store i32 %15, i32* %18, align 8
  %19 = load %struct.test*, %struct.test** %3, align 8
  %20 = bitcast %struct.test* %0 to i8*
  %21 = bitcast %struct.test* %19 to i8*
  call void @llvm.memcpy.p0i8.p0i8.i64(i8* align 8 %20, i8* align 8 %21, i64 24, i1 false)
  ret void
}

; Function Attrs: argmemonly nounwind willreturn
declare void @llvm.memcpy.p0i8.p0i8.i64(i8* noalias nocapture writeonly, i8* noalias nocapture readonly, i64, i1 immarg) #1

; Function Attrs: noinline nounwind optnone uwtable
define dso_local i32 @main() #0 {
  %1 = alloca i32, align 4
  %2 = alloca %struct.test*, align 8
  %3 = alloca %struct.test, align 8
  store i32 0, i32* %1, align 4
  %4 = load %struct.test*, %struct.test** %2, align 8
  call void @function(%struct.test* sret %3, %struct.test* %4)
  %5 = bitcast %struct.test* %3 to i8*
  call void @llvm.memcpy.p0i8.p0i8.i64(i8* align 8 bitcast (%struct.test* @just_ret to i8*), i8* align 8 %5, i64 24, i1 false)
  ret i32 0
}

attributes #0 = { noinline nounwind optnone uwtable "correctly-rounded-divide-sqrt-fp-math"="false" "disable-tail-calls"="false" "frame-pointer"="all" "less-precise-fpmad"="false" "min-legal-vector-width"="0" "no-infs-fp-math"="false" "no-jump-tables"="false" "no-nans-fp-math"="false" "no-signed-zeros-fp-math"="false" "no-trapping-math"="false" "stack-protector-buffer-size"="8" "target-cpu"="x86-64" "target-features"="+cx8,+fxsr,+mmx,+sse,+sse2,+x87" "unsafe-fp-math"="false" "use-soft-float"="false" }
attributes #1 = { argmemonly nounwind willreturn }

!llvm.module.flags = !{!0}
!llvm.ident = !{!1}

!0 = !{i32 1, !"wchar_size", i32 4}
!1 = !{!"clang version 10.0.0-4ubuntu1 "}
