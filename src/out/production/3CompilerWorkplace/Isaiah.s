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
	addi	a1, a0, 1
	sw	a0, 12(sp)
	mv	a0, a1
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
	addi	sp, sp, -16
	.cfi_def_cfa_offset 16
	sw	ra, 12(sp)
	sw	s0, 8(sp)
	.cfi_offset ra, -4
	.cfi_offset s0, -8
	call	global_var_init
	addi	a0, zero, 8
	mv	a1, zero
	call	malloc
	mv	s0, a0
	call	mm
	sw	s0, 4(sp)
	lui	a0, %hi(x)
	sw	s0, %lo(x)(a0)
	lw	a0, 0(s0)
	lw	a1, 4(s0)
	add	a0, a0, a1
	lw	s0, 8(sp)
	lw	ra, 12(sp)
	addi	sp, sp, 16
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
	lui	a0, %hi(b)
	addi	a1, zero, 1
	sw	a1, %lo(b)(a0)
	lui	a0, %hi(.str.0)
	addi	a0, a0, %lo(.str.0)
	lui	a1, %hi(d)
	sw	a0, %lo(d)(a1)
	ret
.Lfunc_end2:
	.size	global_var_init, .Lfunc_end2-global_var_init
	.cfi_endproc
                                        # -- End function
	.globl	mm                      # -- Begin function mm
	.p2align	2
	.type	mm,@function
mm:                                     # @mm
	.cfi_startproc
# %bb.0:
	addi	sp, sp, -16
	.cfi_def_cfa_offset 16
	sw	a0, 12(sp)
	addi	sp, sp, 16
	ret
.Lfunc_end3:
	.size	mm, .Lfunc_end3-mm
	.cfi_endproc
                                        # -- End function
	.type	a,@object               # @a
	.section	.sbss,"aw",@nobits
	.globl	a
	.p2align	2
a:
	.word	0                       # 0x0
	.size	a, 4

	.type	b,@object               # @b
	.globl	b
	.p2align	2
b:
	.word	0                       # 0x0
	.size	b, 4

	.type	c,@object               # @c
	.globl	c
	.p2align	2
c:
	.word	0                       # 0x0
	.size	c, 4

	.type	array,@object           # @array
	.globl	array
	.p2align	2
array:
	.word	0
	.size	array, 4

	.type	d,@object               # @d
	.globl	d
	.p2align	2
d:
	.word	0
	.size	d, 4

	.type	x,@object               # @x
	.globl	x
	.p2align	2
x:
	.word	0
	.size	x, 4

	.type	.str.0,@object          # @.str.0
	.section	.rodata,"a",@progbits
	.globl	.str.0
.str.0:
	.asciz	"branch"
	.size	.str.0, 7

	.section	".note.GNU-stack","",@progbits
