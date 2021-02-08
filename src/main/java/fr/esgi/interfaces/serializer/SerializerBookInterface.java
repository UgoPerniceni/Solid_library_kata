package fr.esgi.interfaces.serializer;

import fr.esgi.model.Book;

import java.io.IOException;
import java.util.List;

public interface SerializerBookInterface {
    List<Book> JsonToList() throws IOException;
    void ListToJson(List<Book> books) throws IOException;
}
