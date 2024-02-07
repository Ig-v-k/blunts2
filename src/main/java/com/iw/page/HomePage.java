package com.iw.page;

import com.iw.Page;
import com.iw.facet.AboutFacet;

public final class HomePage implements Page {
    @Override
    public String render() {
        return new GeneralPage(
                "Blunts2 Statistic",
                "statistics of streamers' stupidity in games.",
                new AboutFacet()).render();
    }
}
