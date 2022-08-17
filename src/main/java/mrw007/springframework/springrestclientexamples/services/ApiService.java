package mrw007.springframework.springrestclientexamples.services;

import mrw007.springframework.api.models.User;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public interface ApiService {
    Flux<User> getUsers(Mono<Integer> limit);
}
