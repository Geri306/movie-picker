package com.gergokovacs.moviepicker.logic.util;

import com.gergokovacs.moviepicker.data.enums.AgeCertification;
import com.gergokovacs.moviepicker.data.enums.Type;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TypeConverter {

    public Integer getIntegerValue(String value) {
        return value.isEmpty() ? null : Integer.valueOf(value);
    }

    public Float getFloatValue(String value) {
        return value.isEmpty() ? null : Float.valueOf(value);
    }

    public Type getTypeValue(String value) {
        return value.isEmpty() ? null : Type.valueOf(value);
    }

    public AgeCertification getAgeCertificationValue(String value) {
        return AgeCertification.getAgeCertificationByName(value);
    }

    public List<String> getListValue(String value) {
        String listValuesAsString = value
                .replace("'", "")
                .replace("\"", "")
                .replace("[", "")
                .replace("]", "");
        return Arrays.stream(listValuesAsString.split(",")).map(String::trim).collect(Collectors.toList());
    }
}
