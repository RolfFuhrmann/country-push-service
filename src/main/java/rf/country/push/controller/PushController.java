package rf.country.push.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.extern.slf4j.Slf4j;
import rf.country.push.model.Country;

@Slf4j
@Controller
@RequestMapping("/send")
public class PushController {

    @PostMapping("/country")
    @ResponseStatus(HttpStatus.OK)
    public void country(@RequestBody Country country) {
        log.info("{}.country {}", PushController.class.getName(), country.toString());
        WebSocketController.broadcast(country);
    }
}
