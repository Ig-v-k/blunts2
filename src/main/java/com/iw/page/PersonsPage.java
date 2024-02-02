package com.iw.page;

import com.iw.Page;
import com.iw.facet.PersonsTableFacet;

import java.util.ArrayList;
import java.util.List;

public final class PersonsPage implements Page {

    private final List<String> persons;

    public PersonsPage() {
        this(new ArrayList<>() {{
            add("Arthas");
            add("Glad Valakas");
            add("Kuplinov");
        }});
    }

    public PersonsPage(List<String> persons) {
        this.persons = persons;
    }

    @Override
    public String render() {
        return new GeneralPage(new PersonsTableFacet(persons)).render();
    }
}
