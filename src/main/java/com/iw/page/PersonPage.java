package com.iw.page;

import com.iw.Page;
import com.iw.Person;
import com.iw.facet.AboutPersonFacet;

public final class PersonPage implements Page {

    private final Person person;

    public PersonPage(final Person person) {
        this.person = person;
    }

    @Override
    public String render() {
        return new GeneralPage(new AboutPersonFacet(person)).render();
    }
}
