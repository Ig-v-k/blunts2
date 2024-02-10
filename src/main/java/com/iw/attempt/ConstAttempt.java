package com.iw.attempt;

import com.iw.Attempt;

public final class ConstAttempt implements Attempt {

    private final Attempt attempt;
    private final int game;
    private final int period;
    private final int blunts;

    public ConstAttempt(Attempt attempt, int game, int period, int blunts) {
        this.attempt = attempt;
        this.game = game;
        this.period = period;
        this.blunts = blunts;
    }

    @Override
    public int id() {
        return attempt.id();
    }

    @Override
    public int game() {
        return game;
    }

    @Override
    public int period() {
        return period;
    }

    @Override
    public int blunts() {
        return blunts;
    }
}
