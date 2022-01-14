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
	lui	a0, %hi(.str.0)
	addi	a0, a0, %lo(.str.0)
	call	print
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
	ret
.Lfunc_end1:
	.size	global_var_init, .Lfunc_end1-global_var_init
	.cfi_endproc
                                        # -- End function
	.section	.init_array,"aw",@init_array
	.p2align	2
	.word	global_var_init
	.type	.str.0,@object          # @.str.0
	.section	.rodata,"a",@progbits
	.globl	.str.0
.str.0:
	.asciz	"hello world"
	.size	.str.0, 12

	.section	".note.GNU-stack","",@progbits
