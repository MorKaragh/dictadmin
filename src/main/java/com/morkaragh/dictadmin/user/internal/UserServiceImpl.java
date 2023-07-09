package com.morkaragh.dictadmin.user.internal;

import com.morkaragh.dictadmin.user.User;
import com.morkaragh.dictadmin.user.UserService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService {
    @Override
    public User getUser() {
        return new User(SecurityContextHolder.getContext().getAuthentication());
    }
}
