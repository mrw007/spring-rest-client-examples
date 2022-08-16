package mrw007.springframework.springrestclientexamples.services;

import mrw007.springframework.api.models.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class ApiServiceImplTest {

    ApiService apiService;

    @BeforeEach
    void setUp() {
        apiService = new ApiServiceImpl(new RestTemplate());
    }

    @Test
    void getUsers() {
        List<User> users = apiService.getUsers(3);
        assertEquals(3, users.size());
    }
}