package mate.academy.dao;

import lombok.Data;

@Data
public class CreateBookRequestDto {
    private String title;
    private String author;
}
