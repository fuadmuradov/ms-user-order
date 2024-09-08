package org.example.msorder.client;

import org.example.msorder.decoder.CustomErrorDecoder;
import org.example.msorder.model.client.UserResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@FeignClient(name = "ms-user", url = "${ms-user.url}", configuration = CustomErrorDecoder.class)
public interface UserClient {
    @GetMapping("internal/v1/users/{id}")
    Optional<UserResponseDto> getUser(@PathVariable long id);
}
