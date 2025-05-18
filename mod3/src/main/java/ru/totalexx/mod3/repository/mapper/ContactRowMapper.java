package ru.totalexx.mod3.repository.mapper;

import org.springframework.jdbc.core.RowMapper;
import ru.totalexx.mod3.model.Contact;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class ContactRowMapper implements RowMapper<Contact> {

    @Override
    public Contact mapRow(ResultSet rs, int rowNum) throws SQLException {
        Contact contact = new Contact();
        contact.setId(UUID.fromString(rs.getString(Contact.Fields.id)));
        contact.setFirstName(rs.getString(Contact.Fields.firstName));
        contact.setLastName(rs.getString(Contact.Fields.lastName));
        contact.setPhone(rs.getString(Contact.Fields.phone));
        contact.setEmail(rs.getString(Contact.Fields.email));

        return contact;
    }
}
