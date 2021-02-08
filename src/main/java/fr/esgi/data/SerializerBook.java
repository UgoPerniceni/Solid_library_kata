package fr.esgi.data;

import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import fr.esgi.interfaces.serializer.SerializerBookInterface;
import fr.esgi.model.Book;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class SerializerBook implements SerializerBookInterface {
    ObjectMapper mapper;
    ObjectWriter writer;

    File path;

    public SerializerBook() {
        path = Paths.get("src/main/resources/Book.json").toFile();

        mapper = new ObjectMapper();
        writer = mapper.writer(new DefaultPrettyPrinter());
    }

    @Override
    public List<Book> JsonToList() throws IOException {
        Book[] booksArray = mapper.readValue(path, Book[].class);
        return Arrays.asList(booksArray);
    }

    @Override
    public void ListToJson(List<Book> books) throws IOException {
        writer.writeValue(path, books);
    }
}
