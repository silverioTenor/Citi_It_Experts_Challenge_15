package main.models;

public class Movie {

    private String title;

    private String direction;

    private String genre;

    private String uf;

    private String durationInMinutes;

    private String release;

    private String classification;

    private String totalPublic;

    private String synopsis;

    public Movie(
            String title,
            String direction,
            String genre,
            String uf,
            String durationInMinutes,
            String release,
            String classification,
            String totalPublic,
            String synopsis
    ) {
        this.title = title;
        this.direction = direction;
        this.genre = genre;
        this.uf = uf;
        this.durationInMinutes = durationInMinutes;
        this.release = release;
        this.classification = classification;
        this.totalPublic = totalPublic;
        this.synopsis = synopsis;
    }

    public String getTitle() {
        return title;
    }

    public String getDirection() {
        return direction;
    }

    public String getGenre() {
        return genre;
    }

    public String getUf() {
        return uf;
    }

    public String getDurationInMinutes() {
        return durationInMinutes;
    }

    public String getRelease() {
        return release;
    }

    public String getClassification() {
        return classification;
    }

    public String getTotalPublic() {
        return totalPublic;
    }

    public String getSynopsis() {
        return synopsis;
    }

    @Override
    public String toString() {
        return "[" +
                    " titulo= " + title +
                    ", direcao= " + direction +
                    ", genero= " + genre +
                    ", uf= " + uf +
                    ", duracao em minutos= " + durationInMinutes +
                    ", lancamento= " + release +
                    ", classificacao= " + classification +
                    ", total public= " + totalPublic +
                    ", sinopse= " + synopsis  +
                "]\n";
    }
}
