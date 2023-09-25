package music.service;

import music.entity.Song;

import java.util.List;

public interface MusicService {

    List<Song> selectAll();
}
