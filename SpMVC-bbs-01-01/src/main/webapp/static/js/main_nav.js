// main_nav 각 tag 의 className 을 키로 하는 객체 선언
const NAV_INDEX = {
  home: { url: "/" },
  notice: { url: "/bbs/notice" },
  bbs: { url: "/bbs/free" },
};
document.addEventListener("DOMContentLoaded", () => {
  const mainNav = document.querySelector("nav.main");
  const navItems = mainNav.querySelectorAll("li");

  mainNav.addEventListener("click", (e) => {
    const target = e.target;
    if (target.tagName === "LI") {
      navItems.forEach((item) => {
        // 혹시 li tag에 active 가 있으면 모두 지워
        // 모든 nav.main li tag 에 active 라는 class 를 제거하기
        item.classList.remove("active");
      });
      // 클릭된 항목에 active 라는 클래스를 추가하기
      target.classList.add("active");

      const className = target.classList[0];
      const url = NAV_INDEX[className].url;
      // alert(url);
      document.location.href = url;
    }
  });
});
