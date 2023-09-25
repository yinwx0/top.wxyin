package music.service.impl;

import music.entity.Song;
import music.mapper.SongMapper;
import music.service.MusicService;
import music.utils.MyBatisUtils;

import java.util.List;

public class MusicServiceImpl implements MusicService {
    @Override
    public List<Song> selectAll() {
        return (List<Song>) MyBatisUtils.executeQuery(sqlSession -> {
            SongMapper mapper = sqlSession.getMapper(SongMapper.class);
            return mapper.selectAll();
        });
    }
}
