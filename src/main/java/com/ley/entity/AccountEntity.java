package com.ley.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AccountEntity {
    private int id;
    private String name;
    private String address;
}
