let songs = [i];

//获取元素对象
const cover = document.getElementById("cover");
const singer = document.getElementById("singer");
const name = document.getElementById("name");
const lyric = document.getElementById("lyric");
const path = document.getElementById("path");

const prevBtn = document.getElementById("prev-btn");
const nextBtn = document.getElementById("next-btn");
const randomBtn = document.getElementById("random-btn");

//设置起始下标
let currentItem = 0;

//初始化数据
function load(){
    $.ajax({
        url:"/music/list",
        type:"get",
        dataType:"json",
        success:json =>{
            songs = json.data.list;
            console.log(songs);
            //默认显示第一首歌
            const item = songs[0];
            cover.src = "images/"+item.cover;
            name.textContent = item.name;
            singer.textContent = item.singer;
            lyric.textContent = item.lyric;
            path.src = "mp3/"+item.path
        }
    })
}

//封装显示歌曲的函数
function showSong(){
    const item = songs[index];
    cover.src = "images/"+item.cover;
    name.textContent = item.name;
    singer.textContent = item.singer;
    lyric.textContent = item.lyric;
    cover.src = "mp3/"+item.path;
}

//下一首歌
nextBtn.addEventListener("click",function (){
    currentItem++;
    if (currentItem > songs.length -1){
        currentItem = 0;
    }
    showSong(currentItem);
});

//上一首歌
prevBtn.addEventListener("click",function (){
    currentItem--;
    if (currentItem < 0){
        currentItem = songs.length - 1;
    }
    showSong(currentItem);
});

//随机
randomBtn.addEventListener("click",function (){
    currentItem = Math.floor(Math.random() * songs.length);
    console.log(currentItem)
    showSong(currentItem);
});