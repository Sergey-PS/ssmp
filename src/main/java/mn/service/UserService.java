package mn.service;

import mn.dto.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService {
    private static final List<Person> storage = new ArrayList<>();

    static {
        storage.add(new Person(1,"Petr","Petrov"));
        storage.add(new Person(2,"Ivan","Ivanov"));
        storage.add(new Person(3,"Jack","Sidorov"));
        storage.add(new Person(4,"Uiiii","jhffsdfkjsdlkfj"));
    }

    public Person get(int id) {
        return storage.get(id);
    }

    public List<Person> getAll() {
         return storage;
    }
}
