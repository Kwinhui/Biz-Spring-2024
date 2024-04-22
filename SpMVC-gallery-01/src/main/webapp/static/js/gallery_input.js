document.addEventListener("DOMContentLoaded", () => {
  const fileInput = document.querySelector("input.file");
  const prevImg = document.querySelector("img.gallery");
  const imgBorderBox = document.querySelector("div.image");
  const base64Box = document.querySelector("textarea.base64");

  const encodeImageFileAsBase64 = async (image) => {
    // Promise : 이 안에 있는 모든 코드가 작동이 끝나고 resolve 라는 함수가 끝날때까지 진행, 실행보장하겠다
    // reader은 무조건 비동기 > 동기방식으로 바꿈
    return new Promise((resolve, _) => {
      const reader = new FileReader();
      reader.onloadend = () => {
        resolve(reader.result);
      };
      reader.readAsDataURL(image);
    });
  };

  prevImg.addEventListener("click", () => fileInput.click());

  // control + v 를 눌렀을때
  imgBorderBox.addEventListener("paste", async (e) => {
    const items = e.clipboardData.items;
    // 제일 마지막에 캡쳐한친구
    // items 객체가 존재하면 그중 0번째 요소를 getter 하기
    const item = items?.[0];
    // image/png, text/plan, application/text

    // 붙여넣기 한 데이터가 image/* 이면
    if (item.type.indexOf("image") === 0) {
      // 붙여넣기 한 이미지 중에서 파일만 추출하기
      const blob = item.getAsFile();
      console.log(blob);
      // 파일이 추출이 안되면
      if (!blob) {
        return null;
      }
      const base64 = await encodeImageFileAsBase64(blob);
      prevImg.src = base64;
      base64Box.value = base64;
      //   // 파일을 읽기 위한 도구(클래스)
      //   const reader = new FileReader();
      //   // 파일이 모두 load(읽히기) 되었으면
      //   reader.onloadend = () => {
      //     prevImg.src = reader.result;
      //   };
      //   // 파일을 읽어라 라는 명령
      //   reader.readAsDataURL(blob);
    } else {
      alert("이미지만 붙여넣기 하세요");
    }
  });

  // 파일을 선택했을때
  fileInput.addEventListener("change", async (e) => {
    const target = e.target;
    const file = target.files[0];
    const base64 = await encodeImageFileAsBase64(file);
    prevImg.src = base64;
    base64Box.value = base64;
    // const reader = new FileReader();

    // reader.onloadend = () => {
    //   prevImg.src = reader.result;
    // };
    // reader.readAsDataURL(file);
  });
});
