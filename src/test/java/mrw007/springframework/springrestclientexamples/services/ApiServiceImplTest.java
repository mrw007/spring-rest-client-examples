package mrw007.springframework.springrestclientexamples.services;

import mrw007.springframework.api.models.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.client.RestTemplate;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@WebFluxTest
@Import({ApiServiceImpl.class, RestTemplate.class})
class ApiServiceImplTest {


    @Autowired
    ApiService apiService;

    @BeforeEach
    void setUp() {
    }

    @Test
    void getUsers() {
        Flux<User> users = apiService.getUsers(Mono.just(3));
        assertNotNull(users);

        StepVerifier.create(users)
                .recordWith(ArrayList::new)
                .thenConsumeWhile(x -> true)
                .expectRecordedMatches(elements -> elements.size() == 3)
                .verifyComplete();
    }
}