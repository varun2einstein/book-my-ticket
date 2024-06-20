package org.booking.ticket.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public abstract class BaseBean {

    private String id;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Long version;
}
