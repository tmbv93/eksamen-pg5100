package no.nith.pg5100.infrastructure.event;

import no.nith.pg5100.dto.Event;
import no.nith.pg5100.dto.EventType;
import no.nith.pg5100.infrastructure.event.JpaEventDao;
import no.nith.pg5100.infrastructure.location.JpaLocationDao;
import no.nith.pg5100.stubs.EventStub;
import no.nith.pg5100.stubs.SubjectStub;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import java.util.Date;

import static org.junit.Assert.assertEquals;

/**
 * Created by Tomas on 06.12.2015.
 */
public class JpaEventDaoIT {

    private EntityManagerFactory factory;
    private EntityManager entityManager;
    private JpaEventDao eventDao;

    @Before
    public void setUp() throws Exception {
        factory = Persistence.createEntityManagerFactory("pg5100-lms");
        entityManager = factory.createEntityManager();
        eventDao = new JpaEventDao(entityManager);
    }

    @After
    public void tearDown() throws Exception {
        entityManager.close();
        factory.close();
    }

    @Test
    public void findById() throws Exception {
        Event event = eventDao.findById(1);
        assertEquals(event.getTitle(), "Meow factory");
    }





}
