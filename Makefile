build:
	make -C app build
install:
	make -C app install
run-dist:
	make -C app run-dist
report:
	make -C app report
.PHONY: build