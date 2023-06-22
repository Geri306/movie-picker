package com.codecool.netflix.logic.reader;

import java.util.LinkedList;
import java.util.List;

public abstract class CsvReader {

    protected List<String> getFieldsFromLine(String line) {
        char delimiter = ',';
        List<String> result = new LinkedList<>();
        StringBuilder stringBuilder = new StringBuilder();
        //to count all the quotation marks in the given line
        int quotationMarkCount = 0;
        for (char character : line.toCharArray()) {
            if (character == '\"') {
                quotationMarkCount++;
            }
            //if a comma comes as character, and the quotation marks' number is even (equal opens and closes),
            // that means the comma is a delimiter and not part of the string.
            if (character == delimiter && (quotationMarkCount % 2 == 0)) {
                //build string from builder and remove whitespaces.
                result.add(stringBuilder.toString().strip());
                //reset StringBuilder and quotationMarkCount. NOTE: this reset is faster than '= new StringBuilder()'.
                stringBuilder.setLength(0);
                quotationMarkCount = 0;
            } else {
                stringBuilder.append(character);
            }
        }
        //we add the characters left in the StringBuilder.
        result.add(stringBuilder.toString().strip());
        return result;
    }
}
