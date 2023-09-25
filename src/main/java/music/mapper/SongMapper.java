package music.mapper;

import music.entity.Song;

import java.util.List;

public interface SongMapper {
    //查询所有音乐
    List<Song> selectAll();
}
