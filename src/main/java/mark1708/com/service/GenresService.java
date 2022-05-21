package mark1708.com.service;

import mark1708.com.dto.GenreDto;
import mark1708.com.model.Genre;
import mark1708.com.repo.GenreRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GenresService {

    private GenreRepository genreRepository;

    @Autowired
    public GenresService(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    public List<Genre> getGenresByParentId(Integer parentId) {
        return genreRepository.findGenreByParentId(parentId);
    }

    public List<GenreDto> getParentGenresList() {
        return genreRepository.findParentGenres()
                .stream()
                .parallel()
                .map(genre -> {
                    GenreDto genreDto = convertToDto(genre);
                    List<Genre> genresByParentId = getGenresByParentId(genre.getId());
                    genreDto.setChildGenreList(genresByParentId);
                    return genreDto;
                })
                .collect(Collectors.toList());
    }

    public GenreDto convertToDto(Genre genre) {
        GenreDto genreDto = new GenreDto();
        BeanUtils.copyProperties(genre, genreDto);
        return genreDto;
    }

}
