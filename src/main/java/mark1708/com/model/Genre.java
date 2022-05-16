package mark1708.com.model;

import java.util.List;

public class Genre {
    private Integer id;
    private Integer parentId;
    private String slug;
    private String name;
    private List<Genre> childGenreList;

    public Genre(Integer id, Integer parentId, String slug, String name, List<Genre> childGenreList) {
        this.id = id;
        this.parentId = parentId;
        this.slug = slug;
        this.name = name;
        this.childGenreList = childGenreList;
    }

    public Genre(Integer parentId, String slug, String name, List<Genre> childGenreList) {
        this.parentId = parentId;
        this.slug = slug;
        this.name = name;
        this.childGenreList = childGenreList;
    }

    public Genre() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Genre> getChildGenreList() {
        return childGenreList;
    }

    public void setChildGenreList(List<Genre> childGenreList) {
        this.childGenreList = childGenreList;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
