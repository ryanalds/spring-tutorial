package org.ifrn.projeto.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter 
@Setter 
@NoArgsConstructor 
@JsonIgnoreProperties(ignoreUnknown = true)
public class SimpsonsCharacter {
    private Integer id;
    private Integer age;
    private String birthdate;
    private String gender;
    private String name;
    private String occupation;

    @JsonProperty("portrait_path")
    private String portraitPath;

    private List<String> phrases;
    private String status;

}
