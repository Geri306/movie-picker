package com.gergokovacs.moviepicker.logic.reader;

import com.gergokovacs.moviepicker.data.Credit;

import java.io.IOException;
import java.util.List;

public interface CreditReader {
    List<Credit> readAll(String fileName) throws IOException;
}
