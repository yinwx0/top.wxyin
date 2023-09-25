let songs = [];

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
  cover.src = "./images/"+item.cover;
  name.textContent = item.name;
  singer.textContent = item.singer;
  lyric.textContent = item.lyric;
  cover.src = "./mp3/"+item.path;
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







// // 本地评价数据
// const reviews = [
//   {
//     id: 1,
//     name: "小吴",
//     job: "前端开发工程师",
//     img: "1.jpg",
//     text: ` Lorem ipsum dolor, sit amet consectetur adipisicing elit. Error quo, dicta
//     ut rerum molestias cum nesciunt? Velit quas aliquam harum excepturi earum,
//     blanditiis omnis dolor delectus optio, nesciunt dolorem? Eveniet?`,
//   },
//   {
//     id: 2,
//     name: "小米",
//     job: "后端开发工程师",
//     img: "2.jpg",
//     text: ` Lorem ipsum dolor, sit amet consectetur adipisicing elit. Error quo, dicta
//     ut rerum molestias cum nesciunt? Velit quas aliquam harum excepturi earum,
//     blanditiis omnis dolor delectus optio, nesciunt dolorem? Eveniet?`,
//   },
//   {
//     id: 3,
//     name: "小飞",
//     job: "全栈开发工程师",
//     img: "3.jpg",
//     text: ` Lorem ipsum dolor, sit amet consectetur adipisicing elit. Error quo, dicta
//     ut rerum molestias cum nesciunt? Velit quas aliquam harum excepturi earum,
//     blanditiis omnis dolor delectus optio, nesciunt dolorem? Eveniet?`,
//   },
//   {
//     id: 4,
//     name: "小丁",
//     job: "测试开发工程师",
//     img: "4.jpg",
//     text: ` Lorem ipsum dolor, sit amet consectetur adipisicing elit. Error quo, dicta
//     ut rerum molestias cum nesciunt? Velit quas aliquam harum excepturi earum,
//     blanditiis omnis dolor delectus optio, nesciunt dolorem? Eveniet?`,
//   },
// ];
//
// // 获取元素对象
// const img = document.getElementById("person-img");
// const author = document.getElementById("author");
// const job = document.getElementById("job");
// const info = document.getElementById("info");
//
// const prevBtn = document.querySelector(".prev-btn");
// const nextBtn = document.querySelector(".next-btn");
// const randomBtn = document.querySelector(".random-btn");
//
// // 设置起始下标
// let currentItem = 0;
//
// // 初始化数据
// window.addEventListener("DOMContentLoaded", function () {
//   const item = reviews[currentItem];
//   img.src = "images/" + item.img;
//   author.textContent = item.name;
//   job.textContent = item.job;
//   info.textContent = item.text;
// });
//
// // 展示用户数据
// function showPerson(person) {
//   const item = reviews[person];
//   img.src = "images/" + item.img;
//   author.textContent = item.name;
//   job.textContent = item.job;
//   info.textContent = item.text;
// }
// // 展示下一个人的数据
// nextBtn.addEventListener("click", function () {
//   currentItem++;
//   if (currentItem > reviews.length - 1) {
//     currentItem = 0;
//   }
//   showPerson(currentItem);
// });
// // 展示上一个人的数据
// prevBtn.addEventListener("click", function () {
//   currentItem--;
//   if (currentItem < 0) {
//     currentItem = reviews.length - 1;
//   }
//   showPerson(currentItem);
// });
// // 随机展示
// randomBtn.addEventListener("click", function () {
//   console.log("hello");
//   currentItem = Math.floor(Math.random() * reviews.length);
//   showPerson(currentItem);
// });
