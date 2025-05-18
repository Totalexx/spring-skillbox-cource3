package ru.totalexx.mod3.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.ArgumentPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapperResultSetExtractor;
import org.springframework.stereotype.Repository;
import ru.totalexx.mod3.model.Contact;
import ru.totalexx.mod3.repository.mapper.ContactRowMapper;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class ContactJDBCRepository implements ContactRepository {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public Optional<Contact> find(UUID id) {
        String sql = "SELECT * FROM contacts WHERE id = ?";
        Contact contact = DataAccessUtils.singleResult(
                jdbcTemplate.query(sql,
                        new ArgumentPreparedStatementSetter(new Object[]{id}),
                        new RowMapperResultSetExtractor<>(new ContactRowMapper(),1)
                )
        );
        return Optional.ofNullable(contact);
    }

    @Override
    public List<Contact> findAll() {
        String sql = "SELECT * FROM contacts";
        return jdbcTemplate.query(sql, new ContactRowMapper());
    }

    @Override
    public Contact save(Contact contact) {
        if (contact.getId() == null) {
            contact.setId(UUID.randomUUID());
        }

        String sql = "INSERT INTO contacts (id, firstName, lastName, phone, email)" +
                "VALUES (?, ?, ?, ?, ?)" +
                "ON CONFLICT (id) DO UPDATE " +
                "SET firstName = EXCLUDED.firstName," +
                "    lastName = EXCLUDED.lastName," +
                "    phone = EXCLUDED.phone," +
                "    email = EXCLUDED.email";

        jdbcTemplate.update(sql, contact.getId(), contact.getFirstName(), contact.getLastName(), contact.getPhone(), contact.getEmail());
        return contact;
    }

    @Override
    public void delete(UUID id) {
        String sql = "DELETE FROM contacts WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
}
