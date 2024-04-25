document.addEventListener("DOMContentLoaded", async () => {
  const fileInput = document.querySelector("input.file.single");
  const filesInput = document.querySelector("input.file.multi");
  const prevImg = document.querySelector("img.gallery");
  const imgBorderBox = document.querySelector("div.image");
  const base64Box = document.querySelector("textarea.base64");
  const multiImageBox = document.querySelector("div.image.multi");

  const encodeImageFileAsBase64 = async (image) => {
    // Promise : 이 안에 있는 모든 코드가 작동이 끝나고 resolve 라는 함수가 끝날때까지 진행, 실행보장하겠다
    // reader은 무조건 비동기 > 동기방식으로 바꿈
    return new Promise((resolve, _) => {
      const reader = new FileReader();
      reader.onloadend = () => {
        // 미리보기를 하기 위한 코드
        resolve(reader.result);
      };
      reader.readAsDataURL(image);
    });
  };

  prevImg.addEventListener("click", () => filesInput.click());

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

  const filePreView = async (file) => {
    const base64 = await encodeImageFileAsBase64(file);
    if (base64) {
      // img tag를 하나 만들어
      const img = document.createElement("img");
      img.style.width = "100px";
      img.src = base64;
      multiImageBox.appendChild(img);
    }
  };
  filesInput.addEventListener("change", async (e) => {
    // 이미지 파일의 미리보기
    const files = e.target.files;

    // 사진을 다시 골랐을때 기존의 preview는 지워주기
    multiImageBox.innerHTML = "";
    // file이 2개이상일 경우
    for (let file of files) {
      await filePreView(file);
    }

    // const file = target.files[0];
    // const base64 = await encodeImageFileAsBase64(file);
    // prevImg.src = base64;
    // base64Box.value = base64;
  });

  // 파일을 선택했을때
  fileInput.addEventListener("change", async (e) => {
    // 이미지 파일의 미리보기
    const target = e.target;
    const file = target.files[0];
    await filePreView(file);

    // const base64 = await encodeImageFileAsBase64(file);
    // prevImg.src = base64;
    // base64Box.value = base64;
  });
});
