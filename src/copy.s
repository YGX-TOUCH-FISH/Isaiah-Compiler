	.text
	.file	"Isaiah.ll"
	.globl	main                    # -- Begin function main
	.p2align	2
	.type	main,@function
main:                                   # @main
	.cfi_startproc
# %bb.0:
	addi	sp, sp, -32
	.cfi_def_cfa_offset 32
	sw	ra, 28(sp)
	sw	s0, 24(sp)
	sw	s1, 20(sp)
	.cfi_offset ra, -4
	.cfi_offset s0, -8
	.cfi_offset s1, -12
	call	global_var_init
	addi	a0, zero, 2
	sw	a0, 16(sp)
	addi	a0, zero, 1
	sw	a0, 12(sp)
	lui	a1, %hi(N)
	lui	a2, %hi(b)
.LBB0_1:                                # =>This Inner Loop Header: Depth=1
	lw	a3, 12(sp)
	lw	a4, %lo(N)(a1)
	blt	a4, a3, .LBB0_3
# %bb.2:                                #   in Loop: Header=BB0_1 Depth=1
	lw	a3, 12(sp)
	lw	a4, %lo(b)(a2)
	add	a3, a4, a3
	sb	a0, 0(a3)
	lw	a3, 12(sp)
	addi	a3, a3, 1
	sw	a3, 12(sp)
	j	.LBB0_1
.LBB0_3:
	addi	a0, zero, 2
	sw	a0, 12(sp)
	lui	s0, %hi(N)
	lui	s1, %hi(b)
.LBB0_4:                                # =>This Inner Loop Header: Depth=1
	lw	a0, 12(sp)
	lw	a1, 16(sp)
	call	__mulsi3
	lw	a1, %lo(N)(s0)
	blt	a1, a0, .LBB0_6
# %bb.5:                                #   in Loop: Header=BB0_4 Depth=1
	lw	a0, 12(sp)
	lw	a1, 16(sp)
	call	__mulsi3
	lw	a1, %lo(b)(s1)  ;b
	add	a0, a1, a0      ;b+%24*%25
	sb	zero, 0(a0)
	lw	a0, 16(sp)
	addi	a0, a0, 1
	sw	a0, 16(sp)
	j	.LBB0_4
.LBB0_6:
	addi	a0, zero, 1
	sw	a0, 12(sp)
	lui	s0, %hi(N)
	lui	s1, %hi(b)
	j	.LBB0_9
.LBB0_7:                                #   in Loop: Header=BB0_9 Depth=1
	mv	a0, zero
.LBB0_8:                                #   in Loop: Header=BB0_9 Depth=1
	call	printlnInt
	lw	a0, 12(sp)
	addi	a0, a0, 1
	sw	a0, 12(sp)
.LBB0_9:                                # =>This Inner Loop Header: Depth=1
	lw	a0, 12(sp)
	lw	a1, %lo(N)(s0)
	blt	a1, a0, .LBB0_12
# %bb.10:                               #   in Loop: Header=BB0_9 Depth=1
	lw	a0, 12(sp)
	lw	a1, %lo(b)(s1)
	add	a0, a1, a0
	lbu	a0, 0(a0)
	beqz	a0, .LBB0_7
# %bb.11:                               #   in Loop: Header=BB0_9 Depth=1
	addi	a0, zero, 1
	j	.LBB0_8
.LBB0_12:
	mv	a0, zero
	lw	s1, 20(sp)
	lw	s0, 24(sp)
	lw	ra, 28(sp)
	addi	sp, sp, 32
	ret
.Lfunc_end0:
	.size	main, .Lfunc_end0-main
	.cfi_endproc
                                        # -- End function
	.globl	global_var_init         # -- Begin function global_var_init
	.p2align	2
	.type	global_var_init,@function
global_var_init:                        # @global_var_init
	.cfi_startproc
# %bb.0:
	addi	sp, sp, -16
	.cfi_def_cfa_offset 16
	sw	ra, 12(sp)
	.cfi_offset ra, -4
	addi	a0, zero, 34
	call	malloc
	addi	a1, zero, 30
	sw	a1, 0(a0)
	addi	a0, a0, 4
	sw	a0, 8(sp)
	lui	a1, %hi(b)
	sw	a0, %lo(b)(a1)
	lui	a0, %hi(N)
	addi	a1, zero, 10
	sw	a1, %lo(N)(a0)
	lw	ra, 12(sp)
	addi	sp, sp, 16
	ret
.Lfunc_end1:
	.size	global_var_init, .Lfunc_end1-global_var_init
	.cfi_endproc
                                        # -- End function
	.type	b,@object               # @b
	.section	.sbss,"aw",@nobits
	.globl	b
	.p2align	2
b:
	.word	0
	.size	b, 4

	.type	N,@object               # @N
	.globl	N
	.p2align	2
N:
	.word	0                       # 0x0
	.size	N, 4

	.section	".note.GNU-stack","",@progbits
