package fr.esgi.interfaces.serializer;

import fr.esgi.model.User;

import java.io.IOException;
import java.util.List;

public interface SerializerUserInterface {
    List<User> JsonToList() throws IOException;
    void ListToJson(List<User> persons) throws IOException;
}
