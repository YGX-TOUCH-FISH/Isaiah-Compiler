	.text
	.file	"Isaiah.ll"
	.globl	abs                     # -- Begin function abs
	.p2align	2
	.type	abs,@function
abs:                                    # @abs
	.cfi_startproc
# %bb.0:
	addi	sp, sp, -16
	.cfi_def_cfa_offset 16
	addi	a1, zero, 1
	sw	a0, 12(sp)
	blt	a0, a1, .LBB0_2
# %bb.1:
	lw	a0, 12(sp)
	addi	sp, sp, 16
	ret
.LBB0_2:
	lw	a0, 12(sp)
	neg	a0, a0
	addi	sp, sp, 16
	ret
.Lfunc_end0:
	.size	abs, .Lfunc_end0-abs
	.cfi_endproc
                                        # -- End function
	.globl	main                    # -- Begin function main
	.p2align	2
	.type	main,@function
main:                                   # @main
	.cfi_startproc
# %bb.0:
	addi	sp, sp, -48
	.cfi_def_cfa_offset 48
	sw	ra, 44(sp)
	sw	s0, 40(sp)
	sw	s1, 36(sp)
	sw	s2, 32(sp)
	sw	s3, 28(sp)
	sw	s4, 24(sp)
	sw	s5, 20(sp)
	sw	s6, 16(sp)
	sw	s7, 12(sp)
	.cfi_offset ra, -4
	.cfi_offset s0, -8
	.cfi_offset s1, -12
	.cfi_offset s2, -16
	.cfi_offset s3, -20
	.cfi_offset s4, -24
	.cfi_offset s5, -28
	.cfi_offset s6, -32
	.cfi_offset s7, -36
	call	global_var_init
	lui	s2, %hi(i)
	addi	a0, s2, %lo(i)
	sw	zero, 0(a0)
	addi	s1, zero, 4
	lui	s0, %hi(j)
	addi	s3, s0, %lo(j)
	lui	s4, %hi(n)
	addi	s5, zero, 1
	lui	s6, %hi(r)
	lui	s7, %hi(c)
	j	.LBB1_2
.LBB1_1:                                #   in Loop: Header=BB1_2 Depth=1
	lw	a0, %lo(i)(s2)
	addi	a0, a0, 1
	sw	a0, %lo(i)(s2)
.LBB1_2:                                # =>This Loop Header: Depth=1
                                        #     Child Loop BB1_5 Depth 2
	lw	a0, %lo(i)(s2)
	blt	s1, a0, .LBB1_8
# %bb.3:                                #   in Loop: Header=BB1_2 Depth=1
	sw	zero, 0(s3)
	j	.LBB1_5
.LBB1_4:                                #   in Loop: Header=BB1_5 Depth=2
	lw	a0, %lo(j)(s0)
	addi	a0, a0, 1
	sw	a0, %lo(j)(s0)
.LBB1_5:                                #   Parent Loop BB1_2 Depth=1
                                        # =>  This Inner Loop Header: Depth=2
	lw	a0, %lo(j)(s0)
	blt	s1, a0, .LBB1_1
# %bb.6:                                #   in Loop: Header=BB1_5 Depth=2
	call	getInt
	sw	a0, %lo(n)(s4)
	bne	a0, s5, .LBB1_4
# %bb.7:                                #   in Loop: Header=BB1_5 Depth=2
	lw	a0, %lo(i)(s2)
	lw	a1, %lo(j)(s0)
	sw	a0, %lo(r)(s6)
	sw	a1, %lo(c)(s7)
	j	.LBB1_4
.LBB1_8:
	lui	a0, %hi(r)
	lw	a0, %lo(r)(a0)
	addi	s1, zero, 2
	sub	a0, s1, a0
	call	abs
	lui	a1, %hi(c)
	lw	a1, %lo(c)(a1)
	mv	s0, a0
	sub	a0, s1, a1
	call	abs
	add	a0, s0, a0
	call	printInt
	mv	a0, zero
	lw	s7, 12(sp)
	lw	s6, 16(sp)
	lw	s5, 20(sp)
	lw	s4, 24(sp)
	lw	s3, 28(sp)
	lw	s2, 32(sp)
	lw	s1, 36(sp)
	lw	s0, 40(sp)
	lw	ra, 44(sp)
	addi	sp, sp, 48
	ret
.Lfunc_end1:
	.size	main, .Lfunc_end1-main
	.cfi_endproc
                                        # -- End function
	.globl	global_var_init         # -- Begin function global_var_init
	.p2align	2
	.type	global_var_init,@function
global_var_init:                        # @global_var_init
	.cfi_startproc
# %bb.0:
	ret
.Lfunc_end2:
	.size	global_var_init, .Lfunc_end2-global_var_init
	.cfi_endproc
                                        # -- End function
	.type	n,@object               # @n
	.section	.sbss,"aw",@nobits
	.globl	n
	.p2align	2
n:
	.word	0                       # 0x0
	.size	n, 4

	.type	r,@object               # @r
	.globl	r
	.p2align	2
r:
	.word	0                       # 0x0
	.size	r, 4

	.type	c,@object               # @c
	.globl	c
	.p2align	2
c:
	.word	0                       # 0x0
	.size	c, 4

	.type	i,@object               # @i
	.globl	i
	.p2align	2
i:
	.word	0                       # 0x0
	.size	i, 4

	.type	j,@object               # @j
	.globl	j
	.p2align	2
j:
	.word	0                       # 0x0
	.size	j, 4

	.section	".note.GNU-stack","",@progbits
