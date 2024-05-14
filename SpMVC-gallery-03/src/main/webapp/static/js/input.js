document.addEventListener("DOMContentLoaded", () => {
  const preImg = document.querySelector("img.represent");
  const imageInput = document.querySelector("#files");
  const thumnailBox = document.querySelector("div.thumnail");
  // 이미지를 클릭하면 input[type="file"] 를 활성화(click 한 것처럼) 하라
  preImg.addEventListener("click", () => imageInput.click());

  const imgPreview = (file, target) => {
    const reader = new FileReader();
    reader.onloadend = (e) => {
      target.src = e.target.result;
    };
    reader.readAsDataURL(file);
  };

  imageInput.addEventListener("change", (e) => {
    const files = e.target.files;
    const file = files[0];
    imgPreview(file, preImg);
    // 초기화 코드를 적어주지 않으면 이미지를 변경해도 기존에 있던 이미지가 남음
    thumnailBox.innerHTML = "";
    for (let i = 0; i < files.length; i++) {
      const tempImage = document.createElement("img");

      imgPreview(files[i], tempImage);
      thumnailBox.appendChild(tempImage);
    }

    // const reader = new FileReader();
    // reader.onload = (image) => {
    //   preImg.src = image.target.result;
    // };
    // reader.readAsDataURL(file);
  });

  thumnailBox.addEventListener("click", (e) => {
    const thumImage = e.target;
    preImg.src = thumImage.src;
  });
});
