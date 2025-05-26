package org.example.interfaces;

import org.example.modele.Client;

import java.io.File;
import java.util.List;

public interface ClientDataReader {
    List<Client> readClients(File file) throws Exception;
}
