package no.nith.pg5100.controller;

import no.nith.pg5100.dto.*;
import no.nith.pg5100.infrastructure.event.EventDao;
import no.nith.pg5100.infrastructure.subject.SubjectDao;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Tomas on 03.12.2015.
 */
@Model
public class EventController {

    @Inject
    private EventDao eventDao;
    private Event event;

    @Inject
    private SubjectDao subjectDao;
    private int subjectId;

    private int selectedId;

    @PostConstruct
    public void init() {
        event = new Event();
    }

    public void initEvent(){
        event = eventDao.findById(selectedId);
    }

    public Event getEvent() {
        return event;
    }

    public List<Event> getAll(){
        return eventDao.getAll();
    }

    public List<Event>getAll(boolean sortResults){

        if(sortResults) {

            List<Event> events = getAll();
            Collections.sort(events, (e1, e2) -> e1.getStartTime().compareTo(e2.getStartTime()));

            return events;
        }

        else return getAll();
    }

    public List<SelectItem> getEventTypes() {
        return Arrays.asList(EventType.values()).stream().map(t -> new SelectItem(t, t.name())).collect(Collectors.toList());
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public List<SelectItem> getAvailableSubjects(){
        List<Subject> subjects = subjectDao.getAll();
        return subjects.stream().map(s -> new SelectItem(s.getId(),s.getName())).collect(Collectors.toList());
    }

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }


    public void setSelectedId(int selectedId) {
        this.selectedId = selectedId;
    }

    public int getSelectedId(){
        return selectedId;
    }

    public void persist() {

        Subject subject = subjectDao.findById(subjectId);
        event.setSubject(subject);

        eventDao.persist(event);
    }


}
