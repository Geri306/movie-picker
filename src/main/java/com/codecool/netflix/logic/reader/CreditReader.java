package com.codecool.netflix.logic.reader;

import com.codecool.netflix.data.Credit;

import java.io.IOException;
import java.util.List;

public interface CreditReader {
    List<Credit> readAll(String fileName) throws IOException;
}
