package com.learn.lambda;

@FunctionalInterface
public interface ChooseOne {
	
	int chooseOne(int a, int b);
	
	default int test(int aParam, int bParam, ChooseOne ch) {
		
		return ch.chooseOne(aParam, bParam);
	}

}
