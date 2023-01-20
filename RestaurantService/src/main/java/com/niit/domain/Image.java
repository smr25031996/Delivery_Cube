/*
 * Author Name: Jaival
 * Date: 20-01-2023
 * Createdd with IntelliJ IDEA Community Editiion
 */
package com.niit.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

//import javax.persistence.*;

@Document(collection = "photos")
//@Table(name = "image")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Image {
    @Id
    private String id;

    //@Column(name = "name")
    private String name;

    //@Column(name = "type")
    private String type;

    //@Column(name = "image", unique = false, nullable = false, length = 100000)
    private byte[] image;

    public Image(String title) {
        this.name = title;
    }
}