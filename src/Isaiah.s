	.text
	.file Isaiah.ll
	.globl	getHash
	.p2align	2
	.type	getHash,@function
getHash:
	addi	sp, sp, -80
	sw	ra, 76(sp)
	sw	s0, 72(sp)
	sw	s1, 68(sp)
	sw	s2, 64(sp)
	sw	s3, 60(sp)
	sw	s4, 56(sp)
	sw	s5, 52(sp)
	sw	s6, 48(sp)
	sw	s7, 44(sp)
	sw	s8, 40(sp)
	sw	s9, 36(sp)
	sw	s10, 32(sp)
	sw	s11, 28(sp)
	sw	a0, 24(sp)
	lw	s0, 24(sp)
	sw	s0, 20(sp)
	lw	s0, 20(sp)
	sw	s0, 16(sp)
	lw	s0, 16(sp)
	li	s1 237
	mul	s2, s0,s1
	sw	s2, 12(sp)
	la	s1 hashsize
	lw	s0, 0(s1)
	sw	s0, 8(sp)
	lw	s0, 12(sp)
	lw	s1, 8(sp)
	rem	s2, s0,s1
	sw	s2, 4(sp)
	lw	a0, 4(sp)
	lw	s0, 72(sp)
	lw	s1, 68(sp)
	lw	s2, 64(sp)
	lw	s3, 60(sp)
	lw	s4, 56(sp)
	lw	s5, 52(sp)
	lw	s6, 48(sp)
	lw	s7, 44(sp)
	lw	s8, 40(sp)
	lw	s9, 36(sp)
	lw	s10, 32(sp)
	lw	s11, 28(sp)
	lw	ra, 76(sp)
	addi	sp, sp, 80
	ret

	.globl	put
	.p2align	2
	.type	put,@function
put:
	addi	sp, sp, -368
	sw	ra, 364(sp)
	sw	s0, 360(sp)
	sw	s1, 356(sp)
	sw	s2, 352(sp)
	sw	s3, 348(sp)
	sw	s4, 344(sp)
	sw	s5, 340(sp)
	sw	s6, 336(sp)
	sw	s7, 332(sp)
	sw	s8, 328(sp)
	sw	s9, 324(sp)
	sw	s10, 320(sp)
	sw	s11, 316(sp)
	sw	a0, 312(sp)
	sw	a1, 308(sp)
	lw	s0, 312(sp)
	sw	s0, 304(sp)
	lw	s0, 308(sp)
	sw	s0, 300(sp)
	mv	s0, zero
	sw	s0, 292(sp)
	lw	s0, 304(sp)
	sw	s0, 288(sp)
	lw	a0, 288(sp)
	call	getHash
	sw	a0, 284(sp)
	lw	s0, 284(sp)
	sw	s0, 296(sp)
	lw	s0, 296(sp)
	sw	s0, 280(sp)
	la	s1 table
	lw	s0, 0(s1)
	sw	s0, 276(sp)
	lw	s1, 276(sp)
	lw	s2, 280(sp)
	slli	s3, s2, 2
	add	s0, s1,s3
	sw	s0, 272(sp)
	lw	s1, 272(sp)
	lw	s0, 0(s1)
	sw	s0, 268(sp)
	lw	s0, 268(sp)
	mv	s1, zero
	sub	s2, s0,s1
	seqz	s4, s2
	sw	s4, 264(sp)
	lw	s0, 264(sp)
	li	s1 0
	sub	s2, s0,s1
	snez	s4, s2
	sw	s4, 260(sp)
	lw	s0, 260(sp)
	beqz s0 .put_2
.put_1:
	lw	s0, 296(sp)
	sw	s0, 256(sp)
	la	s1 table
	lw	s0, 0(s1)
	sw	s0, 252(sp)
	lw	s1, 252(sp)
	lw	s2, 256(sp)
	slli	s3, s2, 2
	add	s0, s1,s3
	sw	s0, 248(sp)
	li	a0 12
	call	malloc
	sw	a0, 240(sp)
	lw	s0, 240(sp)
	sw	s0, 236(sp)
	lw	a0, 236(sp)
	call	node
	lw	s0, 236(sp)
	sw	s0, 244(sp)
	lw	s0, 244(sp)
	sw	s0, 232(sp)
	lw	s0, 232(sp)
	lw	s1, 248(sp)
	sw	s0, 0(s1)
	lw	s0, 296(sp)
	sw	s0, 228(sp)
	la	s1 table
	lw	s0, 0(s1)
	sw	s0, 224(sp)
	lw	s1, 224(sp)
	lw	s2, 228(sp)
	slli	s3, s2, 2
	add	s0, s1,s3
	sw	s0, 220(sp)
	lw	s1, 220(sp)
	lw	s0, 0(s1)
	sw	s0, 216(sp)
	lw	s1, 216(sp)
	li	s2 0
	add	s0, s1,s2
	sw	s0, 212(sp)
	lw	s0, 304(sp)
	sw	s0, 208(sp)
	lw	s0, 208(sp)
	lw	s1, 212(sp)
	sw	s0, 0(s1)
	lw	s0, 296(sp)
	sw	s0, 204(sp)
	la	s1 table
	lw	s0, 0(s1)
	sw	s0, 200(sp)
	lw	s1, 200(sp)
	lw	s2, 204(sp)
	slli	s3, s2, 2
	add	s0, s1,s3
	sw	s0, 196(sp)
	lw	s1, 196(sp)
	lw	s0, 0(s1)
	sw	s0, 192(sp)
	lw	s1, 192(sp)
	li	s2 4
	add	s0, s1,s2
	sw	s0, 188(sp)
	lw	s0, 300(sp)
	sw	s0, 184(sp)
	lw	s0, 184(sp)
	lw	s1, 188(sp)
	sw	s0, 0(s1)
	lw	s0, 296(sp)
	sw	s0, 180(sp)
	la	s1 table
	lw	s0, 0(s1)
	sw	s0, 176(sp)
	lw	s1, 176(sp)
	lw	s2, 180(sp)
	slli	s3, s2, 2
	add	s0, s1,s3
	sw	s0, 172(sp)
	lw	s1, 172(sp)
	lw	s0, 0(s1)
	sw	s0, 168(sp)
	lw	s1, 168(sp)
	li	s2 8
	add	s0, s1,s2
	sw	s0, 164(sp)
	mv	s0, zero
	lw	s1, 164(sp)
	sw	s0, 0(s1)
	lw	s0, 360(sp)
	lw	s1, 356(sp)
	lw	s2, 352(sp)
	lw	s3, 348(sp)
	lw	s4, 344(sp)
	lw	s5, 340(sp)
	lw	s6, 336(sp)
	lw	s7, 332(sp)
	lw	s8, 328(sp)
	lw	s9, 324(sp)
	lw	s10, 320(sp)
	lw	s11, 316(sp)
	lw	ra, 364(sp)
	addi	sp, sp, 368
	ret
.put_2:
	lw	s0, 296(sp)
	sw	s0, 160(sp)
	la	s1 table
	lw	s0, 0(s1)
	sw	s0, 156(sp)
	lw	s1, 156(sp)
	lw	s2, 160(sp)
	slli	s3, s2, 2
	add	s0, s1,s3
	sw	s0, 152(sp)
	lw	s1, 152(sp)
	lw	s0, 0(s1)
	sw	s0, 148(sp)
	lw	s0, 148(sp)
	sw	s0, 292(sp)
	j	.put_3
.put_3:
	lw	s0, 292(sp)
	sw	s0, 144(sp)
	lw	s1, 144(sp)
	li	s2 0
	add	s0, s1,s2
	sw	s0, 140(sp)
	lw	s1, 140(sp)
	lw	s0, 0(s1)
	sw	s0, 136(sp)
	lw	s0, 304(sp)
	sw	s0, 132(sp)
	lw	s0, 136(sp)
	lw	s1, 132(sp)
	sub	s2, s0,s1
	snez	s4, s2
	sw	s4, 128(sp)
	lw	s0, 128(sp)
	li	s1 0
	sub	s2, s0,s1
	snez	s4, s2
	sw	s4, 124(sp)
	lw	s0, 124(sp)
	beqz s0 .put_7
.put_4:
	lw	s0, 292(sp)
	sw	s0, 120(sp)
	lw	s1, 120(sp)
	li	s2 8
	add	s0, s1,s2
	sw	s0, 116(sp)
	lw	s1, 116(sp)
	lw	s0, 0(s1)
	sw	s0, 112(sp)
	lw	s0, 112(sp)
	mv	s1, zero
	sub	s2, s0,s1
	seqz	s4, s2
	sw	s4, 108(sp)
	lw	s0, 108(sp)
	li	s1 0
	sub	s2, s0,s1
	snez	s4, s2
	sw	s4, 104(sp)
	lw	s0, 104(sp)
	beqz s0 .put_6
.put_5:
	lw	s0, 292(sp)
	sw	s0, 100(sp)
	lw	s1, 100(sp)
	li	s2 8
	add	s0, s1,s2
	sw	s0, 96(sp)
	li	a0 12
	call	malloc
	sw	a0, 88(sp)
	lw	s0, 88(sp)
	sw	s0, 84(sp)
	lw	a0, 84(sp)
	call	node
	lw	s0, 84(sp)
	sw	s0, 92(sp)
	lw	s0, 92(sp)
	sw	s0, 80(sp)
	lw	s0, 80(sp)
	lw	s1, 96(sp)
	sw	s0, 0(s1)
	lw	s0, 292(sp)
	sw	s0, 76(sp)
	lw	s1, 76(sp)
	li	s2 8
	add	s0, s1,s2
	sw	s0, 72(sp)
	lw	s1, 72(sp)
	lw	s0, 0(s1)
	sw	s0, 68(sp)
	lw	s1, 68(sp)
	li	s2 0
	add	s0, s1,s2
	sw	s0, 64(sp)
	lw	s0, 304(sp)
	sw	s0, 60(sp)
	lw	s0, 60(sp)
	lw	s1, 64(sp)
	sw	s0, 0(s1)
	lw	s0, 292(sp)
	sw	s0, 56(sp)
	lw	s1, 56(sp)
	li	s2 8
	add	s0, s1,s2
	sw	s0, 52(sp)
	lw	s1, 52(sp)
	lw	s0, 0(s1)
	sw	s0, 48(sp)
	lw	s1, 48(sp)
	li	s2 8
	add	s0, s1,s2
	sw	s0, 44(sp)
	mv	s0, zero
	lw	s1, 44(sp)
	sw	s0, 0(s1)
	j	.put_6
.put_6:
	lw	s0, 292(sp)
	sw	s0, 40(sp)
	lw	s1, 40(sp)
	li	s2 8
	add	s0, s1,s2
	sw	s0, 36(sp)
	lw	s1, 36(sp)
	lw	s0, 0(s1)
	sw	s0, 32(sp)
	lw	s0, 32(sp)
	sw	s0, 292(sp)
	j	.put_3
.put_7:
	lw	s0, 292(sp)
	sw	s0, 28(sp)
	lw	s1, 28(sp)
	li	s2 4
	add	s0, s1,s2
	sw	s0, 24(sp)
	lw	s0, 300(sp)
	sw	s0, 20(sp)
	lw	s0, 20(sp)
	lw	s1, 24(sp)
	sw	s0, 0(s1)
	lw	s0, 360(sp)
	lw	s1, 356(sp)
	lw	s2, 352(sp)
	lw	s3, 348(sp)
	lw	s4, 344(sp)
	lw	s5, 340(sp)
	lw	s6, 336(sp)
	lw	s7, 332(sp)
	lw	s8, 328(sp)
	lw	s9, 324(sp)
	lw	s10, 320(sp)
	lw	s11, 316(sp)
	lw	ra, 364(sp)
	addi	sp, sp, 368
	ret

	.globl	get
	.p2align	2
	.type	get,@function
get:
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
	sw	a0, 88(sp)
	lw	s0, 88(sp)
	sw	s0, 84(sp)
	mv	s0, zero
	sw	s0, 80(sp)
	lw	s0, 84(sp)
	sw	s0, 76(sp)
	lw	a0, 76(sp)
	call	getHash
	sw	a0, 72(sp)
	la	s1 table
	lw	s0, 0(s1)
	sw	s0, 68(sp)
	lw	s1, 68(sp)
	lw	s2, 72(sp)
	slli	s3, s2, 2
	add	s0, s1,s3
	sw	s0, 64(sp)
	lw	s1, 64(sp)
	lw	s0, 0(s1)
	sw	s0, 60(sp)
	lw	s0, 60(sp)
	sw	s0, 80(sp)
	j	.get_1
.get_1:
	lw	s0, 80(sp)
	sw	s0, 56(sp)
	lw	s1, 56(sp)
	li	s2 0
	add	s0, s1,s2
	sw	s0, 52(sp)
	lw	s1, 52(sp)
	lw	s0, 0(s1)
	sw	s0, 48(sp)
	lw	s0, 84(sp)
	sw	s0, 44(sp)
	lw	s0, 48(sp)
	lw	s1, 44(sp)
	sub	s2, s0,s1
	snez	s4, s2
	sw	s4, 40(sp)
	lw	s0, 40(sp)
	li	s1 0
	sub	s2, s0,s1
	snez	s4, s2
	sw	s4, 36(sp)
	lw	s0, 36(sp)
	beqz s0 .get_3
.get_2:
	lw	s0, 80(sp)
	sw	s0, 32(sp)
	lw	s1, 32(sp)
	li	s2 8
	add	s0, s1,s2
	sw	s0, 28(sp)
	lw	s1, 28(sp)
	lw	s0, 0(s1)
	sw	s0, 24(sp)
	lw	s0, 24(sp)
	sw	s0, 80(sp)
	j	.get_1
.get_3:
	lw	s0, 80(sp)
	sw	s0, 20(sp)
	lw	s1, 20(sp)
	li	s2 4
	add	s0, s1,s2
	sw	s0, 16(sp)
	lw	s1, 16(sp)
	lw	s0, 0(s1)
	sw	s0, 12(sp)
	lw	a0, 12(sp)
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

	.globl	main
	.p2align	2
	.type	main,@function
main:
	addi	sp, sp, -208
	sw	ra, 204(sp)
	sw	s0, 200(sp)
	sw	s1, 196(sp)
	sw	s2, 192(sp)
	sw	s3, 188(sp)
	sw	s4, 184(sp)
	sw	s5, 180(sp)
	sw	s6, 176(sp)
	sw	s7, 172(sp)
	sw	s8, 168(sp)
	sw	s9, 164(sp)
	sw	s10, 160(sp)
	sw	s11, 156(sp)
	call	global_var_init
	li	s0 400
	li	s1 4
	add	s2, s0,s1
	sw	s2, 148(sp)
	lw	a0, 148(sp)
	call	malloc
	sw	a0, 144(sp)
	lw	s0, 144(sp)
	sw	s0, 140(sp)
	li	s0 100
	lw	s1, 140(sp)
	sw	s0, 0(s1)
	lw	s1, 144(sp)
	li	s2 4
	add	s0, s1,s2
	sw	s0, 136(sp)
	lw	s0, 136(sp)
	sw	s0, 132(sp)
	lw	s0, 132(sp)
	sw	s0, 128(sp)
	lw	s0, 128(sp)
	sw	s0, 124(sp)
	lw	s0, 124(sp)
	la	s1 table
	sw	s0, 0(s1)
	li	s0 0
	sw	s0, 152(sp)
	j	.main_1
.main_1:
	lw	s0, 152(sp)
	sw	s0, 120(sp)
	la	s1 hashsize
	lw	s0, 0(s1)
	sw	s0, 116(sp)
	lw	s0, 120(sp)
	lw	s1, 116(sp)
	sub	s2, s0,s1
	sltz	s4, s2
	sw	s4, 112(sp)
	lw	s0, 112(sp)
	li	s1 0
	sub	s2, s0,s1
	snez	s4, s2
	sw	s4, 108(sp)
	lw	s0, 108(sp)
	beqz s0 .main_4
.main_2:
	lw	s0, 152(sp)
	sw	s0, 104(sp)
	la	s1 table
	lw	s0, 0(s1)
	sw	s0, 100(sp)
	lw	s1, 100(sp)
	lw	s2, 104(sp)
	slli	s3, s2, 2
	add	s0, s1,s3
	sw	s0, 96(sp)
	mv	s0, zero
	lw	s1, 96(sp)
	sw	s0, 0(s1)
	j	.main_3
.main_3:
	lw	s0, 152(sp)
	sw	s0, 92(sp)
	lw	s0, 92(sp)
	li	s1 1
	add	s2, s0,s1
	sw	s2, 88(sp)
	lw	s0, 88(sp)
	sw	s0, 152(sp)
	j	.main_1
.main_4:
	li	s0 0
	sw	s0, 152(sp)
	j	.main_5
.main_5:
	lw	s0, 152(sp)
	sw	s0, 84(sp)
	lw	s0, 84(sp)
	li	s1 1000
	sub	s2, s0,s1
	sltz	s4, s2
	sw	s4, 80(sp)
	lw	s0, 80(sp)
	li	s1 0
	sub	s2, s0,s1
	snez	s4, s2
	sw	s4, 76(sp)
	lw	s0, 76(sp)
	beqz s0 .main_8
.main_6:
	lw	s0, 152(sp)
	sw	s0, 72(sp)
	lw	s0, 152(sp)
	sw	s0, 68(sp)
	lw	a0, 72(sp)
	lw	a1, 68(sp)
	call	put
	j	.main_7
.main_7:
	lw	s0, 152(sp)
	sw	s0, 64(sp)
	lw	s0, 64(sp)
	li	s1 1
	add	s2, s0,s1
	sw	s2, 60(sp)
	lw	s0, 60(sp)
	sw	s0, 152(sp)
	j	.main_5
.main_8:
	li	s0 0
	sw	s0, 152(sp)
	j	.main_9
.main_9:
	lw	s0, 152(sp)
	sw	s0, 56(sp)
	lw	s0, 56(sp)
	li	s1 1000
	sub	s2, s0,s1
	sltz	s4, s2
	sw	s4, 52(sp)
	lw	s0, 52(sp)
	li	s1 0
	sub	s2, s0,s1
	snez	s4, s2
	sw	s4, 48(sp)
	lw	s0, 48(sp)
	beqz s0 .main_12
.main_10:
	lw	s0, 152(sp)
	sw	s0, 44(sp)
	lw	a0, 44(sp)
	call	toString
	sw	a0, 40(sp)
	la	s0 .str.0
	sw	s0, 36(sp)
	lw	a0, 40(sp)
	lw	a1, 36(sp)
	call	string_add
	sw	a0, 32(sp)
	lw	s0, 152(sp)
	sw	s0, 28(sp)
	lw	a0, 28(sp)
	call	get
	sw	a0, 24(sp)
	lw	a0, 24(sp)
	call	toString
	sw	a0, 20(sp)
	lw	a0, 32(sp)
	lw	a1, 20(sp)
	call	string_add
	sw	a0, 16(sp)
	lw	a0, 16(sp)
	call	println
	j	.main_11
.main_11:
	lw	s0, 152(sp)
	sw	s0, 12(sp)
	lw	s0, 12(sp)
	li	s1 1
	add	s2, s0,s1
	sw	s2, 8(sp)
	lw	s0, 8(sp)
	sw	s0, 152(sp)
	j	.main_9
.main_12:
	li	a0 0
	lw	s0, 200(sp)
	lw	s1, 196(sp)
	lw	s2, 192(sp)
	lw	s3, 188(sp)
	lw	s4, 184(sp)
	lw	s5, 180(sp)
	lw	s6, 176(sp)
	lw	s7, 172(sp)
	lw	s8, 168(sp)
	lw	s9, 164(sp)
	lw	s10, 160(sp)
	lw	s11, 156(sp)
	lw	ra, 204(sp)
	addi	sp, sp, 208
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
	li	s0 100
	la	s1 hashsize
	sw	s0, 0(s1)
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

	.globl	node
	.p2align	2
	.type	node,@function
node:
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
	sw	a0, 8(sp)
	lw	s0, 8(sp)
	sw	s0, 4(sp)
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
	.type	hashsize,@object
	.globl	hashsize
hashsize:
	.word	0
	.size	hashsize, 4

	.type	table,@object
	.globl	table
table:
	.word	0
	.size	table, 4


	.section	.rodata,"a",@progbits
	.type	.str.0,@object
	.globl	.str.0
.str.0: 
	.asciz	" \00"
	.size	.str.0, 7

	.section	".note.GNU-stack","",@progbits
