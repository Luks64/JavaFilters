package com.luks64.filters.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Agent {
    long id;
    String firstName;
    String lastName;
}
