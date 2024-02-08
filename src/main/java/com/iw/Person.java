package com.iw;

import java.util.List;

public interface Person {
    int id();
    int code();
    String firstname();
    String lastname();
    int blunts();
    int period();
    String nickname();
    String link();
    List<Game> games();
}
