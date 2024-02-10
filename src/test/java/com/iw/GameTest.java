package com.iw;

import com.iw.attempts.SimpleAttempts;
import com.iw.game.SimpleGame;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public final class GameTest extends ContainerAbstract {
    @Test
    public void person() {
        final int person = 0;
        final Game game = new SimpleGame(container, 1);
        assertThat(game.person()).isEqualTo(person);
    }

    @Test
    public void title() {
        final Game game = new SimpleGame(container, 1);
        assertThat(game.title()).isNotEmpty();
    }

    @Test
    public void blunts() {
        final Game game = new SimpleGame(container, 1);
        assertThat(game.blunts()).isGreaterThanOrEqualTo(0);
    }

    @Test
    public void attempts() {
        final Game game = new SimpleGame(container, 1);
        final List<Attempt> attempts = new SimpleAttempts(container, game.id()).list();
        assertThat(attempts).isNotEmpty().hasSize(2);
    }
}
