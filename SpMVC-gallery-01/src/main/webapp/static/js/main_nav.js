// main_nav 각 tag 의 className 을 키로 하는 객체 선언
const NAV_INDEX = {
  home: { name: "home", url: "/" },
  notice: { name: "notice", url: "/bbs/notice" },
  free: { name: "free", url: "/bbs/free" },
};
document.addEventListener("DOMContentLoaded", () => {
  const mainNav = document.querySelector("nav.main");
  const navItems = mainNav.querySelectorAll("li");

  mainNav.addEventListener("click", (e) => {
    const target = e.target;
    if (target.tagName === "LI") {
      const className = target.classList[0];
      const url = NAV_INDEX[className].url;
      // alert(url);
      document.location.href = `${rootPath}${url}`;
      // nav 가 클릭 되었을때 active 한 UI 를 보여주기 위한 설정
      // 그런데 nav 를 클릭하면 화면이 refresh 되버리기 때문에 의미가 없음
      // navItems.forEach((item) => {
      //   // 혹시 li tag에 active 가 있으면 모두 지워
      //   // 모든 nav.main li tag 에 active 라는 class 를 제거하기
      //   item.classList.remove("active");
      // });
      // // 클릭된 항목에 active 라는 클래스를 추가하기
      // target.classList.add("active");
    }
  });

  // 화면이 새로 refresh 되었을때, 또는 화면이 최초로 보일때 실행할 코드
  // 현재 화면이 보여지는 URL
  // http://localhost:8080/gallery/bbs/free/write
  const path = document.location.pathname;
  // "/" 를 기준으로 하나씩 쪼갬
  // pathname 을 슬래시("/")를 기준으로 단어단위로 자르기
  const pathArr = path.split("/");

  // localhost:8080/gallery/ 로 끝나면 localhost:8080/gallery/home 이라고 만들어라
  pathArr[pathArr.length - 1] || pathArr.push("home");

  // URL 중에서 가장 끝에 오는 URL 문자열은 ?
  // 가장 끝에 문자열이 ""이면 "home" 문자열로 대체
  // const pathname = pathArr[pathArr.length - 1] || "home";

  // nav 가 1단계만 있을 경우
  // document.querySelector(`nav.main li.${pathname}`)?.classList.add("active");

  // nav 가 2단계만 있을 경우
  // json 을 배열형태로 바꿔줌
  // JSON type 의 데이터를 Array type 의 데이터로 변환하기
  const navs = Object.values(NAV_INDEX);
  navs.forEach((nav) => {
    // 분해한 url 중 nav.name 과 일치한 친구가 있으면
    // 배열.join("sp") : 배열을 sp 문자열을 중간에 추가하여 하나의 문자열로 바꾸는 함수
    // 분해된걸 다시 합쳐서 className 이 포함돼있으면
    if (pathArr.join(" ").includes(nav.name)) {
      document.querySelector(`nav.main li.${nav.name}`)?.classList.add("active");
    }
  });
});
