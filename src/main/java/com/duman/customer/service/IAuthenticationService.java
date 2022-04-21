package com.duman.customer.service;

import com.duman.customer.model.entity.User;


public interface IAuthenticationService {
    User signInAndReturnJWT(User signInRequest);
}
