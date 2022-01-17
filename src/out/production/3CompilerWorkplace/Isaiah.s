	.text
	.file Isaiah.ll
	.globl	main
	.p2align	2
	.type	main,@function
main:
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
	call	global_var_init
	la	s0 .str.0
	li	s1 8
	add	s2, sp,s1
	sw	s0, 0(s2)
	li	s0 8
	add	s1, sp,s0
	lw	a0, 0(s1)
	call	print
	li	a0 0
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
	.type	.str.0,@object
	.globl	.str.0
.str.0: 
	.asciz	"Hello, Wenrui Han!\0A\00"
	.size	.str.0, 27

	.section	".note.GNU-stack","",@progbits
