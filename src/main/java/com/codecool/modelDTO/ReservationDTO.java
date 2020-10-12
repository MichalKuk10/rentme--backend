package com.codecool.modelDTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import java.sql.Date;

@Data
@Getter
@Setter
public class ReservationDTO {
    private Long id;
    private Long itemId;
    private Long appUserId;
    private Date rentingStartDate;
    private Date rentingEndDate;
}
