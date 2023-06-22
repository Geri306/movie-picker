package com.codecool.netflix.logic.reader;

import com.codecool.netflix.data.Title;

import java.io.IOException;
import java.util.List;

public interface TitleReader {
    List<Title> readAll(String fileName) throws IOException;
}
