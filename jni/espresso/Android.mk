LOCAL_PATH      := $(call my-dir)

include $(CLEAR_VARS)

LOCAL_MODULE     := espresso
LOCAL_C_INCLUDES := .
LOCAL_CFLAGS     := -Werror
LOCAL_SRC_FILES  := black_white.c \
	canonical.c \
	cofactor.c \
	cols.c \
	compl.c \
	contain.c \
	cpu_time.c \
	cubestr.c \
	cvrin.c \
	cvrm.c \
	cvrmisc.c \
	cvrout.c \
	dominate.c \
	equiv.c \
	espresso.c \
	essen.c \
	essentiality.c \
	exact.c \
	expand.c \
	gasp.c \
	gimpel.c \
	globals.c \
	hack.c \
	indep.c \
	irred.c \
	main.c \
	map.c \
	matrix.c \
	mincov.c \
	opo.c \
	pair.c \
	part.c \
	primes.c \
	prtime.c \
	reduce.c \
	rows.c \
	set.c \
	setc.c \
	sharp.c \
	sigma.c \
	signature.c \
	signature_exact.c \
	sminterf.c \
	solution.c \
	sparse.c \
	unate.c \
	util_signature.c \
	verify.c
LOCAL_LDLIBS    := -llog

include $(BUILD_EXECUTABLE)
