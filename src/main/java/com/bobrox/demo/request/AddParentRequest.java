package com.bobrox.demo.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.annotations.NaturalId;

@Data
@AllArgsConstructor
public class AddParentRequest {

    private String firstName;
    private String lastName;
    private String email;
    private String address;
}
