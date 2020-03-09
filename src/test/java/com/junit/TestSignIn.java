package com.junit;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestSignIn {

	public static void main(String[] args) {
		Result result = JUnitCore.runClasses(SignInUser.class);

		for (Failure failure : result.getFailures()) {
			System.out.println(failure.getMessage());
		}

		System.out.println(result.wasSuccessful());
	}
}
