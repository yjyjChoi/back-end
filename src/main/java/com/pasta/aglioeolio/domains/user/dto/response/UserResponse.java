package com.pasta.aglioeolio.domains.user.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserResponse {

    private String mt_number;
    private String password;
    private String enlist_date;
    private String discharge_date;
    private String name;
    private String phone_number;
    private String rank;
    private String affiliation;
    private String profile_image;
    private Boolean blue_falcon;
    private String role;
    private Integer fail_count;
    private Boolean is_delyn;
    
}
