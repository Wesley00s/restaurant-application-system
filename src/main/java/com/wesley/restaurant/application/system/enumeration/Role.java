package com.wesley.restaurant.application.system.enumeration;

public enum Role {
    ADMIN("ADMIN"),
    CHEF("CHEF"),
    WAITER("WAITER"),
    CLIENT("USER");

    private final String desc;

    Role(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }
}

