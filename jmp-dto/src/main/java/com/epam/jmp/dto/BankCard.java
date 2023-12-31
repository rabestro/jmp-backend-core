package com.epam.jmp.dto;

import java.util.Objects;

public sealed class BankCard permits CreditBankCard, DebitBankCard {
	private final String number;
	private final User user;

	public BankCard(String number, User user) {
		Objects.requireNonNull(number, "Number cannot be null");
		Objects.requireNonNull(user, "BankUser cannot be null");
		this.number = number;
		this.user = user;
	}

	public String number() {
		return number;
	}

	public User user() {
		return user;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
            return true;
        }
		if (o == null || getClass() != o.getClass()) {
            return false;
        }
		BankCard bankCard = (BankCard) o;
		return Objects.equals(number, bankCard.number);
	}

	@Override
	public int hashCode() {
		return Objects.hash(number);
	}

	@Override
	public String toString() {
		return "BankCard{" +
			   "number='" + number + '\'' +
			   ", user=" + user +
			   '}';
	}
}
