	.text
	.file	"Isaiah.ll"
	.globl	func                    # -- Begin function func
	.p2align	2
	.type	func,@function
func:                                   # @func
	.cfi_startproc
# %bb.0:
	addi	sp, sp, -32
	.cfi_def_cfa_offset 32
	sw	a0, 28(sp)
	sw	a1, 24(sp)
	sw	a2, 20(sp)
	sw	a3, 16(sp)
	lw	a0, 32(sp)
	lw	a1, 36(sp)
	sw	a4, 12(sp)
	sw	a5, 8(sp)
	sw	a6, 4(sp)
	add	a0, a0, a1
	sw	a7, 0(sp)
	addi	sp, sp, 32
	ret
.Lfunc_end0:
	.size	func, .Lfunc_end0-func
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
	.cfi_offset ra, -4
	call	global_var_init
	addi	a0, zero, 2
	sw	a0, 4(sp)
	addi	a0, zero, 1
	sw	a0, 0(sp)
	mv	a0, zero
	mv	a1, zero
	mv	a2, zero
	mv	a3, zero
	mv	a4, zero
	mv	a5, zero
	mv	a6, zero
	mv	a7, zero
	call	func
	call	printlnInt
	mv	a0, zero
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
	ret
.Lfunc_end2:
	.size	global_var_init, .Lfunc_end2-global_var_init
	.cfi_endproc
                                        # -- End function
	.section	".note.GNU-stack","",@progbits
