package org.example.readers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.interfaces.ClientDataReader;
import org.example.modele.Client;

import java.io.File;
import java.util.List;

public class JsonClientReader implements ClientDataReader {
    public List<Client> readClients(File file) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(file, new TypeReference<List<Client>>() {});
    }

}
