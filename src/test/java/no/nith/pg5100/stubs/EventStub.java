package no.nith.pg5100.stubs;

import no.nith.pg5100.dto.Event;
import no.nith.pg5100.dto.EventType;

import java.util.Date;

/**
 * Created by Tomas on 06.12.2015.
 */
public class EventStub extends Event {

    public EventStub(){
        setTitle("Valid event");
        setDescription("This in an example of a valid event");
        setStartTime(new Date());
        setEndTime(new Date());
        setType(EventType.FORELESNING);
        setSubject(new SubjectStub());
    }
}
