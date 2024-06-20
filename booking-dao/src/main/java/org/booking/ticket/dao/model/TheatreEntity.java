package org.booking.ticket.dao.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "theatres")
public class TheatreEntity extends BaseEntity{
    private String name;
    private int capacity;
    private B2BCustomerEntity b2bCustomer;
    @Field("contactInfo")
    private ContactInfo contactInfo;
    @Field("screens")
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
