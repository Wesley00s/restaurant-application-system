package com.wesley.restaurant.application.system.dto;

import com.wesley.restaurant.application.system.enumeration.Role;
import net.bytebuddy.implementation.bytecode.ShiftRight;

public record RegisterDTO(String login, String password, Role role) {
}
