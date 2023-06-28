package com.gergokovacs.moviepicker.logic.reader;

import com.gergokovacs.moviepicker.data.Title;

import java.io.IOException;
import java.util.List;

public interface TitleReader {
    List<Title> readAll(String fileName) throws IOException;
}
