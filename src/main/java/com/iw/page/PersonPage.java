package com.iw.page;

import com.iw.Page;
import com.iw.Person;

public final class PersonPage implements Page {

    private final Person person;

    public PersonPage(final Person person) {
        this.person = person;
    }

    @Override
    public String render() {
        return new GeneralPage(null).render();
    }
}
