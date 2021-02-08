package fr.esgi.data;

import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import fr.esgi.interfaces.serializer.SerializerUserInterface;
import fr.esgi.model.User;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class SerializerUser implements SerializerUserInterface{
    ObjectMapper mapper;
    ObjectWriter writer;

    File path;

    public SerializerUser() {
        path = Paths.get("src/main/resources/Users.json").toFile();

        mapper = new ObjectMapper();
        writer = mapper.writer(new DefaultPrettyPrinter());
    }

    public List<User> JsonToList() throws IOException {
        User[] personsArray = mapper.readValue(path, User[].class);
        return Arrays.asList(personsArray);
    }

    public void ListToJson(List<User> persons) throws IOException {
        writer.writeValue(path, persons);
    }

}
