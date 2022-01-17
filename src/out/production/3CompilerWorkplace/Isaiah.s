	.text
	.file Isaiah.ll
	.globl	main
	.p2align	2
	.type	main,@function
main:
	addi	sp, sp, -96
	sw	ra, 92(sp)
	sw	s0, 88(sp)
	sw	s1, 84(sp)
	sw	s2, 80(sp)
	sw	s3, 76(sp)
	sw	s4, 72(sp)
	sw	s5, 68(sp)
	sw	s6, 64(sp)
	sw	s7, 60(sp)
	sw	s8, 56(sp)
	sw	s9, 52(sp)
	sw	s10, 48(sp)
	sw	s11, 44(sp)
	call	global_var_init
	li	s0 12
	li	s1 4
	add	s2, s0,s1
	li	s4 40
	add	s3, sp,s4
	sw	s2, 0(s3)
	li	s0 40
	add	s1, sp,s0
	lw	a0, 0(s1)
	call	malloc
	li	s1 36
	add	s0, sp,s1
	sw	a0, 0(s0)   ;%2
	li	s1 36
	add	s2, sp,s1
	lw	s0, 0(s2)
	li	s2 32
	add	s1, sp,s2
	sw	s0, 0(s1)   ; bitcast 2 to 3
	li	s0 3
	li	s3 32
	add	s2, sp,s3
	lw	s1, 0(s2)   ;i32* %3
	sw	s0, 0(s1)   ;s1: base address ;	store i32 3, i32* %3
	li	s5 36
	add	s6, sp,s5
	lw	s1, 0(s6)   ;s1: i8* %2
	li	s2 4
	add	s3, s1,s2   ;s3: this
	lw	s0, 0(s3)
	li	s6 28
	add	s5, sp,s6
	sw	s0, 0(s5)
	li	s1 28
	add	s2, sp,s1
	lw	s0, 0(s2)
	li	s2 24
	add	s1, sp,s2
	sw	s0, 0(s1)
	li	s3 24
	add	s4, sp,s3
	lw	s0, 0(s4)
	li	s3 20
	add	s2, sp,s3
	lw	s1, 0(s2)
	sw	s0, 0(s1)
	li	s2 20
	add	s3, sp,s2
	lw	s0, 0(s3)
	lw	s1, 0(s0)
	li	s3 16
	add	s2, sp,s3
	sw	s1, 0(s2)
	li	s3 16
	add	s4, sp,s3
	lw	s0, 0(s4)
	li	s3 12
	add	s2, sp,s3
	lw	s1, 0(s2)
	sw	s0, 0(s1)
	li	s2 12
	add	s3, sp,s2
	lw	s0, 0(s3)
	lw	s1, 0(s0)
	li	s3 8
	add	s2, sp,s3
	sw	s1, 0(s2)
	li	s1 8
	add	s2, sp,s1
	lw	s0, 0(s2)
	li	s2 4
	add	s1, sp,s2
	sw	s0, 0(s1)
	li	s0 4
	add	s1, sp,s0
	lw	a0, 0(s1)
	call	array_size
	li	s1 0
	add	s0, sp,s1
	sw	a0, 0(s0)
	li	s0 0
	add	s1, sp,s0
	lw	a0, 0(s1)
	lw	s0, 88(sp)
	lw	s1, 84(sp)
	lw	s2, 80(sp)
	lw	s3, 76(sp)
	lw	s4, 72(sp)
	lw	s5, 68(sp)
	lw	s6, 64(sp)
	lw	s7, 60(sp)
	lw	s8, 56(sp)
	lw	s9, 52(sp)
	lw	s10, 48(sp)
	lw	s11, 44(sp)
	lw	ra, 92(sp)
	addi	sp, sp, 96
	ret

	.globl	global_var_init
	.p2align	2
	.type	global_var_init,@function
global_var_init:
	addi	sp, sp, -64
	sw	ra, 60(sp)
	sw	s0, 56(sp)
	sw	s1, 52(sp)
	sw	s2, 48(sp)
	sw	s3, 44(sp)
	sw	s4, 40(sp)
	sw	s5, 36(sp)
	sw	s6, 32(sp)
	sw	s7, 28(sp)
	sw	s8, 24(sp)
	sw	s9, 20(sp)
	sw	s10, 16(sp)
	sw	s11, 12(sp)
	lw	s0, 56(sp)
	lw	s1, 52(sp)
	lw	s2, 48(sp)
	lw	s3, 44(sp)
	lw	s4, 40(sp)
	lw	s5, 36(sp)
	lw	s6, 32(sp)
	lw	s7, 28(sp)
	lw	s8, 24(sp)
	lw	s9, 20(sp)
	lw	s10, 16(sp)
	lw	s11, 12(sp)
	lw	ra, 60(sp)
	addi	sp, sp, 64
	ret


	.section	.bss,"aw",@nobits

	.section	.rodata,"a",@progbits
	.section	".note.GNU-stack","",@progbits
