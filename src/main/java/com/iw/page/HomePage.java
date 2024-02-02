package com.iw.page;

import com.iw.Page;
import com.iw.facet.AboutFacet;

public final class HomePage implements Page {
    @Override
    public String render() {
        return new GeneralPage(new AboutFacet()).render();
    }
}
