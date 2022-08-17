package mrw007.springframework.springrestclientexamples.controllers;

import lombok.extern.slf4j.Slf4j;
import mrw007.springframework.springrestclientexamples.services.ApiService;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.server.ServerWebExchange;

import java.util.Optional;

@Slf4j
@Controller
public class UserController {

    private final ApiService apiService;

    public UserController(ApiService apiService) {
        this.apiService = apiService;
    }

    @GetMapping({"", "/", "/index"})
    public String index() {
        return "index";
    }

    @PostMapping("/users")
    public String formPost(Model model, ServerWebExchange serverWebExchange) {
        model.addAttribute("users", apiService.getUsers(serverWebExchange.getFormData()
                .map(data -> {
                    Optional<String> limit = Optional.ofNullable(data.getFirst("limit"));
                    if (limit.isEmpty()
                            || limit.get().equals("")
                            || !NumberUtils.isParsable(limit.get())
                            || Integer.parseInt(limit.get()) == 0) {
                        return 10;
                    }
                    return Integer.parseInt(limit.get());
                })));
        return "userlist";
    }
}