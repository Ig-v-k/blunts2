package com.iw.person;

import com.iw.Games;
import com.iw.Person;

public final class ConstPerson implements Person {

    private final Person person;
    private final int code;
    private final String firstname;
    private final String lastname;
    private final int period;
    private final String nickname;
    private final String link;
    private final Games games;

    public ConstPerson(Person person, int code, String firstname, String lastname, int period, String nickname, String link, Games games) {
        this.person = person;
        this.code = code;
        this.firstname = firstname;
        this.lastname = lastname;
        this.period = period;
        this.nickname = nickname;
        this.link = link;
        this.games = games;
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
        return person.blunts();
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
    public Games games() {
        return games;
    }
}
