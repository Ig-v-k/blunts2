package com.iw;

import java.util.List;

public interface Game {
    int id();
    int person();
    String title();
    int blunts();
    List<Attempt> attempts();
}
