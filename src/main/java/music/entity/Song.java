package music.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Song {
    private Integer id;
    private String name;
    private String singer;
    private String cover;
    private String path;
    private String lyric;
    private Date createTime;
}
