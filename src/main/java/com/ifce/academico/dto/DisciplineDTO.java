package com.ifce.academico.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter
@Setter
public class DisciplineDTO {

    @NotBlank(message = "name is mandatory")
    private String name;

    @Positive(message = "workload must be positive")
    @Min(value = 1, message = "minimum value for workload is 1")
    @Max(value = 1_000_000, message = "maximum value for workload is 1.000.000")
    @NotNull(message = "workload is mandatory")
    private Integer workload;
}
