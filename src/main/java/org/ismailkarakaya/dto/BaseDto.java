package org.ismailkarakaya.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;


@Getter
@Setter
public class BaseDto implements Serializable {

    public static final Long serialVersionUID = 1L;

    protected Long id;
    protected Date systemCreatedDate;

    public BaseDto() {
    }

    public BaseDto(Long id, Date systemCreatedDate) {
        this.id = id;
        this.systemCreatedDate = systemCreatedDate;
    }

    //toString


    @Override
    public String toString() {
        return "BaseDto{" +
                "id=" + id +
                ", systemCreatedDate=" + systemCreatedDate +
                '}';
    }



}
