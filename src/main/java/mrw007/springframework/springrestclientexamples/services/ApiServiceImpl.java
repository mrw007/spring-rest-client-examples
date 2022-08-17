package mrw007.springframework.springrestclientexamples.services;

import lombok.extern.slf4j.Slf4j;
import mrw007.springframework.api.models.User;
import mrw007.springframework.api.models.UserData;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Service
public class ApiServiceImpl implements ApiService {
    private final String app_uri;

    public ApiServiceImpl(@Value("${app.url}") String app_uri) {
        this.app_uri = app_uri;
    }

    @Override
    public Flux<User> getUsers(Mono<Integer> limit) {
        return limit.flatMapMany(l -> WebClient.create(app_uri)
                .get()
                .uri(uriBuilder -> uriBuilder
                        .queryParam("limit", l).build())
                .accept(MediaType.APPLICATION_JSON)
                .exchangeToMono(clientResponse -> clientResponse.bodyToMono(UserData.class))
                .flatMapIterable(UserData::getUsers));
    }
}
