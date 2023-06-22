package com.codecool.netflix.data.enums;


import java.util.Arrays;
import java.util.Optional;

public enum AgeCertification {
    TVMA("TV-MA"), R("R"), PG("PG"), TV14("TV-14"), PG13("PG-13"), TVPG("TV-PG"), TVG("TV-G"), TVY("TV-Y"), TVY7("TV-Y7"),
    G("G"), NC17("NC-17");

    private final String name;

    AgeCertification(String ageCertification) {
        this.name = ageCertification;
    }

    public static AgeCertification getAgeCertificationByName(String name) {
        Optional<AgeCertification> isValidAc = Arrays.stream(AgeCertification.values())
                .filter(ac -> ac.getName().equals(name)).findFirst();
        return isValidAc.orElse(null);
    }

    public String getName() {
        return this.name;
    }
}
