package com.iw;

import com.iw.game.SimpleGame;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public final class GameTest extends ContainerAbstract {
    @Test
    public void person() {
        final int person = 0;
        final Game game = new SimpleGame(container, 0);
        assertThat(game.person()).isEqualTo(person);
    }
}
