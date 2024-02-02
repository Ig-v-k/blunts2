package com.iw.page;

import com.iw.Page;

public final class PersonPage implements Page {

    private final String id;

    public PersonPage(String id) {
        this.id = id;
    }

    @Override
    public String render() {
        return new GeneralPage(null).render();
    }
}
