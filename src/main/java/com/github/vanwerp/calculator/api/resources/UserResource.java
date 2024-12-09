package com.github.vanwerp.calculator.api.resources;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserResource {

    private Long id;

    private String username;

    private String role;

}
