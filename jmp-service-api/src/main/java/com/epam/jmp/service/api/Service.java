package com.epam.jmp.service.api;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import com.epam.jmp.dto.BankCard;
import com.epam.jmp.dto.Subscription;
import com.epam.jmp.dto.User;

public interface Service {
	LegalAgePredicate USER_PAYABLE_PREDICATE = new LegalAgePredicate();

	static boolean isPayableUser(User user) {
		return USER_PAYABLE_PREDICATE.test(user);
	}

	void subscribe(BankCard bankCard);

	Optional<Subscription> getSubscriptionByBankCardNumber(String cardNumber);

	List<User> getAllUsers();

	default double getAverageUserAge() {
		return getAllUsers().stream()
			.map(User::birthday)
			.mapToDouble(birthday -> LocalDate.now().getYear() - birthday.getYear())
			.average()
			.orElse(0);
	}

	List<Subscription> getAllSubscriptionsByCondition(Predicate<? super Subscription> filter);
}
