package com.activeweb.aps.constants;

public enum LoanType {

	AUTOLOAN(1), MORTAGAGE(2), PERSONALLOAN(2);

	LoanType(Integer i) {

	}

	public static LoanType getLoanType(Integer i) {
		for (LoanType lt : LoanType.values()) {
			if (lt.name().equals(i)) {
				return lt;
			}
		}
		return null;
	}

}
