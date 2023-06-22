package com.codecool.netflix.logic.reader;

import com.codecool.netflix.data.Credit;
import com.codecool.netflix.data.enums.Role;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CreditReaderImpl extends CsvReader implements CreditReader {

    private String creditCsvLocation;

    @Override
    public List<Credit> readAll(String path) throws IOException {
        List<Credit> credits = new ArrayList<>();
        InputStream inputStream = getClass().getResourceAsStream(path);
        try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
            String line = br.readLine(); // Reading header, Ignoring
            while ((line = br.readLine()) != null && !line.isEmpty()) {
                List<String> fields = super.getFieldsFromLine(line);
                Long personId = Long.valueOf(fields.get(0));
                String id = fields.get(1);
                String name = fields.get(2);
                String character = fields.get(3);
                Role role = Role.valueOf(fields.get(4));
                credits.add(new Credit(personId, id, name, character, role));
            }
            return credits;
        }
    }
}
