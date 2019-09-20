package com.ley.entity;

import lombok.*;

@Data
@EqualsAndHashCode(exclude = "data")
@ToString(exclude = "data")
@AllArgsConstructor
@NoArgsConstructor
public class AccountEntity {
    private int id;
    private String name;
    private String address;
    private byte[] data;
}
