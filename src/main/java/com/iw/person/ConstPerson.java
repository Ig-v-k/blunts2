package com.iw.person;

import com.iw.Game;
import com.iw.Person;

import java.util.Collections;
import java.util.List;

public final class ConstPerson implements Person {

    private final Person person;
    private final int code;
    private final String firstname;
    private final String lastname;
    private final int blunts;
    private final int period;
    private final String nickname;
    private final String link;

    public ConstPerson(Person person, int code, String firstname, String lastname, int blunts, int period, String nickname, String link) {
        this.person = person;
        this.code = code;
        this.firstname = firstname;
        this.lastname = lastname;
        this.blunts = blunts;
        this.period = period;
        this.nickname = nickname;
        this.link = link;
    }

    @Override
    public int id() {
        return person.id();
    }

    @Override
    public int code() {
        return code;
    }

    @Override
    public String firstname() {
        return firstname;
    }

    @Override
    public String lastname() {
        return lastname;
    }

    @Override
    public int blunts() {
        return blunts;
    }

    @Override
    public int period() {
        return period;
    }

    @Override
    public String nickname() {
        return nickname;
    }

    @Override
    public String link() {
        return link;
    }

    @Override
    public List<Game> games() {
        return Collections.emptyList();
    }
}
