	.text
	.globl	abs
	.p2align	2
	.type	abs,@function
abs:
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
	sw	a0, 40(sp)
	lw	s0, 40(sp)
	sw	s0, 36(sp)
	lw	s0, 36(sp)
	sw	s0, 32(sp)
	lw	s0, 32(sp)
	li	s1, 0
	sub	s2, s0,s1
	sgtz	s4, s2
	sw	s4, 28(sp)
	lw	s0, 28(sp)
	li	s1, 0
	sub	s2, s0,s1
	snez	s4, s2
	sw	s4, 24(sp)
	lw	s0, 24(sp)
	beqz s0 .abs_2
.abs_1:
	lw	s0, 36(sp)
	sw	s0, 20(sp)
	lw	a0, 20(sp)
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
.abs_2:
	lw	s0, 36(sp)
	sw	s0, 16(sp)
	li	s0, 0
	lw	s1, 16(sp)
	sub	s2, s0,s1
	sw	s2, 12(sp)
	lw	a0, 12(sp)
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

	.globl	main
	.p2align	2
	.type	main,@function
main:
	addi	sp, sp, -144
	sw	ra, 140(sp)
	sw	s0, 136(sp)
	sw	s1, 132(sp)
	sw	s2, 128(sp)
	sw	s3, 124(sp)
	sw	s4, 120(sp)
	sw	s5, 116(sp)
	sw	s6, 112(sp)
	sw	s7, 108(sp)
	sw	s8, 104(sp)
	sw	s9, 100(sp)
	sw	s10, 96(sp)
	sw	s11, 92(sp)
	call	global_var_init
	li	s0, 0
	la	s1, i
	sw	s0, 0(s1)
	j	.main_1
.main_1:
	la	s1, i
	lw	s0, 0(s1)
	sw	s0, 88(sp)
	lw	s0, 88(sp)
	li	s1, 5
	sub	s2, s0,s1
	sltz	s4, s2
	sw	s4, 84(sp)
	lw	s0, 84(sp)
	li	s1, 0
	sub	s2, s0,s1
	snez	s4, s2
	sw	s4, 80(sp)
	lw	s0, 80(sp)
	beqz s0 .main_10
.main_2:
	li	s0, 0
	la	s1, j
	sw	s0, 0(s1)
	j	.main_3
.main_3:
	la	s1, j
	lw	s0, 0(s1)
	sw	s0, 76(sp)
	lw	s0, 76(sp)
	li	s1, 5
	sub	s2, s0,s1
	sltz	s4, s2
	sw	s4, 72(sp)
	lw	s0, 72(sp)
	li	s1, 0
	sub	s2, s0,s1
	snez	s4, s2
	sw	s4, 68(sp)
	lw	s0, 68(sp)
	beqz s0 .main_8
.main_4:
	call	getInt
	sw	a0, 64(sp)
	lw	s0, 64(sp)
	la	s1, n
	sw	s0, 0(s1)
	la	s1, n
	lw	s0, 0(s1)
	sw	s0, 60(sp)
	lw	s0, 60(sp)
	li	s1, 1
	sub	s2, s0,s1
	seqz	s4, s2
	sw	s4, 56(sp)
	lw	s0, 56(sp)
	li	s1, 0
	sub	s2, s0,s1
	snez	s4, s2
	sw	s4, 52(sp)
	lw	s0, 52(sp)
	beqz s0 .main_6
.main_5:
	la	s1, i
	lw	s0, 0(s1)
	sw	s0, 48(sp)
	lw	s0, 48(sp)
	la	s1, r
	sw	s0, 0(s1)
	la	s1, j
	lw	s0, 0(s1)
	sw	s0, 44(sp)
	lw	s0, 44(sp)
	la	s1, c
	sw	s0, 0(s1)
	j	.main_6
.main_6:
	j	.main_7
.main_7:
	la	s1, j
	lw	s0, 0(s1)
	sw	s0, 40(sp)
	lw	s0, 40(sp)
	li	s1, 1
	add	s2, s0,s1
	sw	s2, 36(sp)
	lw	s0, 36(sp)
	la	s1, j
	sw	s0, 0(s1)
	j	.main_3
.main_8:
	j	.main_9
.main_9:
	la	s1, i
	lw	s0, 0(s1)
	sw	s0, 32(sp)
	lw	s0, 32(sp)
	li	s1, 1
	add	s2, s0,s1
	sw	s2, 28(sp)
	lw	s0, 28(sp)
	la	s1, i
	sw	s0, 0(s1)
	j	.main_1
.main_10:
	la	s1, r
	lw	s0, 0(s1)
	sw	s0, 24(sp)
	li	s0, 2
	lw	s1, 24(sp)
	sub	s2, s0,s1
	sw	s2, 20(sp)
	lw	a0, 20(sp)
	call	abs
	sw	a0, 16(sp)
	la	s1, c
	lw	s0, 0(s1)
	sw	s0, 12(sp)
	li	s0, 2
	lw	s1, 12(sp)
	sub	s2, s0,s1
	sw	s2, 8(sp)
	lw	a0, 8(sp)
	call	abs
	sw	a0, 4(sp)
	lw	s0, 16(sp)
	lw	s1, 4(sp)
	add	s2, s0,s1
	sw	s2, 0(sp)
	lw	a0, 0(sp)
	call	printInt
	li	a0, 0
	lw	s0, 136(sp)
	lw	s1, 132(sp)
	lw	s2, 128(sp)
	lw	s3, 124(sp)
	lw	s4, 120(sp)
	lw	s5, 116(sp)
	lw	s6, 112(sp)
	lw	s7, 108(sp)
	lw	s8, 104(sp)
	lw	s9, 100(sp)
	lw	s10, 96(sp)
	lw	s11, 92(sp)
	lw	ra, 140(sp)
	addi	sp, sp, 144
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
	.type	n,@object
	.globl	n
n:
	.word	0
	.size	n, 4

	.type	r,@object
	.globl	r
r:
	.word	0
	.size	r, 4

	.type	c,@object
	.globl	c
c:
	.word	0
	.size	c, 4

	.type	i,@object
	.globl	i
i:
	.word	0
	.size	i, 4

	.type	j,@object
	.globl	j
j:
	.word	0
	.size	j, 4


	.section	.rodata,"a",@progbits
	.section	".note.GNU-stack","",@progbits
