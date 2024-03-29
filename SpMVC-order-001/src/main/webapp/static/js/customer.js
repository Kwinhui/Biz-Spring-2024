document.addEventListener("DOMContentLoaded", () => {
  const cust_body = document.querySelector("tbody.cust_body");
  const btn_update = document.querySelector("input.btn_update");
  const btn_delete = document.querySelector("input.btn_delete");

  const cust_body_onClick_handler = (e) => {
    const target = e.target;
    if (target.tagName === "TD") {
      // 눌린태그가 TD이면
      const TR = target.closest("TR");
      // TD랑 가장가까운 TR을 찾아
      const ccode = TR.dataset.ccode;

      // alert(ccode);
      document.location.href = `${rootPath}/customer/detail?c_code=${ccode}`;
    }
  };
  cust_body?.addEventListener("click", cust_body_onClick_handler);

  btn_update?.addEventListener("click", (e) => {
    const ccode = e.target.dataset.ccode;
    // alert(ccode);
    // update?c_code=${ccode} 로 적게되면 주소창에도 c_code가 있고 input body에도 c_code가 있기때문에
    // c_code 의 값이 2개가 넘어오게 된다 그렇기 때문에 주소창엔 변수와 다른 값으로 적어주는게 좋다.
    document.location.href = `${rootPath}/customer/update?ccode=${ccode}`; // ? get방식
  });

  btn_delete.addEventListener("click", (e) => {
    const ccode = e.target.dataset.ccode;

    if (confirm("정말 삭제할까요?")) {
      document.location.replace(`${rootPath}/customer/delete/${ccode}`);
    }
  });
});
