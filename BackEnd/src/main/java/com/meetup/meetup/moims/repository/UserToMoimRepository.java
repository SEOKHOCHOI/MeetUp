package com.meetup.meetup.moims.repository;

import com.meetup.meetup.moims.domain.UserToMoim;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserToMoimRepository extends JpaRepository<UserToMoim, Long> {
}
