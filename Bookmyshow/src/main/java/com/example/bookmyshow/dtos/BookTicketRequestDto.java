package com.example.bookmyshow.dtos;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookTicketRequestDto {
    private List<Long> showSeatIds;
    private Long userId;
    private Long showId;
}
