package no.nith.pg5100.dto;

import no.nith.pg5100.stubs.EventStub;
import no.nith.pg5100.stubs.InvalidSubjectStub;
import no.nith.pg5100.stubs.SubjectStub;
import org.junit.Before;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Date;
import java.util.Set;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

/**
 * Created by Tomas on 03.12.2015.
 */
public class EventTest {

    private Event event;

    private Validator validator;



    @Before
    public void setUp() throws Exception {

        validator = Validation.buildDefaultValidatorFactory().getValidator();

        event = new EventStub();
    }

    @Test
    public void validEvent() throws Exception{
        Set<ConstraintViolation<Event>> violations = validator.validate(event);
        assertTrue(violations.isEmpty());
    }

    @Test
    public void titleCantBeNull() throws Exception {
        event.setTitle(null);
        Set<ConstraintViolation<Event>> violations = validator.validate(event);
        assertEquals(1, violations.size());
    }

    @Test
    public void titleMustBeAtLeast5Chars() throws Exception {
        event.setTitle("1234");
        Set<ConstraintViolation<Event>> violations = validator.validate(event);
        assertEquals(1, violations.size());
    }

    @Test
    public void titleMustBe25CharsOrShorter() throws Exception {
        event.setTitle("this is precisely 26 chars");
        Set<ConstraintViolation<Event>> violations = validator.validate(event);
        assertEquals(1, violations.size());
    }

    @Test
    public void typeCantBeNull() throws Exception {
        event.setType(null);
        Set<ConstraintViolation<Event>> violations = validator.validate(event);
        assertEquals(1, violations.size());
    }

    @Test
    public void descriptionMustBe100CharsOrShorter() throws Exception {
        event.setTitle("tLorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean ma");
        Set<ConstraintViolation<Event>> violations = validator.validate(event);
        assertEquals(1, violations.size());
    }

    @Test
    public void subjectCantBeNull() throws Exception {
        event.setSubject(null);
        Set<ConstraintViolation<Event>> violations = validator.validate(event);
        assertEquals(1, violations.size());
    }

    @Test
    public void subjectMustBeValid() throws Exception {
        event.setSubject(new InvalidSubjectStub());
        Set<ConstraintViolation<Event>> violations = validator.validate(event);
        assertEquals(1, violations.size());
    }

    @Test
    public void startTimeCantBeNull() throws Exception {
        event.setStartTime(null);
        Set<ConstraintViolation<Event>> violations = validator.validate(event);
        assertEquals(1, violations.size());
    }

    @Test
    public void endTimeCantBeNull() throws Exception {
        event.setEndTime(null);
        Set<ConstraintViolation<Event>> violations = validator.validate(event);
        assertEquals(1, violations.size());
    }


}