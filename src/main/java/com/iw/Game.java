package com.iw;

public interface Game {
    int id();
    int person();
    String title();
    int blunts();
    List<Attempt> attempts();
}
