	.text
	.file Isaiah.ll
	.globl	exchange
	.p2align	2
	.type	exchange,@function
exchange:
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
	sw	a1, 84(sp)
	lw	s0, 88(sp)
	sw	s0, 80(sp)
	lw	s0, 84(sp)
	sw	s0, 76(sp)
	lw	s0, 80(sp)
	sw	s0, 72(sp)
	la	s1 a
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
	sw	s0, 56(sp)
	lw	s0, 80(sp)
	sw	s0, 52(sp)
	la	s1 a
	lw	s0, 0(s1)
	sw	s0, 48(sp)
	lw	s1, 48(sp)
	lw	s2, 52(sp)
	slli	s3, s2, 2
	add	s0, s1,s3
	sw	s0, 44(sp)
	lw	s0, 76(sp)
	sw	s0, 40(sp)
	la	s1 a
	lw	s0, 0(s1)
	sw	s0, 36(sp)
	lw	s1, 36(sp)
	lw	s2, 40(sp)
	slli	s3, s2, 2
	add	s0, s1,s3
	sw	s0, 32(sp)
	lw	s1, 32(sp)
	lw	s0, 0(s1)
	sw	s0, 28(sp)
	lw	s0, 28(sp)
	lw	s1, 44(sp)
	sw	s0, 0(s1)
	lw	s0, 76(sp)
	sw	s0, 24(sp)
	la	s1 a
	lw	s0, 0(s1)
	sw	s0, 20(sp)
	lw	s1, 20(sp)
	lw	s2, 24(sp)
	slli	s3, s2, 2
	add	s0, s1,s3
	sw	s0, 16(sp)
	lw	s0, 56(sp)
	sw	s0, 12(sp)
	lw	s0, 12(sp)
	lw	s1, 16(sp)
	sw	s0, 0(s1)
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

	.globl	makeHeap
	.p2align	2
	.type	makeHeap,@function
makeHeap:
	addi	sp, sp, -256
	sw	ra, 252(sp)
	sw	s0, 248(sp)
	sw	s1, 244(sp)
	sw	s2, 240(sp)
	sw	s3, 236(sp)
	sw	s4, 232(sp)
	sw	s5, 228(sp)
	sw	s6, 224(sp)
	sw	s7, 220(sp)
	sw	s8, 216(sp)
	sw	s9, 212(sp)
	sw	s10, 208(sp)
	sw	s11, 204(sp)
	la	s1 n
	lw	s0, 0(s1)
	sw	s0, 188(sp)
	lw	s0, 188(sp)
	li	s1 1
	sub	s2, s0,s1
	sw	s2, 184(sp)
	lw	s0, 184(sp)
	li	s1 2
	div	s2, s0,s1
	sw	s2, 180(sp)
	lw	s0, 180(sp)
	sw	s0, 200(sp)
	li	s0 0
	sw	s0, 196(sp)
	li	s0 0
	sw	s0, 192(sp)
	j	.makeHeap_1
.makeHeap_1:
	lw	s0, 200(sp)
	sw	s0, 176(sp)
	lw	s0, 176(sp)
	li	s1 0
	sub	s2, s0,s1
	sltz	s3, s2
	seqz	s4, s3
	sw	s4, 172(sp)
	lw	s0, 172(sp)
	li	s1 0
	sub	s2, s0,s1
	snez	s4, s2
	sw	s4, 168(sp)
	lw	s0, 168(sp)
	beqz s0 .makeHeap_9
.makeHeap_2:
	lw	s0, 200(sp)
	sw	s0, 164(sp)
	lw	s0, 164(sp)
	li	s1 2
	mul	s2, s0,s1
	sw	s2, 160(sp)
	lw	s0, 160(sp)
	sw	s0, 192(sp)
	lw	s0, 200(sp)
	sw	s0, 156(sp)
	lw	s0, 156(sp)
	li	s1 2
	mul	s2, s0,s1
	sw	s2, 152(sp)
	lw	s0, 152(sp)
	li	s1 1
	add	s2, s0,s1
	sw	s2, 148(sp)
	la	s1 n
	lw	s0, 0(s1)
	sw	s0, 144(sp)
	lw	s0, 148(sp)
	lw	s1, 144(sp)
	sub	s2, s0,s1
	sltz	s4, s2
	sw	s4, 140(sp)
	lw	s0, 140(sp)
	li	s1 0
	sub	s2, s0,s1
	snez	s4, s2
	sw	s4, 136(sp)
	lw	s0, 136(sp)
	li	s1 0
	beqz s0 .makeHeap_4
.makeHeap_3:
	lw	s0, 200(sp)
	sw	s0, 132(sp)
	lw	s0, 132(sp)
	li	s1 2
	mul	s2, s0,s1
	sw	s2, 128(sp)
	lw	s0, 128(sp)
	li	s1 1
	add	s2, s0,s1
	sw	s2, 124(sp)
	la	s1 a
	lw	s0, 0(s1)
	sw	s0, 120(sp)
	lw	s1, 120(sp)
	lw	s2, 124(sp)
	slli	s3, s2, 2
	add	s0, s1,s3
	sw	s0, 116(sp)
	lw	s0, 200(sp)
	sw	s0, 112(sp)
	lw	s0, 112(sp)
	li	s1 2
	mul	s2, s0,s1
	sw	s2, 108(sp)
	la	s1 a
	lw	s0, 0(s1)
	sw	s0, 104(sp)
	lw	s1, 104(sp)
	lw	s2, 108(sp)
	slli	s3, s2, 2
	add	s0, s1,s3
	sw	s0, 100(sp)
	lw	s1, 116(sp)
	lw	s0, 0(s1)
	sw	s0, 96(sp)
	lw	s1, 100(sp)
	lw	s0, 0(s1)
	sw	s0, 92(sp)
	lw	s0, 96(sp)
	lw	s1, 92(sp)
	sub	s2, s0,s1
	sltz	s4, s2
	sw	s4, 88(sp)
	lw	s0, 88(sp)
	li	s1 0
	sub	s2, s0,s1
	snez	s4, s2
	sw	s4, 84(sp)
	li	s2 84
	add	s3, sp,s2
	lw	s1, 0(s3)
	j	.makeHeap_4
.makeHeap_4:
	sw	s1, 80(sp)
	lw	s0, 80(sp)
	li	s1 0
	sub	s2, s0,s1
	snez	s4, s2
	sw	s4, 76(sp)
	lw	s0, 76(sp)
	beqz s0 .makeHeap_6
.makeHeap_5:
	lw	s0, 200(sp)
	sw	s0, 72(sp)
	lw	s0, 72(sp)
	li	s1 2
	mul	s2, s0,s1
	sw	s2, 68(sp)
	lw	s0, 68(sp)
	li	s1 1
	add	s2, s0,s1
	sw	s2, 64(sp)
	lw	s0, 64(sp)
	sw	s0, 192(sp)
	j	.makeHeap_6
.makeHeap_6:
	lw	s0, 200(sp)
	sw	s0, 60(sp)
	la	s1 a
	lw	s0, 0(s1)
	sw	s0, 56(sp)
	lw	s1, 56(sp)
	lw	s2, 60(sp)
	slli	s3, s2, 2
	add	s0, s1,s3
	sw	s0, 52(sp)
	lw	s0, 192(sp)
	sw	s0, 48(sp)
	la	s1 a
	lw	s0, 0(s1)
	sw	s0, 44(sp)
	lw	s1, 44(sp)
	lw	s2, 48(sp)
	slli	s3, s2, 2
	add	s0, s1,s3
	sw	s0, 40(sp)
	lw	s1, 52(sp)
	lw	s0, 0(s1)
	sw	s0, 36(sp)
	lw	s1, 40(sp)
	lw	s0, 0(s1)
	sw	s0, 32(sp)
	lw	s0, 36(sp)
	lw	s1, 32(sp)
	sub	s2, s0,s1
	sgtz	s4, s2
	sw	s4, 28(sp)
	lw	s0, 28(sp)
	li	s1 0
	sub	s2, s0,s1
	snez	s4, s2
	sw	s4, 24(sp)
	lw	s0, 24(sp)
	beqz s0 .makeHeap_8
.makeHeap_7:
	lw	s0, 200(sp)
	sw	s0, 20(sp)
	lw	s0, 192(sp)
	sw	s0, 16(sp)
	lw	a0, 20(sp)
	lw	a1, 16(sp)
	call	exchange
	j	.makeHeap_8
.makeHeap_8:
	lw	s0, 200(sp)
	sw	s0, 12(sp)
	lw	s0, 12(sp)
	li	s1 1
	sub	s2, s0,s1
	sw	s2, 8(sp)
	lw	s0, 8(sp)
	sw	s0, 200(sp)
	j	.makeHeap_1
.makeHeap_9:
	li	a0 0
	lw	s0, 248(sp)
	lw	s1, 244(sp)
	lw	s2, 240(sp)
	lw	s3, 236(sp)
	lw	s4, 232(sp)
	lw	s5, 228(sp)
	lw	s6, 224(sp)
	lw	s7, 220(sp)
	lw	s8, 216(sp)
	lw	s9, 212(sp)
	lw	s10, 208(sp)
	lw	s11, 204(sp)
	lw	ra, 252(sp)
	addi	sp, sp, 256
	ret

	.globl	adjustHeap
	.p2align	2
	.type	adjustHeap,@function
adjustHeap:
	addi	sp, sp, -320
	sw	ra, 316(sp)
	sw	s0, 312(sp)
	sw	s1, 308(sp)
	sw	s2, 304(sp)
	sw	s3, 300(sp)
	sw	s4, 296(sp)
	sw	s5, 292(sp)
	sw	s6, 288(sp)
	sw	s7, 284(sp)
	sw	s8, 280(sp)
	sw	s9, 276(sp)
	sw	s10, 272(sp)
	sw	s11, 268(sp)
	sw	a0, 264(sp)
	lw	s0, 264(sp)
	sw	s0, 260(sp)
	li	s0 0
	sw	s0, 256(sp)
	li	s0 0
	sw	s0, 252(sp)
	li	s0 0
	sw	s0, 248(sp)
	j	.adjustHeap_1
.adjustHeap_1:
	lw	s0, 256(sp)
	sw	s0, 244(sp)
	lw	s0, 244(sp)
	li	s1 2
	mul	s2, s0,s1
	sw	s2, 240(sp)
	lw	s0, 260(sp)
	sw	s0, 236(sp)
	lw	s0, 240(sp)
	lw	s1, 236(sp)
	sub	s2, s0,s1
	sltz	s4, s2
	sw	s4, 232(sp)
	lw	s0, 232(sp)
	li	s1 0
	sub	s2, s0,s1
	snez	s4, s2
	sw	s4, 228(sp)
	lw	s0, 228(sp)
	beqz s0 .adjustHeap_10
.adjustHeap_2:
	lw	s0, 256(sp)
	sw	s0, 224(sp)
	lw	s0, 224(sp)
	li	s1 2
	mul	s2, s0,s1
	sw	s2, 220(sp)
	lw	s0, 220(sp)
	sw	s0, 252(sp)
	lw	s0, 256(sp)
	sw	s0, 216(sp)
	lw	s0, 216(sp)
	li	s1 2
	mul	s2, s0,s1
	sw	s2, 212(sp)
	lw	s0, 212(sp)
	li	s1 1
	add	s2, s0,s1
	sw	s2, 208(sp)
	lw	s0, 260(sp)
	sw	s0, 204(sp)
	lw	s0, 208(sp)
	lw	s1, 204(sp)
	sub	s2, s0,s1
	sltz	s4, s2
	sw	s4, 200(sp)
	lw	s0, 200(sp)
	li	s1 0
	sub	s2, s0,s1
	snez	s4, s2
	sw	s4, 196(sp)
	lw	s0, 196(sp)
	li	s1 0
	beqz s0 .adjustHeap_4
.adjustHeap_3:
	lw	s0, 256(sp)
	sw	s0, 192(sp)
	lw	s0, 192(sp)
	li	s1 2
	mul	s2, s0,s1
	sw	s2, 188(sp)
	lw	s0, 188(sp)
	li	s1 1
	add	s2, s0,s1
	sw	s2, 184(sp)
	la	s1 a
	lw	s0, 0(s1)
	sw	s0, 180(sp)
	lw	s1, 180(sp)
	lw	s2, 184(sp)
	slli	s3, s2, 2
	add	s0, s1,s3
	sw	s0, 176(sp)
	lw	s0, 256(sp)
	sw	s0, 172(sp)
	lw	s0, 172(sp)
	li	s1 2
	mul	s2, s0,s1
	sw	s2, 168(sp)
	la	s1 a
	lw	s0, 0(s1)
	sw	s0, 164(sp)
	lw	s1, 164(sp)
	lw	s2, 168(sp)
	slli	s3, s2, 2
	add	s0, s1,s3
	sw	s0, 160(sp)
	lw	s1, 176(sp)
	lw	s0, 0(s1)
	sw	s0, 156(sp)
	lw	s1, 160(sp)
	lw	s0, 0(s1)
	sw	s0, 152(sp)
	lw	s0, 156(sp)
	lw	s1, 152(sp)
	sub	s2, s0,s1
	sltz	s4, s2
	sw	s4, 148(sp)
	lw	s0, 148(sp)
	li	s1 0
	sub	s2, s0,s1
	snez	s4, s2
	sw	s4, 144(sp)
	li	s2 144
	add	s3, sp,s2
	lw	s1, 0(s3)
	j	.adjustHeap_4
.adjustHeap_4:
	sw	s1, 140(sp)
	lw	s0, 140(sp)
	li	s1 0
	sub	s2, s0,s1
	snez	s4, s2
	sw	s4, 136(sp)
	lw	s0, 136(sp)
	beqz s0 .adjustHeap_6
.adjustHeap_5:
	lw	s0, 256(sp)
	sw	s0, 132(sp)
	lw	s0, 132(sp)
	li	s1 2
	mul	s2, s0,s1
	sw	s2, 128(sp)
	lw	s0, 128(sp)
	li	s1 1
	add	s2, s0,s1
	sw	s2, 124(sp)
	lw	s0, 124(sp)
	sw	s0, 252(sp)
	j	.adjustHeap_6
.adjustHeap_6:
	lw	s0, 256(sp)
	sw	s0, 120(sp)
	la	s1 a
	lw	s0, 0(s1)
	sw	s0, 116(sp)
	lw	s1, 116(sp)
	lw	s2, 120(sp)
	slli	s3, s2, 2
	add	s0, s1,s3
	sw	s0, 112(sp)
	lw	s0, 252(sp)
	sw	s0, 108(sp)
	la	s1 a
	lw	s0, 0(s1)
	sw	s0, 104(sp)
	lw	s1, 104(sp)
	lw	s2, 108(sp)
	slli	s3, s2, 2
	add	s0, s1,s3
	sw	s0, 100(sp)
	lw	s1, 112(sp)
	lw	s0, 0(s1)
	sw	s0, 96(sp)
	lw	s1, 100(sp)
	lw	s0, 0(s1)
	sw	s0, 92(sp)
	lw	s0, 96(sp)
	lw	s1, 92(sp)
	sub	s2, s0,s1
	sgtz	s4, s2
	sw	s4, 88(sp)
	lw	s0, 88(sp)
	li	s1 0
	sub	s2, s0,s1
	snez	s4, s2
	sw	s4, 84(sp)
	lw	s0, 84(sp)
	beqz s0 .adjustHeap_8
.adjustHeap_7:
	lw	s0, 256(sp)
	sw	s0, 80(sp)
	la	s1 a
	lw	s0, 0(s1)
	sw	s0, 76(sp)
	lw	s1, 76(sp)
	lw	s2, 80(sp)
	slli	s3, s2, 2
	add	s0, s1,s3
	sw	s0, 72(sp)
	lw	s1, 72(sp)
	lw	s0, 0(s1)
	sw	s0, 68(sp)
	lw	s0, 68(sp)
	sw	s0, 64(sp)
	lw	s0, 256(sp)
	sw	s0, 60(sp)
	la	s1 a
	lw	s0, 0(s1)
	sw	s0, 56(sp)
	lw	s1, 56(sp)
	lw	s2, 60(sp)
	slli	s3, s2, 2
	add	s0, s1,s3
	sw	s0, 52(sp)
	lw	s0, 252(sp)
	sw	s0, 48(sp)
	la	s1 a
	lw	s0, 0(s1)
	sw	s0, 44(sp)
	lw	s1, 44(sp)
	lw	s2, 48(sp)
	slli	s3, s2, 2
	add	s0, s1,s3
	sw	s0, 40(sp)
	lw	s1, 40(sp)
	lw	s0, 0(s1)
	sw	s0, 36(sp)
	lw	s0, 36(sp)
	lw	s1, 52(sp)
	sw	s0, 0(s1)
	lw	s0, 252(sp)
	sw	s0, 32(sp)
	la	s1 a
	lw	s0, 0(s1)
	sw	s0, 28(sp)
	lw	s1, 28(sp)
	lw	s2, 32(sp)
	slli	s3, s2, 2
	add	s0, s1,s3
	sw	s0, 24(sp)
	lw	s0, 64(sp)
	sw	s0, 20(sp)
	lw	s0, 20(sp)
	lw	s1, 24(sp)
	sw	s0, 0(s1)
	lw	s0, 252(sp)
	sw	s0, 16(sp)
	lw	s0, 16(sp)
	sw	s0, 256(sp)
	j	.adjustHeap_9
.adjustHeap_8:
	j	.adjustHeap_10
.adjustHeap_9:
	j	.adjustHeap_1
.adjustHeap_10:
	li	a0 0
	lw	s0, 312(sp)
	lw	s1, 308(sp)
	lw	s2, 304(sp)
	lw	s3, 300(sp)
	lw	s4, 296(sp)
	lw	s5, 292(sp)
	lw	s6, 288(sp)
	lw	s7, 284(sp)
	lw	s8, 280(sp)
	lw	s9, 276(sp)
	lw	s10, 272(sp)
	lw	s11, 268(sp)
	lw	ra, 316(sp)
	addi	sp, sp, 320
	ret

	.globl	heapSort
	.p2align	2
	.type	heapSort,@function
heapSort:
	addi	sp, sp, -192
	sw	ra, 188(sp)
	sw	s0, 184(sp)
	sw	s1, 180(sp)
	sw	s2, 176(sp)
	sw	s3, 172(sp)
	sw	s4, 168(sp)
	sw	s5, 164(sp)
	sw	s6, 160(sp)
	sw	s7, 156(sp)
	sw	s8, 152(sp)
	sw	s9, 148(sp)
	sw	s10, 144(sp)
	sw	s11, 140(sp)
	li	s0 0
	sw	s0, 136(sp)
	li	s0 0
	sw	s0, 132(sp)
	j	.heapSort_1
.heapSort_1:
	lw	s0, 132(sp)
	sw	s0, 128(sp)
	la	s1 n
	lw	s0, 0(s1)
	sw	s0, 124(sp)
	lw	s0, 128(sp)
	lw	s1, 124(sp)
	sub	s2, s0,s1
	sltz	s4, s2
	sw	s4, 120(sp)
	lw	s0, 120(sp)
	li	s1 0
	sub	s2, s0,s1
	snez	s4, s2
	sw	s4, 116(sp)
	lw	s0, 116(sp)
	beqz s0 .heapSort_4
.heapSort_2:
	la	s1 a
	lw	s0, 0(s1)
	sw	s0, 112(sp)
	lw	s1, 112(sp)
	li	s2 0
	add	s0, s1,s2
	sw	s0, 108(sp)
	lw	s1, 108(sp)
	lw	s0, 0(s1)
	sw	s0, 104(sp)
	lw	s0, 104(sp)
	sw	s0, 136(sp)
	la	s1 a
	lw	s0, 0(s1)
	sw	s0, 100(sp)
	lw	s1, 100(sp)
	li	s2 0
	add	s0, s1,s2
	sw	s0, 96(sp)
	la	s1 n
	lw	s0, 0(s1)
	sw	s0, 92(sp)
	lw	s0, 132(sp)
	sw	s0, 88(sp)
	lw	s0, 92(sp)
	lw	s1, 88(sp)
	sub	s2, s0,s1
	sw	s2, 84(sp)
	lw	s0, 84(sp)
	li	s1 1
	sub	s2, s0,s1
	sw	s2, 80(sp)
	la	s1 a
	lw	s0, 0(s1)
	sw	s0, 76(sp)
	lw	s1, 76(sp)
	lw	s2, 80(sp)
	slli	s3, s2, 2
	add	s0, s1,s3
	sw	s0, 72(sp)
	lw	s1, 72(sp)
	lw	s0, 0(s1)
	sw	s0, 68(sp)
	lw	s0, 68(sp)
	lw	s1, 96(sp)
	sw	s0, 0(s1)
	la	s1 n
	lw	s0, 0(s1)
	sw	s0, 64(sp)
	lw	s0, 132(sp)
	sw	s0, 60(sp)
	lw	s0, 64(sp)
	lw	s1, 60(sp)
	sub	s2, s0,s1
	sw	s2, 56(sp)
	lw	s0, 56(sp)
	li	s1 1
	sub	s2, s0,s1
	sw	s2, 52(sp)
	la	s1 a
	lw	s0, 0(s1)
	sw	s0, 48(sp)
	lw	s1, 48(sp)
	lw	s2, 52(sp)
	slli	s3, s2, 2
	add	s0, s1,s3
	sw	s0, 44(sp)
	lw	s0, 136(sp)
	sw	s0, 40(sp)
	lw	s0, 40(sp)
	lw	s1, 44(sp)
	sw	s0, 0(s1)
	la	s1 n
	lw	s0, 0(s1)
	sw	s0, 36(sp)
	lw	s0, 132(sp)
	sw	s0, 32(sp)
	lw	s0, 36(sp)
	lw	s1, 32(sp)
	sub	s2, s0,s1
	sw	s2, 28(sp)
	lw	s0, 28(sp)
	li	s1 1
	sub	s2, s0,s1
	sw	s2, 24(sp)
	lw	a0, 24(sp)
	call	adjustHeap
	sw	a0, 20(sp)
	j	.heapSort_3
.heapSort_3:
	lw	s0, 132(sp)
	sw	s0, 16(sp)
	lw	s0, 16(sp)
	li	s1 1
	add	s2, s0,s1
	sw	s2, 12(sp)
	lw	s0, 12(sp)
	sw	s0, 132(sp)
	j	.heapSort_1
.heapSort_4:
	li	a0 0
	lw	s0, 184(sp)
	lw	s1, 180(sp)
	lw	s2, 176(sp)
	lw	s3, 172(sp)
	lw	s4, 168(sp)
	lw	s5, 164(sp)
	lw	s6, 160(sp)
	lw	s7, 156(sp)
	lw	s8, 152(sp)
	lw	s9, 148(sp)
	lw	s10, 144(sp)
	lw	s11, 140(sp)
	lw	ra, 188(sp)
	addi	sp, sp, 192
	ret

	.globl	main
	.p2align	2
	.type	main,@function
main:
	addi	sp, sp, -224
	sw	ra, 220(sp)
	sw	s0, 216(sp)
	sw	s1, 212(sp)
	sw	s2, 208(sp)
	sw	s3, 204(sp)
	sw	s4, 200(sp)
	sw	s5, 196(sp)
	sw	s6, 192(sp)
	sw	s7, 188(sp)
	sw	s8, 184(sp)
	sw	s9, 180(sp)
	sw	s10, 176(sp)
	sw	s11, 172(sp)
	call	global_var_init
	call	getString
	sw	a0, 164(sp)
	lw	a0, 164(sp)
	call	string_parseInt
	sw	a0, 160(sp)
	lw	s0, 160(sp)
	la	s1 n
	sw	s0, 0(s1)
	la	s1 n
	lw	s0, 0(s1)
	sw	s0, 156(sp)
	lw	s0, 156(sp)
	li	s1 4
	mul	s2, s0,s1
	sw	s2, 152(sp)
	lw	s0, 152(sp)
	li	s1 4
	add	s2, s0,s1
	sw	s2, 148(sp)
	lw	a0, 148(sp)
	call	malloc
	sw	a0, 144(sp)
	lw	s0, 144(sp)
	sw	s0, 140(sp)
	lw	s0, 156(sp)
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
	la	s1 a
	sw	s0, 0(s1)
	li	s0 0
	sw	s0, 168(sp)
	j	.main_1
.main_1:
	la	s1 a
	lw	s0, 0(s1)
	sw	s0, 120(sp)
	lw	s0, 120(sp)
	sw	s0, 116(sp)
	lw	a0, 116(sp)
	call	array_size
	sw	a0, 112(sp)
	lw	s0, 168(sp)
	sw	s0, 108(sp)
	lw	s0, 108(sp)
	lw	s1, 112(sp)
	sub	s2, s0,s1
	sltz	s4, s2
	sw	s4, 104(sp)
	lw	s0, 104(sp)
	li	s1 0
	sub	s2, s0,s1
	snez	s4, s2
	sw	s4, 100(sp)
	lw	s0, 100(sp)
	beqz s0 .main_4
.main_2:
	lw	s0, 168(sp)
	sw	s0, 96(sp)
	la	s1 a
	lw	s0, 0(s1)
	sw	s0, 92(sp)
	lw	s1, 92(sp)
	lw	s2, 96(sp)
	slli	s3, s2, 2
	add	s0, s1,s3
	sw	s0, 88(sp)
	lw	s0, 168(sp)
	sw	s0, 84(sp)
	lw	s0, 84(sp)
	lw	s1, 88(sp)
	sw	s0, 0(s1)
	j	.main_3
.main_3:
	lw	s0, 168(sp)
	sw	s0, 80(sp)
	lw	s0, 80(sp)
	li	s1 1
	add	s2, s0,s1
	sw	s2, 76(sp)
	lw	s0, 76(sp)
	sw	s0, 168(sp)
	j	.main_1
.main_4:
	call	makeHeap
	sw	a0, 72(sp)
	call	heapSort
	sw	a0, 68(sp)
	li	s0 0
	sw	s0, 168(sp)
	j	.main_5
.main_5:
	la	s1 a
	lw	s0, 0(s1)
	sw	s0, 64(sp)
	lw	s0, 64(sp)
	sw	s0, 60(sp)
	lw	a0, 60(sp)
	call	array_size
	sw	a0, 56(sp)
	lw	s0, 168(sp)
	sw	s0, 52(sp)
	lw	s0, 52(sp)
	lw	s1, 56(sp)
	sub	s2, s0,s1
	sltz	s4, s2
	sw	s4, 48(sp)
	lw	s0, 48(sp)
	li	s1 0
	sub	s2, s0,s1
	snez	s4, s2
	sw	s4, 44(sp)
	lw	s0, 44(sp)
	beqz s0 .main_8
.main_6:
	lw	s0, 168(sp)
	sw	s0, 40(sp)
	la	s1 a
	lw	s0, 0(s1)
	sw	s0, 36(sp)
	lw	s1, 36(sp)
	lw	s2, 40(sp)
	slli	s3, s2, 2
	add	s0, s1,s3
	sw	s0, 32(sp)
	lw	s1, 32(sp)
	lw	s0, 0(s1)
	sw	s0, 28(sp)
	lw	a0, 28(sp)
	call	toString
	sw	a0, 24(sp)
	la	s0 .str.0
	sw	s0, 20(sp)
	lw	a0, 24(sp)
	lw	a1, 20(sp)
	call	string_add
	sw	a0, 16(sp)
	lw	a0, 16(sp)
	call	print
	j	.main_7
.main_7:
	lw	s0, 168(sp)
	sw	s0, 12(sp)
	lw	s0, 12(sp)
	li	s1 1
	add	s2, s0,s1
	sw	s2, 8(sp)
	lw	s0, 8(sp)
	sw	s0, 168(sp)
	j	.main_5
.main_8:
	la	s0 .str.1
	sw	s0, 4(sp)
	lw	a0, 4(sp)
	call	print
	li	a0 0
	lw	s0, 216(sp)
	lw	s1, 212(sp)
	lw	s2, 208(sp)
	lw	s3, 204(sp)
	lw	s4, 200(sp)
	lw	s5, 196(sp)
	lw	s6, 192(sp)
	lw	s7, 188(sp)
	lw	s8, 184(sp)
	lw	s9, 180(sp)
	lw	s10, 176(sp)
	lw	s11, 172(sp)
	lw	ra, 220(sp)
	addi	sp, sp, 224
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

	.type	a,@object
	.globl	a
a:
	.word	0
	.size	a, 4


	.section	.rodata,"a",@progbits
	.type	.str.0,@object
	.globl	.str.0
.str.0: 
	.asciz	" \00"
	.size	.str.0, 7

	.type	.str.1,@object
	.globl	.str.1
.str.1: 
	.asciz	"\0A\00"
	.size	.str.1, 9

	.section	".note.GNU-stack","",@progbits
