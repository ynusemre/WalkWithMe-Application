package com.example.WalkWithMe.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReservationRequest {
    private LocalDateTime startRes;
    private LocalDateTime finishRes;
}
