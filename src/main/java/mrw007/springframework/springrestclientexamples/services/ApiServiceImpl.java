package mrw007.springframework.springrestclientexamples.services;

import lombok.extern.slf4j.Slf4j;
import mrw007.springframework.api.models.User;
import mrw007.springframework.api.models.UserData;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Slf4j
public class ApiServiceImpl implements ApiService {

    private final RestTemplate restTemplate;

    public ApiServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<User> getUsers(Integer limit) {
        Optional<UserData> userDataOptional = Optional.ofNullable(restTemplate.getForObject("https://dummyjson.com/users?limit=" + limit, UserData.class));
        return userDataOptional.map(UserData::getUsers).orElse(null);
    }
}
