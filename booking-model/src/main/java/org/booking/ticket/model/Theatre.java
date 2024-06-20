package org.booking.ticket.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Theatre extends BaseBean {
    private String name;
    private int capacity;
    private ContactInfo contactInfo;
    private List<Screen> screens;
    private B2BCustomer b2bCustomer;

    @Data
    public static class Screen extends BaseBean {
        private String name;
        private Theatre theatre;
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
