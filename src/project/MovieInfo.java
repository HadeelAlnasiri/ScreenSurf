/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

/**
 *
 * @author HUAWEI
 */
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "moviinfo")

public class MovieInfo implements Serializable {
    
    @Id
    @Column(name = "movieName")
    private String movieName;
    
    @Column(name = "description")
    private String description;
    
    @Column(name = "dateOfShow")
    private String dateOfShow;
    
    @Column(name = "genres")
    private String genres;

    public MovieInfo(String movieName, String description, String dateOfShow, String genres) {
        this.movieName = movieName;
        this.description = description;
        this.dateOfShow = dateOfShow;
        this.genres = genres;
    }

    public MovieInfo() {
    }

    public String getGenres() {
        return genres;
    }

    public void setGenres(String genres) {
        this.genres = genres;
    }


    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDateOfShow() {
        return dateOfShow;
    }

    public void setDateOfShow(String dateOfShow) {
        this.dateOfShow = dateOfShow;
    }
    
    

    
    
}

