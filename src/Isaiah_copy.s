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
	addi	a0, zero, 16
	call	malloc
	addi	a1, zero, 3
	sw	a1, 0(a0)
	addi	a1, a0, 4
	sw	a1, 8(sp)
	sw	a1, 4(sp)
	lw	a0, 12(a0)
	sw	a0, 0(sp)
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
	.section	".note.GNU-stack","",@progbits
