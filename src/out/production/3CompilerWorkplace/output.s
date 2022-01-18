	.text
	.globl	bubble_sort
	.p2align	2
	.type	bubble_sort,@function
bubble_sort:
	addi	sp, sp, -272
	sw	ra, 268(sp)
	sw	s0, 264(sp)
	sw	s1, 260(sp)
	sw	s2, 256(sp)
	sw	s3, 252(sp)
	sw	s4, 248(sp)
	sw	s5, 244(sp)
	sw	s6, 240(sp)
	sw	s7, 236(sp)
	sw	s8, 232(sp)
	sw	s9, 228(sp)
	sw	s10, 224(sp)
	sw	s11, 220(sp)
	sw	a0, 216(sp)
	lw	s0, 216(sp)
	sw	s0, 212(sp)
	lw	s0, 212(sp)
	sw	s0, 200(sp)
	lw	s0, 200(sp)
	sw	s0, 196(sp)
	lw	a0, 196(sp)
	call	array_size
	sw	a0, 192(sp)
	lw	s0, 192(sp)
	sw	s0, 188(sp)
	li	s0, 0
	sw	s0, 208(sp)
	j	.bubble_sort_1
.bubble_sort_1:
	lw	s0, 188(sp)
	sw	s0, 184(sp)
	lw	s0, 184(sp)
	li	s1, 1
	sub	s2, s0,s1
	sw	s2, 180(sp)
	lw	s0, 208(sp)
	sw	s0, 176(sp)
	lw	s0, 176(sp)
	lw	s1, 180(sp)
	sub	s2, s0,s1
	sltz	s4, s2
	sw	s4, 172(sp)
	lw	s0, 172(sp)
	li	s1, 0
	sub	s2, s0,s1
	snez	s4, s2
	sw	s4, 168(sp)
	lw	s0, 168(sp)
	beqz s0, .bubble_sort_10
.bubble_sort_2:
	li	s0, 0
	sw	s0, 204(sp)
	j	.bubble_sort_3
.bubble_sort_3:
	lw	s0, 188(sp)
	sw	s0, 164(sp)
	lw	s0, 208(sp)
	sw	s0, 160(sp)
	lw	s0, 164(sp)
	lw	s1, 160(sp)
	sub	s2, s0,s1
	sw	s2, 156(sp)
	lw	s0, 156(sp)
	li	s1, 1
	sub	s2, s0,s1
	sw	s2, 152(sp)
	lw	s0, 204(sp)
	sw	s0, 148(sp)
	lw	s0, 148(sp)
	lw	s1, 152(sp)
	sub	s2, s0,s1
	sltz	s4, s2
	sw	s4, 144(sp)
	lw	s0, 144(sp)
	li	s1, 0
	sub	s2, s0,s1
	snez	s4, s2
	sw	s4, 140(sp)
	lw	s0, 140(sp)
	beqz s0, .bubble_sort_8
.bubble_sort_4:
	lw	s0, 204(sp)
	sw	s0, 136(sp)
	lw	s0, 212(sp)
	sw	s0, 132(sp)
	lw	s1, 132(sp)
	lw	s2, 136(sp)
	slli	s3, s2, 2
	add	s0, s1,s3
	sw	s0, 128(sp)
	lw	s0, 204(sp)
	sw	s0, 124(sp)
	lw	s0, 124(sp)
	li	s1, 1
	add	s2, s0,s1
	sw	s2, 120(sp)
	lw	s0, 212(sp)
	sw	s0, 116(sp)
	lw	s1, 116(sp)
	lw	s2, 120(sp)
	slli	s3, s2, 2
	add	s0, s1,s3
	sw	s0, 112(sp)
	lw	s1, 128(sp)
	lw	s0, 0(s1)
	sw	s0, 108(sp)
	lw	s1, 112(sp)
	lw	s0, 0(s1)
	sw	s0, 104(sp)
	lw	s0, 108(sp)
	lw	s1, 104(sp)
	sub	s2, s0,s1
	sltz	s4, s2
	sw	s4, 100(sp)
	lw	s0, 100(sp)
	li	s1, 0
	sub	s2, s0,s1
	snez	s4, s2
	sw	s4, 96(sp)
	lw	s0, 96(sp)
	beqz s0, .bubble_sort_6
.bubble_sort_5:
	j	.bubble_sort_7
.bubble_sort_6:
	lw	s0, 204(sp)
	sw	s0, 92(sp)
	lw	s0, 212(sp)
	sw	s0, 88(sp)
	lw	s1, 88(sp)
	lw	s2, 92(sp)
	slli	s3, s2, 2
	add	s0, s1,s3
	sw	s0, 84(sp)
	lw	s1, 84(sp)
	lw	s0, 0(s1)
	sw	s0, 80(sp)
	lw	s0, 80(sp)
	sw	s0, 76(sp)
	lw	s0, 204(sp)
	sw	s0, 72(sp)
	lw	s0, 212(sp)
	sw	s0, 68(sp)
	lw	s1, 68(sp)
	lw	s2, 72(sp)
	slli	s3, s2, 2
	add	s0, s1,s3
	sw	s0, 64(sp)
	lw	s0, 204(sp)
	sw	s0, 60(sp)
	lw	s0, 60(sp)
	li	s1, 1
	add	s2, s0,s1
	sw	s2, 56(sp)
	lw	s0, 212(sp)
	sw	s0, 52(sp)
	lw	s1, 52(sp)
	lw	s2, 56(sp)
	slli	s3, s2, 2
	add	s0, s1,s3
	sw	s0, 48(sp)
	lw	s1, 48(sp)
	lw	s0, 0(s1)
	sw	s0, 44(sp)
	lw	s0, 44(sp)
	lw	s1, 64(sp)
	sw	s0, 0(s1)
	lw	s0, 204(sp)
	sw	s0, 40(sp)
	lw	s0, 40(sp)
	li	s1, 1
	add	s2, s0,s1
	sw	s2, 36(sp)
	lw	s0, 212(sp)
	sw	s0, 32(sp)
	lw	s1, 32(sp)
	lw	s2, 36(sp)
	slli	s3, s2, 2
	add	s0, s1,s3
	sw	s0, 28(sp)
	lw	s0, 76(sp)
	sw	s0, 24(sp)
	lw	s0, 24(sp)
	lw	s1, 28(sp)
	sw	s0, 0(s1)
	j	.bubble_sort_7
.bubble_sort_7:
	lw	s0, 204(sp)
	sw	s0, 20(sp)
	lw	s0, 20(sp)
	li	s1, 1
	add	s2, s0,s1
	sw	s2, 16(sp)
	lw	s0, 16(sp)
	sw	s0, 204(sp)
	j	.bubble_sort_3
.bubble_sort_8:
	j	.bubble_sort_9
.bubble_sort_9:
	lw	s0, 208(sp)
	sw	s0, 12(sp)
	lw	s0, 12(sp)
	li	s1, 1
	add	s2, s0,s1
	sw	s2, 8(sp)
	lw	s0, 8(sp)
	sw	s0, 208(sp)
	j	.bubble_sort_1
.bubble_sort_10:
	lw	s0, 264(sp)
	lw	s1, 260(sp)
	lw	s2, 256(sp)
	lw	s3, 252(sp)
	lw	s4, 248(sp)
	lw	s5, 244(sp)
	lw	s6, 240(sp)
	lw	s7, 236(sp)
	lw	s8, 232(sp)
	lw	s9, 228(sp)
	lw	s10, 224(sp)
	lw	s11, 220(sp)
	lw	ra, 268(sp)
	addi	sp, sp, 272
	ret

	.globl	main
	.p2align	2
	.type	main,@function
main:
	addi	sp, sp, -272
	sw	ra, 268(sp)
	sw	s0, 264(sp)
	sw	s1, 260(sp)
	sw	s2, 256(sp)
	sw	s3, 252(sp)
	sw	s4, 248(sp)
	sw	s5, 244(sp)
	sw	s6, 240(sp)
	sw	s7, 236(sp)
	sw	s8, 232(sp)
	sw	s9, 228(sp)
	sw	s10, 224(sp)
	sw	s11, 220(sp)
	call	global_var_init
	call	getInt
	sw	a0, 216(sp)
	lw	s0, 216(sp)
	sw	s0, 212(sp)
	lw	s0, 212(sp)
	sw	s0, 208(sp)
	lw	s0, 208(sp)
	li	s1, 4
	mul	s2, s0,s1
	sw	s2, 204(sp)
	lw	s0, 204(sp)
	li	s1, 4
	add	s2, s0,s1
	sw	s2, 200(sp)
	lw	a0, 200(sp)
	call	malloc
	sw	a0, 196(sp)
	lw	s0, 196(sp)
	sw	s0, 192(sp)
	lw	s0, 208(sp)
	lw	s1, 192(sp)
	sw	s0, 0(s1)
	lw	s1, 196(sp)
	li	s2, 4
	add	s0, s1,s2
	sw	s0, 188(sp)
	lw	s0, 188(sp)
	sw	s0, 184(sp)
	lw	s0, 184(sp)
	sw	s0, 180(sp)
	lw	s0, 180(sp)
	sw	s0, 176(sp)
	lw	s0, 176(sp)
	sw	s0, 172(sp)
	li	s0, 0
	sw	s0, 168(sp)
	j	.main_1
.main_1:
	lw	s0, 168(sp)
	sw	s0, 164(sp)
	lw	s0, 212(sp)
	sw	s0, 160(sp)
	lw	s0, 164(sp)
	lw	s1, 160(sp)
	sub	s2, s0,s1
	sltz	s4, s2
	sw	s4, 156(sp)
	lw	s0, 156(sp)
	li	s1, 0
	sub	s2, s0,s1
	snez	s4, s2
	sw	s4, 152(sp)
	lw	s0, 152(sp)
	beqz s0, .main_4
.main_2:
	lw	s0, 168(sp)
	sw	s0, 148(sp)
	lw	s0, 172(sp)
	sw	s0, 144(sp)
	lw	s1, 144(sp)
	lw	s2, 148(sp)
	slli	s3, s2, 2
	add	s0, s1,s3
	sw	s0, 140(sp)
	call	getInt
	sw	a0, 136(sp)
	lw	s0, 136(sp)
	lw	s1, 140(sp)
	sw	s0, 0(s1)
	j	.main_3
.main_3:
	lw	s0, 168(sp)
	sw	s0, 132(sp)
	lw	s0, 132(sp)
	li	s1, 1
	add	s2, s0,s1
	sw	s2, 128(sp)
	lw	s0, 128(sp)
	sw	s0, 168(sp)
	j	.main_1
.main_4:
	li	s0, 0
	sw	s0, 168(sp)
	j	.main_5
.main_5:
	lw	s0, 168(sp)
	sw	s0, 124(sp)
	lw	s0, 212(sp)
	sw	s0, 120(sp)
	lw	s0, 124(sp)
	lw	s1, 120(sp)
	sub	s2, s0,s1
	sltz	s4, s2
	sw	s4, 116(sp)
	lw	s0, 116(sp)
	li	s1, 0
	sub	s2, s0,s1
	snez	s4, s2
	sw	s4, 112(sp)
	lw	s0, 112(sp)
	beqz s0, .main_8
.main_6:
	lw	s0, 168(sp)
	sw	s0, 108(sp)
	lw	s0, 172(sp)
	sw	s0, 104(sp)
	lw	s1, 104(sp)
	lw	s2, 108(sp)
	slli	s3, s2, 2
	add	s0, s1,s3
	sw	s0, 100(sp)
	lw	s1, 100(sp)
	lw	s0, 0(s1)
	sw	s0, 96(sp)
	lw	a0, 96(sp)
	call	toString
	sw	a0, 92(sp)
	la	s0, .str.0
	sw	s0, 88(sp)
	lw	a0, 92(sp)
	lw	a1, 88(sp)
	call	string_add
	sw	a0, 84(sp)
	lw	a0, 84(sp)
	call	print
	j	.main_7
.main_7:
	lw	s0, 168(sp)
	sw	s0, 80(sp)
	lw	s0, 80(sp)
	li	s1, 1
	add	s2, s0,s1
	sw	s2, 76(sp)
	lw	s0, 76(sp)
	sw	s0, 168(sp)
	j	.main_5
.main_8:
	la	s0, .str.1
	sw	s0, 72(sp)
	lw	a0, 72(sp)
	call	println
	lw	s0, 172(sp)
	sw	s0, 68(sp)
	lw	a0, 68(sp)
	call	bubble_sort
	li	s0, 0
	sw	s0, 168(sp)
	j	.main_9
.main_9:
	lw	s0, 168(sp)
	sw	s0, 64(sp)
	lw	s0, 212(sp)
	sw	s0, 60(sp)
	lw	s0, 64(sp)
	lw	s1, 60(sp)
	sub	s2, s0,s1
	sltz	s4, s2
	sw	s4, 56(sp)
	lw	s0, 56(sp)
	li	s1, 0
	sub	s2, s0,s1
	snez	s4, s2
	sw	s4, 52(sp)
	lw	s0, 52(sp)
	beqz s0, .main_12
.main_10:
	lw	s0, 168(sp)
	sw	s0, 48(sp)
	lw	s0, 172(sp)
	sw	s0, 44(sp)
	lw	s1, 44(sp)
	lw	s2, 48(sp)
	slli	s3, s2, 2
	add	s0, s1,s3
	sw	s0, 40(sp)
	lw	s1, 40(sp)
	lw	s0, 0(s1)
	sw	s0, 36(sp)
	lw	a0, 36(sp)
	call	toString
	sw	a0, 32(sp)
	la	s0, .str.2
	sw	s0, 28(sp)
	lw	a0, 32(sp)
	lw	a1, 28(sp)
	call	string_add
	sw	a0, 24(sp)
	lw	a0, 24(sp)
	call	print
	j	.main_11
.main_11:
	lw	s0, 168(sp)
	sw	s0, 20(sp)
	lw	s0, 20(sp)
	li	s1, 1
	add	s2, s0,s1
	sw	s2, 16(sp)
	lw	s0, 16(sp)
	sw	s0, 168(sp)
	j	.main_9
.main_12:
	la	s0, .str.3
	sw	s0, 12(sp)
	lw	a0, 12(sp)
	call	println
	li	a0, 0
	lw	s0, 264(sp)
	lw	s1, 260(sp)
	lw	s2, 256(sp)
	lw	s3, 252(sp)
	lw	s4, 248(sp)
	lw	s5, 244(sp)
	lw	s6, 240(sp)
	lw	s7, 236(sp)
	lw	s8, 232(sp)
	lw	s9, 228(sp)
	lw	s10, 224(sp)
	lw	s11, 220(sp)
	lw	ra, 268(sp)
	addi	sp, sp, 272
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
	.asciz	" \00"
	.size	.str.0, 7

	.type	.str.1,@object
	.globl	.str.1
.str.1: 
	.asciz	"\00"
	.size	.str.1, 6

	.type	.str.2,@object
	.globl	.str.2
.str.2: 
	.asciz	" \00"
	.size	.str.2, 7

	.type	.str.3,@object
	.globl	.str.3
.str.3: 
	.asciz	"\00"
	.size	.str.3, 6

	.section	".note.GNU-stack","",@progbits
