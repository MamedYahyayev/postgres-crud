package az.maqa.spring.postgres.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonDto {

    private Long id;

    private String name;

    private String surname;

    private List<String> addresses;
}
