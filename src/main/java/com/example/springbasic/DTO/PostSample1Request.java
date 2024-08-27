package com.example.springbasic.DTO;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostSample1Request {

    @NotBlank
    @Length(max=10)
    private String sampleId;

    @NotNull
    private Integer sampleColumn;

}
