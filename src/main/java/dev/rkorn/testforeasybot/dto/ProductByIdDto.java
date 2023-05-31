package dev.rkorn.testforeasybot.dto;

import dev.rkorn.testforeasybot.entities.enums.Type;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Setter
@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ProductByIdDto {

    @NotNull
    private Long series;

    @NotNull
    private String producer;

    @NotNull
    private BigDecimal price;

    @NotNull
    private Integer amount;

    @NotNull
    @Enumerated(value = EnumType.STRING)
    private Type type;

    @NotNull
    private String property;

}
