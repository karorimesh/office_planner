package com.tracom.office_planner.Meeting;
/*
Repository class to handle the meeting
 */

import org.springframework.data.jpa.repository.JpaRepository;

public interface MeetingRepository extends JpaRepository<Meeting, Integer> {
}
