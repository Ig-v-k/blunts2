package com.iw.game;

import com.iw.Attempts;
import com.iw.Game;

public final class ConstGame implements Game {

    private final Game game;
    private final int person;
    private final String title;
    private final Attempts attempts;

    public ConstGame(Game game, int person, String title, Attempts attempts) {
        this.game = game;
        this.person = person;
        this.title = title;
        this.attempts = attempts;
    }

    @Override
    public int id() {
        return game.id();
    }

    @Override
    public int person() {
        return person;
    }

    @Override
    public String title() {
        return title;
    }

    @Override
    public int blunts() {
        return game.blunts();
    }

    @Override
    public Attempts attempts() {
        return attempts;
    }
}
