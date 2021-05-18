package com.springboot.repository;

import org.springframework.data.repository.CrudRepository;


import com.springboot.model.ConfirmationToken;

public interface ConfirmationTokenRepository extends CrudRepository<ConfirmationToken, String> {
	ConfirmationToken findByConfirmationToken(String confirmationToken);
}
