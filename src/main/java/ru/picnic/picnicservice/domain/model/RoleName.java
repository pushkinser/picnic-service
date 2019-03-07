package ru.picnic.picnicservice.domain.model;

public enum RoleName {
    ADMIN("ADMIN"),
    USER("USER");

    private final String roleName;

    RoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public String toString() {
        return roleName;
    }
}


