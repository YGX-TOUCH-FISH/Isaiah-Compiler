	.text
	.file Isaiah.ll
	.globl	main
	.p2align	2
	.type	main,@function
main:
	addi	sp, sp, -352
	sw	ra, 348(sp)
	sw	s0, 344(sp)
	sw	s1, 340(sp)
	sw	s2, 336(sp)
	sw	s3, 332(sp)
	sw	s4, 328(sp)
	sw	s5, 324(sp)
	sw	s6, 320(sp)
	sw	s7, 316(sp)
	sw	s8, 312(sp)
	sw	s9, 308(sp)
	sw	s10, 304(sp)
	sw	s11, 300(sp)
	call	global_var_init
	li	s0 10000
	sw	s0, 296(sp)
	li	s0 0
	sw	s0, 292(sp)
	li	s0 2800
	sw	s0, 288(sp)
	li	s0 0
	sw	s0, 284(sp)
	li	s0 0
	sw	s0, 280(sp)
	li	s0 11204
	li	s1 4
	add	s2, s0,s1
	sw	s2, 276(sp)
	lw	a0, 276(sp)
	call	malloc
	sw	a0, 272(sp)
	lw	s0, 272(sp)
	sw	s0, 268(sp)
	li	s0 2801
	lw	s1, 268(sp)
	sw	s0, 0(s1)
	lw	s1, 272(sp)
	li	s2 4
	add	s0, s1,s2
	sw	s0, 264(sp)
	lw	s0, 264(sp)
	sw	s0, 260(sp)
	lw	s0, 260(sp)
	sw	s0, 256(sp)
	lw	s0, 256(sp)
	sw	s0, 252(sp)
	lw	s0, 252(sp)
	sw	s0, 248(sp)
	li	s0 0
	sw	s0, 244(sp)
	j	.main_1
.main_1:
	lw	s0, 292(sp)
	sw	s0, 240(sp)
	lw	s0, 288(sp)
	sw	s0, 236(sp)
	lw	s0, 240(sp)
	lw	s1, 236(sp)
	sub	s2, s0,s1
	sw	s2, 232(sp)
	lw	s0, 232(sp)
	li	s1 0
	sub	s2, s0,s1
	snez	s4, s2
	sw	s4, 228(sp)
	lw	s0, 228(sp)
	li	s1 0
	sub	s2, s0,s1
	snez	s4, s2
	sw	s4, 224(sp)
	lw	s0, 224(sp)
	beqz s0 .main_4
.main_2:
	lw	s0, 292(sp)
	sw	s0, 220(sp)
	lw	s0, 248(sp)
	sw	s0, 216(sp)
	lw	s1, 216(sp)
	lw	s2, 220(sp)
	slli	s3, s2, 2
	add	s0, s1,s3
	sw	s0, 212(sp)
	lw	s0, 296(sp)
	sw	s0, 208(sp)
	lw	s0, 208(sp)
	li	s1 5
	div	s2, s0,s1
	sw	s2, 204(sp)
	lw	s0, 204(sp)
	lw	s1, 212(sp)
	sw	s0, 0(s1)
	j	.main_3
.main_3:
	lw	s0, 292(sp)
	sw	s0, 200(sp)
	lw	s0, 200(sp)
	li	s1 1
	add	s2, s0,s1
	sw	s2, 196(sp)
	lw	s0, 196(sp)
	sw	s0, 292(sp)
	j	.main_1
.main_4:
	j	.main_5
.main_5:
	j	.main_6
.main_6:
	li	s0 0
	sw	s0, 284(sp)
	lw	s0, 288(sp)
	sw	s0, 192(sp)
	lw	s0, 192(sp)
	li	s1 2
	mul	s2, s0,s1
	sw	s2, 188(sp)
	lw	s0, 188(sp)
	sw	s0, 244(sp)
	lw	s0, 244(sp)
	sw	s0, 184(sp)
	lw	s0, 184(sp)
	li	s1 0
	sub	s2, s0,s1
	seqz	s4, s2
	sw	s4, 180(sp)
	lw	s0, 180(sp)
	li	s1 0
	sub	s2, s0,s1
	snez	s4, s2
	sw	s4, 176(sp)
	lw	s0, 176(sp)
	beqz s0 .main_8
.main_7:
	j	.main_16
.main_8:
	lw	s0, 288(sp)
	sw	s0, 172(sp)
	lw	s0, 172(sp)
	sw	s0, 292(sp)
	j	.main_9
.main_9:
	j	.main_10
.main_10:
	lw	s0, 292(sp)
	sw	s0, 168(sp)
	lw	s0, 248(sp)
	sw	s0, 164(sp)
	lw	s1, 164(sp)
	lw	s2, 168(sp)
	slli	s3, s2, 2
	add	s0, s1,s3
	sw	s0, 160(sp)
	lw	s1, 160(sp)
	lw	s0, 0(s1)
	sw	s0, 156(sp)
	lw	s0, 296(sp)
	sw	s0, 152(sp)
	lw	s0, 156(sp)
	lw	s1, 152(sp)
	mul	s2, s0,s1
	sw	s2, 148(sp)
	lw	s0, 284(sp)
	sw	s0, 144(sp)
	lw	s0, 144(sp)
	lw	s1, 148(sp)
	add	s2, s0,s1
	sw	s2, 140(sp)
	lw	s0, 140(sp)
	sw	s0, 284(sp)
	lw	s0, 292(sp)
	sw	s0, 136(sp)
	lw	s0, 248(sp)
	sw	s0, 132(sp)
	lw	s1, 132(sp)
	lw	s2, 136(sp)
	slli	s3, s2, 2
	add	s0, s1,s3
	sw	s0, 128(sp)
	lw	s0, 244(sp)
	sw	s0, 124(sp)
	lw	s0, 124(sp)
	li	s1 1
	sub	s2, s0,s1
	sw	s2, 120(sp)
	lw	s0, 120(sp)
	sw	s0, 244(sp)
	lw	s0, 284(sp)
	sw	s0, 116(sp)
	lw	s0, 244(sp)
	sw	s0, 112(sp)
	lw	s0, 116(sp)
	lw	s1, 112(sp)
	rem	s2, s0,s1
	sw	s2, 108(sp)
	lw	s0, 108(sp)
	lw	s1, 128(sp)
	sw	s0, 0(s1)
	lw	s0, 284(sp)
	sw	s0, 104(sp)
	lw	s0, 244(sp)
	sw	s0, 100(sp)
	lw	s0, 104(sp)
	lw	s1, 100(sp)
	div	s2, s0,s1
	sw	s2, 96(sp)
	lw	s0, 96(sp)
	sw	s0, 284(sp)
	lw	s0, 244(sp)
	sw	s0, 92(sp)
	lw	s0, 92(sp)
	li	s1 1
	sub	s2, s0,s1
	sw	s2, 88(sp)
	lw	s0, 88(sp)
	sw	s0, 244(sp)
	lw	s0, 292(sp)
	sw	s0, 84(sp)
	lw	s0, 84(sp)
	li	s1 1
	sub	s2, s0,s1
	sw	s2, 80(sp)
	lw	s0, 80(sp)
	sw	s0, 292(sp)
	lw	s0, 292(sp)
	sw	s0, 76(sp)
	lw	s0, 76(sp)
	li	s1 0
	sub	s2, s0,s1
	seqz	s4, s2
	sw	s4, 72(sp)
	lw	s0, 72(sp)
	li	s1 0
	sub	s2, s0,s1
	snez	s4, s2
	sw	s4, 68(sp)
	lw	s0, 68(sp)
	beqz s0 .main_12
.main_11:
	j	.main_14
.main_12:
	j	.main_13
.main_13:
	lw	s0, 284(sp)
	sw	s0, 64(sp)
	lw	s0, 292(sp)
	sw	s0, 60(sp)
	lw	s0, 64(sp)
	lw	s1, 60(sp)
	mul	s2, s0,s1
	sw	s2, 56(sp)
	lw	s0, 56(sp)
	sw	s0, 284(sp)
	j	.main_9
.main_14:
	lw	s0, 288(sp)
	sw	s0, 52(sp)
	lw	s0, 52(sp)
	li	s1 14
	sub	s2, s0,s1
	sw	s2, 48(sp)
	lw	s0, 48(sp)
	sw	s0, 288(sp)
	lw	s0, 284(sp)
	sw	s0, 44(sp)
	lw	s0, 296(sp)
	sw	s0, 40(sp)
	lw	s0, 44(sp)
	lw	s1, 40(sp)
	div	s2, s0,s1
	sw	s2, 36(sp)
	lw	s0, 280(sp)
	sw	s0, 32(sp)
	lw	s0, 32(sp)
	lw	s1, 36(sp)
	add	s2, s0,s1
	sw	s2, 28(sp)
	lw	a0, 28(sp)
	call	toString
	sw	a0, 24(sp)
	lw	a0, 24(sp)
	call	print
	j	.main_15
.main_15:
	lw	s0, 284(sp)
	sw	s0, 20(sp)
	lw	s0, 296(sp)
	sw	s0, 16(sp)
	lw	s0, 20(sp)
	lw	s1, 16(sp)
	rem	s2, s0,s1
	sw	s2, 12(sp)
	lw	s0, 12(sp)
	sw	s0, 280(sp)
	j	.main_5
.main_16:
	la	s0 .str.0
	sw	s0, 8(sp)
	lw	a0, 8(sp)
	call	print
	li	a0 0
	lw	s0, 344(sp)
	lw	s1, 340(sp)
	lw	s2, 336(sp)
	lw	s3, 332(sp)
	lw	s4, 328(sp)
	lw	s5, 324(sp)
	lw	s6, 320(sp)
	lw	s7, 316(sp)
	lw	s8, 312(sp)
	lw	s9, 308(sp)
	lw	s10, 304(sp)
	lw	s11, 300(sp)
	lw	ra, 348(sp)
	addi	sp, sp, 352
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
	.asciz	"\0A\00"
	.size	.str.0, 9

	.section	".note.GNU-stack","",@progbits
