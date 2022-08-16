package mrw007.springframework.springrestclientexamples.services;

import mrw007.springframework.api.models.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ApiService {

    List<User> getUsers(Integer limit);
}
