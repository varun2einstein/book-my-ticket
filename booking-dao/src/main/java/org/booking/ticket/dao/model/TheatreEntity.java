package org.booking.ticket.dao.model;

import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "theatre")
public class TheatreEntity extends BaseEntity{
    private String name;
    private int capacity;
    private B2BCustomerEntity b2bCustomer;
    private ContactInfo contactInfo;
    private List<ScreenEntity> screens;

    @Data
    public static class ScreenEntity extends BaseEntity{
        private String name;
        private TheatreEntity theatre;
        private String screenNumber;
        private int capacity;
    }

    @Data
    public static class ContactInfo {
        private String phone;
        private String email;
        private String location;
        private String address;
    }
}
