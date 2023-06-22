package com.codecool.netflix.data;

import com.codecool.netflix.data.enums.Role;

import java.util.Objects;

public class Credit {
    private Long personId;
    private String id;
    private String name;
    private String character;
    private Role role;

    public Credit(Long personId, String id, String name, String character, Role role) {
        this.personId = personId;
        this.id = id;
        this.name = name;
        this.character = character;
        this.role = role;
    }

    public Credit() {
    }

    public Long getPersonId() {
        return this.personId;
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getCharacter() {
        return this.character;
    }

    public Role getRole() {
        return this.role;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCharacter(String character) {
        this.character = character;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Credit)) return false;
        Credit credit = (Credit) o;
        return Objects.equals(getPersonId(), credit.getPersonId()) && Objects.equals(getId(), credit.getId())
                && Objects.equals(getName(), credit.getName()) && Objects.equals(getCharacter(), credit.getCharacter())
                && getRole() == credit.getRole();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPersonId(), getId(), getName(), getCharacter(), getRole());
    }

    @Override
    public String toString() {
        return "Credit{" +
                "personId=" + personId +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", character='" + character + '\'' +
                ", role=" + role +
                '}';
    }
}
