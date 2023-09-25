package music.controller;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import music.entity.Song;
import music.service.MusicService;
import music.service.impl.MusicServiceImpl;
import music.utils.ResponseUtils;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/music/*")
@Slf4j
public class SongServlet extends HttpServlet {

    private final MusicService musicService = new MusicServiceImpl();

    @Override
    public void init(ServletConfig config) throws ServletException {
        log.info("init");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String requestURI = req.getRequestURI();
        log.info(requestURI);
        int position = requestURI.lastIndexOf("/");
        // /music/list
        String method = requestURI.substring(position+1);
        log.info(method);
        switch (method){
            case "list" ->{
                selectlist(req,resp);
            }
            case "add" ->{
                add(req,resp);
            }
        }

    }

    private void selectlist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        ResponseUtils responseUtils;
        List<Song> songs = musicService.selectAll();
        responseUtils = new ResponseUtils().put("list",songs);
        resp.setContentType("application/json;charset=UTF-8");
        resp.getWriter().println(responseUtils.toJsonString());
    }

    private void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        log.info("新增歌曲");
    }

    @Override
    public void destroy() {
        log.info("destroy");

    }
}
