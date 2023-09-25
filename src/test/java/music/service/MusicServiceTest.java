package music.service;

import lombok.extern.slf4j.Slf4j;
import music.entity.Song;
import music.service.impl.MusicServiceImpl;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class MusicServiceTest {

    private final MusicService musicService = new MusicServiceImpl();

    @Test
    void selectAll() {
        List<Song> songs = musicService.selectAll();
        songs.forEach(song -> log.info(String.valueOf(song)));
    }
}