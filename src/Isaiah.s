	.text
	.file	"Isaiah.ll"
	.globl	main                    # -- Begin function main
	.p2align	2
	.type	main,@function
main:                                   # @main
	.cfi_startproc
# %bb.0:
	addi	sp, sp, -16
	.cfi_def_cfa_offset 16
	sw	ra, 12(sp)
	.cfi_offset ra, -4
	call	global_var_init
	mv	a0, zero
	lw	ra, 12(sp)
	addi	sp, sp, 16
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
	lui	a0, %hi(.str.0)
	addi	a0, a0, %lo(.str.0)
	lui	a1, %hi(x)
	sw	a0, %lo(x)(a1)
	lui	a0, %hi(.str.1)
	addi	a0, a0, %lo(.str.1)
	lui	a1, %hi(y)
	sw	a0, %lo(y)(a1)
	lui	a0, %hi(m)
	sw	zero, %lo(m)(a0)
	ret
.Lfunc_end1:
	.size	global_var_init, .Lfunc_end1-global_var_init
	.cfi_endproc
                                        # -- End function
	.globl	a                       # -- Begin function a
	.p2align	2
	.type	a,@function
a:                                      # @a
	.cfi_startproc
# %bb.0:
	addi	sp, sp, -16
	.cfi_def_cfa_offset 16
	sw	a0, 12(sp)
	addi	sp, sp, 16
	ret
.Lfunc_end2:
	.size	a, .Lfunc_end2-a
	.cfi_endproc
                                        # -- End function
	.type	x,@object               # @x
	.section	.sbss,"aw",@nobits
	.globl	x
	.p2align	2
x:
	.word	0
	.size	x, 4

	.type	y,@object               # @y
	.globl	y
	.p2align	2
y:
	.word	0
	.size	y, 4

	.type	m,@object               # @m
	.globl	m
	.p2align	2
m:
	.word	0                       # 0x0
	.size	m, 4

	.type	test,@object            # @test
	.globl	test
	.p2align	2
test:
	.word	0
	.size	test, 4

	.type	pp,@object              # @pp
	.globl	pp
pp:
	.byte	0                       # 0x0
	.size	pp, 1

	.type	.str.0,@object          # @.str.0
	.section	.rodata,"a",@progbits
	.globl	.str.0
.str.0:
	.zero	1
	.size	.str.0, 1

	.type	.str.1,@object          # @.str.1
	.globl	.str.1
.str.1:
	.asciz	"justice"
	.size	.str.1, 8

	.section	".note.GNU-stack","",@progbits
