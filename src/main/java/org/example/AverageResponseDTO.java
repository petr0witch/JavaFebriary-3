package org.example;

import lombok.Builder;
import lombok.Data;
@Data
@Builder

public class AverageResponseDTO {
    private double avgSalary;
    private double avgAge;
    private int avgLettersInName;

}
