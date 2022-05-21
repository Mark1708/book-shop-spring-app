package mark1708.com.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import mark1708.com.model.Genre;

import java.util.List;

@Data
@NoArgsConstructor
public class GenreDto {
    private Integer id;
    private Integer parentId;
    private String slug;
    private String name;
    private List<Genre> childGenreList;
}
