package com.tracom.office_planner.Meeting;

/*Entity to enable scheduling of a meeting */

import com.tracom.office_planner.Boardroom.BoardRoom;
import com.tracom.office_planner.Organization.Organization;
import com.tracom.office_planner.RepeatMeetings.RepeatMeetings;
import com.tracom.office_planner.User.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "meeting")
//Lombok
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Meeting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int meetId;
    private String meetName;
    private String description;
    private int capacity;
    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST})
    @JoinTable(
            name = "user_meetings",
            joinColumns = @JoinColumn(name = "meet_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<User> users = new ArrayList<User>();
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "room")
    private BoardRoom boardroom;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY, mappedBy = "meeting")
    private List<RepeatMeetings> repeatMeetings = new ArrayList<>();
    private LocalTime meetStart;
    private LocalTime meetEnd;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "organization")
    private Organization organization;


    @Override
    public String toString() {
        return "Meeting{" +
                "meetId=" + meetId +
                ", meetName='" + meetName + '\'' +
                ", description='" + description + '\'' +
                ", capacity=" + capacity +
                ", users=" + users +
                ", boardroom=" + boardroom +
                ", repeatMeetings=" + repeatMeetings +
                ", meetStart=" + meetStart +
                ", meetEnd=" + meetEnd +
                '}';
    }
}
