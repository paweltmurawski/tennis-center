package com.tennis.controller.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "tennis product not found")
public class TennisProductsNotFoundException extends Exception {
}
