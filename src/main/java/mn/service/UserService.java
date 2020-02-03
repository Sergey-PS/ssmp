package mn.service;

import mn.dto.Person;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {
    private static final Map<Integer, Person> storage = new HashMap<Integer, Person>();

    static {
        storage.put(1, new Person(1,"Petr","Petrov"));
        storage.put(2, new Person(2,"Ivan","Ivanov"));
        storage.put(3, new Person(3,"Jack","Sidorov"));
    }

    public Person get(int id) {
        return storage.get(id);
    }
}
