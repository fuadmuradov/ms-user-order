package org.example.msuser.model.request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class UserRequest {
    private String name;
    private String surname;
    private String email;
    private String phone;
}
