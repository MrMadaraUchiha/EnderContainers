package fr.utarwyn.endercontainers.hologram;

import fr.utarwyn.endercontainers.TestHelper;
import fr.utarwyn.endercontainers.TestInitializationException;
import org.bukkit.entity.Player;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class HologramTest {

    @Mock
    private Player observer;

    @BeforeAll
    public static void setUpClass() throws TestInitializationException {
        TestHelper.setUpServer();
        TestHelper.getPlugin();
    }

    @Test
    void observerOnline() {
        Hologram hologram = new Hologram(this.observer, 10);

        when(this.observer.isOnline()).thenReturn(true);
        assertThat(hologram.isObserverOnline()).isTrue();
        when(this.observer.isOnline()).thenReturn(false);
        assertThat(hologram.isObserverOnline()).isFalse();
    }

}
