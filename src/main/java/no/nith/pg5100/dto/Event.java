package no.nith.pg5100.dto;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * Created by Tomas on 03.12.2015.
 */

@Entity
@NamedQuery(name = "Event.getAll", query = "select e from Event e")
@SecondaryTable(name = "EVENT_DETAILS", pkJoinColumns = @PrimaryKeyJoinColumn(name = "FK_EVENT"))
@SequenceGenerator(name = "SEQ_EVENT")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_EVENT")
    private int id;

    @NotNull
    @Enumerated(EnumType.STRING)
    private EventType type;

    @NotNull
    @Size(min = 5, max = 25)
    private String title;

    @Size(max = 100)
    private String description;

    @Valid
    @NotNull
    @ManyToOne
    @JoinColumn(name = "FK_SUBJECT")
    private Subject subject;

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @Column(table = "EVENT_DETAILS")
    private Date startTime;

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @Column(table = "EVENT_DETAILS")
    private Date endTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public EventType getType() {
        return type;
    }

    public void setType(EventType type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

}
