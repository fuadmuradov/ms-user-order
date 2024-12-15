package org.example.msuser.model.request;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class UserRequest {
    private String name;
    private String surname;
    private String email;
    private String phone;
    private List<AddressRequest> addresses;
}
